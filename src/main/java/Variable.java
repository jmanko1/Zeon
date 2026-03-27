public class Variable {
    private String name;
    private Type type;
    private Boolean isArgument;

    public Variable(String name, Boolean isArgument, Type type) {
        this.name = name;
        this.isArgument = isArgument;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsArgument() {
        return isArgument;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
