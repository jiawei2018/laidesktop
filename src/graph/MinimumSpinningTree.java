package graph;

import java.util.*;

public class MinimumSpinningTree {
    //lc 1168
    /*
    *1168. Optimize Water Distribution in a Village


There are n houses in a village.
We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i],
or pipe in water from another well to it.
The costs to lay pipes between houses are given by the array pipes,
where each pipes[i] = [house1, house2, cost] represents
the cost to connect house1 and house2 together using a pipe.
Connections are bidirectional.

Find the minimum total cost to supply water to all houses.



Example 1:



Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation:
The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and
connect the other houses to it with cost 2 so the total cost is 3.


Constraints:

1 <= n <= 10000
wells.length == n
0 <= wells[i] <= 10^5
1 <= pipes.length <= 10000
1 <= pipes[i][0], pipes[i][1] <= n
0 <= pipes[i][2] <= 10^5
pipes[i][0] != pipes[i][1]
    *
    *
    *
    * */

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        //using Kruskal's algorithm
        //we see the well as an edge from un fake node to current node i;
        PriorityQueue<Edge> minheap = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        for(int[] p : pipes){
            minheap.offer(new Edge(p[0], p[1], p[2]));
        }

        Set<Integer> used = new HashSet<>();
        //add fake edge for each well into heap
        for(int i = 0; i < wells.length; i++){
            //notice here ! the well num also from 1 to n,!!!!!
            //so the current node's id is i + 1
            minheap.offer(new Edge(0, i + 1, wells[i]));
        }

        UnionFind uf = new UnionFind(n + 1);//thsi problem node's id starts from one

        int res = 0;
        int count = 0;
        while(!minheap.isEmpty()){
            Edge cur = minheap.poll();
            //record the currentt edge
            //System.out.println(cur);
            if(uf.union(cur.u, cur.v)){
                //System.out.println(cur);
                res += cur.cost;
                count++;
            }
        }
        //System.out.println(count + " <<<<");
        if(count == n){//means something wrong, we cant get enough information to ans
            return res;
        }

        return -1;
    }

    class UnionFind{
        int[] roots;

        public UnionFind(int num){
            roots = new int[num];
            for(int i = 0; i < roots.length; i++){
                roots[i] = i;
            }
        }

        public int find(int a){
            if(roots[a] == a){
                return a;
            }
            roots[a] = find(roots[a]);
            return roots[a];
        }

        public boolean union(int a, int b){
            int roota = find(a);
            int rootb = find(b);
            if(roota != rootb){
                roots[roota] = rootb;
                return true;
            }
            return false;
        }
    }







    public int minCostToSupplyWater_prim(int n, int[] wells, int[][] pipes) {
        //using prim algorithm

        //step 1 build graph with adjascent list
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 0; i <= n; i++){//u-> v
            graph.put(i, new ArrayList<>());
        }
        for(int[] p : pipes){
            Edge a = new Edge(p[0], p[1], p[2]);
            Edge b = new Edge(p[1], p[0], p[2]);
            graph.get(p[0]).add(a);
            graph.get(p[1]).add(b);
        }

        for(int i  = 0; i < wells.length; i++){
            Edge a = new Edge(0, i + 1, wells[i]);
            Edge b = new Edge(i + 1, 0, wells[i]);
            graph.get(0).add(a);
            graph.get(i + 1).add(b);
        }

        PriorityQueue<Edge> minheap = new PriorityQueue<>((a, b) -> {
            if(a.cost == b.cost){
                return a.v - b.v;//?
            }
            return a.cost - b.cost;
        });

        minheap.offer(new Edge(0, 0, 0));

        int res = 0;
        Set<Integer> used = new HashSet<>();
        while(!minheap.isEmpty()){
            Edge cur = minheap.poll();

            if(used.add(cur.v)){
                res += cur.cost;
                for(Edge e: graph.get(cur.v)){//u->v -> next neighbours
                    if(!used.contains(e.v)){
                        minheap.offer(e);
                    }
                }
            }
        }

        return res;
    }

    class Edge{
        int u;
        int v;
        int cost;
        public Edge(int a, int b, int cost){
            u = a;
            v = b;
            this.cost = cost;
        }

        @Override
        public String toString(){
            return u+","+v+","+cost;
        }
    }

}
