import org.antlr.v4.runtime.*;

import java.util.HashSet;
import java.util.LinkedList;

public class ErrorHandler extends BaseErrorListener {
    // private final boolean report = false;
    // private HashSet<Integer> errorlines = new HashSet<>();

    public static void main(String[] args) throws Exception {
        /*
        CharStream input = CharStreams.fromFileName("inputs/test.txt");
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        // remove ALL error listeners to prevent cluttering stdout/stderr
        parser.removeErrorListeners();
        // add an instance of this class as a error listener
        ErrorHandler handler = new ErrorHandler();
        parser.addErrorListener(handler);

        parser.start();

        if(handler.errorlines.isEmpty()) {
            System.out.println("No Errors detected");
        } else {
            System.out.println("Errors detected on lines: " + handler.errorlines);
        }
        */
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        /*
        errorlines.add(line);
        if(report) {
            System.out.println("Syntax error detected");
            System.out.println("  Location: " + line + ":" + charPositionInLine);
            System.out.println("  Message: " + msg);
        }
        */
    }
}
