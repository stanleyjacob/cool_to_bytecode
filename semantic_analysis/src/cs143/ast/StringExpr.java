package cs143.ast;

import java.io.PrintStream;

public class StringExpr extends Expr {
    String value;

    public StringExpr(int line_num, String value, String type_name) {
        super(line_num, type_name);
        this.value = value;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_string");
        ps.println(padding(pad+2) + value);
        super.dumpType(ps, pad);
    }

    public String value() { return value; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitStringExpr(this);
    }
}
