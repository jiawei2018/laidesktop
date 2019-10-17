package midTerm_I;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q3 {
  /*                                                time                                     space
                               abc                  1                                         n:
                          /    |     \
                        a(bc) b(ac)  c(ba)          n branches                                 n-1:at HashSet and from idx not 0
                    /    \
                 ab(c)  ac(b)                               n* n - 1// fixed one element


                                                    n* n-1 * n-2 .... so it is an n!at last row;



   */


    public List<String> allPermutation(String input){
// assumption is input neither null or "";
// so we are good to go;
        //recursion way to solve this problem.
        List<String> res = new ArrayList<>();
        char[] carr = input.toCharArray();
        recur(res, carr, 0);
        return res;
    }

    private void recur(List<String> res, char[] carr, int idx){
        if(idx == carr.length - 1){
            res.add(String.valueOf(carr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = idx ; i < carr.length - 1; i ++){
            if(set.add(carr[i])){//if add sucess ,will return an boolean true,otherwise, will return false
                swap(carr, idx, i);
                recur(res, carr, idx + 1);
                swap(carr, idx, i);
            }
        }
    }

    private void swap(char[] carr , int idxa, int idxb){
        char tmp = carr[idxa];
        carr[idxa] = carr[idxb];
        carr[idxb] = tmp;
    }
//time complaxity is O(2^n) ; space coomplexity is O(n);  //wrong!11
    // time is o(n!)  space O(n^2) because there is an set at eachlevel
}
