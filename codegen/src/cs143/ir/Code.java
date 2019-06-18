package cs143.ir;

public abstract class Code {

    int line_num  = 0;

    abstract public <T> T accept(CodeVisitor<? extends T> visitor);

    public int line_num() { return line_num; }
}
