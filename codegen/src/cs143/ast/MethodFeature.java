package cs143.ast;

import java.io.PrintStream;
import java.util.List;

public class MethodFeature extends Feature {
    List<Formal> formals; // whats a formal ? parameters to the method ?

    public MethodFeature(int line_num, String attr_name,  List<Formal> formals, String ty_name, Expr e) {
        super(line_num, attr_name, ty_name, e);
        this.formals = formals;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_method");
        ps.println(padding(pad+2) + attr_name);
        for (Formal f : formals)
            f.dump(ps, pad+2);
        ps.println(padding(pad+2) + ty_name);
        expr.dump(ps, pad + 2);
    }

    public List<Formal> formals() { return formals; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitMethodFeature(this);
    }
}
