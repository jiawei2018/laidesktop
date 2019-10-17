package temp;

import java.util.ArrayList;
import java.util.List;

public class halfSumSubsetss {
    public List<Integer>  halfs(int[] nums){
        if (nums == null || nums.length < 1){
            return new ArrayList<>();
        }
        int sum = getSum(nums);
        int half = sum % 2 == 0 ? sum / 2: sum - sum / 2;

        //recur();

        return null;
    }

    private void recur(int[] nums, int idx, int target, List<Integer> res, int cursum){



    }

    private int getSum(int[] nums){
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res += nums[i];
        }
        return res;
    }


}
