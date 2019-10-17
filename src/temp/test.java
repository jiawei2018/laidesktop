package temp;

import java.util.*;

public class test {

    public static void main(String[] args) {
        // test t = new test();
        // System.out.println(t.findprime(10000000));
        //999983
        //99991
        //9973
        //997
        //9999991
//        char ct = 'u';
//        int j = ct;
//        StringBuilder sb = new StringBuilder();
//        sb.charAt(0);
//        TreeMap<Integer, Integer> aa = new TreeMap<>();
//        aa.putIfAbsent(1, 2);
//        Map<Integer, Integer> map = new HashMap<>();
//        for (Integer key : map.keySet()) {
//
//        }
        long s = 1l;
        int b = 0;

        String tt = "qwerasdf";
        System.out.println(tt.substring(0,4));
        System.out.println(tt.substring(4,8));

        String s1 = "0000100";
        String s2 = "00001";
        //System.out.println(strCom(s1, s2));

    }

    public static int strCom(String s1, String s2) {
        //1 deal with leading 0
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (i < s1.length()) {
            if (sb1.length() != 0  || s1.charAt(i) != '0') {
                sb1.append(s1.charAt(i));
            }
            i++;
        }
        i = 0;
        while (i < s2.length()) {
            if (sb2.length() != 0 || s2.charAt(i) != '0') {
                sb2.append(s2.charAt(i));
            }
            i++;
        }

        if (sb1.length() > sb2.length()) {
            return 1;
        } else if (sb1.length() < sb2.length()) {
            return -1;
        }

        int len1 = 0;
        int len2 = 0;
        while (len1 < sb1.length() || len2 < sb2.length()) {//same length
            int a = 0;
            int b = 0;
            if (len1 < sb1.length()) {
                a = sb1.charAt(len1++);
            }

            if (len2 < sb2.length()) {
                b = sb2.charAt(len2++);
            }

            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }

        }

        return 0;
    }


    private List<Integer> findprime(int from) {
        //int res = 0;
        List<Integer> res = new ArrayList<>();

        for (int i = from; i >= 2; i--) {
            int sq = (int) Math.sqrt(i);
            for (int j = 2; j <= sq; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == sq) {
                    res.add(i);
                    return res;
                }
            }
        }
        return res;
    }


    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int n = matrix.length, m = matrix[0].length;
        int[] res = new int[n * m];
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idxSum = i + j;
                List tmp = map.putIfAbsent(idxSum, new ArrayList());
                List cur = tmp == null ? map.get(idxSum) : tmp;
                if (idxSum % 2 == 0) {
                    cur.add(0, matrix[i][j]);
                } else
                    cur.add(matrix[i][j]);
            }
        }
        int i = 0;
        for (int idxSum : map.keySet()) {
            List<Integer> list = map.get(idxSum);
            for (int num : list) {
                res[i++] = num;
            }
        }
        return res;
    }

    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int slices = m + n - 1;
        int[] ret = new int[m * n];
        int index = 0;
        for (int slice = 0; slice < slices; slice++) {
            int row = slice < m ? 0 : slice - m + 1;
            int col = slice < n ? 0 : slice - n + 1;
            if (slice % 2 == 0) {
                for (int j = slice - row; j >= col; j--) {
                    ret[index++] = matrix[j][slice - j];
                }
            } else {
                for (int j = col; j <= slice - row; j++) {
                    ret[index++] = matrix[j][slice - j];
                }
            }
        }
        return ret;
    }

    public int[] twoSum(int[] numbers, int target) {
        int i1 = 0, i2 = numbers.length - 1;
        for (int sum = numbers[i1] + numbers[i2]; sum != target; sum = numbers[i1] + numbers[i2]) {
            if (sum < target) {
                i1++;
            } else
                i2--;
        }

        return new int[]{i1 + 1, i2 + 1};
    }

}
