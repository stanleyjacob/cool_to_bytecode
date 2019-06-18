package cs143.ast;

import java.io.PrintStream;

public class AttrFeature extends Feature {

    public AttrFeature(int line_num, String attr_name, String ty_name, Expr expr) {
        super(line_num, attr_name, ty_name, expr);
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_attr");
        ps.println(padding(pad+2) + attr_name);
        ps.println(padding(pad+2) + ty_name);
        expr.dump(ps, pad + 2);
    }


    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitAttrFeature(this);
    }
}
