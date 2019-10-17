package schoolOS;

import myHelperUtil.MyPrintHelper;

public class banker {
    public static void main(String[] args) {
        int n, m, i, j, k;
        n = 5;
        m = 4;
        int[][] alloc = {{0, 0, 1, 2}, {1, 0, 0, 0}, {1, 3, 5, 4}, {0, 6, 3, 2},
                {0, 0, 1, 4}};

        int[][] max = {{0, 0, 1, 2},
                {1, 7, 5, 0},
                {2, 3, 5, 6},
                {0, 6, 5, 2},
                {0, 6, 5, 6}};

        int[] avail = {1,5,2,0}; // Available Resources

        int[] f = new int[n];
        int[] ans = new int[n];
        int ind = 0;
        for (k = 0; k < n; k++) {
            f[k] = 0;
        }
        int[][] need = new int[5][4];
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++)
                need[i][j] = max[i][j] - alloc[i][j];
        }
        int y = 0;
        for (k = 0; k < 5; k++) {
            for (i = 0; i < n; i++) {
                if (f[i] == 0) {

                    int flag = 0;
                    for (j = 0; j < m; j++) {
                        if (need[i][j] > avail[j])
                            flag = 1;
                        break;
                    }

                    if (flag == 0) {
                        ans[ind++] = i;
                        for (y = 0; y < m; y++)
                            avail[y] += alloc[i][y];
                        f[i] = 1;
                    }
                }
            }
        }
        MyPrintHelper.printArray(ans);
        System.out.println("Following is the SAFE Sequence");
        for (i = 0; i < n - 1; i++)
            System.out.println(" P%d ->"+ ans[i]);
        System.out.println(" P%d"+ ans[n - 1]);


        // This code is contributed by Deep Baldha (CandyZack)
    }
}
