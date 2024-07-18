import org.antlr.v4.runtime.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class Listener extends ExprBaseListener {
    private static String toPrint = "";
    private static HashSet<String> ids = new HashSet<>();

    @Override
    public void exitTerm(ExprParser.TermContext ctx) {
        String s = ctx.parent.getChild(0).getText();
        int index = ctx.parent.getRuleIndex();

        if (index == 2) {
            toPrint += s + " ";
        }
    }

    @Override
    public void exitFactor(ExprParser.FactorContext ctx) {
        if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            toPrint += id + " ";
            ids.add(id);
        } else if (ctx.NUM() != null) {
            toPrint += ctx.NUM().getText() + " ";
        }

        String s = ctx.parent.getChild(0).getText();
        int index = ctx.parent.getRuleIndex();

        if (index == 4) {
            toPrint += s + " ";
        }
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
            toPrint = "";
            parser.line();

            if (parser.getNumberOfSyntaxErrors() == 0) {
                System.out.println(toPrint + ";");
            } else {
                System.out.println("Invalid input: " + line);
            }

            line = reader.readLine();
        }

        String idsText = ids.toString();
        idsText = idsText.substring(1, idsText.length() - 1);
        System.out.println("Symbol Table: " + idsText + ".");
    }
}
