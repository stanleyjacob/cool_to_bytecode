package cs143.ast;

import java.io.PrintStream;

public class Kase extends Ast {
    String id;
    String case_ty;
    Expr expr;

    public Kase(int line_num, String id, String case_ty, Expr e) {
        super(line_num);
        this.id = id;
        this.case_ty = case_ty;
        this.expr = e;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_branch");
        ps.println(padding(pad+2) + id);
        ps.println(padding(pad+2) + case_ty);
        expr.dump(ps, pad+2);
    }

    public String id() { return id; }

    public String case_ty() { return case_ty; }

    public Expr expr() { return expr; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitKase(this);
    }
}
