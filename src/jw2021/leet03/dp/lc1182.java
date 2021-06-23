package jw2021.leet03.dp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class lc1182 {
    public static void main(String[] args) {
        String a = "F:\\temp\\aaa.txt";
        String b = "F:\\temp\\qqq.txt";

        String fa = "";
        try (BufferedReader br = new BufferedReader(new FileReader(a))) {
            while (br.ready()) {
                fa = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        String fb = "";
        try (BufferedReader br = new BufferedReader(new FileReader(b))) {
            while (br.ready()) {
                fb = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        int[] arra = geta(fa);

        int[][] arrq = getb(fb);


        BufferedReader br1 = null;

        try {
            br1 = new BufferedReader(new FileReader(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //BufferedReader br = new BufferedReader(new FileReader(filename), size);


        ArrayList<String> result = new ArrayList<>();


        List<Integer> right = shortestDistanceColor(arra, arrq);

        List<Integer> wrong = shortestDistanceColor_bug(arra, arrq);
        for (int i = 0; i < right.size(); i++) {
            if (right.get(i) != wrong.get(i)) {
                System.out.println(right.get(i) + "  <> " + wrong.get(i));
                System.out.println(i + "  " + arra[i] + "  " + Arrays.toString(arrq[i]));
            }
        }
    }


    private static int[] geta(String a) {
        String[] str = a.split(",");
        int[] res = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            res[i] = Integer.parseInt(str[i]);
        }
        return res;
    }

    private static int[][] getb(String b) {
        //{1,2},{3,4},{5,6}
        List<int[]> list = new ArrayList<>();
        String l = "{";
        String r = "}";
        int idxl = 0;
        int idxr = 0;

        while (idxl != -1 && idxr != -1) {
            idxl = b.indexOf(l, idxl);
            idxr = b.indexOf(r, idxr);
            if (idxl == -1 && idxr == -1) {
                break;
            }
            String[] cur = b.substring(idxl + 1, idxr).split(",");
            list.add(new int[]{Integer.parseInt(cur[0]), Integer.parseInt(cur[1])});
            idxl++;
            idxr++;
        }


        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        final int max = 50_001;
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], max);
        dp[0][colors[0] - 1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][colors[i] - 1] = 0;
            for (int j = 0; j < 3; j++) dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (i == 2580 || i == 3543) {
                    System.out.println(dp[i + 1][j] + 1 + " correct  " + dp[i][j]);
                }
                dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j]);
            }
        }
        int m = queries.length;
        List<Integer> res = new ArrayList(m);
        for (int i = 0; i < m; i++) {
            int idx = queries[i][0], col = queries[i][1];

            if (dp[idx][col - 1] >= max) res.add(-1);
            else res.add(dp[idx][col - 1]);
        }
        return res;
    }

    public static List<Integer> shortestDistanceColor_bug(int[] colors, int[][] queries) {
        //dp
        // status
        int len = colors.length;
        int[][] left = new int[len][4];
        int[][] right = new int[len][4];

        int MILLION = 1000000;
        left[0][1] = colors[0] == 1 ? 0 : MILLION;
        left[0][2] = colors[0] == 2 ? 0 : MILLION;
        left[0][3] = colors[0] == 3 ? 0 : MILLION;
        for (int i = 1; i < len; i++) {
            //corrent color
            int c = colors[i];
            for (int j = 1; j <= 3; j++) {
                if (j == c) {
                    left[i][j] = 0;
                } else
                    left[i][j] = left[i - 1][j] + 1;
            }
        }


        right[len - 1][1] = colors[len - 1] == 1 ? 0 : MILLION;
        right[len - 1][2] = colors[len - 1] == 2 ? 0 : MILLION;
        right[len - 1][3] = colors[len - 1] == 3 ? 0 : MILLION;
        for (int i = len - 2; i >= 0; i--) {
            //corrent color
            int c = colors[i];
            for (int j = 1; j <= 3; j++) {
                if (j == c) {
                    right[i][j] = 0;
                } else
                    right[i][j] = right[i + 1][j] + 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int min = Math.min(left[q[0]][q[1]], right[q[0]][q[1]]);
            if (q[0] == 4994) {
                System.out.println(left[q[0]][q[1]] + "  kl " + right[q[0]][q[1]]);
            }
            res.add(min > len ? -1 : min);
        }
        return res;
    }
}
