package cs143;

import cs143.reader.*;
import cs143.ast.Ast;
import cs143.ast.AstDumpVisitor;
import cs143.ast.ReadASTVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

// Uncomment the lines below to run the AST to IR
import cs143.ir.AstToIR;
import cs143.ir.Code;
import cs143.ir.CodeDumpVisitor;
import cs143.ir.ProgramCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

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
        // a.dump(new PrintStream(fileout), 0);
        AstDumpVisitor av = new AstDumpVisitor(new PrintStream(fileout));
        av.visit(a);
        fileout.flush();
        fileout.close();
    }

   // Uncomment the lines below to run the AST to IR
   public static void CodeDumper(AstToIR ast_to_ir_object, Code c, String out_dir) throws Exception {

       CodeDumpVisitor cdv = new CodeDumpVisitor(out_dir, ast_to_ir_object);
       cdv.visit(c);
       cdv.ir_writer.close();
   }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome!");

        String AST_IN = args[0];
        String AST_OUT = args[1] + ".semant";

        System.out.println("Reading:        " + AST_IN);
        System.out.println("AST writing:    " + AST_OUT);

        System.out.print("Reading AST...");

        // Read in an AST, and dump it directly for debugging
        Ast a = ASTReader(AST_IN);
        AstDumper(a, AST_OUT);
        System.out.println(" done!");

        // AST to IR
        String IR_OUT_DIR = args[1];
        // File dir = new File(IR_OUT_DIR);
        // dir.mkdir();

        System.out.println("IR writing:   " + IR_OUT_DIR);
        System.out.print("Converting to IR...");

        // Convert AST to Code and dump directly for debugging
        AstToIR ast_to_ir_object = new AstToIR();
        Code c = ast_to_ir_object.visit(a);
        CodeDumper(ast_to_ir_object, c, IR_OUT_DIR);

        // ir_writer.close();
        System.out.println(" done!");

   }

}
