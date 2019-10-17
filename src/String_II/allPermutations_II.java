package String_II;

import java.util.*;

/**
 *
 All Permutations II
 Description
 Given a string with possible duplicate characters, return a list with all permutations of the characters.

 Examples

 Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 Set = "aba", all permutations are ["aab", "aba", "baa"]
 Set = "", all permutations are [""]
 Set = null, all permutations are []
 */
public class allPermutations_II {

     public List<String> permutations(String set) {
            // Write your solution here
            List<String> res = new ArrayList<>();
            if(set == null || set.length() < 1){
                return res;
            }
            char[] carr = set.toCharArray();
            recur(carr, 0, res);
            return res;
        }
        private void recur(char[] carr, int idx, List<String> res){// this works
            //but think teacher mentioned the swap and sort method
            if(idx == carr.length){
                res.add(String.valueOf(carr));
                return;
            }
            Set<Character> set = new HashSet<>();

            for(int i = idx; i < carr.length; i++){
                if(set.add(carr[i])) {
                    swap(carr, idx, i);
                    recur(carr, idx + 1, res);
                    swap(carr, idx, i);
                }
            }
        }

        private void swap(char[] input, int idxa, int idxb){
            char temp = input[idxa];
            input[idxa] = input[idxb];
            input[idxb] = temp;
        }
}
