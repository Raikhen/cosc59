import org.antlr.v4.runtime.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Listener extends ExprBaseListener {
    @Override
    public void exitExpr(ExprParser.ExprContext ctx) {
        System.out.println("Hey!" + ctx.getText());
    }

    @Override
    public void exitTerm(ExprParser.TermContext ctx) {
        System.out.println("Hey!" + ctx.getText());
    }

    public static void main(String[] args) throws Exception {
        // HashSet<String> ids = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader("inputs/test.txt"));
        String line = reader.readLine();

        while (line != null) {
            CharStream input = CharStreams.fromString(line);
            ExprLexer lexer = new ExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExprParser parser = new ExprParser(tokens);
            Listener listener = new Listener();
            parser.addParseListener(listener);
            parser.line();

            if (parser.getNumberOfSyntaxErrors() == 0) {
                // ...
            } else {
                System.out.println("Invalid input: " + line);
            }

            line = reader.readLine();
        }

        // String idsText = ids.toString();
        // idsText = idsText.substring(1, idsText.length() - 1);
        // System.out.println("Symbol Table: " + idsText + ".");
    }
}
