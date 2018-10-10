package class_DFS_I;

import java.util.ArrayList;
import java.util.List;

/**
 * All Subsets I
 * Description
 * Given a set of characters represented by a String,
 * return a list containing all subsets of the characters.
 *
 * Assumptions
 *
 * There are no duplicate characters in the original set.
 * ​Examples
 *
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 */
public class allset_I {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if(set == null ){//mistake was:|| set.length() == 0    , but length = 0 must do the recur!
            return res;
        }

        recur(set, 0, new StringBuilder(),res);
        return res;
    }

    private void recur(String set, int idx, StringBuilder tmp, List<String> res){
        if(idx == set.length() ){
            res.add(tmp.toString());
            return;
        }
        recur(set, idx + 1, tmp,res);
        tmp.append(set.charAt(idx));
        recur(set, idx + 1, tmp, res);
        tmp.deleteCharAt(tmp.length() - 1);
    }
    private void recur2(String set, int idx, StringBuilder tmp, List<String> res){
                 res.add(tmp.toString());
                 //这个是逆序排?
                for(int i = idx ; i < set.length(); i++){
                    tmp.append(set.charAt(i));
                    recur2(set,idx + 1, tmp,  res);
                    tmp.deleteCharAt(tmp.length() - 1);
                }
     }


    public static void main(String[] args) {
        allset_I t = new allset_I();
        //t.subSets("abc");
        System.out.println(t.subSets("abc"));
    }

}
