package mem_algo;

import java.util.*;

public class MST {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n + 1);
        // Store all edges and compare by its weight.
        // int[] edge, from edge[0] to edge[1] cost is edge[2].
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for(int[] pipe : pipes) {
            minHeap.offer(pipe);
        }
        for(int i = 0; i < n; i++) {
            minHeap.offer(new int[] {0, i + 1, wells[i]});
        }
        // res is the minimum cost to build pipes and wells.
        // cnt record how many times we union disconnected nodes.
        int res = 0, cnt = 0;
        while(!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();
            if(uf.connected(edge[0], edge[1])) {
                continue;
            } else {
                res += edge[2];
                cnt++;
                uf.union(edge[0], edge[1]);
            }
        }
        if(cnt == n) {
            return res;
        }
        return -1;
    }

    class UnionFind {
        int[] rank;
        int[] parent;

        UnionFind(int n) {
            this.rank = new int[n];
            this.parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if(parent[x] == x) return x;
            int p = find(parent[x]);
            parent[x] = p;
            return p;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int xp = find(x);
            int yp = find(y);
            if(xp == yp) {
                return;
            }

            if(rank[xp] == rank[yp]) {
                parent[yp] = xp;
                rank[xp]++;
            } else if (rank[xp] > rank[yp]) {
                parent[yp] = xp;
            } else {
                parent[xp] = yp;
            }
        }
    }






    class Edge {
        int w;
        int from;
        int to;
        public Edge(int from, int to, int w) {
            this.w = w;
            this.to = to;
            this.from = from;
        }
    }
    public int minCostToSupplyWater1(int n, int[] wells, int[][] pipes) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] pipe : pipes) {
            int from = pipe[0];
            int to = pipe[1];
            int w = pipe[2];
            graph.get(from).add(new Edge(from, to, w));
            graph.get(to).add(new Edge(to, from, w));
        }
        for(int i = 1; i <= n; i++) {
            graph.get(i).add(new Edge(i, 0, wells[i - 1]));
            graph.get(0).add(new Edge(0, i, wells[i - 1]));
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> heap = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                if(e1.w == e2.w) {
                    return e1.to - e2.to;
                }
                return e1.w - e2.w;
            }
        });
        heap.offer(new Edge(0, 0, 0));

        int minimumCost = 0;
        while (!heap.isEmpty()) {
            Edge e = heap.poll();
            //System.out.println("To:" + e.to);
            int from = e.from;
            int to = e.to;
            int w = e.w;
            if (!visited.add(to)) continue;
            minimumCost += w;

            for(Edge nei : graph.get(to)) {
                if(!visited.contains(nei.to)) {
                    heap.offer(nei);
                }

            }
        }
        return minimumCost;
    }



}
