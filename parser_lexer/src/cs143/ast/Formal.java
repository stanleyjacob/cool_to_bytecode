package cs143.ast;

import java.io.PrintStream;

public class Formal extends Ast {
    String formal_name;
    String ty_name;

    public Formal(int line_num, String formal_name, String ty_name) {
        super(line_num);
        this.formal_name = formal_name;
        this.ty_name = ty_name;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_formal");
        ps.println(padding(pad+2) + formal_name);
        ps.println(padding(pad+2) + ty_name);
    }

    public String formal_name() { return formal_name; }

    public String ty_name() { return ty_name; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitFormal(this);
    }
}
