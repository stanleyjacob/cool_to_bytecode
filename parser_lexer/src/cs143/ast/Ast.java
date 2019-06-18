package cs143.ast;

import java.io.PrintStream;

public abstract class Ast {
    private int line_num;

    private Ast() {} // derived classes' constructor may not call this.

    public Ast(int line_num) {
        this.line_num = line_num;
    }

    String padding(int n) {
        char a[] = new char[n];
        for (int i = 0; i < n; i++) a[i] = ' ';
        return new String(a);
    }

    public void dump(PrintStream ps, int pad) {
        ps.println(padding(pad) + "#" + line_num);
    }

    public int line_num() {
        return line_num;
    }

    abstract public <T> T accept(AstVisitor<? extends T> visitor);
}
