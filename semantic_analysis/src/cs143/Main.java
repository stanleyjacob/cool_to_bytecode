package cs143;

import cs143.reader.*;
import cs143.semant.*;
import cs143.ast.Ast;
import cs143.ast.AstDumpVisitor;
import cs143.ast.ReadASTVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Main {

    public static Ast ASTReader(String f_in) throws Exception {
        FileInputStream filein = new FileInputStream(f_in);

        ASTLexer lexer = new ASTLexer(new ANTLRInputStream(filein));
        ASTParser parser = new ASTParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();
        // System.out.println(tree.toStringTree(parser));

        ReadASTVisitor c = new ReadASTVisitor();
        Ast a = c.visit(tree);
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

        String AST_IN = args[0];
        String AST_OUT = args[1] + ".out";
        String SEMANT_OUT = args[1] + ".semant";

        System.out.println("Reading:        " + AST_IN);
        System.out.println("AST writing:    " + AST_OUT);

        System.out.print("Reading AST...");
        // Read in an AST, and dump it directly for debugging
        Ast a = ASTReader(AST_IN);
        //AstDumper(a, AST_OUT);
        System.out.println(" done!");

        System.out.print("Checking types...");
        // Annotate the AST with types, and dump it directly for debugging
        new SemantVisitor().visit(a);
        AstDumper(a, SEMANT_OUT);
        System.out.println(" done!");
   }
}
