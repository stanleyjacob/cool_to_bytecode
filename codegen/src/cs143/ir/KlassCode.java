package cs143.ir;

import cs143.environment.VarSymbol;
import cs143.environment.KlassSymbol;
import cs143.environment.MethodSymbol;

import java.util.Collection;
import java.util.List;

public class KlassCode extends Code {

    KlassSymbol klass;

    KlassSymbol base;

    Collection<VarSymbol> attrs; // fields defined in this class

    List<MethodCode> methods; // Methods defined in this class, order not important (includes init?)

    Collection<MethodSymbol> methodSigs;

    protected KlassCode() {}

    public KlassCode(KlassSymbol klass, KlassSymbol base, Collection<VarSymbol> attrs, Collection<MethodSymbol> methodSigs, List<MethodCode> methods) {
        this.klass = klass;
        this.base = base;
        this.attrs = attrs;
        this.methodSigs = methodSigs;
        this.methods = methods;
    }

    public <T> T accept(CodeVisitor<? extends T> visitor) {
        return visitor.visitKlassCode(this);
    }

    public KlassSymbol klass() { return klass; }

    public KlassSymbol base() { return base; }

    public Collection<VarSymbol> attrs() { return attrs; }

    public List<MethodCode> methods() { return methods; }

    public Collection<MethodSymbol> methodSigs() { return methodSigs; }  // Symbols are never compared, ref equality is OK
}
