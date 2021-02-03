package new2020;

import java.util.*;

public class k_subsum {
    public static void main(String[] args) {
        int[][] aaa = {{1,1,1},{1,1,1}};
        System.out.println(aaa[0].length);

        k_subsum t = new k_subsum();
        int[] nums = {129,17,74,57,1421,99,77, 77, 77,92,285,1276,218,1588,215,369,117,153,22,129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22,129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22};
        int k = 3;
        //System.out.println(t.canPartitionKSubsets(nums, k) + "  " + count );

    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : nums){
            max = Math.max(max, i);
            sum += i;
        }
        int target = sum / k;
        if( sum % k != 0) {
            return false;
        }
        List<List<Integer>> res = new ArrayList<>();

        res.add(Arrays.asList(1,2));



        char[] visited = new char[nums.length];
        Arrays.fill(visited, 'f');
        memo = new HashSet<>();
        return recur(nums, k, target, visited, 0);
    }

    Set<String> memo;
    static int count = 0;
    private boolean recur(int[] nums, int k, int target, char[] visited, int sum){
        // k == 0 && all visisted -> instead of boolean we also can use hashSet ;
        String cur = String.valueOf(visited);
        if(memo.contains(cur)){
            count++;
            return false;
        }
        //we can meme whole visited as memo to false set or hashmap
        if(k == 0) {
            return true;
        }
        if(sum == target) {
            return recur(nums, k -1, target, visited, 0);
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 't' || sum + nums[i] > target) {
                continue;
            }
            visited[i] = 't';
            if(recur(nums, k, target, visited, sum + nums[i])) {
                return true;
            }
            visited[i] = 'f';
        }
        memo.add(cur);

        return false;
    }
}
