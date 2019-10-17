package CTIV;

import java.util.*;

/**
 * 2 Sum
 * Description
 * Determine if there exist two elements in a given array, the sum of which is the given target number.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 2
 * ​Examples
 *
 * A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
 *
 * A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
 *
 * A = {2, 4, 1}, target = 4, return false
 */
public class twosum {
    public boolean existSum(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length < 1){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //map.get keys
        List<Integer> l = new ArrayList<>();
        //l.clear();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            if(set.contains(array[i])){
                return true;
            }else{
                set.add(target - array[i]);
            }
        }
        return false;
    }
}
