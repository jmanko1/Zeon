import java.util.List;
import java.util.Stack;

public class LLVMGenerator {

    static String header_text = "";
    static String main_text = "";
    static String buffer = "";

    static int main_tmp = 1;
    static int tmp = 1;
    static int br = 0;

    static Stack<Integer> brStack = new Stack<>();

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
        return switch (type) {
            case FLOAT -> "float";
            case LONG_INT -> "i64";
            case DOUBLE -> "double";
            case INT -> "i32";
            default -> "void";
        };
    }

    static String getInitialValue(Type type) {
        if (type == Type.FLOAT || type == Type.DOUBLE) return "0.0";
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
        text += "@strsf = constant [4 x i8] c\"%lf\\00\"\n";
        text += "@strpl = constant [5 x i8] c\"%ld\\0A\\00\"\n";
        text += header_text;
        text += "define i32 @main() nounwind{\n";
        text += main_text;
        text += "ret i32 0 \n}\n";

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
        String format = "";
        String size = "[4 x i8]"; // Domyślnie dla %d\n i %f\n

        switch (type) {
            case INT -> format = "@strp";
            case FLOAT, DOUBLE -> format = "@strf";
            case LONG_INT -> {
                format = "@strpl";
                size = "[5 x i8]"; // Dla %ld\n\0 (5 znaków)
            }
        }

        String t = getTypeText(type);

        buffer += "%" + tmp + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ";
        // Używamy zmiennej 'size' zamiast sztywnego '[4 x i8]'
        buffer += "(" + size + ", " + size + "* " + format + ", i32 0, i32 0), " + t + " " + id + ")\n";
        tmp++;
    }

    static void scanf(String id, Type type) {
        String format = "";
        String size = "";

        if (type == Type.FLOAT || type == Type.DOUBLE) {
            format = "@strsf";
            size = "[4 x i8]";
        } else {
            format = "@strs";
            size = "[3 x i8]";
        }

        buffer += "%" + tmp + " = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ";
        buffer += "(" + size + ", " + size + "* " + format + ", i32 0, i32 0), " + getTypeText(type) + "* " + id + ")\n";
        tmp++;
    }

    static void startIf(String cond) {
        br++;
        brStack.push(br);

        buffer += "br i1 " + cond + ", label %true" + br + ", label %false" + br + "\n";
        buffer += "true" + br + ":\n";
    }

    static void icmp(String valueLeft, String op, String valueRight, Type targetType) {
        String type = getTypeText(targetType);

        String cond = switch (op) {
            case "!=" -> "ne";
            case ">" -> "sgt";
            case "<" -> "slt";
            case ">=" -> "sge";
            case "<=" -> "sle";
            default -> "eq";
        };

        buffer += "%" + tmp + " = icmp " + cond + " " + type + " " + valueLeft + ", " + valueRight + "\n";
        tmp++;
    }

    static void fcmp(String valueLeft, String op, String valueRight, Type targetType) {
        String type = getTypeText(targetType);

        String cond = switch (op) {
            case "!=" -> "one";
            case ">" -> "ogt";
            case "<" -> "olt";
            case ">=" -> "oge";
            case "<=" -> "ole";
            default -> "oeq";
        };

        buffer += "%" + tmp + " = fcmp " + cond + " " + type + " " + valueLeft+ ", " + valueRight + "\n";
        tmp++;
    }

    static void endIf() {
        int b = brStack.pop();
        String check = buffer.trim();
        if (!check.endsWith("ret i64 %3") && !check.contains("ret ")) {
            buffer += "br label %false" + b + "\n";
        }
        buffer += "false" + b + ":\n";
    }

    static void startWhile() {
        br++;
        brStack.push(br);
        buffer += "br label %while_start" + br + "\n";
        buffer += "while_start" + br + ":\n";
    }

    static void whileCond(String cond) {
        int id = brStack.peek();
        buffer += "br i1 " + cond + ", label %while_true" + id + ", label %while_end" + id + "\n";
        buffer += "while_true" + id + ":\n";
    }

    static void endWhile() {
        int id = brStack.pop();
        buffer += "br label %while_start" + id + "\n";
        buffer += "while_end" + id + ":\n";
    }

    static void startFunc(String header) {
        main_text += buffer;
        buffer = header;
        main_tmp = tmp;
        tmp = 1;
    }

    static void ret(String value, Type returnType) {
        buffer += "ret " + getTypeText(returnType) + " " + value + "\n";
    }

    static void endFunc(Type returnType) {
        if (returnType == Type.VOID)
            buffer += "ret void\n";

        buffer += "}\n";
        header_text += buffer;
        buffer = "";
        tmp = main_tmp;
    }

    static void call(String id, Stack<String> args, List<Type> argsTypes, Type returnType) {
        if (returnType == Type.VOID)
            buffer += "call void @" + id + "(";
        else {
            buffer += "%" + tmp + " = call " + getTypeText(returnType) + " @" + id + "(";
            tmp++;
        }

        for (int i = 0; i < argsTypes.size(); i++) {
            String t = getTypeText(argsTypes.get(i));
            String arg = args.pop();
            buffer += t + " " + arg;
            if (i < argsTypes.size() - 1)
                buffer += ", ";
        }

        buffer += ")\n";
    }

    static void trunc(String id, Type fromType, Type toType) {
        buffer += "%" + tmp + " = trunc " + getTypeText(fromType) + " " + id + " to " + getTypeText(toType) + "\n";
        tmp++;
    }

    static void fptrunc(String id, Type fromType, Type toType) {
        buffer += "%" + tmp + " = fptrunc " + getTypeText(fromType) + " " + id + " to " + getTypeText(toType) + "\n";
        tmp++;
    }
}
