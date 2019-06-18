package cs143.ir;

public abstract class InstVisitor<T> {

     final public T visit(Inst a) { return a.accept(this); }

     abstract public T visitAllocInst(AllocInst p);
     abstract public T visitBinopInst(BinopInst p);
     abstract public T visitCondBranchInst(CondBranchInst p);
     abstract public T visitDispatchInst(DispatchInst p);
     abstract public T visitGotoInst(GotoInst p);
     abstract public T visitDiscardInst(DiscardInst p);
     abstract public T visitLabelInst(LabelInst p);
     abstract public T visitLoadAttrInst(LoadAttrInst p);
     abstract public T visitMoveInst(MoveInst p);
     abstract public T visitReturnInst(ReturnInst p);
     abstract public T visitStaticDispatchInst(StaticDispatchInst p);
     abstract public T visitStoreAttrInst(StoreAttrInst p);
     abstract public T visitUnopInst(UnopInst p);
}
