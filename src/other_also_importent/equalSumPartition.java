package other_also_importent;

public class equalSumPartition {
    /**
     *
     Equal Sum Partitions
     Description
     An equal sum partition of a sequence of numbers is a grouping of the numbers
     (in the same order as the original sequence)
     in such a way that each group has the same sum. For example, the sequence:
     2 5 1 3 3 7
     may be grouped as:
     (2 5) (1 3 3) (7)
     to yield an equal sum of 7.

     Note: The partition that puts all the numbers in a single group is
     an equal sum partition with the sum equal to the sum of all the numbers in the sequence.
     For this problem, you will write a program that takes as
     input a sequence of positive integers and returns the smallest sum for an equal sum partition of the sequence.
     Input: A decimal integer N (1 ≤ N ≤ 10000),
     giving the total number of integers in the array, and the array X of positive decimal integers.


     * @param N
     * @param X
     * @return
     */
    public int getMinEqualSumPartition(int N, int[] X) {
        int[] nums = X;
        if(nums == null || nums.length < 1){
            return 0;
        }
        int cursum = 0;
        for(int i = 0; i < nums.length; i++){
            cursum += nums[i];
            if(isPart(cursum, nums, i + 1)){
                return cursum;
            }
        }
        return -1;
    }

    private boolean isPart(int sum, int[] nums, int nexStartPos){
        // 2 1 1 1 2 2  3 4 5 4 5 6 6 7 8 7
        int len = nums.length;
        int i = nexStartPos;
        int cursum = 0;
        while(i < len){
            cursum += nums[i++];
            if(cursum == sum){
                cursum = 0;
            }
        }
        return cursum == 0;
    }




}
