package debug;

public class mock720 {

    public static void main(String[] args) {
        int[] n = {1,2,3,4,5};
        mock720 t = new mock720();
        t.shorestSubArray(5, n);
    }

    public int[] shorestSubArray(int k, int[] nums) {
        //assume return start idx, end idx
        int[] res = new int[2];

        //prefix sum + two pointers
        // assumptions : 1 must have at least 1 valid answer
        int slow = 0;
        int fast = 0;
        int sum = 0;

        int[] ps = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            ps[i] = ps[i - 1] + nums[i];
        }

        while(fast <= nums.length) {
            while(fast < nums.length && sum <= k) {
                sum += nums[fast++];
            }


        }
        return res;
    }


    private int[] getele(int[] nums, int start, int end) {
        return null;
    }
}
