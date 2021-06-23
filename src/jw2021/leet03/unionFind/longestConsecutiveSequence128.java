package jw2021.leet03.unionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestConsecutiveSequence128 {

    public static void main(String[] args) {
        int[] t1 = {100,4,200,3,1,2};


        longestConsecutiveSequence128 tt = new longestConsecutiveSequence128();

        tt.longestConsecutive(t1);
    }


    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        //value , index map
        Map<Integer, Integer> map = new HashMap<>();
        UF uf = new UF(nums.length);

        for(int i= 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }

            if(map.containsKey(nums[i] - 1)) {
                int idx = map.get(nums[i] - 1);
                uf.union(idx, i);
            }

            if(map.containsKey(nums[i] + 1)) {
                int idx = map.get(nums[i] + 1);
                uf.union(idx, i);
            }
        }

        return uf.max;
    }

    class UF{
        int[] roots;
        int[] sizes;
        int max;

        public UF(int size){
            roots = new int[size];// all 0
            sizes = new int[size];
            Arrays.fill(sizes, 1);
            //System.out.print(Arrays.toString(sizes));
            max = 1;
        }

        public int find(int a) {
            //a is a index
            if(roots[a] != 0){
                roots[a] = find(roots[a]);
            }
            return roots[a];
        }

        public void union(int a, int b){
            int ra = find(a);
            int rb = find(b);
            if(ra != rb) {
                //update max and sizes, and union both;
                roots[ra] = rb;
                sizes[rb] += sizes[ra];
                max = Math.max(max, sizes[rb]);
            }
        }
    }
}
