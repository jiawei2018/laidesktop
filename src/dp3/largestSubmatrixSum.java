package dp3;

/***

 Largest SubMatrix Sum
 Description
 Given a matrix that contains integers, find the submatrix with the largest sum.

 Return the sum of the submatrix.

 Assumptions

 The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
 Examples

 { {1, -2, -1, 4},

 {1, -1,  1, 1},

 {0, -1, -1, 1},

 {0,  0,  1, 1} }

 the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
 */
public class largestSubmatrixSum {
    public int largest(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;//m row;
        int n = matrix[0].length;//n cols
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] compress = new int[n];
            for (int j = i; j < m; j++) {
                flatten(compress, matrix[j]);
                res = Math.max(res, curmax(compress));
            }
        }
        return res;
    }

    private void flatten(int[] compress, int[] source) {
        for (int i = 0; i < compress.length; i++) {
            compress[i] += source[i];
        }
    }

    private int curmax(int[] curr) {//dp here
        int res = curr[0];
        int tmp = curr[0];
        for (int i = 1; i < curr.length; i++) {//here start at 1!!!!!!!!!!!!!!
            tmp = Math.max(tmp + curr[i], curr[i]);
            res = Math.max(tmp, res);
        }
        return res;
    }

    public static void main(String[] args) {
        largestSubmatrixSum t = new largestSubmatrixSum();
        int[][] s ={{1,-1},{1,1}} ;
        t.largest(s);
        System.out.println(t.largest(s) + "   <<");
    }
}
