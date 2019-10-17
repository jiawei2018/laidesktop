package dp3;


/**
 * Description
 * Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.
 *
 * Return the arm length of the largest cross.
 *
 * Assumptions
 *
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
 * Examples
 *
 * { {0, 0, 0, 0},
 *
 *   {1, 1, 1, 1},
 *
 *   {0, 1, 1, 1},
 *
 *   {1, 0, 1, 1} }
 *
 * the largest cross of 1s has arm length 2.
 */
public class largestCross {
    public int largest(int[][] matrix) {
        // Write your solution here
        if(matrix == null) {
            return 0;
        }
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        if(n == 0){
            return 0;
        }
        int[][] left = left(matrix, m,n);
        int[][] right = right(matrix, m,n);
        int[][] top = top(matrix, m,n);
        int[][] bottom = bottom(matrix, m,n);

        int res = 0;



        for(int i = 0; i < m; i++){
            for(int j =0; j< n;j++){
                res = Math.max(res, min4(left[i][j],top[i][j], bottom[i][j], right[i][j]));

            }
        }

        return res;
    }





    private int[][] left(int[][] matrix, int m, int n ){//left to right
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++){
                if(matrix[i][j] == 1){
                   if( i == 0 && j == 0){
                       res[i][j] = 1;
                   }else if(j == 0){
                       res[i][j] = 1;
                   }else{
                       res[i][j] = res[i][j - 1] + 1;
                   }
                }
            }//inner for
        }//out for
        return res;
    }

    private int[][] top(int[][] matrix, int m, int n ){//top to bottom
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++){
                if(matrix[i][j] == 1){
                    if( i == 0 && j == 0){
                        res[i][j] = 1;
                    }else if(i == 0){
                        res[i][j] =  1;
                    }else{
                        res[i][j] = res[i - 1][j] + 1;
                    }
                }
            }//inner for
        }//out for
        return res;
    }

    private int[][] bottom(int[][] matrix, int m, int n ){//bottom to top
        int[][] res = new int[m][n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1;j >= 0; j--){
                if(matrix[i][j] == 1){
                    if( i == m - 1 && j == n - 1){
                        res[i][j] = 1;
                    }else if(i == m - 1){
                        res[i][j] = 1;
                    }else{
                        res[i][j] = res[i + 1][j] + 1;
                    }
                }
            }//inner for
        }//out for
        return res;
    }

    private int[][] right(int[][] matrix, int m, int n ){//right to left
        int[][] res = new int[m][n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1;j >= 0; j--){
                if(matrix[i][j] == 1){
                    if( i == m - 1 && j == n - 1){
                        res[i][j] = 1;
                    }else if(j == n - 1){
                        res[i][j] = 1;
                    }else{
                        res[i][j] = res[i][j + 1] + 1;
                    }
                }
            }//inner for
        }//out for
        return res;
    }

    private int min4(int a, int b, int c , int d){
        return Math.min(Math.min(a,b),Math.min(c,d));
    }

}
