import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName(args[0]);

        JacobLexer lexer = new JacobLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JacobParser parser = new JacobParser(tokens);

        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new LLVMActions(), tree);
    }
}
