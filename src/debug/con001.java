package debug;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class con001 {
    public static void main(String[] args) {
        int [] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        int[] arr1 = {1,1,1,1,1};
        System.out.println(uniqueOccurrences(arr1));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        if(arr == null || arr.length == 0){
            return true;
        }

        HashSet<?>[] sets = new HashSet<?>[arr.length];
        //[0].add(12);

        Map<Integer, Integer> map = new HashMap<>();
        for(int cur : arr){
            System.out.println(cur + " <<  " + map.get(cur)  );
//            if(!map.containsKey(cur)){
//                map.put(cur, 0);
//            }
//            map.put(cur, map.get(cur) +1);
            System.out.println(map.getOrDefault(cur, 77) + "   ????");
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        System.out.println(map);
        Set<Integer> set = new HashSet<>();
        for(int k : map.keySet()){
            if(!set.add(map.get(k))){
                return false;
            }
        }
        return true;
    }
}
