package mem_algo;

import java.util.*;

public class ttttets {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Set<Integer> set = new HashSet<>();
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> p : pairs){
            uf.union(p.get(0), p.get(1));
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < uf.roots.length; i++){
            if(uf.roots[i] == i){
                map.put(i, new ArrayList<>());
            }
        }
        for(int i = 0; i < uf.roots.length; i++){
            if(uf.roots[i] != i){
                map.get(uf.find(i)).add(s.charAt(i));
            }
        }

        for(int i : map.keySet()){
            Collections.sort(map.get(i));
        }

        char[] res = new char[s.length()];
        //first deal with fix postion chars
        for(int i = 0; i < res.length; i++){
            if(uf.roots[i] == i){//first deal with fix postion chars
                res[i] = s.charAt(i);
            } else { // now del with sorted group?
                int curroot = uf.find(i);
                res[i] = map.get(curroot).get(0);
                map.get(curroot).remove(0);
            }
        }

        return String.valueOf(res);
    }

    class UnionFind{
        public int[] roots;
        //List<List<Integer>> groups;

        public UnionFind(int n){
            roots = new int[n];
            //groups = new ArrayList<>();
            for(int i = 0; i < n; i++){
                roots[i] = i;
            }
        }

        public int find(int a){
            if(roots[a] != a){
                roots[a] = find(roots[a]);
            }

            return roots[a];
        }

        public void union(int a, int b){
            int roota = find(a);
            int rootb = find(b);
            if(roota != rootb){
                roots[roota] = rootb;
            }
        }
    }

    class Pair{
        int idx;
        char c;
        public Pair(int i, char c){
            idx = i;
            this.c = c;
        }
    }
}
