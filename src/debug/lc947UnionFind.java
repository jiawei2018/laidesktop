package debug;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc947UnionFind {
    public static void main(String[] args) {
        lc947UnionFind t = new lc947UnionFind();
        int[][] arr = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};

        t.removeStones(arr);
    }
    public int removeStones(int[][] stones) {
        //how to solve? union find?
        // stone idx indicates a stone.
        int len = stones.length;
        int[] parent = new int[len];
        Arrays.fill(parent, -1);
        Map<Integer, Integer> xmap = new HashMap<>();
        Map<Integer, Integer> ymap = new HashMap<>();
        for(int i = 0; i < len; i++) {
            int[] stone = stones[i];
            int x = stone[0];
            if(!xmap.containsKey(x)){
                xmap.put(x, i);
            } else {
                parent[x] = xmap.get(x);
            }
            int y = stone[1];
            if(!ymap.containsKey(y)){
                ymap.put(y, i);
            } else {
                parent[y] = ymap.get(y);
            }

            union(x, y, xmap, ymap, parent);
        }
        int count = 0;
        for(int i : parent){
            if(i == -1) count++;
        }
        return len - count;
    }

    private int find(int z, int[] parent) {
        //to find the root stone's idx;
        if(parent[z] == -1) {
            return z;
        }
        // System.out.println(parent[z]+"  "+ z);
        parent[z] = find(parent[z], parent);

        return parent[z];
    }

    private void union(int x, int y, Map<Integer, Integer> xmap, Map<Integer, Integer> ymap, int[] parent){
        int rootx = find(xmap.get(x), parent);
        int rooty = find(ymap.get(y), parent);
        if(rootx != rooty){
            ymap.put(ymap.get(y), rootx);
        }
    }
}
