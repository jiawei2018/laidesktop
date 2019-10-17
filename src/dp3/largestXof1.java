package dp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestXof1 {
    public int lagest(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] topleft = topleft(matrix, m, n);
        showme(topleft);
        int[][] topright = topright(matrix, m, n);
        showme(topright);
        int[][] bottomleft = leftbottom(matrix, m, n);
        showme(bottomleft);
        int[][] bottomright = rightbottom(matrix, m, n);
        showme(bottomright);

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, min4(topleft[i][j], topright[i][j], bottomright[i][j], bottomleft[i][j]));
            }
        }
        return res;
    }

    private int[][] topleft(int[][] matrix, int m, int n) {//left to right
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    res[i][j] = getnum(res, i - 1, j - 1) + 1;//this is dp, reuse res[][]

                }
            }//inner for
        }//out for
        return res;
    }


    private int[][] topright(int[][] matrix, int m, int n) {//right to left
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    res[i][j] = getnum(res, i - 1, j + 1) + 1;//this is dp, reuse res[][]
                }
            }//inner for
        }//out for
        return res;
    }

    private int[][] leftbottom(int[][] matrix, int m, int n) {//top to bottom
        int[][] res = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    res[i][j] = getnum(res, i + 1, j - 1) + 1;
                }
            }//inner for
        }//out for
        return res;
    }

    private int[][] rightbottom(int[][] matrix, int m, int n) {//right-bottom coner
        int[][] res = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    res[i][j] = getnum(res, i + 1, j + 1) + 1;
                }
            }//inner for
        }//out for
        return res;
    }

    private int getnum(int[][] matrix, int x, int y) {
        if (x < 0 || x >  matrix[0].length - 1 || y < 0 || y >  matrix.length - 1) {
            return 0;
        }
        return matrix[x][y];
    }

    private int min4(int a, int b, int c, int d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

    private void showme(int[][] nums){
        StringBuilder sb = new StringBuilder();
        int m = nums.length;
        int n = nums[0].length;
        for(int i = 0; i< m ; i++ ){
            for(int j =0; j < n; j++){
                sb.append(nums[i][j]).append(".");
            }
            System.out.println(sb);
            System.out.println(" ");
            sb.delete(0,sb.length());
        }

        System.out.println("---------------");
    }

    public static void main(String[] args) {
        int[][] r = {{1, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 1, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 1}};
        int[][] p = {   {1,1,1,1,1},
                        {1,0,0,1,1},
                        {1,1,1,1,1},
                        {1,1,1,1,0},
                        {0,0,0,1,1}};
        int[][] s = {{1,1},{1,1}};
        largestXof1 t = new largestXof1();
        System.out.println(t.lagest(p));
    }

}
