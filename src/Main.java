import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner1 scanner = null;
        Parser1 parser = null;
        CharStream input = null;
        CommonTokenStream tokens = null;
        ParseTree tree;

        try {

            input = CharStreams.fromFileName("test.txt");
            scanner = new generated.Scanner1(input);
            tokens = new CommonTokenStream(scanner);
            parser = new Parser1(scanner);
            parser.parse();

            if (parser.successful) {
                System.out.println("Compilación terminada exitosamente.");
            }else {
                System.out.println("Compilación terminada con errores.");
            }
        } catch (Exception e) {
            System.out.println("No hay archivo");
            e.printStackTrace();
        }
    }
}
