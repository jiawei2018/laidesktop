package prctice01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueen {
    public List<List<Integer>> Nqueen(int n ){
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 0 ){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        recur(res, temp, n);

        System.out.println(tostr(res, n));
        return res;
    }

    private void recur(List<List<Integer>> res, List<Integer> temp, int n){
        if(temp.size() == n){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < n; i++){
            if(isValid(temp, i )){
                temp.add(i);
                recur(res, temp, n);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * X1XXX
     * XX2XX
     * XXX3X
     *
     * @param temp
     * @param curidx
     * @return
     */

    private boolean isValid(List<Integer> temp, int curidx){
        //curidx means at row temp.size and col curidx the queen is valid or not
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) == curidx || Math.abs(temp.get(i) - curidx) == temp.size() - i ){
                // temp.get(i) == curidx  means there if same column  queen exist
                // Math.abs(temp.get(i) - curidx) == temp.size() - i
                //因为在对角线延长线上,说明这两个点的横坐标的距离与纵坐标的距离应该是相等的;
                //Math.abs(temp.get(i) - curidx) 就是横坐标的差值
                //temp.size() - i 就是纵坐标的差值

                return  false;
            }
        }
        return true;
    }

    private List<List<String>> tostr(List<List<Integer>> input, int n){
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < input.size(); i++){
            List<Integer> tmp = input.get(i);
            List<String> sout = new ArrayList<>();
            //[1,2,3,4,5,6,7,8]
            for(int j = 0; j < tmp.size(); j++){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < n; k++){
                    if(k != tmp.get(j)){
                        sb.append(".");
                    }else
                        sb.append("Q");
                }
                sout.add(sb.toString());
            }
            res.add(sout);
        }
        return res;
    }

    public static void main(String[] args) {
        Nqueen t = new Nqueen();
        List<List<Integer>> res = t.Nqueen(4);
        System.out.println(res.size()+"  " + res);
    }


}
