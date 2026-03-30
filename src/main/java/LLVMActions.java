import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class LLVMActions extends ZeonBaseListener {
    private Map<String, Function> functions = new HashMap<>();
    private Set<Variable> globalVariables = new HashSet<>();
    private Stack<Set<Variable>> localVariables = new Stack<>();
    private Boolean global;
    private Function currentFunction;

    private Stack<Type> typeStack = new Stack<>();
    private Stack<String> valueStack = new Stack<>();

    @Override
    public void enterProgram(ZeonParser.ProgramContext ctx) {
        global = true;
        currentFunction = null;
    }

    @Override
    public void exitProgram(ZeonParser.ProgramContext ctx) {
        LLVMGenerator.close_main();
        String code = LLVMGenerator.generate();

        try (PrintWriter out = new PrintWriter("out.ll")) {
            out.print(code);
            System.out.println("Successfully compiled into IR.");
        } catch (IOException e) {
            System.err.println("Error while saving the IR file: " + e.getMessage());
        }
    }

    @Override
    public void exitDeclStat(ZeonParser.DeclStatContext ctx) {
        String id = ctx.decl().ID().getText();
        Type type = mapAntlrTypeToEnum(ctx.decl().type().getText());
        registerVariable(ctx, id, type);
    }

    @Override
    public void exitAssignStat(ZeonParser.AssignStatContext ctx) {
        String id = ctx.assign().ID().getText();
        String value = valueStack.pop();
        Type exprType = typeStack.pop();

        if (ctx.assign().type() != null) {
            Type declType = mapAntlrTypeToEnum(ctx.assign().type().getText());
            registerVariable(ctx, id, declType);
        }

        Variable variable = findVariable(id);
        if (variable == null) {
            error(ctx, "Unknown variable " + id + ".");
        }

        String finalValue = ensureType(value, exprType, variable.getType());

        boolean isGlobal = globalVariables.contains(variable);
        String prefix = isGlobal ? "@" : "%";
        LLVMGenerator.assign(prefix + variable.getName(), finalValue, variable.getType());
    }

    @Override
    public void exitPrintStat(ZeonParser.PrintStatContext ctx) {
        String value = valueStack.pop();
        Type type = typeStack.pop();

        if (type == Type.FLOAT) {
            LLVMGenerator.fpext(value, Type.FLOAT, Type.DOUBLE);
            value = "%" + (LLVMGenerator.tmp - 1);
            type = Type.DOUBLE;
        }

        LLVMGenerator.printf(value, type);
    }

    @Override
    public void exitRead(ZeonParser.ReadContext ctx) {
        String id = ctx.ID().getText();
        if (ctx.type() != null) {
            registerVariable(ctx, id, mapAntlrTypeToEnum(ctx.type().getText()));
        }

        Variable variable = findVariable(id);
        if (variable == null)
            error(ctx, "Unknown variable " + id + ".");

        boolean isGlobal = globalVariables.contains(variable);
        LLVMGenerator.scanf((isGlobal ? "@" : "%") + id, variable.getType());
    }

    @Override
    public void exitUnaryMinus(ZeonParser.UnaryMinusContext ctx) {
        Type type = typeStack.pop();
        String value = valueStack.pop();

        if (type == Type.FLOAT || type == Type.DOUBLE) {
            LLVMGenerator.fmul(value, "-1.0", type);
        } else {
            LLVMGenerator.mul(value, "-1", type);
        }

        valueStack.push("%" + (LLVMGenerator.tmp - 1));
        typeStack.push(type);
    }

    @Override
    public void exitInt(ZeonParser.IntContext ctx) {
        String value = ctx.INT().getText();
        LLVMGenerator.add("0", value, Type.LONG_INT);

        valueStack.push("%" + (LLVMGenerator.tmp - 1));
        typeStack.push(Type.LONG_INT);
    }


    @Override
    public void exitReal(ZeonParser.RealContext ctx) {
        String value = ctx.REAL().getText();
        LLVMGenerator.fadd("0.0", value, Type.DOUBLE);

        valueStack.push("%" + (LLVMGenerator.tmp - 1));
        typeStack.push(Type.DOUBLE);
    }

    @Override
    public void exitId(ZeonParser.IdContext ctx) {
        String id = ctx.ID().getText();
        Variable variable = findVariable(id);
        if (variable == null)
            error(ctx, "Unknown variable " + id + ".");

        if (variable.getIsArgument()) {
            valueStack.push("%" + variable.getName());
            typeStack.push(variable.getType());
        } else {
            boolean isGlobal = globalVariables.contains(variable);
            String prefix = isGlobal ? "@" : "%";

            LLVMGenerator.load(prefix + variable.getName(), variable.getType());
            valueStack.push("%" + (LLVMGenerator.tmp - 1));
            typeStack.push(variable.getType());
        }
    }

    @Override
    public void exitAddSub(ZeonParser.AddSubContext ctx) {
        String op = ctx.op.getText();

        Type typeRight = typeStack.pop();
        Type typeLeft = typeStack.pop();

        String valueRight = valueStack.pop();
        String valueLeft = valueStack.pop();

        Type targetType = getStrongerType(typeLeft, typeRight);
        valueLeft = ensureType(valueLeft, typeLeft, targetType);
        valueRight = ensureType(valueRight, typeRight, targetType);

        if (targetType == Type.FLOAT || targetType == Type.DOUBLE) {
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
    public void exitMultDiv(ZeonParser.MultDivContext ctx) {
        String op = ctx.op.getText();

        Type typeRight = typeStack.pop();
        Type typeLeft = typeStack.pop();

        String valueRight = valueStack.pop();
        String valueLeft = valueStack.pop();

        Type targetType = getStrongerType(typeLeft, typeRight);
        valueLeft = ensureType(valueLeft, typeLeft, targetType);
        valueRight = ensureType(valueRight, typeRight, targetType);

        if (targetType == Type.FLOAT || targetType == Type.DOUBLE) {
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
    public void enterBlockif(ZeonParser.BlockifContext ctx) {
        global = false;
        localVariables.push(new HashSet<>());
    }

    @Override
    public void exitCond(ZeonParser.CondContext ctx) {
        String op = ctx.op.getText();

        Type typeRight = typeStack.pop();
        Type typeLeft = typeStack.pop();
        String valueRight = valueStack.pop();
        String valueLeft = valueStack.pop();

        Type targetType = getStrongerType(typeLeft, typeRight);
        valueLeft = ensureType(valueLeft, typeLeft, targetType);
        valueRight = ensureType(valueRight, typeRight, targetType);

        if (targetType == Type.FLOAT || targetType == Type.DOUBLE)
            LLVMGenerator.fcmp(valueLeft, op, valueRight, targetType);
        else
            LLVMGenerator.icmp(valueLeft, op, valueRight, targetType);

        String condResult = "%" + (LLVMGenerator.tmp - 1);
        valueStack.push(condResult);
        typeStack.push(Type.INT);

        if (ctx.getParent() instanceof ZeonParser.BlockifContext)
            LLVMGenerator.startIf(condResult);
        else if (ctx.getParent() instanceof ZeonParser.BlockwhileContext)
            LLVMGenerator.whileCond(condResult);
    }

    @Override
    public void exitBlockif(ZeonParser.BlockifContext ctx) {
        localVariables.pop();

        if (localVariables.size() <= 1 && currentFunction == null) {
            global = true;
        }

        LLVMGenerator.endIf();
    }

    @Override
    public void enterBlockwhile(ZeonParser.BlockwhileContext ctx) {
        global = false;
        localVariables.push(new HashSet<>());
        LLVMGenerator.startWhile();
    }

    @Override
    public void exitBlockwhile(ZeonParser.BlockwhileContext ctx) {
        localVariables.pop();

        if (localVariables.size() <= 1 && currentFunction == null)
            global = true;

        LLVMGenerator.endWhile();
    }

    @Override
    public void enterFunc(ZeonParser.FuncContext ctx) {
        global = false;

        String id = ctx.ID().getText();
        if (functions.containsKey(id))
            error(ctx, "Function " + id + " is already defined.");

        String returnType = mapAntlrTypeToLlvmType(ctx.functype().getText());
        StringBuilder funcHeaderBuilder = new StringBuilder("define " + returnType + " @" + id + "(");
        localVariables.push(new HashSet<>());
        List<Type> argumentTypes = new ArrayList<>();

        if (ctx.params() != null) {
            for (int i = 0; i < ctx.params().param().size(); i++) {
                ZeonParser.ParamContext pctx = ctx.params().param(i);
                String paramId = pctx.ID().getText();
                String paramType = mapAntlrTypeToLlvmType(pctx.type().getText());
                funcHeaderBuilder.append(paramType).append(" %").append(paramId);

                if (i < ctx.params().param().size() - 1)
                    funcHeaderBuilder.append(", ");

                Type paramTypeEnum = mapAntlrTypeToEnum(pctx.type().getText());
                argumentTypes.add(paramTypeEnum);
                localVariables.peek().add(new Variable(paramId, true, paramTypeEnum));
            }
        }

        Function function = new Function(false, argumentTypes, mapAntlrTypeToEnum(ctx.functype().getText()));
        functions.put(id, function);
        currentFunction = function;
        funcHeaderBuilder.append(") nounwind {\n");
        LLVMGenerator.startFunc(funcHeaderBuilder.toString());
    }

    @Override
    public void exitFunc(ZeonParser.FuncContext ctx) {
        global = true;
        currentFunction = null;

        String id = ctx.ID().getText();
        Function function = functions.get(id);
        LLVMGenerator.endFunc(function.getReturnType());
        localVariables.pop();
    }

    @Override
    public void exitCallFunc(ZeonParser.CallFuncContext ctx) {
        String id = ctx.ID().getText();
        Function function = functions.get(id);
        if (function == null)
            error(ctx, "Undefined function " + id);

        int providedArgsCount = ctx.args() != null ? ctx.args().expr().size() : 0;
        List<Type> expectedArgTypes = function.getArgumentTypes();
        int expectedArgsCount = expectedArgTypes.size();
        if (providedArgsCount != expectedArgsCount)
            error(ctx, "Function " + id + " expects " + expectedArgsCount +
                    " arguments, but " + providedArgsCount + " were provided.");

        Type returnType = function.getReturnType();
        Stack<String> args = new Stack<>();
        for (int i = expectedArgsCount - 1; i >= 0; i--) {
            Type expectedType = expectedArgTypes.get(i);
            Type providedType = typeStack.pop();
            String providedValue = valueStack.pop();

            String convertedValue = ensureType(providedValue, providedType, expectedType);
            args.push(convertedValue);
        }

        LLVMGenerator.call(id, args, expectedArgTypes, returnType);

        if (returnType != Type.VOID) {
            valueStack.push("%" + (LLVMGenerator.tmp - 1));
            typeStack.push(returnType);
        }
    }

    @Override
    public void exitReturnStat(ZeonParser.ReturnStatContext ctx) {
        if (currentFunction == null)
            error(ctx, "Return statement outside of a function.");

        if (currentFunction.getReturnType() == Type.VOID)
            error(ctx, "Cannot return a value in a void function.");

        Type exprType = typeStack.pop();
        String exprValue = valueStack.pop();
        String convertedValue = ensureType(exprValue, exprType, currentFunction.getReturnType());
        LLVMGenerator.ret(convertedValue, currentFunction.getReturnType());
        currentFunction.setHasReturn(true);
    }

    private void error(ParserRuleContext ctx, String msg) {
        int line = ctx.getStart().getLine();
        System.err.println("Error at line " + line + ": " + msg);
        System.exit(1);
    }

    private boolean isDeclaredInTheScope(String id) {
        if (global)
            return globalVariables.stream().anyMatch(v -> v.getName().equals(id));
        else
            return localVariables.stream().anyMatch(s -> s.stream().anyMatch(v -> v.getName().equals(id)));
    }

    private void registerVariable(ParserRuleContext ctx, String id, Type type) {
        if (isDeclaredInTheScope(id))
            error(ctx, "Variable " + id + " is already declared in the scope.");

        Variable newVar = new Variable(id, false, type);
        if (global)
            globalVariables.add(newVar);
        else
            localVariables.peek().add(newVar);

        LLVMGenerator.declare(id, global, type);
    }

    private String mapAntlrTypeToLlvmType(String antlrType) {
        return switch (antlrType) {
            case "long int" -> "i64";
            case "float" -> "float";
            case "double" -> "double";
            case "int" -> "i32";
            default -> antlrType;
        };
    }

    private String ensureType(String value, Type current, Type target) {
        if (current == target) return value;

        // int -> long int
        if (current == Type.INT && target == Type.LONG_INT) {
            LLVMGenerator.sext(value, current, target);
        }
        // long int -> int
        else if (current == Type.LONG_INT && target == Type.INT) {
            LLVMGenerator.trunc(value, current, target);
        }

        // float -> double
        else if (current == Type.FLOAT && target == Type.DOUBLE) {
            LLVMGenerator.fpext(value, current, target);
        }

        // double -> float
        else if (current == Type.DOUBLE && target == Type.FLOAT) {
            LLVMGenerator.fptrunc(value, current, target);
        }

        // int/long int -> float/double
        else if ((current == Type.INT || current == Type.LONG_INT) &&
                (target == Type.FLOAT || target == Type.DOUBLE)) {
            LLVMGenerator.sitofp(value, current, target);
        }

        // float/double -> int/long int
        else if ((current == Type.FLOAT || current == Type.DOUBLE) &&
                (target == Type.INT || target == Type.LONG_INT)) {
            LLVMGenerator.fptosi(value, current, target);
        }

        else
            return value;

        return "%" + (LLVMGenerator.tmp - 1);
    }

    private Type getStrongerType(Type type1, Type type2) {
        if (type1 == Type.DOUBLE || type2 == Type.DOUBLE)
            return Type.DOUBLE;
        else if (type1 == Type.FLOAT || type2 == Type.FLOAT)
            return Type.FLOAT;
        else if (type1 == Type.LONG_INT || type2 == Type.LONG_INT)
            return Type.LONG_INT;
        else
            return Type.INT;
    }

    private Variable findVariable(String id) {
        for (int i = localVariables.size() - 1; i >= 0; i--) {
            for (Variable v : localVariables.get(i)) {
                if (v.getName().equals(id))
                    return v;
            }
        }

        return globalVariables.stream()
                .filter(v -> v.getName().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Type mapAntlrTypeToEnum(String text) {
        return switch (text) {
            case "float" -> Type.FLOAT;
            case "long int" -> Type.LONG_INT;
            case "double" -> Type.DOUBLE;
            case "int" -> Type.INT;
            case "void" -> Type.VOID;
            default -> null;
        };
    }
}
