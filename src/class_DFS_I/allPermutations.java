package class_DFS_I;

import java.util.ArrayList;
import java.util.List;

/**
 * All Permutations I
 * Description
 * Given a string with no duplicate characters,
 * return a list with all permutations of the characters.
 *
 * Examples
 *
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 */
public class allPermutations {
    public List<String> permutations(String set) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if(set == null || set.length() == 0){
            return res;
        }
        recur(set.toCharArray(), 0, res);
        return res;
    }

    private void recur(char[] set, int idx,List<String> res){//from  tang lao si
        if(idx == set.length - 1){
            res.add(String.valueOf(set));
            return;
        }
            // abc -> bac -> cba; level++ then
        for(int i = idx; i < set.length; i++){
            swap(set, idx, i);
            recur(set, idx + 1, res);
            swap(set, idx, i);
        }

    }

    private void swap(char[] carr, int idxa , int idxb){
        char c = carr[idxa];
        carr[idxa] = carr[idxb];
        carr[idxb] = c;
    }

}
