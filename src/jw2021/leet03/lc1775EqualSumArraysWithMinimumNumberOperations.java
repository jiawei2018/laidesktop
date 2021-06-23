package jw2021.leet03;

import java.util.Arrays;

public class lc1775EqualSumArraysWithMinimumNumberOperations {


    public static void main(String[] args) {
        lc1775EqualSumArraysWithMinimumNumberOperations tt = new lc1775EqualSumArraysWithMinimumNumberOperations();

        int[] n1 = {6,6};
        int[] n2 = {1};

        System.out.println(tt.minOperations(n1, n2));
    }




    public int minOperations(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1 = getSum(nums1);
        int sum2 = getSum(nums2);
        Pair p1 = getRange(nums1);
        Pair p2 = getRange(nums2);

        if(sum1 == sum2) return 0;
        //chk if it is possible
        boolean flag = false;
        if(sum1 > sum2){

            if (p1.min > p2.max) return -1;
        } else {
            flag = true;
            if(p1.max < p2.min) return -1;
        }

        int start  = Math.max(p1.min, p2.min);
        int end = Math.min(p1.max, p2.max);

        int target = start + (end -start) /2;

        if(flag) {
            return getOp(nums1, nums2, target, sum1, sum2);
        } else
            return getOp(nums2, nums1, target, sum2, sum1);
    }


    private int getOp(int[] nums1, int[] nums2, int target, int sum1, int sum2) {
        //here always nums is smaller one;
        int res = 0;
        System.out.println(sum1);
        for(int i = 0; i< nums1.length; i++) {
            if(sum1 < target ) {
                sum1 += 6 - nums1[i];
                res++;
            }
        }
        //System.out.println(sum1 +" << " + res + "  " + target );
        //now for sum2 the target will be sum1
        int s2 = sum2;
        for(int i = nums2.length - 1; i >= 0; i--){
            if(s2 > sum1){
                //System.out.println(sum2 +" << " + res);
                s2 = s2 - (nums2[i] - 1) ;
                //System.out.println(sum2 +" << " + res);
                res++;
                System.out.println(s2 +" <<su2 " + res);
            }
        }
        System.out.println(s2 +" <<sm2 " + res);

        return res;
    }




//     private boolean isValid(int[] nums1, int[] nums2) {

//         return true;
//     }

    private Pair getRange(int[] nums) {
        return new Pair(nums.length, nums.length * 6);
    }

    private int getSum(int[] nums) {
        int res = 0;
        for(int i : nums) {
            res += i;
        }
        return res;
    }

    class Pair {
        int min;
        int max;
        Pair(int ss, int bb){
            min = ss;
            max = bb;
        }
    }
}
