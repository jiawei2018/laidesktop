package CTIV;

import java.util.*;

public class twosum_II {
    public static void main(String[] args) {
        int[] u = {3,9,1,2,3};
        allPairs(u, 4);


    }
    public static  List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        //no need to corner, assumption good enough
        // List<Integer> cur = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < array.length; i++){
            List<Integer> idxarr = map.get(target - array[i]);
            if(idxarr != null){
                for(int j : idxarr){
                    res.add(Arrays.asList(i, j));
                }
            }
            if(!map.containsKey(array[i])){
                map.put(array[i],new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }
}
