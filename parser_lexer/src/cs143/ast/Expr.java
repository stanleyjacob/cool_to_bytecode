package cs143.ast;

import java.io.PrintStream;

public abstract class Expr extends Ast {
    String type_name;
    public Expr(int line_num, String type_name) {
        super(line_num);
        this.type_name = type_name;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
    }

    public void dumpType(PrintStream ps, int pad) {
        ps.println(padding(pad) + ": " + ((type_name == null) ? "" : type_name));
    }

    public void set_type_name(String t) { type_name =  t; }
    public String type_name() { return type_name; }
}
