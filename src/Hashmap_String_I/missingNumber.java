package Hashmap_String_I;

import java.util.*;

/**
 * Description
 * Given an integer array of size N - 1,
 * containing all the numbers from 1 to N except one, find the missing number.
 *
 * Assumptions
 *
 * The given array is not null, and N >= 1
 * Examples
 *
 * A = {2, 1, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 *
 */
public class missingNumber {
    public int missing(int[] array) {
        // Write your solution here
        int sum = (1 + array.length + 1) * (array.length + 1) / 2;
        int idx = array.length - 1;
        while(idx >= 0){
            sum -= array[idx--];
        }
        List<List<String>> res = new ArrayList<>();
        Collections.sort(res, (a, b)-> a.size());

        Map<Integer ,Integer> map = new HashMap<>();

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            e.getKey();
            e.getValue();

        }

        boolean v = true;

        return sum;
    }
//    private int sum(int n){
//
//         (n + 1) / 2;
//
//         return
//    }
}
