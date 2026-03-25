import java.util.HashSet;

public class LLVMActions extends JacobBaseListener {
    private HashSet<String> functionNames = new HashSet<>();
    private HashSet<Variable> globalVariables = new HashSet<>();
    private HashSet<Variable> localVariables = new HashSet<>();
    private Boolean global;

    @Override
    public void enterProgram(JacobParser.ProgramContext ctx) {
        global = true;
    }

    @Override
    public void exitProgram(JacobParser.ProgramContext ctx) {
        LLVMGenerator.close_main();
        System.out.println( LLVMGenerator.generate() );
    }

    @Override public void exitDeclStat(JacobParser.DeclStatContext ctx) {

    }

    @Override public void exitAssignStat(JacobParser.AssignStatContext ctx) {
        String id = ctx.assign().ID().getText();
        String value = "%" + (LLVMGenerator.tmp - 1);

        // int x = 5;
        if (ctx.assign().type() != null) {
            // Czy jest zmienna globalna lub lokalna o takim identyfikatorze?
            boolean exists = global ?
                    globalVariables.stream().anyMatch(v -> v.getName().equals(id)) :
                    localVariables.stream().anyMatch(v -> v.getName().equals(id));

            if (exists) {
                System.err.println("Error: " + id + " is already declared.");
                return;
            }

            Type type = mapAntlrTypeToEnum(ctx.assign().type().getText());
            Variable newVar = new Variable(id, type);

            if (global)
                globalVariables.add(newVar);
            else
                localVariables.add(newVar);

            LLVMGenerator.declare(id, global, type);
        } else {
            // x = 5;
            Variable variable = localVariables.stream()
                    .filter(v -> v.getName().equals(id))
                    .findFirst()
                    .orElse(globalVariables.stream()
                            .filter(v -> v.getName().equals(id))
                            .findFirst()
                            .orElse(null)
                    );

            if (variable == null) {
                System.err.println("Error: " + id + " never declared.");
                return;
            }

            
        }
    }

    @Override public void exitPrintStat(JacobParser.PrintStatContext ctx) {

    }

    private Type mapAntlrTypeToEnum(String text) {
        return switch (text) {
            case "real" -> Type.REAL;
            case "lint" -> Type.LONG_INT;
            case "lreal" -> Type.LONG_REAL;
            default -> Type.INT;
        };
    }
}
