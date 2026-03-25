import java.util.Stack;

public class LLVMGenerator {

    static String header_text = "";
    static String main_text = "";
    static String buffer = "";

    static int main_tmp = 1;
    static int tmp = 1;
    static int br = 0;

    static Stack<Integer> brstack = new Stack<>();

    static void declare(String id, Boolean global, Type type) {
        String typeText = getTypeText(type);

        if (global)
            header_text += "@"+id+" = global "+typeText+" "+getInitialValue(type)+"\n";
        else
            buffer += "%"+id+" = alloca "+typeText+"\n";
    }

    static void assign(String id, String value, Type type) {
        String typeText = getTypeText(type);
        buffer += "store "+typeText+" "+value+", "+typeText+"* "+id+"\n";
    }

    static String getTypeText(Type type) {
        String typeText;

        switch (type) {
            case REAL -> typeText = "float";
            case LONG_INT -> typeText = "i64";
            case LONG_REAL -> typeText = "double";
            default -> typeText = "i32";
        }

        return typeText;
    }

    static String getInitialValue(Type type) {
        if (type == Type.REAL || type == Type.LONG_REAL) return "0.0";
        return "0";
    }

    static void close_main() {
        main_text += buffer;
    }

    static String generate() {
        String text = "";

        text += "declare i32 @printf(i8*, ...)\n";
        text += "declare i32 @__isoc99_scanf(i8*, ...)\n";
        text += "@strp = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strs = constant [3 x i8] c\"%d\\00\"\n";
        text += "@strf = constant [4 x i8] c\"%f\\0A\\00\"\n";
        text += header_text;
        text += "define i32 @main() nounwind{\n";
        text += main_text;
        text += "ret i32 0 }\n";

        return text;
    }

    static void sext(String id, Type fromType, Type toType) {
        String fromTypeStr = getTypeText(fromType);
        String toTypeStr = getTypeText(toType);

        buffer += "%" + tmp + " = sext " + fromTypeStr + " " + id + " to " + toTypeStr + "\n";
        tmp++;
    }

    static void fpext(String id, Type fromType, Type toType) {
        String fromTypeStr = getTypeText(fromType);
        String toTypeStr = getTypeText(toType);

        buffer += "%" + tmp + " = fpext " + fromTypeStr + " " + id + " to " + toTypeStr + "\n";
        tmp++;
    }

    static void sitofp(String id, Type fromType, Type toType) {
        String fromTypeStr = getTypeText(fromType);
        String toTypeStr = getTypeText(toType);

        buffer += "%" + tmp + " = sitofp " + fromTypeStr + " " + id + " to " + toTypeStr + "\n";
        tmp++;
    }

    static void fptosi(String id, Type fromType, Type toType) {
        String fromTypeStr = getTypeText(fromType);
        String toTypeStr = getTypeText(toType);

        buffer += "%" + tmp + " = fptosi " + fromTypeStr + " " + id + " to " + toTypeStr + "\n";
        tmp++;
    }

    static void fadd(String value0, String value1, Type targetType) {
        String type = getTypeText(targetType);
        buffer += "%" + tmp + " = fadd " + type + " " + value0 + ", " + value1 + "\n";
        tmp++;
    }

    static void fsub(String value0, String value1, Type targetType) {
        String type = getTypeText(targetType);
        buffer += "%" + tmp + " = fsub " + type + " " + value0 + ", " + value1 + "\n";
        tmp++;
    }

    static void add(String value0, String value1, Type targetType) {
        String type = getTypeText(targetType);
        buffer += "%" + tmp + " = add " + type + " " + value0 + ", " + value1 + "\n";
        tmp++;
    }

    static void sub(String value0, String value1, Type targetType) {
        String type = getTypeText(targetType);
        buffer += "%" + tmp + " = sub " + type + " " + value0 + ", " + value1 + "\n";
        tmp++;
    }

    static void mul(String value0, String value1, Type targetType) {
        String type = getTypeText(targetType);
        buffer += "%" + tmp + " = mul " + type + " " + value0 + ", " + value1 + "\n";
        tmp++;
    }

    static void fmul(String value0, String value1, Type targetType) {
        String type = getTypeText(targetType);
        buffer += "%" + tmp + " = fmul " + type + " " + value0 + ", " + value1 + "\n";
        tmp++;
    }

    static void div(String value0, String value1, Type targetType) {
        String type = getTypeText(targetType);
        buffer += "%" + tmp + " = sdiv " + type + " " + value0 + ", " + value1 + "\n";
        tmp++;
    }

    static void fdiv(String val0, String val1, Type targetType) {
        String type = getTypeText(targetType);
        buffer += "%" + tmp + " = fdiv " + type + " " + val0 + ", " + val1 + "\n";
        tmp++;
    }

    static void load(String id, Type type) {
        String t = getTypeText(type);
        buffer += "%" + tmp + " = load " + t + ", " + t + "* " + id + "\n";
        tmp++;
    }

    static void printf(String id, Type type) {
        String format = (type == Type.REAL || type == Type.LONG_REAL) ? "@strf" : "@strp";
        String t = getTypeText(type);

        buffer += "%" + tmp + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ";
        buffer += "([4 x i8], [4 x i8]* " + format + ", i32 0, i32 0), " + t + " " + id + ")\n";
        tmp++;
    }

    static void scanf(String id, Type type) {
        String format = (type == Type.REAL || type == Type.LONG_REAL) ? "@strsf" : "@strs";
        String t = getTypeText(type);

        buffer += "%" + tmp + " = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ";
        buffer += "([3 x i8], [3 x i8]* " + format + ", i32 0, i32 0), " + t + "* " + id + ")\n";
        tmp++;
    }

    public static void startIf() {
        br++;
        main_text += "br i1 %"+(tmp-1)+", label %true"+br+", label %false"+br+"\n";
        main_text += "true"+br+":\n";
        brstack.push(br);
    }

    static void icmp(String id, Cond cond, String value){
        main_text += "%"+tmp+" = load i32, i32* %"+id+"\n";
        tmp++;

        String llvmCond = "";
        switch (cond) {
            case EQ -> llvmCond = "eq";
            case NEQ -> llvmCond = "neq";
            case GT -> llvmCond = "gt";
            case LT -> llvmCond = "lt";
            case GTE -> llvmCond = "gte";
            case LTE -> llvmCond = "lte";
        }

        main_text += "%"+tmp+" = icmp "+llvmCond+" i32 %"+(tmp-1)+", "+value+"\n";
        tmp++;
    }

    public static void endIf() {
        int b = brstack.pop();
        main_text += "br label %false"+b+"\n";
        main_text += "false"+b+":\n";
    }
}
