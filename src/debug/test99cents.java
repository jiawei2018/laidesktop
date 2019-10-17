package debug;

public class test99cents {
    public static void main(String[] args) {
        test99cents t = new test99cents();
        int[] arr = {470,18,66,301,403,112,360};
        int value = 8235;
        t.coinChange(arr, value);
    }

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int[] min = {Integer.MAX_VALUE};
        recur(amount, 0, coins, min, 0);
        System.out.println(count);
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }
    int count = 0;
    private void recur(int value, int level, int[] coins, int[] min, int boxs) {
        count++;
        if(value < 0 ) {
            return;
        }
        if(level == coins.length) {
            if(value == 0) {
                min[0] = Math.min(min[0], boxs);
            }
            return;
        }
        int val = value / coins[level];
        for(int i = 0; i <= val; i++) {
            int remain = value - i * coins[level];
            recur(remain, level + 1, coins, min, boxs + i);
        }
    }
}
