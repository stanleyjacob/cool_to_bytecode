package cs143.environment;

import java.util.List;

public class MethodSymbol extends Symbol {
    public List<String> argTy;
    public String defKlass; // for attr and method
    public String type; // in method, interpreted as ret ty. Unused in klass.
}
