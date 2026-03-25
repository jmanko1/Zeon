import java.util.HashSet;
import java.util.Stack;

import static java.lang.System.exit;

public class LLVMActions extends JacobBaseListener {
    private HashSet<String> functionNames = new HashSet<>();
    private HashSet<Variable> globalVariables = new HashSet<>();
    private HashSet<Variable> localVariables = new HashSet<>();
    private Boolean global;

    private Stack<Type> typeStack = new Stack<>();
    private Stack<String> valueStack = new Stack<>();

    @Override
    public void enterProgram(JacobParser.ProgramContext ctx) {
        global = true;
    }

    @Override
    public void exitProgram(JacobParser.ProgramContext ctx) {
        LLVMGenerator.close_main();
        System.out.println( LLVMGenerator.generate() );
    }

    @Override
    public void exitDeclStat(JacobParser.DeclStatContext ctx) {
        String id = ctx.decl().ID().getText();
        boolean exists = global ?
                globalVariables.stream().anyMatch(v -> v.getName().equals(id)) :
                localVariables.stream().anyMatch(v -> v.getName().equals(id));

        if (exists) {
            System.err.println("Error: " + id + " already declared.");
            exit(1);
        }

        String typeText = ctx.decl().type().getText();
        Type type = mapAntlrTypeToEnum(ctx.decl().type().getText());
        if (type == null) {
            System.err.println("Unknown type " + typeText);
            exit(1);
        }

        Variable newVar = new Variable(id, type);

        if (global)
            globalVariables.add(newVar);
        else
            localVariables.add(newVar);

        LLVMGenerator.declare(id, global, type);
    }

    @Override
    public void exitAssignStat(JacobParser.AssignStatContext ctx) {
        String id = ctx.assign().ID().getText();
        String value = valueStack.pop();
        Type exprType = typeStack.pop();

        if (ctx.assign().type() != null) {
            boolean exists = global ?
                    globalVariables.stream().anyMatch(v -> v.getName().equals(id)) :
                    localVariables.stream().anyMatch(v -> v.getName().equals(id));

            if (exists) {
                System.err.println("Error: " + id + " already declared.");
                exit(1);
            }

            String declTypeText = ctx.assign().type().getText();
            Type declType = mapAntlrTypeToEnum(declTypeText);
            if (declType == null) {
                System.err.println("Unknown type " + declTypeText);
                exit(1);
            }

            Variable newVar = new Variable(id, declType);

            if (global)
                globalVariables.add(newVar);
            else
                localVariables.add(newVar);

            LLVMGenerator.declare(id, global, declType);
        }

        Variable variable = findVariable(id);

        if (variable == null) {
            System.err.println("Error: " + id + " never declared.");
            exit(1);
        }

        String finalValue = ensureType(value, exprType, variable.getType());

        String prefix = (globalVariables.contains(variable) && !localVariables.contains(variable)) ? "@" : "%";
        String llvmId = prefix + variable.getName();
        LLVMGenerator.assign(llvmId, finalValue, variable.getType());
    }

    @Override
    public void exitPrintStat(JacobParser.PrintStatContext ctx) {
        String value = valueStack.pop();
        Type type = typeStack.pop();

        if (type == Type.REAL) {
            LLVMGenerator.fpext(value, Type.REAL, Type.LONG_REAL);
            value = "%" + (LLVMGenerator.tmp - 1);
            type = Type.LONG_REAL;
        }

        LLVMGenerator.printf(value, type);
    }

    @Override
    public void exitRead(JacobParser.ReadContext ctx) {
        String id = ctx.ID().getText();

        if (ctx.type() != null) {
            boolean exists = global ?
                    globalVariables.stream().anyMatch(v -> v.getName().equals(id)) :
                    localVariables.stream().anyMatch(v -> v.getName().equals(id));

            if (exists) {
                System.err.println("Error: " + id + " already declared.");
                exit(1);
            }

            String declTypeText = ctx.type().getText();
            Type declType = mapAntlrTypeToEnum(ctx.type().getText());
            if (declType == null) {
                System.err.println("Unknown type " + declTypeText);
                exit(1);
            }

            Variable newVar = new Variable(id, declType);

            if (global)
                globalVariables.add(newVar);
            else
                localVariables.add(newVar);

            LLVMGenerator.declare(id, global, declType);
        }

        Variable var = findVariable(id);

        if (var == null) {
            System.err.println("Error: " + id + " never declared.");
            exit(1);
        }

        String prefix = (globalVariables.contains(var) && !localVariables.contains(var)) ? "@" : "%";
        String llvmId = prefix + var.getName();

        LLVMGenerator.scanf(llvmId, var.getType());
    }

    @Override
    public void exitInt(JacobParser.IntContext ctx) {
        String value = ctx.INT().getText();
        LLVMGenerator.add("0", value, Type.INT);

        valueStack.push("%" + (LLVMGenerator.tmp - 1));
        typeStack.push(Type.INT);
    }

    @Override
    public void exitReal(JacobParser.RealContext ctx) {
        String value = ctx.REAL().getText();
        LLVMGenerator.fadd("0.0", value, Type.REAL);

        valueStack.push("%" + (LLVMGenerator.tmp - 1));
        typeStack.push(Type.REAL);
    }

    @Override
    public void exitId(JacobParser.IdContext ctx) {
        String id = ctx.ID().getText();
        Variable variable = findVariable(id);

        if (variable == null) {
            System.err.println("Error: " + id + " never declared.");
            exit(1);
        }

        boolean isGlobal = globalVariables.contains(variable) && !localVariables.contains(variable);
        String llvmId = (isGlobal ? "@" : "%") + id;

        LLVMGenerator.load(llvmId, variable.getType());

        valueStack.push("%" + (LLVMGenerator.tmp - 1));
        typeStack.push(variable.getType());
    }

    @Override
    public void exitAddSub(JacobParser.AddSubContext ctx) {
        String op = ctx.op.getText();

        Type typeRight = typeStack.pop();
        Type typeLeft = typeStack.pop();

        String valueRight = valueStack.pop();
        String valueLeft = valueStack.pop();

        Type targetType = getStrongerType(typeLeft, typeRight);
        valueLeft = ensureType(valueLeft, typeLeft, targetType);
        valueRight = ensureType(valueRight, typeRight, targetType);

        if (targetType == Type.REAL || targetType == Type.LONG_REAL) {
            if (op.equals("+"))
                LLVMGenerator.fadd(valueLeft, valueRight, targetType);
            else
                LLVMGenerator.fsub(valueLeft, valueRight, targetType);
        } else {
            if (op.equals("+"))
                LLVMGenerator.add(valueLeft, valueRight, targetType);
            else
                LLVMGenerator.sub(valueLeft, valueRight, targetType);
        }

        valueStack.push("%" + (LLVMGenerator.tmp - 1));
        typeStack.push(targetType);
    }

    @Override
    public void exitMultDiv(JacobParser.MultDivContext ctx) {
        String op = ctx.op.getText();

        Type typeRight = typeStack.pop();
        Type typeLeft = typeStack.pop();

        String valueRight = valueStack.pop();
        String valueLeft = valueStack.pop();

        Type targetType = getStrongerType(typeLeft, typeRight);
        valueLeft = ensureType(valueLeft, typeLeft, targetType);
        valueRight = ensureType(valueRight, typeRight, targetType);

        if (targetType == Type.REAL || targetType == Type.LONG_REAL) {
            if (op.equals("*"))
                LLVMGenerator.fmul(valueLeft, valueRight, targetType);
            else
                LLVMGenerator.fdiv(valueLeft, valueRight, targetType);
        } else {
            if (op.equals("*"))
                LLVMGenerator.mul(valueLeft, valueRight, targetType);
            else
                LLVMGenerator.div(valueLeft, valueRight, targetType);
        }

        valueStack.push("%" + (LLVMGenerator.tmp - 1));
        typeStack.push(targetType);
    }

    @Override
    public void enterBlockif(JacobParser.BlockifContext ctx) {
        LLVMGenerator.startIf();
    }

    @Override
    public void exitBlockif(JacobParser.BlockifContext ctx) {
        LLVMGenerator.endIf();
    }

    private String ensureType(String value, Type current, Type target) {
        if (current == target) return value;

        if (current == Type.INT && target == Type.LONG_INT) {
            LLVMGenerator.sext(value, current, target);
        } else if (current == Type.REAL && target == Type.LONG_REAL) {
            LLVMGenerator.fpext(value, current, target);
        } else if ((current == Type.INT || current == Type.LONG_INT) &&
                (target == Type.REAL || target == Type.LONG_REAL)) {
            LLVMGenerator.sitofp(value, current, target);
        } else if ((current == Type.REAL || current == Type.LONG_REAL) &&
                (target == Type.INT || target == Type.LONG_INT)) {
            LLVMGenerator.fptosi(value, current, target);
        }

        return "%" + (LLVMGenerator.tmp - 1);
    }

    private Type getStrongerType(Type type1, Type type2) {
        if (type1 == Type.LONG_REAL || type2 == Type.LONG_REAL)
            return Type.LONG_REAL;
        else if (type1 == Type.REAL || type2 == Type.REAL)
            return Type.REAL;
        else if (type1 == Type.LONG_INT || type2 == Type.LONG_INT)
            return Type.LONG_INT;
        else
            return Type.INT;
    }

    private Variable findVariable(String id) {
        return localVariables.stream()
                .filter(v -> v.getName().equals(id))
                .findFirst()
                .orElse(globalVariables.stream()
                        .filter(v -> v.getName().equals(id))
                        .findFirst()
                        .orElse(null)
                );
    }

    private Type mapAntlrTypeToEnum(String text) {
        return switch (text) {
            case "real" -> Type.REAL;
            case "lint" -> Type.LONG_INT;
            case "lreal" -> Type.LONG_REAL;
            case "int" -> Type.INT;
            default -> null;
        };
    }
}
