package cs143;

import cs143.lexparse.CoolLexer;
import cs143.lexparse.CoolParser;
import cs143.lexparse.ReadCoolVisitor;
import cs143.ast.Ast;
import cs143.ast.AstDumpVisitor;
import cs143.ast.ReadASTVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Main {


    public static class MyErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(
                Recognizer<?,?> recognizer,
                Object offendingSymbol,
                int line,
                int charPositionInLine,
                String msg,
                RecognitionException e)
        {
            System.err.println("Bad token at line: " + line + " position: " + charPositionInLine);
            System.exit(1);
        }
    }

    static ANTLRErrorListener errListener = new MyErrorListener();
    static ANTLRErrorListener errListener2 = new MyErrorListener();

    public static Ast CoolReader(String f_in) throws Exception {
        Ast a = null;
        try {
            FileInputStream filein = new FileInputStream(f_in);
            CoolLexer lexer = new CoolLexer(new ANTLRInputStream(filein));



            lexer.removeErrorListeners();
            lexer.addErrorListener(errListener);

            CoolParser parser = new CoolParser(new CommonTokenStream(lexer));

            parser.removeErrorListeners();
            parser.addErrorListener(errListener2);

            ParseTree tree = parser.program();
            System.out.println(tree.toStringTree(parser));



            ReadCoolVisitor c = new ReadCoolVisitor(f_in);

            if (lexer.nesting > 0) {
                throw new RuntimeException("Bad comment");
            }
            a = c.visit(tree);
        }
        catch(Exception exc) {
            System.err.println("Exception: bad comment");
            System.exit(1);
        }

        return a;
    }

    public static void AstDumper(Ast a, String f_out) throws Exception {
        FileOutputStream fileout = new FileOutputStream(f_out);
        //        a.dump(new PrintStream(fileout), 0);
        AstDumpVisitor av = new AstDumpVisitor(new PrintStream(fileout));
        av.visit(a);
        fileout.flush();
        fileout.close();
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Welcome!");

        String COOL_IN = args[0];
        String AST_OUT = args[1] + ".out";
        System.out.println("Reading:        " + COOL_IN);
        System.out.println("AST writing:    " + AST_OUT);

        Ast a = CoolReader(COOL_IN);

        boolean debug = false;
        if (debug) {
            System.out.println("Done reading");
        }

        AstDumper(a, AST_OUT);
        System.out.println(" done!");
    }

}
