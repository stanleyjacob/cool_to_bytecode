package cs143.ast;

import java.io.PrintStream;

public class AssignExpr extends Expr {
    String id;
    Expr expr;

    public AssignExpr(int line_num, String id, Expr e, String type_name) {
        super(line_num, type_name);
        this.id = id;
        this.expr = e;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_assign");
        ps.println(padding(pad+2) + id);
        expr.dump(ps, pad+2);
        super.dumpType(ps, pad);
    }

    public String id() { return id; }
    public Expr expr() { return expr;}

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitAssignExpr(this);
    }
}
