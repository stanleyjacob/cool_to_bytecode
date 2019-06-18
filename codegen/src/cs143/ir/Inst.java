package cs143.ir;

public abstract class Inst {

    abstract public <T> T accept(InstVisitor<? extends T> visitor);
}
