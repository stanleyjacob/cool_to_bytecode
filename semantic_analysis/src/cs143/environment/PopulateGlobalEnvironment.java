package cs143.environment;


import cs143.ast.*;

import java.util.LinkedList;
import java.util.List;
import cs143.semant.*;

import java.util.*;

public class PopulateGlobalEnvironment {

    Environment env;
    BuiltinKlasses biks;

    public PopulateGlobalEnvironment(Environment env, BuiltinKlasses biks) {
        this.env = env;
        this.biks = biks;
    }

    private void collectLocalMethods(Klass k) {

        try {

            List<String> method_names = new ArrayList<>();
            for (Feature f : k.features()) {
                if (f instanceof MethodFeature) {
                    MethodFeature mf = (MethodFeature) f;
                    String mname = mf.attr_name();
                    String retTy = mf.ty_name();
                    List<String> argTy = new LinkedList<>();
                    for (Formal fr : mf.formals()) {
                        argTy.add(fr.ty_name());
                    }
                    env.addMethod(k.class_name(), mname, argTy, retTy);

                    if ( method_names.contains(mname) ) {
                        throw new SemanticException("Line " + mf.line_num() + ": Method " +
                            mname +
                            " is multiply defined.");
                    }
                    method_names.add(mname);
                }
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }
        return;
    }

    private void collectLocalAttributes(Klass k) {

        try {
            List<String> attr_names = new ArrayList<>();
            for (Feature f : k.features()) {
                if (f instanceof AttrFeature) {
                    AttrFeature af = (AttrFeature) f;
                    env.addAttr(k.class_name(), af.attr_name(), af.ty_name());

                    if ( attr_names.contains(af.attr_name()) ) {
                        throw new SemanticException("Line " + af.line_num() + ": Attribute " +
                            af.attr_name() +
                            " is multiply defined in class.");
                    }
                    attr_names.add(af.attr_name());
                }
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return;
    }

    private void installKlass(Klass k) {
        env.addKlass(k.class_name(), k.base_class_name());
        // env.asts.put(k.class_name(), k);
        collectLocalAttributes(k);
        collectLocalMethods(k);
    }

    public void installBuiltinKlasses() {
        installKlass(biks.objectKlass);
        installKlass(biks.ioKlass);
        installKlass(biks.stringKlass);
        installKlass(biks.intKlass);
        installKlass(biks.boolKlass);
    }

    public void installKlasses(Program p) {
        installBuiltinKlasses();

        try {

            // get all class names first:
            Set<String> possible_class_names = new HashSet<String>();
            possible_class_names.add("Object");
            possible_class_names.add("IO");
            // possible_class_names.add("String");
            // possible_class_names.add("Int");
            // possible_class_names.add("Bool");

            for (Klass k : p.klasses()) {
                possible_class_names.add(k.class_name());
            }

            // check class redefine
            Set<String> set_class_names = new HashSet<String>();

            for (Klass k : p.klasses()) {

                String visiting_class_name = k.class_name();
                if (visiting_class_name == "SELF_TYPE") {
                    throw new SemanticException("Line " + k.line_num() + ": Redefinition of basic class SELF_TYPE.");
                }
                if (set_class_names.contains(visiting_class_name)) {
                    throw new SemanticException("Line " + k.line_num() + ": Repeated class name " + visiting_class_name);
                }

                if (k.base_class_name() == "Int" || k.base_class_name() == "String" || k.base_class_name() == "Bool" || k.base_class_name() == "SELF_TYPE") {
                    throw new SemanticException("Line " + k.line_num() + ": Can't inherit from " + k.base_class_name() );
                }

                if (visiting_class_name == "Int" || visiting_class_name == "String" || visiting_class_name == "Bool"
                    || visiting_class_name == "Object" || visiting_class_name == "IO") {
                    throw new SemanticException("Line " + k.line_num() + ": Redefinition of basic class " + visiting_class_name );
                }

                if (!possible_class_names.contains(k.base_class_name())) {
                    throw new SemanticException("Line " + k.line_num() + ": Undefined class name " + k.base_class_name() );
                }
                if (visiting_class_name == k.base_class_name()) {
                    throw new SemanticException("Line " + k.line_num() + ": inheritance cycle for " +
                        visiting_class_name + " and " + k.base_class_name());
                }

                set_class_names.add(visiting_class_name);
                installKlass(k);
            }


            if (!env.klassTable.keySet().contains("Main")) {
                throw new SemanticException("Class Main is not defined.");
            }

            Map<String, MethodSymbol> meth_tab_main = env.klassMethodTable.get("Main");
            Set<String> meth_names_main = meth_tab_main.keySet();
            if (!meth_names_main.contains("main")) {
                throw new SemanticException("No 'main' method in class Main.");
            }

            // Check class inheritance problems
            // aka cycles
            InheritanceGraph class_graph = new InheritanceGraph();
            for (Klass k : p.klasses()) {

                // System.out.println(k.class_name());
                // System.out.println(k.base_class_name());
                class_graph.addNode(k.class_name(),
                    k.base_class_name());
            }

            if (class_graph.hasCycle()) {

                String curr_str = new String();
                for (int i = 0; i < class_graph.cycle_list.size(); ++i) {
                    curr_str += class_graph.cycle_list.get(i) + " ";
                }
                throw new SemanticException("Inheritance cycle detected involving " + curr_str);
            }

            // now, check each class to see if attribute name in current
            // class is same as base classes
            for (Klass k : p.klasses()) {
                Map<String, VarSymbol> curr_attr_table =
                    env.klassAttrTable.get(k.class_name());

                if (curr_attr_table == null) {
                    continue;
                }

                String curr_class = k.class_name();
                String parent_class;
                while (curr_class != "_no_type" ||
                    curr_class != Singletons.BOTTOM ||
                    curr_class != "Object" ||
                    curr_class != "IO" ||
                    curr_class != null) {

                    parent_class = env.parent.get(curr_class);
                    // System.out.println(parent_class);
                    if (parent_class == null || parent_class == "Object" ||
                        parent_class == "IO" || parent_class == "Bottom") {
                        break;
                    }

                    Map<String, VarSymbol> parent_attr = env.klassAttrTable.get(parent_class);
                    if (parent_attr == null) {
                        curr_class = parent_class;
                        continue;
                    }
                    Set<String> parent_attr_names = parent_attr.keySet();

                    for (String curr_attr : curr_attr_table.keySet()) {
                        if (parent_attr_names.contains(curr_attr)) {
                            throw new SemanticException("Line " + k.line_num() + ": Repeated attribute name " + curr_attr);
                        }
                    }

                    curr_class = parent_class;
                }
            }


            // now, see if method override exactly matches
            for (Klass k : p.klasses()) {
                Map<String, MethodSymbol> curr_method_table =
                    env.klassMethodTable.get(k.class_name());

                if (curr_method_table == null) {
                    continue;
                }

                String curr_class = k.class_name();
                String parent_class;
                while (curr_class != "_no_type" ||
                    curr_class != Singletons.BOTTOM ||
                    curr_class != "Object" ||
                    curr_class != "IO" ||
                    curr_class != null) {

                    parent_class = env.parent.get(curr_class);
                    // System.out.println(parent_class);
                    if (parent_class == null || parent_class == "Object" ||
                        parent_class == "IO" || parent_class == "Bottom") {
                        break;
                    }

                    Map<String, MethodSymbol> parent_method = env.klassMethodTable.get(parent_class);
                    if (parent_method == null) {
                        curr_class = parent_class;
                        continue;
                    }
                    Set<String> parent_method_names = parent_method.keySet();

                    for (String curr_meth_name : curr_method_table.keySet()) {

                        if (parent_method_names.contains(curr_meth_name)) {

                            // entering here for method overriding
                            // now compare parameters using MethodSymbol

                            MethodSymbol parent_methsym = parent_method.get(curr_meth_name);
                            MethodSymbol curr_methsym = curr_method_table.get(curr_meth_name);
                            if (parent_methsym.argTy.size() != curr_methsym.argTy.size()) {
                                throw new SemanticException("Line " + k.line_num() + ": Incompatible number of formal parameters in redefined method " + curr_meth_name);
                            }

                            else {
                                for (int i = 0; i < curr_methsym.argTy.size(); ++i) {

                                    String ty1 = curr_methsym.argTy.get(i);
                                    String ty2 = parent_methsym.argTy.get(i);
                                    if (ty1 != ty2) {
                                        throw new SemanticException("Line " + k.line_num() + ": In redefined method " + curr_meth_name + ", parameter type " + ty1 + " is different from original type " + ty2);
                                    }

                                }

                                if (parent_methsym.type != curr_methsym.type) {

                                    throw new SemanticException("Line " + k.line_num() + ": In redefined method " + curr_meth_name + ", return type " + curr_methsym.type + " is different from original type " + parent_methsym.type);

                                }

                            }

                        }

                    }

                    curr_class = parent_class;
                }

            }

        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

}
