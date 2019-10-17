package debug;

import myHelperUtil.MyPrintHelper;

import java.util.Arrays;

public class jiangti620 {

    public static void main(String[] args) {
        int[] n = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
        System.out.println(n.length + " <<");
        jiangti620 t = new jiangti620();
        //t.canPartition(n);
        int[] n1 = {1, 2, 5};
        t.canPartition1(n1);

    }

//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int i : nums) {
//            sum += i;
//        }
//        if (sum % 2 != 0) {
//            return false;
//        }
//        int half = sum / 2;
//        return recur(nums, half, 0, 0);
//    }
//
//    private boolean recur1(int[] nums, int target, int sum, int idx) {
//        if (target < 0 || idx == nums.length) {
//            return false;
//        }
//        if (target < nums[idx]) {
//            return false;
//        }
//        if (sum == target) {
//            return true;
//        }
//        return recur1(nums, target, sum + nums[idx], idx + 1) || recur(nums, target, sum, idx + 1);
//    }


    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= half; j++) {
                System.out.println(j + "   " + nums[i]);
                MyPrintHelper.printArray(dp);
                dp[j] = dp[j - nums[i]] || dp[j];
            }

//            for (int j = half; j >= nums[i]; j--) {
//                  System.out.println(j + "   "+ nums[i]);
//                MyPrintHelper.printArray(dp);
//                dp[j] = dp[j - nums[i]] || dp[j];
//            }
        }
        return dp[half];
    }


//    public boolean canPartition3(int[] nums) {
//        int sum = 0;
//        for (int i : nums) {
//            sum += i;
//        }
//        if (sum % 2 != 0) {
//            return false;
//        }
//        int half = sum / 2;
//        Arrays.sort(nums);
//        return recur(nums, half, 0, 0);
//    }

//    private boolean recur(int[] nums, int target, int sum, int idx) {
//        //System.out.println(sum + "  " + idx);
//        if (sum > target || idx == nums.length || target < nums[idx]) {
//            return false;
//        }
//        if (sum == target) {
//            return true;
//        }
//        if (recur(nums, target, sum + nums[idx], idx + 1)) {
//            return true;
//        }
//        int nextidx = idx + 1;
//        while (nextidx < nums.length && nums[nextidx] == nums[idx]) {
//            nextidx++;
//        }
//        return recur(nums, target, sum, nextidx);
//    }
//
//
//    public boolean canPartition2(int[] nums) {//not work
//        int sum = 0;
//        for (int i : nums) {
//            sum += i;
//        }
//        if (sum % 2 != 0) {
//            return false;
//        }
//        int half = sum / 2;
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length; i++) {
//            int tmp = 0;
//            for (int j = i; j < nums.length; j++) {
//                if (tmp + nums[j] == half) {
//                    return true;
//                } else if (tmp + nums[j] < half) {
//                    tmp += nums[j];
//                }
//            }
//        }
//        return false;
//    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][half + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int j = 0; j < half + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < half + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][half];
    }




    // o(n^2) and o(1)
    public int longestSubtring(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            max = Math.max(max, fromMid(s, i));
        }
        return max;
    }

    private int fromMid(String s, int i) {
        int j = i + 1;
        int left = 0, right = 0;
        int max = 0;
        while (i >= 0 && j < s.length()) {
            left += s.charAt(i) - '0';
            right += s.charAt(j) - '0';
            if (left == right) {
                max = Math.max(max, j - i + 1);
            }
            i--;
            j++;
        }
        return max;
    }


    public int targetSum(int[] nums1, int[] nums2, int target) {
        //corner case

        int left1 = 0;
        int right2 = nums2.length;
        int res = nums1[left1] + nums2[right2];
        while (left1 < nums1.length && right2 >= 0) {
            int curSum = nums1[left1];
            if (curSum == target) {
                return target;
            } else if (Math.abs(target - curSum) <= Math.abs(target - res)) {
                res = curSum;
            }
            if (curSum > target) {
                right2--;
            } else {
                left1++;
            }
        }
        return res;
    }
}
