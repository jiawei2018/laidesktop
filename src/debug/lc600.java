package debug;

import myHelperUtil.MyPrintHelper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class lc600 {
    public static void main(String[] args) {
        lc600 t = new lc600();
       // System.out.println(t.intToStr(13));
        MyPrintHelper.printArray(t.buildFibo(31));
    }


    private int[] buildFibo(int num) {
        int[] res = new int[31];
        res[0] = 1;//
        res[1] = 2;
        for(int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
         Set<Integer> f = new HashSet<>();
        for(int i : f) {

        }
        return res;
    }




    private String intToStr(int num) {
        char[] res = new char[32];
        int j = 0;
        for(int i = 31; i >= 0; i--) {
            //System.out.println(1 << i);
            //System.out.println(num);
            //System.out.println(num & ( 1 << i));
            if((num & ( 1 << i)) > 0) {
                res[j++] = '1';
            } else
                res[j++] = '0';
        }
        return new String(res);
    }


    private void recur(int[] num, String target, int idx, int prev) {
        if(idx == target.length()) {
            return;
        }
        if(prev == 1) {
            if(target.charAt(idx) == '1') {
                num[0]++;
            }
            recur(num, target, idx + 1, 0);
        } else {//prev is 0
            num[0]++;
            recur(num, target, idx + 1, 0);
            recur(num, target, idx + 1, 1);
        }
    }


//    private void recur(int[] num, String target, int idx, int prev) {
//        if(idx == target.length()) {
//            return;
//        }
//        if(prev == 1) {
//            if(target.charAt(idx) == '1') {
//                num[0]++;
//                //recur(num, target, idx + 1, 0);
//            }
//            // } else
//            recur(num, target, idx + 1, 0);
//        } else {//prev is 0
//            // if(target.charAt(idx) == '1') {
//            num[0]++;
//            recur(num, target, idx + 1, 0);
//            recur(num, target, idx + 1, 1);
//            // } else {
//            //  num[0]++;
//            //  recur(num, target, idx + 1, 1);
//            //  recur(num, target, idx + 1, 0);
//            //num[0]--;
//            //}
//        }
//    }
}
