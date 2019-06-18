package cs143.environment;

import cs143.ast.Klass;

import cs143.ast.AttrFeature;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cs143.ir.AttrCode;

public class BaseEnvironment {

    // These are initialized once for the code gen phase
    public Map<String, Map<String, MethodSymbol>> klassMethodTable = new LinkedHashMap<>();
    public Map<String, KlassSymbol> klassTable = new LinkedHashMap<>();
    public Map<String, String> parent = new LinkedHashMap<>();

    public Map<String, Map<String, VarSymbol>> klassAttrTable = new LinkedHashMap<>();
    public Map<String, List<AttrFeature>> klassAttrFeatureTable = new LinkedHashMap<>();

    public Map<String, Map<String, AttrCode>> klassAttrCodeTable = new LinkedHashMap<>();

    public Map<String, List<String>> children = new LinkedHashMap<>();
    public Map<String, Klass> asts = new LinkedHashMap<>();

    // These are initialized once per klass
    public SymbolTable<VarSymbol> varsymtab;
    public SymbolTable<MethodSymbol> methsymtab;
    static int label = 0;

    // Helper functions called from PopulateGlobalEnv
    public BaseEnvironment() {

        this.varsymtab = new SymbolTable();
        this.methsymtab = new SymbolTable();

    }

    public void addKlass(String name, String base) {

        if (klassTable.containsKey(name)) {
            // System.out.println(name);
            return;
        }

        KlassSymbol s = new KlassSymbol();
        s.id = name;
        s.base = base;
        klassTable.put(name, s);

        klassMethodTable.put(name, new LinkedHashMap<>());
        klassAttrTable.put(name, new LinkedHashMap<>());
        klassAttrCodeTable.put(name, new LinkedHashMap<>());

        parent.put(name, base);
        if (! base.equals(Singletons.BOTTOM))
            children.get(base).add(name);
        children.put(name, new LinkedList<>());
    }

    public void addMethod(String kname, String mname,
        List<String> argTy, String retTy) {
        Map<String, MethodSymbol> methods = klassMethodTable.get(kname);
        MethodSymbol s = new MethodSymbol();
        s.id = mname;
        s.defKlass = kname;
        s.argTy = argTy;
        s.type = retTy;
        methods.put(mname, s);


    }

    public void addAttr(String kname, String aname, String tyname) {
        Map<String, VarSymbol> attrs = klassAttrTable.get(kname);
        VarSymbol s = new VarSymbol();
        s.id = aname;
        s.kind = VarSymbol.SymbolKind.attr;
        s.defKlass = kname;
        s.type = tyname;
        attrs.put(aname, s);
    }

    public void addParam(String kname, String aname,
        String tyname, int seq_no) {
        VarSymbol s = new VarSymbol();

        s.id = aname;
        s.kind = VarSymbol.SymbolKind.param;
        s.defKlass = kname;
        s.type = tyname;
        s.seq = seq_no;
        // don't increment seq_no here, already doing in AstToIR()

        varsymtab.put(s.id, s);
    }


    // Given a klass name, this method can set up
    // the scoped symbol table varsymtab
    public void addAttributesToSymbolTable(String name,
        SymbolTable<VarSymbol> varsymtab) {

        String base = parent.get(name);
        if (!base.equals(Singletons.BOTTOM)) {

            addAttributesToSymbolTable(base, varsymtab);
        }
        Map<String, VarSymbol> localAttrs = klassAttrTable.get(name);
        varsymtab.pushScope(localAttrs);
    }


    // Given a klass name, this method can set up
    // the scoped symbol table methsymtab
    public void addMethodsToSymbolTable(String name,
        SymbolTable<MethodSymbol> methsymtab) {

        String base = parent.get(name);
        if (! base.equals(Singletons.BOTTOM)) {

            addMethodsToSymbolTable(base, methsymtab);
        }
        Map<String, MethodSymbol> localMethods = klassMethodTable.get(name);
        methsymtab.pushScope(localMethods);
    }


    public int newLabel() {
        int current_label = label;
        label = label + 1;
        return current_label;
    }

    public String newName(int name_id) {
        String name = Integer.toString(name_id);
        return name;
    }

    // Functions that will be called to look things up during processing
    public VarSymbol findVar(String id) {
        return varsymtab.find(id);

    }

    public boolean found_symbol_check(String id) {
        return varsymtab.found_symbol_check(id);

    }

    public MethodSymbol findMethod(String id) {
        MethodSymbol ms = methsymtab.find(id);
        return ms;
    }

    // what's this ???
    public MethodSymbol findMethod(String id, String klass) {
        SymbolTable<MethodSymbol> st = new SymbolTable<>();

        addMethodsToSymbolTable(klass, st);

        return st.find(id);
    }

}
