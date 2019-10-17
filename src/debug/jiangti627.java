package debug;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class jiangti627 {

    /*
    -2 -3 3
    -5 -10 1
    10 30 -5
     */


    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i], 1);
        }


        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(down, right);
            }
        }

        Queue<cood> heap = new PriorityQueue<>(new Comparator<cood>() {
            @Override
            public int compare(cood o1, cood o2) {

                return o1.u.compareTo(o2.u);
            }
        });
        return dp[0][0];


    }


    private void test (cood[] kkk) {

        Arrays.sort(kkk, (o1, o2) -> {
            if(o1.x != o2.x) {
                return o1.x - o2.x;
            } else if(o1.y != o2.y) {
                return o1.y - o2.y;
            } else
                return o1.u.compareTo(o2.u);
        });

//        Arrays.sort(kkk, new Comparator<>() {
//            @Override
//            public int compare(cood o1, cood o2) {
//                if(o1.x != o2.x) {
//                    return o1.x - o2.x;
//                } else if(o1.y != o2.y) {
//                    return o1.y - o2.y;
//                } else
//                    return o1.u.compareTo(o2.u);
//            }
//        });
    }


    class cood {
        int x, y;
        String u;


    }
}
