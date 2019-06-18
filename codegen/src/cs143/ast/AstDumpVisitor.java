package cs143.ast;

import cs143.ast.*;

import java.io.PrintStream;

public class AstDumpVisitor extends AstVisitor<Void> {

    PrintStream ps;
    int indentation;

    public AstDumpVisitor(PrintStream ps) {
        this.ps = ps;
        this.indentation = 0;
    }

    void incr() { indentation = indentation + 2; }
    void dec() { indentation = indentation - 2; }

    String pad() {
        char a[] = new char[indentation];
        for (int i = 0; i < indentation; i++) a[i] = ' ';
        return new String(a);
    }

    private void println(String s) {
        ps.println(pad() + s);
    }

    private void print_line_num(Ast a) { println("#" + a.line_num()); }

    private void print_type_name(Expr e) {
        println(": " + ((e.type_name() == null) ? "" : e.type_name()));
    }

    @Override
    public Void visitProgram(Program p) {
        print_line_num(p);
        println("_program");
        incr();
            for (Klass k : p.klasses()) visitKlass(k);
        dec();
        return null;
    }

    @Override
    public Void visitKlass(Klass k) {
        print_line_num(k);
        println("_class");
        incr();
            println(k.class_name());
            println(k.base_class_name());
            println(k.file_name());
            println("(");
            for (Feature f : k.features()) {
                visit(f);
            }
            println(")");
        dec();
        return null;
    }

    @Override
    public Void visitMethodFeature(MethodFeature m) {
        print_line_num(m);
        println("_method");
        incr();
            println(m.attr_name());
            for (Formal f : m.formals())
                visit(f);
            println(m.ty_name());
            visit(m.expr());
        dec();
        return null;
    }


    @Override
    public Void visitAttrFeature(AttrFeature a) {
        print_line_num(a);
        println("_attr");
        incr();
            println(a.attr_name());
            println(a.ty_name());
            visit(a.expr());
        dec();
        return null;
    }

    @Override
    public Void visitFormal(Formal f) {
        print_line_num(f);
        println("_formal");
        incr();
            println(f.formal_name());
            println(f.ty_name());
        dec();
        return null;
    }

    @Override
    public Void visitAssignExpr(AssignExpr a) {
        print_line_num(a);
        println("_assign");
        incr();
            println(a.id());
            visit(a.expr());
        dec();
        print_type_name(a);
        return null;
    }

    @Override
    public Void visitStaticDispatchExpr(StaticDispatchExpr a) {
        print_line_num(a);
        println("_static_dispatch");
        incr();
            visit(a.expr());
            println(a.at());
            println(a.mname());
            println("(");
            for (Expr e : a.actuals())
                visit(e);
            println(")");
        dec();
        print_type_name(a);
        return null;
    }

    @Override
    public Void visitDispatchExpr(DispatchExpr d) {
        print_line_num(d);
        println("_dispatch");
        incr();
            visit(d.expr());
            println(d.mname());
            println("(");
            for (Expr a : d.actuals())
                visit(a);
            println(")");
        dec();
        print_type_name(d);
        return null;
    }

    @Override
    public Void visitCondExpr(CondExpr c) {
        print_line_num(c);
        println("_cond");
        incr();
            visit(c.cond());
            visit(c.then());
            visit(c.els());
        dec();
        print_type_name(c);
        return null;
    }


    @Override
    public Void visitLoopExpr(LoopExpr l) {
        print_line_num(l);
        println("_loop");
        incr();
            visit(l.cond());
            visit(l.body());
        dec();
        print_type_name(l);
        return null;
    }

    @Override
    public Void visitBlockExpr(BlockExpr b) {
        print_line_num(b);
        println("_block");
        incr();
            for (Expr e : b.exprs())
                visit(e);
        dec();
        print_type_name(b);
        return null;
    }

    @Override
    public Void visitLetExpr(LetExpr l) {
        print_line_num(l);
        println("_let");
        incr();
            println(l.id());
            println(l.ty());
            visit(l.init());
            visit(l.body());
        dec();
        print_type_name(l);
        return null;
    }

    @Override
    public Void visitTypCaseExpr(TypCaseExpr t) {
        print_line_num(t);
        println("_typcase");
        incr();
            visit(t.expr());
            for (Kase k : t.kases()) {
                visit(k);
            }
        dec();
        print_type_name(t);
        return null;
    }

    @Override
    public Void visitNewExpr(NewExpr n) {
        print_line_num(n);
        println("_new");
        incr();
            println(n.id());
        dec();
        print_type_name(n);
        return null;
    }

    public Void visitUnary(Expr e, String op, Expr arg_e) {
        print_line_num(e);
        println(op);
        incr();
            visit(arg_e);
        dec();
        print_type_name(e);
        return null;
    }

    public Void visitBinary(Expr e, String op, Expr left, Expr right) {
        print_line_num(e);
        println(op);
        incr();
            visit(left);
            visit(right);
        dec();
        print_type_name(e);
        return null;
    }

    @Override
    public Void visitIsVoidExpr(IsVoidExpr i) {
        return visitUnary(i, i.op(), i.expr());
    }

    @Override
    public Void visitPlusExpr(PlusExpr p) {
        return visitBinary(p, p.op(), p.left(), p.right());
    }

    @Override
    public Void visitSubExpr(SubExpr s) {
        return visitBinary(s, s.op(), s.left(), s.right());
    }

    @Override
    public Void visitMulExpr(MulExpr m) {
        return visitBinary(m, m.op(), m.left(), m.right());
    }

    @Override
    public Void visitDivideExpr(DivideExpr d) {
        return visitBinary(d, d.op(), d.left(), d.right());
    }

    @Override
    public Void visitNegExpr(NegExpr n) {
        return visitUnary(n, n.op(), n.expr());
    }

    @Override
    public Void visitLtExpr(LtExpr l) {
        return visitBinary(l, l.op(), l.left(), l.right());
    }

    @Override
    public Void visitEqExpr(EqExpr e) {
        return visitBinary(e, e.op(), e.left(), e.right());
    }

    @Override
    public Void visitLeqExpr(LeqExpr l) {
        return visitBinary(l, l.op(), l.left(), l.right());
    }

    @Override
    public Void visitCompExpr(CompExpr c) {
        return visitUnary(c, c.op(), c.expr());
    }

    @Override
    public Void visitIntExpr(IntExpr i) {
        print_line_num(i);
        println("_int");
        incr();
            println(i.value()+""); // convert to string
        dec();
        print_type_name(i);
        return null;
    }

    @Override
    public Void visitStringExpr(StringExpr s) {
        print_line_num(s);
        println("_string");
        incr();
            println(s.value());
        dec();
        print_type_name(s);
        return null;
    }

    @Override
    public Void visitBoolExpr(BoolExpr b) {
        print_line_num(b);
        println("_bool");
        incr();
            println(b.value()+"");
        dec();
        print_type_name(b);
        return null;
    }

    @Override
    public Void visitObjectExpr(ObjectExpr o) {
        print_line_num(o);
        println("_object");
        incr();
           println(o.id());
        dec();
        print_type_name(o);
        return null;
    }

    @Override
    public Void visitNoExprExpr(NoExprExpr n) {
        print_line_num(n);
        println("_no_expr");
        print_type_name(n);
        return null;
    }

    @Override
    public Void visitKase(Kase k) {
        print_line_num(k);
        println("_branch");
        incr();
            println(k.id());
            println(k.case_ty());
            visit(k.expr());
        dec();
        return null;
    }
}
