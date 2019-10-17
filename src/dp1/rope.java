package dp1;

public class rope {
    public static  int maxProduct(int length) {
        // Write your solution here
        int[] dp = new int[length + 1];

        dp[0] = 0;//rope is 0meter
        dp[1] = 0;//rope is 1 meter
        dp[2] = 1;

        for(int i = 3; i <= length; i++){
            for(int j = 1; j <= i / 2; j++){
                dp[i] = Math.max(
                        dp[i],
                        Math.max(j, dp[j] ) * Math.max(i - j, dp[i - j])
                         );

            }
        }

        return dp[length];

    }

    public static void main(String[] args) {
        System.out.println(maxProduct(25));
    }
}
