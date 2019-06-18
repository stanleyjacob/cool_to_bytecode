package cs143.ast;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class Program extends Ast {
    private List<Klass> klasses;

    public Program(int line_num) {
        super(line_num);
    }

    public Program(int line_num, List<Klass> klasses) {
        this(line_num);
        this.klasses = klasses;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_program");
        for (Klass k : klasses) k.dump(ps, pad+2);
    }

    public List<Klass> klasses() {
        return klasses;
    }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitProgram(this);
    }
}
