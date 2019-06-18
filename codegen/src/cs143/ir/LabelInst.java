package cs143.ir;

public class LabelInst extends Inst {
    int label;

    public LabelInst(int label) {
        this.label = label;
    }

    public int label() { return label; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitLabelInst(this);
    }
}
