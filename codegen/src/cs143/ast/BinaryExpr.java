package cs143.ast;

import java.io.PrintStream;

public abstract class BinaryExpr extends Expr {
    String op;
    Expr left;
    Expr right;

    public BinaryExpr(int line_num, String op, Expr e1, Expr e2, String type_name) {
        super(line_num, type_name);
        this.op = op;
        this.left = e1;
        this.right = e2;
    }

    public String op() { return op; }

    public Expr left() { return left; }

    public Expr right() { return right; }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + op);
        left.dump(ps, pad+2);
        right.dump(ps, pad+2);
        super.dumpType(ps, pad);
    }

}
