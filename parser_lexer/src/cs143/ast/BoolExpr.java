package cs143.ast;

import java.io.PrintStream;

public class BoolExpr extends Expr {
    int value; // booleans are 0 or 1 at the AST level

    public BoolExpr(int line_num, int value, String type_name) {
        super(line_num, type_name);
        this.value = value;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_bool");
        ps.println(padding(pad+2) + value);
        super.dumpType(ps, pad);
    }

    public int value() { return value; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitBoolExpr(this);
    }
}
