package cs143.environment;

import cs143.ast.*;

import java.util.*;

import cs143.ir.AttrCode;

public class Environment extends BaseEnvironment {

    public int seq_no;

    public List<AttrCode> attr_init_code = new ArrayList<>();

    public List<VarSymbol> locals = new LinkedList();

    public VarSymbol freshLocal(String curr_type_name) {

        VarSymbol curr_var_symbol = new VarSymbol();
        curr_var_symbol.type = curr_type_name;

        String id = newName(seq_no); // gets new number for scope variable name
        curr_var_symbol.seq = seq_no;  // for params, letvar and tmps
        seq_no += 1;

        curr_var_symbol.kind = curr_var_symbol.kind.tmp;

        curr_var_symbol.id = id;

        varsymtab.put(id, curr_var_symbol);

        locals.add(curr_var_symbol);
        return curr_var_symbol;
    }

    public VarSymbol freshLet(String curr_type_name) {

        VarSymbol curr_var_symbol = new VarSymbol();
        curr_var_symbol.type = curr_type_name;

        String id = newName(seq_no); // gets new number for scope variable name
        curr_var_symbol.seq = seq_no;  // for params, letvar and tmps
        seq_no += 1;

        curr_var_symbol.kind = curr_var_symbol.kind.letvar;

        curr_var_symbol.id = id;

        varsymtab.put(id, curr_var_symbol);

        return curr_var_symbol;
    }


    public void enterClass(String kname) {

        addAttributesToSymbolTable(kname, varsymtab);
        addMethodsToSymbolTable(kname, methsymtab);
    }

    public void exitClass() {

        varsymtab.popScope();
        methsymtab.popScope();
    }

    public void enterMethod() {

        varsymtab.pushScope();
    }

    public void exitMethod() {

        // empty list of locals
        locals = new LinkedList();
        varsymtab.popScope();
    }

    public void enterLet() {

        varsymtab.pushScope();
    }

    public void exitLet() {

        varsymtab.popScope();
    }

    public int lca(String klass_a, String klass_b, int height) {
        if(klass_a.equals("Object")){
            return -1;
        }

        if(klass_a.equals(klass_b)) {
            return height;

        }else{
            String parent_name = parent.get(klass_a);
            int newh = height + 1;
            return lca(parent_name, klass_b, newh);
        }
    }

}
