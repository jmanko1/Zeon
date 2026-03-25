
public class LLVMGenerator {

    static String header_text = "";
    static String main_text = "";
    static int main_tmp = 1;
    static int tmp = 1;
    static String buffer = "";

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
}
