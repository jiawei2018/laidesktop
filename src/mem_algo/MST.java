package mem_algo;

import java.util.*;

public class MST {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        //using kraskul's algorithm
        //we see the well as an edge from un fake node to current node i;
        PriorityQueue<Edge> minheap = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });

        for(int[] p : pipes){
            minheap.offer(new Edge(p[0], p[1], p[2]));
        }

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
            if(uf.union(cur.u, cur.v)){
                res += cur.cost;
                count++;//means we used a edge
            }
        }
        if(count == n){//means something wrong, we cant get enough information to ans
            return res;
        }

        return -1;
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





    public int minCostToSupplyWater2(int n, int[] wells, int[][] pipes) {
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
            // if(!graph.containsKey(p[1])){
            //     graph.add(p[1], new ArrayList<>());
            // }
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




}
