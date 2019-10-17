package mem_algo;

import myHelperUtil.MyPrintHelper;

public class IntToBinary {
    public static void intToBinary(int num) {
        for(int i = 31; i >= 0; i--) {
            int cur = num >> i & 1;
            System.out.print(cur);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //intToBinary(25);
        System.out.println(numOfCube(4));

        int[][] aa = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(findNumSquare(aa));
    }


    private static int numOfCube(int edgeLength) {
        // calculate how many cubes can form by a n length edge cubes;
        // n^2 + (n - 1)^2 + ... + 1^2;  n = edge length;
        int sum = 0;
        while(edgeLength > 0) {
            sum += edgeLength * edgeLength;
            edgeLength--;
        }
        return sum;
    }




    public static int findNumSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int numSquare = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i ==0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                    numSquare += dp[i][j];
                    continue;
                }
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    dp[i][j]++;
                    numSquare += dp[i][j];
                }
            }
        }
        MyPrintHelper.printArray(dp);
        return numSquare;
    }

}
