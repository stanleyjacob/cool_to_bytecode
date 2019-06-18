package cs143.ir;

import cs143.environment.Rvalue;
import cs143.environment.Lvalue;
import cs143.environment.Singletons;
import cs143.environment.MethodSymbol;
import cs143.environment.VarSymbol;

import java.io.BufferedWriter;
import java.util.List;
import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InstDumpVisitor extends InstVisitor<Void> {

    BufferedWriter ir_writer;
    BufferedWriter jasmin_writer;
    AstToIR ast_to_ir_object;
    String curr_class_name;

    String curr_method_return_type;

    int indentation;

    void incr() { indentation = indentation + 2; }
    void dec() { indentation = indentation - 2; }

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

    private String printargs(List<Rvalue> args) {
        String s = "(";
        boolean first = true;
        for (Rvalue r : args) {
            if (!first) {
                s = s + ", ";
            } else {
                first = false;
            }
            s = s + r;
        }
        s = s + ")";
        return s;
    }

    public InstDumpVisitor(BufferedWriter ir_writer, int indentation,
        BufferedWriter jasmin_writer,
        AstToIR ast_to_ir_object, String curr_class_name, String curr_method_return_type) {
        this.indentation = indentation;
        this.ir_writer = ir_writer;
        this.jasmin_writer = jasmin_writer;
        this.ast_to_ir_object = ast_to_ir_object;
        this.curr_class_name = curr_class_name;
        this.curr_method_return_type = curr_method_return_type;
    }

    @Override
    public Void visitAllocInst(AllocInst p) {
        println(p.lval() + " = " + "new " + p.klass().id);

        try {
            this.jasmin_writer.write("; Alloc Inst start");
            this.jasmin_writer.newLine();

            // this.jasmin_writer.write("goto label" + p.label());
            if (p.klass().id == "SELF_TYPE") {
                this.jasmin_writer.write("new " + curr_class_name);
            }
            else {
                this.jasmin_writer.write("new " + p.klass().id);
            }

            this.jasmin_writer.newLine();
            this.jasmin_writer.write("dup");
            this.jasmin_writer.newLine();

            if (p.lval().symbol.type == "SELF_TYPE") {
                this.jasmin_writer.write("invokespecial " + curr_class_name + "/<init>()V");
            }
            else {
                this.jasmin_writer.write("invokespecial " + p.lval().symbol.type + "/<init>()V");
            }
            this.jasmin_writer.newLine();
            this.jasmin_writer.write("astore " + p.lval().symbol.seq);
            this.jasmin_writer.newLine();

            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitBinopInst(BinopInst p) {
        println(p.dest() + " = " + p.left() + " " + p.op() +
            " " + p.right());


        try {
            this.jasmin_writer.write("; Binop Inst start");
            this.jasmin_writer.newLine();

            int dest_seq = p.dest().symbol.seq;
            int left_seq = p.left().symbol.seq;
            int right_seq = p.right().symbol.seq;

            if (p.op() == "_eq") {

                System.out.println("Binary op equality results: ");
                System.out.println(p.left().symbol.type);
                System.out.println(p.right().symbol.type);
                System.out.println(p.left().symbol.id);
                System.out.println(p.right().symbol.id);
                System.out.println(p.left().symbol.kind);
                System.out.println(p.right().symbol.kind);

                if (p.left().symbol.type == "Int" &&
                    p.right().symbol.type == "Int") {

                    this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                    this.jasmin_writer.newLine();

                    this.jasmin_writer.write("invokevirtual Int/eq(LInt;)LBool;");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                    this.jasmin_writer.newLine();

                }
                else if (p.left().symbol.type == "Bool" &&
                    p.right().symbol.type == "Bool") {

                    this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                    this.jasmin_writer.newLine();

                    this.jasmin_writer.write("invokevirtual Bool/true_eq(LBool;)LBool;");
                    this.jasmin_writer.newLine();

                    this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                    this.jasmin_writer.newLine();

                }
                else if (p.left().symbol.type == "String" &&
                    p.right().symbol.type == "String") {

                    this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                    this.jasmin_writer.newLine();

                    this.jasmin_writer.write("invokevirtual String/eq(LString;)LBool;");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                    this.jasmin_writer.newLine();

                }
                else if (p.left().symbol.id == p.right().symbol.id) {
                    // same symbol ids for same objects
                    // just return 1 or true for them
                    this.jasmin_writer.write("new Bool");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("dup");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokespecial Bool/<init>()V");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("iconst_1");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokevirtual Bool/putval(Z)LBool;");
                    this.jasmin_writer.newLine();

                    this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                    this.jasmin_writer.newLine();
                }
                else {
                    System.out.println("made it");

                    // default to returning false
                    this.jasmin_writer.write("new Bool");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("dup");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokespecial Bool/<init>()V");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("iconst_0");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokevirtual Bool/putval(Z)LBool;");
                    this.jasmin_writer.newLine();

                    this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                    this.jasmin_writer.newLine();

                }
            }

            else if (p.op() == "_leq") {

                this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("invokevirtual Int/leq(LInt;)LBool;");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                this.jasmin_writer.newLine();
            }

            else if (p.op() == "_lt") {

                this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("invokevirtual Int/lt(LInt;)LBool;");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                this.jasmin_writer.newLine();
            }

            else if (p.op() == "_plus") {

                this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("invokevirtual Int/add(LInt;)LInt;");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                this.jasmin_writer.newLine();
            }

            else if (p.op() == "_sub") {

                this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("invokevirtual Int/minus(LInt;)LInt;");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                this.jasmin_writer.newLine();
            }

            else if (p.op() == "_divide") {

                this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("invokevirtual Int/divide(LInt;)LInt;");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                this.jasmin_writer.newLine();
            }

            else if (p.op() == "_leq") {

                this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("invokevirtual Int/multiply(LInt;)LInt;");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("astore " + Integer.toString(dest_seq));
                this.jasmin_writer.newLine();
            }

            this.jasmin_writer.newLine();
            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitCondBranchInst(CondBranchInst p) {
        println("_if " + p.left() + " "  + p.op() + " " + p.right() +
            " _goto " + p.label());

        try {
            this.jasmin_writer.write("; CondBranch Inst start");
            this.jasmin_writer.newLine();

            if (p.left() != null && p.right() != null) {

                int left_seq = p.left().symbol.seq;
                int right_seq = p.right().symbol.seq;

                if (p.left().symbol.type == "Bool") {
                    if (p.op() == "_eq" && p.right().symbol.type == "Bool") {
                        this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                        this.jasmin_writer.newLine();
                        this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("invokevirtual Bool/eq(LBool;)I");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("iconst_0");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("if_icmpne label" + Integer.toString(p.label()));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.newLine();
                        this.jasmin_writer.newLine();
                    }
                    else if (p.op() == "_eq" && p.right().symbol.type == "Int") {
                            this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                            this.jasmin_writer.newLine();
                            this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                            this.jasmin_writer.newLine();

                            this.jasmin_writer.write("invokevirtual Bool/eq(LInt;)I");
                            this.jasmin_writer.newLine();

                            this.jasmin_writer.write("iconst_0");
                            this.jasmin_writer.newLine();

                            this.jasmin_writer.write("if_icmpne label" + Integer.toString(p.label()));
                            this.jasmin_writer.newLine();

                            this.jasmin_writer.newLine();
                            this.jasmin_writer.newLine();
                    }
                }
                else if (p.left().symbol.type == "Int") {

                    if (p.op() == "_eq") {
                        this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                        this.jasmin_writer.newLine();
                        this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("invokevirtual Int/eq(LInt;)I");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("iconst_0");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("if_icmpne label" + Integer.toString(p.label()));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.newLine();
                        this.jasmin_writer.newLine();
                    }
                    else if (p.op() == "_leq") {
                        this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                        this.jasmin_writer.newLine();
                        this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("invokevirtual Int/leq(LInt;)I");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("iconst_0");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("if_icmpne label" + Integer.toString(p.label()));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.newLine();
                        this.jasmin_writer.newLine();
                    }
                    else if (p.op() == "_lt") {
                        this.jasmin_writer.write("aload " + Integer.toString(left_seq));
                        this.jasmin_writer.newLine();
                        this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("invokevirtual Int/lt(LInt;)I");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("iconst_0");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("if_icmpne label" + Integer.toString(p.label()));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.newLine();
                        this.jasmin_writer.newLine();
                    }
                    else {
                        System.out.println("Unhandled cond branch case");
                        this.jasmin_writer.newLine();
                    }
                }

            }
            else if (p.left() != null && p.right() == null) {
                System.out.println("Unhandled cond branch case");
                this.jasmin_writer.newLine();
            }
            else if (p.right() != null && p.left() == null) {
                int right_seq = p.right().symbol.seq;
                this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                this.jasmin_writer.newLine();


                if (p.right().symbol.type == "Bool") {
                    if (p.op() == "_eq") {
                        this.jasmin_writer.write("aload " + Integer.toString(right_seq));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("invokevirtual Bool/eq(LInt;)I");
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("iconst_0"); // right
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.write("if_icmpne label" + Integer.toString(p.label()));
                        this.jasmin_writer.newLine();

                        this.jasmin_writer.newLine();
                        this.jasmin_writer.newLine();
                    }
                }
            }
            else {
                System.out.println("Unhandled cond branch case");
                this.jasmin_writer.newLine();

                this.jasmin_writer.newLine();
                this.jasmin_writer.newLine();
            }

        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitDispatchInst(DispatchInst p) {
        println(p.tmp() + " = " + "_dispatch " + p.e0() + ", " +
            p.method().id + ", " + printargs(p.args()));

        try {

            this.jasmin_writer.write("; Dispatch Inst start");
            this.jasmin_writer.newLine();

            this.jasmin_writer.write("aload " + p.e0().symbol.seq);
            this.jasmin_writer.newLine();

            for (Rvalue r : p.args() ) {
                this.jasmin_writer.write("aload " + r.symbol.seq);// immediates possible?
                this.jasmin_writer.newLine();
            }

            this.jasmin_writer.write("invokevirtual ");
            this.jasmin_writer.write(p.method().defKlass + "/" + p.method().id + "(");

            System.out.println("Printing dispatch arguments...");
            for (Rvalue r : p.args() ) {
                  this.jasmin_writer.write("L" + r.symbol.type + ";");

                  System.out.println(p.method().id);
                  System.out.println(r.symbol.id);
            }
            this.jasmin_writer.write(")");


            if (p.method().type != "SELF_TYPE") {

                this.jasmin_writer.write("L" + p.method().type + ";");
            }
            else {
                // method type is SELF TYPE
                this.jasmin_writer.write("L" + p.method().defKlass + ";");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("checkcast " + this.curr_class_name);
            }

            this.jasmin_writer.newLine();

            this.jasmin_writer.write("astore " + p.tmp().symbol.seq);
            this.jasmin_writer.newLine();
            this.jasmin_writer.newLine();

        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitGotoInst(GotoInst p) {
        println("_goto " + p.label());

        try {
            this.jasmin_writer.write("; Goto Inst start");
            this.jasmin_writer.newLine();

            this.jasmin_writer.write("goto label" + p.label());
            this.jasmin_writer.newLine();
            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitDiscardInst(DiscardInst p) {
        println("_discard " + p.rvalue());

        return null;
    }

    @Override
    public Void visitLabelInst(LabelInst p) {
        println("_label " + p.label());

        try {
            this.jasmin_writer.write("; Label Inst start");
            this.jasmin_writer.newLine();

            this.jasmin_writer.write("label" + p.label() + ":");
            this.jasmin_writer.newLine();
            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitLoadAttrInst(LoadAttrInst p) {
        println("_load_attr " + p.dest() + ", " + p.receiver() +
            ", " + "attr#" + p.attr().id);

        try {
            this.jasmin_writer.write("; Load Inst start");
            this.jasmin_writer.newLine();

            this.jasmin_writer.write("aload " + p.receiver().symbol.seq); // aload 0?
            this.jasmin_writer.newLine();


            String def_klass = p.receiver().symbol.defKlass;
            String symbol_type = p.receiver().symbol.type;

            if (def_klass == "SELF_TYPE") {
                def_klass = curr_class_name;
            }

            if (symbol_type == "SELF_TYPE") {
                symbol_type = curr_class_name;
            }

            this.jasmin_writer.write("getfield " + def_klass +
                "/" + p.attr().id + " L" + symbol_type + ";");
            this.jasmin_writer.newLine();
            this.jasmin_writer.write("astore " + p.dest().symbol.seq); // either seq or id
            this.jasmin_writer.newLine();
            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitMoveInst(MoveInst p) {
        println("_mov " + p.dest() + ", " + p.src());
        try {
            this.jasmin_writer.write("; Move Inst start");
            this.jasmin_writer.newLine();

            System.out.println("Entering move instruction");

            // check if right side is immediate first
            if (p.src() == null) {

            }
            else if (p.src().kind == Rvalue.KIND.IMMEDIATE &&
                p.src().immTy == Singletons.INT) {

                System.out.println("Going to the int move instruction");

                if (p.dest().symbol.type == "Bool") {
                    this.jasmin_writer.write("new Bool");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("dup");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokespecial Bool/<init>()V");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("bipush " + p.src().iimm);
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokevirtual Bool/putval(I)LBool;");
                    this.jasmin_writer.newLine();
                }

                else {
                    this.jasmin_writer.write("new Int");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("dup");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokespecial Int/<init>()V");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("bipush " + p.src().iimm);
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokevirtual Int/putval(I)LInt;");
                    this.jasmin_writer.newLine();
                }

                this.jasmin_writer.write("astore " + p.dest().symbol.seq);
                this.jasmin_writer.newLine();

            }
            else if (p.src().kind == Rvalue.KIND.IMMEDIATE &&
                p.src().immTy == Singletons.BOOLEAN) {

                System.out.println("Going to the boolean move instruction");

                this.jasmin_writer.write("new Bool");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("dup");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("invokespecial Bool/<init>()V");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("iconst_" + p.src().iimm);
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("invokevirtual Bool/putval(I)LBool;");
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("astore " + p.dest().symbol.seq);
                this.jasmin_writer.newLine();
            }
            else if (p.src().kind == Rvalue.KIND.IMMEDIATE &&
                p.src().immTy == Singletons.STRING) {

                this.jasmin_writer.write("new String");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("dup");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("invokespecial String/<init>()V");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("ldc " + p.src().simm);
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("invokevirtual String/putval(Ljava/lang/String;)LString;");
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("astore " + p.dest().symbol.seq);
                this.jasmin_writer.newLine();
            }
            else if (p.src().symbol != null &&
                p.src().symbol.kind == VarSymbol.SymbolKind.attr) {

                String attr_class = p.src().symbol.defKlass;
                String attr_name = p.src().symbol.id;
                String attr_type = p.src().symbol.type;

                if (attr_class == "SELF_TYPE") {
                    attr_class = curr_class_name;
                }
                else if (attr_type == "SELF_TYPE") {
                    attr_class = curr_class_name;
                }
                System.out.println("Attribute move instruction: " + p.src().symbol.id);
                System.out.println("Attribute move instruction: " + p.dest().symbol.id);

                this.jasmin_writer.write("getfield " + attr_class + "/" +
                    attr_name + " L" + attr_type + ";");
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("astore " + p.dest().symbol.seq);
                this.jasmin_writer.newLine();
            }
            // now check if not IMMEDIATE
            else if ( p.src().symbol != null &&
                  (p.src().symbol.kind == VarSymbol.SymbolKind.tmp ||
                  p.src().symbol.kind == VarSymbol.SymbolKind.letvar ||
                  p.src().isRef()
                  ) )
            {
                System.out.println("Standard move instruction: " + p.src().symbol.id);
                System.out.println("Standard move instruction: " + p.dest().symbol.id);
                this.jasmin_writer.write("aload " + p.src().symbol.seq);
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("astore " + p.dest().symbol.seq);
                this.jasmin_writer.newLine();
            }
            else {

                System.out.println("Potential error in move instruction");
                this.jasmin_writer.write("aload " + p.src().symbol.seq);
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("astore " + p.dest().symbol.seq);
                this.jasmin_writer.newLine();
            }
            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitReturnInst(ReturnInst p) {
        println("_return " + p.rvalue());

        try {
            this.jasmin_writer.write("; Return Inst start");
            this.jasmin_writer.newLine();

            System.out.println("Return type target: " + curr_method_return_type);
            // System.out.println(p.rvalue().symbol.type);

            // if returning immediate, there should be an error
            // since it should be in a temp (aka an Rvalue.KIND.SYMBOL)
            if (p.rvalue().kind == Rvalue.KIND.IMMEDIATE) {

                this.jasmin_writer.write("Unhandled return case");
                this.jasmin_writer.newLine();
            }
            // should just be a check for only attr, not param, letval, tmp
            // need to check
            else if (p.rvalue().symbol.kind == VarSymbol.SymbolKind.attr) {

                String target_array_loc = Integer.toString(p.rvalue().symbol.seq);
                this.jasmin_writer.write("aload " + target_array_loc);
                this.jasmin_writer.newLine();

                String attr_class = p.rvalue().symbol.defKlass;
                String attr_name = p.rvalue().symbol.id;
                String attr_type = p.rvalue().symbol.type;

                if (attr_class == "SELF_TYPE") {
                    attr_class = curr_class_name;
                }
                if (attr_type == "SELF_TYPE") {
                    attr_type = curr_class_name;
                }

                this.jasmin_writer.write("getfield " + attr_class + "/" +
                    attr_name + " L" + attr_type + ";");
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("areturn");
                this.jasmin_writer.newLine();

            }
            else {

                String target_array_loc = Integer.toString(p.rvalue().symbol.seq);
                this.jasmin_writer.write("aload " + target_array_loc);
                this.jasmin_writer.newLine();

                if (p.rvalue().symbol.type == "SELF_TYPE") {

                    this.jasmin_writer.write("checkcast " + curr_class_name);
                    this.jasmin_writer.newLine();
                }
                else {
                    this.jasmin_writer.newLine();
                }
                this.jasmin_writer.write("areturn");
                this.jasmin_writer.newLine();
            }
            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitStaticDispatchInst(StaticDispatchInst p) {
        println(p.tmp() + " = " + "_staticdispatch " + p.e0() + ", " +
            p.method().defKlass + "@" +
            p.method().id + ", " +  printargs(p.args()));
        try {

            this.jasmin_writer.write("; Static Dispatch Inst start");
            this.jasmin_writer.newLine();

            this.jasmin_writer.write("aload " + p.e0().symbol.seq);
            this.jasmin_writer.newLine();

            for (Rvalue r : p.args() ) {
                this.jasmin_writer.write("aload " + r.symbol.seq);
                this.jasmin_writer.newLine();
            }

            this.jasmin_writer.write("checkcast " + p.method().defKlass);
            this.jasmin_writer.newLine();
            this.jasmin_writer.write("invokevirtual ");
            this.jasmin_writer.write(p.method().defKlass + "/" + p.method().id + "(");

            System.out.println("Printing dispatch arguments...");
            for (Rvalue r : p.args() ) {
                  this.jasmin_writer.write("L" + r.symbol.type + ";");

                  System.out.println(p.method().id);
                  System.out.println(r.symbol.id);
            }
            this.jasmin_writer.write(")");


            if (p.method().type != "SELF_TYPE") {

                this.jasmin_writer.write("L" + p.method().type + ";");
            }
            else {
                // method type is SELF TYPE
                this.jasmin_writer.write("L" + p.method().defKlass + ";");
                this.jasmin_writer.newLine();
                this.jasmin_writer.write("checkcast " + this.curr_class_name);
            }

            this.jasmin_writer.newLine();

            this.jasmin_writer.write("astore " + p.tmp().symbol.seq);
            this.jasmin_writer.newLine();
            this.jasmin_writer.newLine();

        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitStoreAttrInst(StoreAttrInst p) {
        println("_store_attr " + p.receiver() + ", " +
            "attr#" + p.attr().id + ", " + p.value());

        try {
            this.jasmin_writer.write("; Store Attr Inst start");
            this.jasmin_writer.newLine();

            this.jasmin_writer.write("aload " + p.receiver().symbol.seq);
            this.jasmin_writer.newLine();
            this.jasmin_writer.write("aload " + p.value().symbol.seq);
            this.jasmin_writer.newLine();

            String curr_def_klass = p.receiver().symbol.defKlass;
            String curr_ret_type = p.receiver().symbol.type;
            if (curr_def_klass == "SELF_TYPE") {
                curr_def_klass = curr_class_name;
            }
            if (curr_ret_type == "SELF_TYPE") {
                curr_ret_type = curr_class_name;
            }

            this.jasmin_writer.write("putfield " + curr_def_klass +
                "/" + p.attr().id + " L" + curr_ret_type + ";");

            this.jasmin_writer.newLine();
            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitUnopInst(UnopInst p) {

        println(p.left() + " = " + p.op() + " " + p.right());

        try {
            this.jasmin_writer.write("; Unop Inst start");
            this.jasmin_writer.newLine();

            if (p.op() == Singletons.ISVOID) {
                this.jasmin_writer.write("aload " + p.right().symbol.seq);
                this.jasmin_writer.newLine();

                if (p.right().symbol.not_void) {
                    this.jasmin_writer.write("new Bool");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("dup");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokespecial Bool/<init>()V");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("iconst_0");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokevirtual Bool/putval(Z)LBool;");
                    this.jasmin_writer.newLine();
                }
                else {
                    this.jasmin_writer.write("new Bool");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("dup");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokespecial Bool/<init>()V");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("iconst_1");
                    this.jasmin_writer.newLine();
                    this.jasmin_writer.write("invokevirtual Bool/putval(Z)LBool;");
                    this.jasmin_writer.newLine();
                }

                this.jasmin_writer.write("astore " + p.left().symbol.seq);
                this.jasmin_writer.newLine();
            }
            if (p.op() == Singletons.NEG) {
                this.jasmin_writer.write("aload " + p.right().symbol.seq);
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("invokevirtual Int/neg()LInt;");
                this.jasmin_writer.newLine();

                this.jasmin_writer.write("astore " + p.left().symbol.seq);
                this.jasmin_writer.newLine();

                this.jasmin_writer.newLine();
            }
            this.jasmin_writer.newLine();
            this.jasmin_writer.newLine();
        }
        catch (IOException e) {
            System.err.println("An IOException was caught :" + e.getMessage());
        }
        return null;
    }
}
