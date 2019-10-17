package dfs0811;

import java.util.ArrayList;
import java.util.List;

public class IPaddressMapping {
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        //we use a list<list> to store the final answer and convert it to ip address
        List<List<Integer>> res = new ArrayList<>();
        recur(res, new ArrayList<>(), 0, 0, s) ;
        return convert(res);
    }

    private void recur(List<List<Integer>> res, List<Integer> tmp, int part, int idx, String str) {
        if(idx == str.length()) {
            if(part == 4) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        if(part == 4) {
            return;
        }

        int one = Integer.valueOf(str.charAt(idx) - '0');
        tmp.add(one);
        recur(res, tmp, part + 1, idx + 1, str);
        tmp.remove(tmp.size() - 1);

        if(one != 0 && idx + 1 < str.length()) {

            int two = Integer.valueOf(str.substring(idx, idx + 2));
            tmp.add(two);
            recur(res, tmp, part + 1, idx + 2, str);
            tmp.remove(tmp.size() - 1);

            if(two <= 25 && idx + 2 < str.length()) {
                int three = Integer.valueOf(str.substring(idx, idx + 3));
                if(three > 255) return;
                tmp.add(three);
                recur(res, tmp, part + 1, idx + 3, str);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    private List<String> convert(List<List<Integer>> list) {
        List<String> res = new ArrayList<>();
        for(List<Integer> l : list) {
            res.add(convertOne(l));
        }
        return res;
    }

    private String convertOne(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for(int p : list) {
            sb.append(p).append(".");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
