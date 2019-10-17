package backtracking;

import java.util.*;

/**
 WJ
 Combination Sum
 Description
 Given a collection of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums toT.
 The same repeated number may be chosen from C unlimited number of times.

 All numbers (including target) will be positive integers.

 Elements in a combination (a1, a2, … , ak) must be in non-descending order.

 The solution set must not contain duplicate combinations.

 Example

 given candidate set 2,3,6,7 and target 7,

 A solution set is:

 [7]

 [2, 2, 3]
 */
public class alllcombination {
    public static void main(String[] args) {
        alllcombination t = new alllcombination();
        int[] a = {2,3,6,7};
        System.out.println(t.combinationSum(a, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(candidates == null || candidates.length < 1){
            return res;
        }
        recur(res, temp, candidates, target, 0);
        return res;
    }

    private void recur(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int idx){
        if(0 == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i < candidates.length; i++){
            if(0 > target){
                return;
            }
            temp.add(candidates[i]);
            recur(res, temp, candidates, target - candidates[i], i);//
            //此处去重的方法是很重要的,具体就是走过了就绝对不回头看!
            temp.remove(temp.size() - 1);
        }
    }
}
