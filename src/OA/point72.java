package OA;

public class point72 {
    public static void main(String[] args) {
        point72 p = new point72();
        //p.getall();

        int[] arr1 = {-2,1,3,-4,5};
        System.out.println(maxSubsetSum(arr1));
    }

    static int maxSubsetSum(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            dp[i] = Math.max(Math.max(dp[i - 2] + arr[i], dp[i- 1]), arr[i]);
        }
        return dp[arr.length - 1];
    }

    private void getall(){
        for(int i = 1; i < 30; i++){
            for(int j = 1; j < 30; j++){
                int cur = 2*i+4*j;
                if(cur == 20){
                    System.out.println("i: "+i+"  j:"+j+"  res:"+cur);
                }

            }
        }
    }
}
