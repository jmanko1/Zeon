import java.util.List;

public class Function {
    private Type returnType;
    private List<Type> argumentTypes;
    private Boolean hasReturn = false;

    public Function(Boolean hasReturn, List<Type> argumentTypes, Type returnType) {
        this.hasReturn = hasReturn;
        this.argumentTypes = argumentTypes;
        this.returnType = returnType;
    }

    public void setHasReturn(Boolean hasReturn) {
        this.hasReturn = hasReturn;
    }

    public Type getReturnType() {
        return returnType;
    }


    public List<Type> getArgumentTypes() {
        return argumentTypes;
    }
}
