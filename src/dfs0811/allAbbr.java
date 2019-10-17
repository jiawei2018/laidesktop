package dfs0811;

import java.util.ArrayList;
import java.util.List;

public class allAbbr {
    public static void main(String[] args) {
        allAbbr t = new allAbbr();
        String s = "word";
        System.out.println(t.allAbbr(s));
    }

    public List<String> allAbbr(String word) {
        if(word == null || word.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        recur(word, res, new StringBuilder(), 0, 0);

        return res;
    }

    private void recur(String word, List<String> res, StringBuilder sb, int idx, int num) {
        // the level looks like a
        // word - 1ord, 2rd, 3d, 4
        //base case
        if(idx == word.length()) {
            if(num != 0) {
                sb.append(num);
            }
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        recur(word, res, sb, idx + 1, num + 1);//we abbr current char at idx in word
        sb.setLength(len);

        if(num > 0) {
            sb.append(num);
        }
        sb.append(word.charAt(idx));
        recur(word, res, sb, idx + 1, 0);
        sb.setLength(len);
    }




}
