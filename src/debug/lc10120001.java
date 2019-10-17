package debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc10120001 {
    public static void main(String[] args) {
        String s = "RLLLLRRRLR";
        lc10120001 t = new lc10120001();

        System.out.println(t.balancedStringSplit(s));

    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        for(int[] q : queens){
            if(q[0] == king[0]){
                res.add(Arrays.asList(q[0], q[1]));
                continue;
            }
            if(q[1] == king[1]){
                //res.add(Arrays.asList(q));
                continue;
            }
            if(Math.abs(q[0] - king[0]) == Math.abs(q[1] - king[1])){
                //res.add(Arrays.asList(q));
                continue;
            }

        }


        return res;
    }




    public int balancedStringSplit(String s) {
        if(s ==null || s.length() == 0){
            return 0;
        }
        return recur(s);
    }

    private int recur(String str){
        if(str.length() == 0){
            return 0;
        }
        int count = 0;
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'R'){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                res = 1 + recur(str.substring(i + 1, str.length()));
                break;
            }
        }
        return res;
    }
}
