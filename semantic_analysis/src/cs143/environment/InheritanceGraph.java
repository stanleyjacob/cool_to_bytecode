
package cs143.environment;

// import java.util.LinkedHashMap;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Map;
// import java.util.Set;
import java.util.*;

import cs143.semant.*;

public class InheritanceGraph {

    int num_inheritable_classes;
    Map< String, List<String> > graph_adjacency_list;

    public List<String> cycle_list = new ArrayList<>();

    public InheritanceGraph() {

        graph_adjacency_list = new LinkedHashMap<>();
        graph_adjacency_list.put("Object", new ArrayList<>());
        graph_adjacency_list.put("IO", new ArrayList<>());
        graph_adjacency_list.put("String", new ArrayList<>());
        graph_adjacency_list.put("Int", new ArrayList<>());
        graph_adjacency_list.put("Bool", new ArrayList<>());

        num_inheritable_classes = 2;
    }

    void addNode(String class_name, String base_name) {

        try {
            if (base_name == "Int" ||
                base_name == "String" ||
                base_name == "Bool") {
                throw new SemanticException("Cannot inherit from builtin class "
                    + base_name);
            }

            if ( graph_adjacency_list.containsKey(base_name) ) {

                List<String> child_names = graph_adjacency_list.get(base_name);
                child_names.add(class_name);
            }
            else {

                graph_adjacency_list.put( base_name, new ArrayList<>() );

                List<String> child_names = graph_adjacency_list.get(base_name);
                child_names.add(class_name);
            }

            num_inheritable_classes += 1;
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

    }

    boolean hasCycle() {
        Set<String> visited_class_names = new HashSet<>();
        int num_checked_classes = 0;

        boolean res_obj = hasCycle("Object", visited_class_names, num_checked_classes);
        boolean res_io = hasCycle("IO", visited_class_names, num_checked_classes);

        if (res_obj || res_io) {
            return true;
        }

        if (num_inheritable_classes != num_checked_classes) {

            for (String curr_class : graph_adjacency_list.keySet()) {

                if (! visited_class_names.contains(curr_class) ) {

                    if (curr_class == "String" || curr_class == "Int" ||
                        curr_class == "Bool")
                    {
                        continue;
                    }

                    boolean ret_val =
                        hasCycle(curr_class,
                            visited_class_names, num_checked_classes);

                    if (ret_val) {
                        return true;
                    }

                }

            }

        }

        return false;
    }

    boolean hasCycle(String hierarchy_top, Set<String> visited_class_names,
        int num_checked_classes) {

        Set<String> explored_set = new HashSet<String>();
        List<String> dfs_stack = new ArrayList<>();
        dfs_stack.add(hierarchy_top);

        while (dfs_stack.size() != 0) {

            String curr_class = dfs_stack.get( dfs_stack.size() - 1 );
            dfs_stack.remove( dfs_stack.size() - 1 );

            explored_set.add(curr_class);

            num_checked_classes += 1;
            visited_class_names.add(curr_class);

            List<String> child_name_list = graph_adjacency_list.get(curr_class);

            if (child_name_list != null) {
                for (String child_name : child_name_list ) {

                    if (dfs_stack.contains(child_name) ||
                        explored_set.contains(child_name) ) {

                        // cycle_list.add(curr_class);
                        cycle_list.addAll(explored_set);
                        Collections.reverse(cycle_list);

                        // cycle_list.add(child_name);
                        return true;
                    }

                    // if (!explored_set.contains(child_name)) {
                        dfs_stack.add(child_name);
                    // }

                }
            }

        }

        return false;
    }

}
