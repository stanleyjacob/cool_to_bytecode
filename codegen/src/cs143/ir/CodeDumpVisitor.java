package cs143.ir;

import cs143.environment.VarSymbol;
import cs143.environment.MethodSymbol;

import cs143.ast.AttrFeature;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
// import java.io.PrintStream;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CodeDumpVisitor extends CodeVisitor<Void> {

    public BufferedWriter ir_writer;
    public BufferedWriter curr_jasmin_writer;
    public String curr_class_name;
    public AstToIR ast_to_ir_object;

    int indentation;
    Set<String> built_in_classes = new HashSet<String>();
    String test_filename;
    int file_count;

    String curr_method_return_type;

    void incr() { indentation = indentation + 2; }
    void dec() { indentation = indentation - 2; }

    void addBuiltInClasses() {
        built_in_classes.add("String");
        built_in_classes.add("Object");
        built_in_classes.add("IO");
        built_in_classes.add("Int");
        built_in_classes.add("Bool");
    }

    String pad() {
        char a[] = new char[indentation];
        for (int i = 0; i < indentation; i++) a[i] = ' ';
        return new String(a);
    }

    private void println(String s) {
        try {
            ir_writer.write(pad() + s);
            ir_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }
    }

    private void printlnTy(String s) {
        println(": " + s);
    }

    private void printlnSub(String s) {
        println("<: " + s);
    }

    private void printlnFrom(String s) {
        println(":: " + s);
    }

    private void print_line_num(Code a) {
        println("#" + a.line_num());
    }

    public CodeDumpVisitor(String test_filename, AstToIR ast_to_ir_object) {
        try {
            this.test_filename = test_filename;
            System.out.println("test_filename");
            this.ir_writer = new BufferedWriter(new FileWriter(test_filename + ".ir"));
            this.indentation = 0;
            this.file_count = file_count;
            this.ast_to_ir_object = ast_to_ir_object;
            addBuiltInClasses();

        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }
    }

    @Override
    public Void visitProgramCode(ProgramCode p) {
        println("_program");
        incr();
            for (KlassCode k : p.klasses()) visitKlassCode(k);
        dec();

        try {

            for (String s : built_in_classes) {
                Files.copy(new File("./ir_code/jasmin_builtin/" + s + ".j").toPath(),
                    new File(
                        test_filename + ".j" + Integer.toString(file_count)).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                file_count += 1;
            }

        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitKlassCode(KlassCode p) {

        try {

            if (!built_in_classes.contains(p.klass().id)) {
                FileWriter jasmin_fname = new FileWriter(test_filename + ".j" +
                    Integer.toString(file_count));
                file_count += 1;
                BufferedWriter jasmin_writer = new BufferedWriter(jasmin_fname);

                curr_jasmin_writer = jasmin_writer;

                String main_ret = new String();
                String curr_class_name = new String(p.klass().id);
                this.curr_class_name = curr_class_name;

                jasmin_writer.write(".class public " + p.klass().id);
                jasmin_writer.newLine();
                jasmin_writer.write(".super " + p.base().id);
                jasmin_writer.newLine();
                jasmin_writer.newLine();

                println("_klass");
                incr();
                    println(p.klass().id);
                    printlnSub( (p.base() == null) ? "null" : p.base().id);
                    println("_attrs");
                    incr();
                        for (VarSymbol k : p.attrs()) {
                            println(k.id);
                            printlnFrom(k.defKlass);
                            printlnTy(k.type);

                            // System.out.println(k.kind);
                            if (k.id == "self" || k.kind != VarSymbol.SymbolKind.attr) {
                                System.out.println(k.kind);
                                continue;
                            }

                            String curr_type = k.type;
                            if (curr_type == "SELF_TYPE") {
                                jasmin_writer.write(".field private " + k.id +
                                    " L" + curr_class_name + ";");
                            }
                            else {
                                jasmin_writer.write(".field private " +
                                    k.id + " L" + k.type + ";");
                            }
                            jasmin_writer.newLine();
                        }
                    dec();

                    println("_methodmap");
                    incr();


                    // Loop through attributes and initialize them
                    // Add in an attribute code table?
                    // Class to Attribute name : Attribute Code
                    Map<String, Map<String, AttrCode>> klassAttrCodeTable =
                        ast_to_ir_object.env.klassAttrCodeTable;
                    Map<String, AttrCode> attr_code_map = klassAttrCodeTable.get(curr_class_name);

                    Map<String, Map<String, VarSymbol>> klassAttrTable =
                        ast_to_ir_object.env.klassAttrTable;
                    Map<String, VarSymbol> attr_table = klassAttrTable.get(curr_class_name);


                    /* First Init method */
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    jasmin_writer.write(".method public <init>()V");
                    jasmin_writer.newLine();
                    jasmin_writer.write(".limit stack 3"); // load, new, dup
                    jasmin_writer.newLine();
                    jasmin_writer.write(".limit locals " + Integer.toString(3 * p.attrs().size()));
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    jasmin_writer.write("aload 0");
                    jasmin_writer.newLine();

                    if (p.base().id == "Object" || p.base().id == "IO") {
                        jasmin_writer.write("invokespecial " + p.base().id + "/<init>()V");
                    }
                    else {
                        jasmin_writer.write("new Object");
                        jasmin_writer.newLine();
                        jasmin_writer.write("dup");
                        jasmin_writer.newLine();
                        jasmin_writer.write("invokespecial Object/<init>()V");
                        jasmin_writer.newLine();
                        jasmin_writer.write("invokespecial " + p.base().id + "/<init>(LObject;)V");
                    }

                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    /* general init */
                    for (VarSymbol k : p.attrs()) {

                        if (k.id == "self" || k.kind != VarSymbol.SymbolKind.attr) {
                            continue;
                        }

                        String attr_name = k.id;
                        AttrCode curr_attr_code = attr_code_map.get(attr_name);
                        VarSymbol attr_sym = attr_table.get(attr_name);

                        if (attr_sym.type == "String") {

                            jasmin_writer.write("aload 0");
                            jasmin_writer.newLine();
                            jasmin_writer.write("new String");
                            jasmin_writer.newLine();
                            jasmin_writer.write("dup");
                            jasmin_writer.newLine();
                            jasmin_writer.write("invokespecial String/<init>()V");
                            jasmin_writer.newLine();
                            if (attr_sym.kind == VarSymbol.SymbolKind.attr) {
                                jasmin_writer.write("putfield " + curr_class_name + "/" + attr_name + " LString;");
                                jasmin_writer.newLine();
                            }
                            else {
                                jasmin_writer.write("astore " + k.seq);
                                jasmin_writer.newLine();
                            }

                        }
                        else if (attr_sym.type == "Int") {
                            // System.out.println("Initializing Int in code attribute");

                            jasmin_writer.write("aload 0");
                            jasmin_writer.newLine();
                            jasmin_writer.write("new Int");
                            jasmin_writer.newLine();
                            jasmin_writer.write("dup");
                            jasmin_writer.newLine();
                            jasmin_writer.write("invokespecial Int/<init>()V");
                            jasmin_writer.newLine();
                            if (attr_sym.kind == VarSymbol.SymbolKind.attr) {
                                jasmin_writer.write("putfield " + curr_class_name + "/" + attr_name + " LInt;");
                                jasmin_writer.newLine();
                            }
                            else {
                                jasmin_writer.write("astore " + k.seq);
                                jasmin_writer.newLine();
                            }

                        }
                        else if (attr_sym.type == "Bool") {

                            jasmin_writer.write("aload 0");
                            jasmin_writer.newLine();
                            jasmin_writer.write("new Bool");
                            jasmin_writer.newLine();
                            jasmin_writer.write("dup");
                            jasmin_writer.newLine();
                            jasmin_writer.write("invokespecial Bool/<init>()V");
                            jasmin_writer.newLine();
                            if (attr_sym.kind == VarSymbol.SymbolKind.attr) {
                                jasmin_writer.write("putfield " + curr_class_name + "/" + attr_name + " LBool;");
                                jasmin_writer.newLine();
                            }
                            else {
                                jasmin_writer.write("astore " + k.seq);
                                jasmin_writer.newLine();
                            }

                        }
                    }
                    /* end of general init */


                    jasmin_writer.newLine();
                    jasmin_writer.newLine();



                    Map< String, List<AttrFeature> > klassAttrFeatureTable =
                        ast_to_ir_object.env.klassAttrFeatureTable;

                    Map<String, String> parentTable =
                        ast_to_ir_object.env.parent;

                    List<String> classHierarchy = new ArrayList<String>();
                    String visiting_class = this.curr_class_name;
                    System.out.println("Visiting this class!: " + visiting_class);
                    classHierarchy.add(visiting_class);
                    int count = 0;
                    while (visiting_class != "Object" &&
                        visiting_class != "IO" &&
                        visiting_class != "Bottom" &&
                        visiting_class != "") {
                        count += 1;
                        if (count == 5) {
                          break;
                        }
                        visiting_class = parentTable.get(visiting_class);
                        classHierarchy.add(visiting_class);
                        System.out.println(visiting_class);
                    }
                    System.out.println("Done hierarchy");

                    Collections.reverse(classHierarchy);
                    for (String curr_class : classHierarchy) {
                        System.out.println(curr_class);
                    }

                    // List<String> attributesList = new ArrayList<String>();

                    // view attribute table to determine ordering
                    // call the attribute expression visitor on right side

                    // put in instruction code starting
                    // with the class Object (call AstToIR from here)
                    // enter current class and exit current class
                    // just need to grab instructions to init
                    // allowing dispatch to work properly

                    ast_to_ir_object.env.enterClass(this.curr_class_name);
                    ast_to_ir_object.env.seq_no = 1;
                    List<AttrCode> list_attr_code = new ArrayList<AttrCode>();
                    List<String> relevant_attr_name = new ArrayList<String>();
                    List<String> relevant_type_name = new ArrayList<String>();
                    List<String> relevant_defklass_name = new ArrayList<String>();
                    for (String curr_class : classHierarchy) {

                        if (curr_class == "Object" || curr_class == "IO") {
                            continue;
                        }
                        System.out.println("Current class attribute visiting: " + curr_class);

                        List<AttrFeature> attr_feat_list = klassAttrFeatureTable.get(curr_class);
                        for ( AttrFeature curr_attr_feature : attr_feat_list ) {

                            // if (curr_var_symbol.id == "self" ||
                            //     curr_var_symbol.kind != VarSymbol.SymbolKind.attr) {
                            //     System.out.println("Still getting bad symbols");
                            //     continue;
                            // }
                            System.out.println("Adding attribute features...");
                            AttrCode ac = (AttrCode) ast_to_ir_object.visitAttrFeature(curr_attr_feature);
                            list_attr_code.add(ac);
                            relevant_attr_name.add(curr_attr_feature.attr_name());
                            relevant_type_name.add(curr_attr_feature.ty_name());
                            relevant_defklass_name.add(curr_class);

                        }

                    }
                    ast_to_ir_object.env.exitClass();

                    for (int i = 0; i < list_attr_code.size(); i++) {
                        AttrCode curr_attr_code = list_attr_code.get(i);

                        if (curr_attr_code.expr() == null ||
                                curr_attr_code.expr().dest == null)
                        {
                            continue;
                        }
                        visitExprCode(curr_attr_code.expr());

                        jasmin_writer.write("aload 0");
                        jasmin_writer.newLine();
                        jasmin_writer.write("aload " + curr_attr_code.expr().dest.symbol.seq);
                        jasmin_writer.newLine();
                        jasmin_writer.write("putfield " + relevant_defklass_name.get(i) + "/" +
                            relevant_attr_name.get(i) + " L" +
                            relevant_type_name.get(i) + ";");
                        jasmin_writer.newLine();
                        jasmin_writer.newLine();
                    }



                    jasmin_writer.write("return");

                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    jasmin_writer.write(".end method");
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    /* End of Init method */









                    /* Second Init method */
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    jasmin_writer.write(".method public <init>(LObject;)V");
                    jasmin_writer.newLine();
                    jasmin_writer.write(".limit stack 3"); // load, new, dup
                    jasmin_writer.newLine();


                    jasmin_writer.write(".limit locals " + Integer.toString(3 * p.attrs().size()));
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    jasmin_writer.write("aload 0");
                    jasmin_writer.newLine();


                    if (p.base().id == "Object" || p.base().id == "IO") {
                        jasmin_writer.write("invokespecial " + p.base().id + "/<init>()V");
                    }
                    else {
                        jasmin_writer.write("new Object");
                        jasmin_writer.newLine();
                        jasmin_writer.write("dup");
                        jasmin_writer.newLine();
                        jasmin_writer.write("invokespecial Object/<init>()V");
                        jasmin_writer.newLine();
                        jasmin_writer.write("invokespecial " + p.base().id + "/<init>(LObject;)V");
                    }
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();


                    /* General init func used by current classes
                     and any inherited classes */
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    for (VarSymbol k : p.attrs()) {

                        if (k.id == "self" || k.kind != VarSymbol.SymbolKind.attr) {
                            continue;
                        }

                        String attr_name = k.id;
                        AttrCode curr_attr_code = attr_code_map.get(attr_name);
                        VarSymbol attr_sym = attr_table.get(attr_name);

                        if (attr_sym.type == "String") {

                            jasmin_writer.write("aload 0");
                            jasmin_writer.newLine();
                            jasmin_writer.write("new String");
                            jasmin_writer.newLine();
                            jasmin_writer.write("dup");
                            jasmin_writer.newLine();
                            jasmin_writer.write("invokespecial String/<init>()V");
                            jasmin_writer.newLine();
                            if (attr_sym.kind == VarSymbol.SymbolKind.attr) {
                                jasmin_writer.write("putfield " + curr_class_name + "/" + attr_name + " LString;");
                                jasmin_writer.newLine();
                            }
                            else {
                                jasmin_writer.write("astore " + k.seq);
                                jasmin_writer.newLine();
                            }

                        }
                        else if (attr_sym.type == "Int") {
                            // System.out.println("Initializing Int in code attribute");

                            jasmin_writer.write("aload 0");
                            jasmin_writer.newLine();
                            jasmin_writer.write("new Int");
                            jasmin_writer.newLine();
                            jasmin_writer.write("dup");
                            jasmin_writer.newLine();
                            jasmin_writer.write("invokespecial Int/<init>()V");
                            jasmin_writer.newLine();
                            if (attr_sym.kind == VarSymbol.SymbolKind.attr) {
                                jasmin_writer.write("putfield " + curr_class_name + "/" + attr_name + " LInt;");
                                jasmin_writer.newLine();
                            }
                            else {
                                jasmin_writer.write("astore " + k.seq);
                                jasmin_writer.newLine();
                            }

                        }
                        else if (attr_sym.type == "Bool") {

                            jasmin_writer.write("aload 0");
                            jasmin_writer.newLine();
                            jasmin_writer.write("new Bool");
                            jasmin_writer.newLine();
                            jasmin_writer.write("dup");
                            jasmin_writer.newLine();
                            jasmin_writer.write("invokespecial Bool/<init>()V");
                            jasmin_writer.newLine();
                            if (attr_sym.kind == VarSymbol.SymbolKind.attr) {
                                jasmin_writer.write("putfield " + curr_class_name + "/" + attr_name + " LBool;");
                                jasmin_writer.newLine();
                            }
                            else {
                                jasmin_writer.write("astore " + k.seq);
                                jasmin_writer.newLine();
                            }

                        }
                    }

                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    /* End of general init */


                    jasmin_writer.write("return");

                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    jasmin_writer.write(".end method");
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    System.out.println("Second init complete");
                    /* End of Second Init method */





                    /* Some IR code  */
                    // visit method signatures
                    for (MethodSymbol ks : p.methodSigs()) {
                        if (ks.id == "main") {
                            if (ks.type != "SELF_TYPE") {
                                main_ret = "L" + ks.type + ";";
                            }
                            else {
                                main_ret = "L" + curr_class_name + ";";
                            }
                        }
                        println(ks.id);
                        printlnFrom(ks.defKlass);
                        printlnTy(ks.type);
                    }
                    dec();
                    /* End of IR code */


                    // for (AttributeCode ac : p.attributes()) {
                    //     visitAttrCode(ac);
                    // }

                    // visit code within each method
                    for (MethodCode mc : p.methods()) {

                        curr_method_return_type = mc.method().type;
                        visitMethodCode(mc);
                    }
                dec();

                if (p.klass().id == "Main") {
                    /* Init method */
                    jasmin_writer.newLine();
                    jasmin_writer.write(".method public static main([Ljava/lang/String;)V");
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    jasmin_writer.write(".limit stack 2");
                    jasmin_writer.newLine();
                    jasmin_writer.write(".limit locals 1");
                    jasmin_writer.newLine();
                    jasmin_writer.write("new Main");
                    jasmin_writer.newLine();
                    jasmin_writer.write("dup");
                    jasmin_writer.newLine();

                    jasmin_writer.write("invokespecial " + p.klass().id + "/<init>()V");
                    jasmin_writer.newLine();

                    // use the signature for the main function here
                    jasmin_writer.write("invokevirtual " + p.klass().id + "/main()" + main_ret);

                    jasmin_writer.newLine();
                    jasmin_writer.write("pop");
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.write("return");

                    jasmin_writer.newLine();
                    jasmin_writer.newLine();

                    jasmin_writer.write(".end method");
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    jasmin_writer.newLine();
                    /* End of Init method */
                }

                jasmin_writer.close();
            }

        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitMethodCode(MethodCode p) {

        try {
            println("_method");

            curr_jasmin_writer.write(".method public " + p.method.id + "(");

            incr();
                println(p.method.id);
                printlnTy(p.method.type);
                println("_formals");
                incr();
                    for (VarSymbol k : p.formals()) {
                        println(k.id);
                        printlnTy(k.type);

                        if (k.type == "SELF_TYPE") { // necessary?
                            curr_jasmin_writer.write("L" + curr_class_name + ";");
                        }
                        else {
                            curr_jasmin_writer.write("L" + k.type + ";");
                        }

                    }

                curr_jasmin_writer.write(")");
                if (p.method.type == "SELF_TYPE") {
                    curr_jasmin_writer.write("L" + curr_class_name + ";");
                }
                else {
                    curr_jasmin_writer.write("L" + p.method.type + ";");
                }
                curr_jasmin_writer.newLine();

                int stack_sz = 3;
                int local_sz = (p.formals().size() + p.locals().size()) * 2;
                if (local_sz > stack_sz) {
                    stack_sz = local_sz;
                }

                curr_jasmin_writer.newLine();
                curr_jasmin_writer.write(".limit stack " + Integer.toString(stack_sz));
                curr_jasmin_writer.newLine();
                curr_jasmin_writer.write(".limit locals " + Integer.toString(local_sz));
                curr_jasmin_writer.newLine();
                curr_jasmin_writer.newLine();

                dec();
                println("_locals");
                incr();
                    for (VarSymbol k1 : p.locals()) {
                        println(k1.id);
                        printlnTy(k1.type);
                    }
                dec();
                println("_expr");
                incr();
                    visitExprCode(p.expr());
                dec();

            dec();

            curr_jasmin_writer.write(".end method");
            curr_jasmin_writer.newLine();
            curr_jasmin_writer.newLine();
            curr_jasmin_writer.newLine();


          //   /* Adding static code */
          //   if (p.method.id != "main") {
          //       curr_jasmin_writer.write(".method public static " + p.method.id + "2(");
          //
          //       for (VarSymbol k : p.formals()) {
          //           if (k.type == "SELF_TYPE") { // necessary?
          //               curr_jasmin_writer.write("L" + curr_class_name + ";");
          //           }
          //           else {
          //               curr_jasmin_writer.write("L" + k.type + ";");
          //           }
          //       }
          //       curr_jasmin_writer.write(")");
          //       if (p.method.type == "SELF_TYPE") {
          //           curr_jasmin_writer.write("L" + curr_class_name + ";");
          //       }
          //       else {
          //           curr_jasmin_writer.write("L" + p.method.type + ";");
          //       }
          //       curr_jasmin_writer.newLine();
          //
          //       stack_sz = 3;
          //       local_sz = (p.formals().size() + p.locals().size()) * 2;
          //       if (local_sz > stack_sz) {
          //           stack_sz = local_sz;
          //       }
          //
          //       curr_jasmin_writer.newLine();
          //       curr_jasmin_writer.write(".limit stack " + Integer.toString(stack_sz));
          //       curr_jasmin_writer.newLine();
          //       curr_jasmin_writer.write(".limit locals " + Integer.toString(local_sz));
          //       curr_jasmin_writer.newLine();
          //       curr_jasmin_writer.newLine();
          //
          //       visitExprCode(p.expr());
          //
          //       curr_jasmin_writer.write(".end method");
          //       curr_jasmin_writer.newLine();
          //       curr_jasmin_writer.newLine();
          //       curr_jasmin_writer.newLine();
          // }
          //
          //   /* End of static code */
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitAttrCode(AttrCode p) {
        try {
          // println("_method");
          curr_jasmin_writer.write("Attr Error");
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitExprCode(ExprCode p) {
        InstDumpVisitor dv = new InstDumpVisitor(ir_writer, indentation,
            curr_jasmin_writer, ast_to_ir_object, curr_class_name, curr_method_return_type);
        for (Inst i : p.insts()) {
            dv.visit(i);
        }
        return null;
    }
}
