package debug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc140 {

    public static void main(String[] args) {
        lc140 t = new lc140();
        String str = "pineapplepenapple";
        String[]  strs = {"apple","pen","applepen","pine","pineapple"};
        List<String> l = t.cov(strs);
        t.wordBreak(str, l);

    }

    private List<String> cov(String[] strs) {
        List<String> res = new ArrayList<>();
        for(String s: strs){
            res.add(s);
        }
        return res;
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> dict = toSet(wordDict);
        int[] memo = new int[s.length()];
        recur(res, new ArrayList<>(), s, dict, 0, memo);

        return res;
    }

    private boolean recur(List<String> res, List<String> temp, String s, Set<String> dict, int idx, int[] memo) {
        System.out.println(temp + " " + idx);
        if(idx == s.length()) {
            res.add(convert(temp));
            return true;
        }
        if(memo[idx] < 0){
            System.out.println(idx);
            return false;
        }

        for(int i = idx; i < s.length(); i++) {
            String cur = s.substring(idx, i + 1);
            if(dict.contains(cur)) {
                temp.add(cur);
                if(recur(res, temp, s, dict, i + 1, memo)) {
                    // temp.remove(temp.size() - 1);
                    memo[idx] = Integer.MAX_VALUE;
                    //continue;
                }
                temp.remove(temp.size() - 1);
            }
        }
        //System.out.println(idx + "  << " + flag);
        if(memo[idx] == 0){
            memo[idx]--;
        }
        return false;
    }

    private Set<String> toSet(List<String> wordDict){
        Set<String> res = new HashSet<>();
        for(String s : wordDict){
            res.add(s);
        }
        return res;
    }

    private String convert(List<String> list) {
        StringBuilder res = new StringBuilder();
        for(String s : list) {
            res.append(s).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
