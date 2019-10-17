package slidingWindows;

public class maxAvgSubarray {
    public static void main(String[] args) {
        int[] t = new int[]{-6, -7,-8};
        System.out.println(findMaxAverage(t, 2));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double res = Integer.MIN_VALUE;
        int size = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(size >= k){
                //1 2 3 4 5   k = 2
                //  i i
                sum -= nums[i - k];
            }
            sum += nums[i];
            size++;
            if(size > k){
                res = Math.max(res, sum );
            } else {
                res = sum;
            }

        }

        return res/ (double)k;
    }
}
