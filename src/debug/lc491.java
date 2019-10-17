package debug;

import java.util.*;

public class lc491 {
    public static void main(String[] args) {
        lc491 tt = new lc491();
        int[] t1 = {-8,28,68,-54,96,97,84,-32,8,-87,1,-7,-20,12,22};

        List<List<Integer>> res =  tt.findSubsequences(t1);

    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 2) {
            return res;
        }
        Arrays.sort(nums);
        recur(nums, res, new ArrayList<>(), 0, Integer.MIN_VALUE);
        System.out.println(res.size());
        return res;
    }

    private void recur(int[] nums, List<List<Integer>> res, List<Integer> tmp, int idx, int prev) {

        if(tmp.size() >= 2) {
            res.add(new ArrayList<>(tmp));
        }

        //Set<Integer> set = new HashSet<>();
        int used = prev;
        for(int i = idx; i < nums.length; i++) {
             //if(!set.contains(nums[i]) && nums[i] >= prev) {
            while (i > 0 && i < nums.length && nums[i] == used) {
                i++;
            }
            if(nums[i] >= prev) {
                tmp.add(nums[i]);
                //set.add(nums[i]);
                recur(nums, res, tmp, i + 1, nums[i]);
                tmp.remove(tmp.size() - 1);
                //i--;
                used = nums[i];
            }
        }

    }
}
