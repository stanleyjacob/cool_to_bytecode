package cs143.ast;

import java.io.PrintStream;

public abstract class UnaryExpr extends Expr {
    String op;  // IsVoid, Neg, Comp
    Expr expr;

    public UnaryExpr(int line_num, String op, Expr e, String type_name) {
        super(line_num, type_name);
        this.op = op;
        this.expr = e;
    }

    public String op() { return op; }

    public Expr expr() { return expr; }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + op);
        expr.dump(ps, pad+2);
        super.dumpType(ps, pad);
    }
}
