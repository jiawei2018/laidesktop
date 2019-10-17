package class6;

import java.util.*;

/**
 * Determine if an undirected graph is bipartite.
 * A bipartite graph is one in which the nodes can be divided into
 * two groups such that no nodes have direct edges to other nodes in the same group.
 *
 * Examples
 *
 * 1  --   2
 *
 *     /
 *
 * 3  --   4
 *
 * is bipartite (1, 3 in group 1 and 2, 4 in group 2).
 *
 * 1  --   2
 *
 *     /   |
 *
 * 3  --   4
 *
 * is not bipartite.
 *
 * Assumptions
 *
 * The graph is represented by a list of nodes, and the list of nodes is not null.
 *
 */
public class bipartite {
    class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
      this.key = key;
      this.neighbors = new ArrayList<GraphNode>();
    }
  }

        public boolean isBipartite(List<GraphNode> graph) {
            // write your solution here
            //看样子bfs1 是不可以 recursion?
            if(graph.size() <= 1){
                return false;
            }
            Map<GraphNode, Integer> map = new HashMap<>();//visited


            int dir = 1;//1 or -1
            for(GraphNode g : graph){
                if(checkNode(g, map, -dir) == false) {
                    return false;
                }
            }//for
            return true;
        }

        private boolean checkNode(GraphNode g , Map<GraphNode, Integer> map, int dir){
            if(map.containsKey(g)){//base case
                return true;
            }
            Queue<GraphNode>  q = new ArrayDeque<>();
            q.offer(g);
            map.put(g, dir);
            while(!q.isEmpty()){
                GraphNode cur = q.poll();
                int curdir = map.get(cur);
                for(GraphNode i : cur.neighbors){
                    if(!map.containsKey(i)){
                        map.put(i, -curdir);
                        q.offer(i);
                    }else if(map.get(i) != -curdir){
                            return false;
                    }
                }//for
            }//while
            return true;
        }//method
}
