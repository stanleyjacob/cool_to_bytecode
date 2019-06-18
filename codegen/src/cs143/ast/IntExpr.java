package cs143.ast;

import java.io.PrintStream;

public class IntExpr extends Expr {
    int value;

    public IntExpr(int line_num, int value, String type_name) {
        super(line_num, type_name);
        this.value = value;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_int");
        ps.println(padding(pad+2) + value);
        super.dumpType(ps, pad);
    }

    public int value() { return value; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitIntExpr(this);
    }
}
