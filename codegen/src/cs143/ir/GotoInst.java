package cs143.ir;

public class GotoInst extends Inst {
    int label;

    public GotoInst(int label) {
        this.label = label;
    }

    public int label() { return label; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitGotoInst(this);
    }
}
