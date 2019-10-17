package graph;

import java.util.*;

public class allTopoPath {
    class Vertex {
        int val;
        List<Integer> neis;
        public Vertex (int val) {
            this.val = val;
            neis = new ArrayList<>();
        }
    }

    public List<List<Integer>> allPath(int[][] edges, int n) {//[[1,2][2,3]]
        Map<Integer, Integer> indegree = new HashMap<>();
        List<Vertex> graph = buildGraph(edges, n, indegree);
        List<List<Integer>> res = new ArrayList<>();
        for(int i : indegree.keySet()) {
            if(indegree.get(i) > 0) {
                continue;
            }
            recur(res, new ArrayList<>(), i, indegree, n ,graph);
        }


        return null;
    }

    private void recur(List<List<Integer>> res, List<Integer> temp, int idx, Map<Integer, Integer> indegree, int n, List<Vertex> graph){
        if(temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int nei : graph.get(idx).neis) {
            if(indegree.get(nei) == 0) {
                temp.add(nei);
                update(indegree, nei, graph);
                recur(res, temp, nei, indegree, n, graph);
                recover(indegree, nei, graph);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private void update(Map<Integer, Integer> indegree, int idx, List<Vertex> graph) {
        for(int nei : graph.get(idx).neis) {
            indegree.put(nei, indegree.get(nei) - 1);
        }
    }

    private void recover(Map<Integer, Integer> indegree, int idx,  List<Vertex> graph) {
        for(int nei : graph.get(idx).neis) {
            indegree.put(nei, indegree.get(nei) + 1);
        }
    }

    private List<Vertex> buildGraph(int[][] edges, int n, Map<Integer, Integer> indegree) {//n node
        List<Vertex> res = new ArrayList<>();
        for(int i  = 0; i < n; i++) {
            res.add(new Vertex(i));
            indegree.put(i, 0);
        }
        for(int[] edge : edges) {
            int start =  edge[0];
            int end = edge[1];
            res.get(start).neis.add(end);
            if(!indegree.containsKey(end)) {
                indegree.put(end, 0);
            }
            indegree.put(end, indegree.get(end) + 1);
        }
        return res;
    }



}
