package dp2_important;

import java.util.Comparator;
import java.util.TreeSet;

public class PainterMinTime {

    //method from class
    public int MinTime(int[] nums, int painters) {
        //2D- dp problem
        int m = nums.length;
        int n = painters;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int p = 1; p < n + 1 && p <= i; p++) {
                //System.out.println(p);
                if (p == 1) {
                    dp[i][p] = dp[i - 1][p] + nums[i - 1];
                } else {
                    int curmin = Integer.MAX_VALUE;
                    int currcost = 0;
                    for (int k = i - 1; k >= p - 1; k--) {
                        currcost += nums[k];
                        int cost = Math.max(dp[k][p - 1], currcost);
                        curmin = Math.min(curmin, cost);
                    }
                    dp[i][p] = curmin;
                }
            }
        }

//        TreeSet<Pair> set = new TreeSet<>(new Comparator<Pair>(){
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return 0;
//            }
//        });

        MyPrintHelper.printArray(dp);
        System.out.println(dp[m][n]);
        return dp[m][n];
    }

    class Pair{
        int h, idx;
    }

    public static void main(String[] args) {
        PainterMinTime t = new PainterMinTime();
       int[] a = {1,1,2,1};
        t.MinTime(a,2);
    }



}
