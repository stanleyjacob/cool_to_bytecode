
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

    // int num_classes;
    Map< String, List<String> > graph_adjacency_list;

    public InheritanceGraph() {

        graph_adjacency_list = new LinkedHashMap<>();
        graph_adjacency_list.put("Object", new ArrayList<>());
        graph_adjacency_list.put("IO", new ArrayList<>());
        graph_adjacency_list.put("String", new ArrayList<>());
        graph_adjacency_list.put("Int", new ArrayList<>());
        graph_adjacency_list.put("Bool", new ArrayList<>());
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
      }
      catch (SemanticException e) {
          System.out.println(e);
          System.exit(-1);
      }

    }

    boolean hasCycle() {
        Set<String> explored_set = new HashSet<String>();
        List<String> dfs_stack = new ArrayList<>();
        dfs_stack.add("Object");

        while (dfs_stack.size() != 0) {
            String curr_class = dfs_stack.get( dfs_stack.size() - 1 );
            dfs_stack.remove( dfs_stack.size() - 1 );

            explored_set.add(curr_class);

            for (String child_name : graph_adjacency_list.get(curr_class) ) {

                if (dfs_stack.contains(child_name)) {
                    return true;
                }

                if (!explored_set.contains(child_name)) {
                    dfs_stack.add(child_name);
                }

            }

        }

        return false;
    }

}
