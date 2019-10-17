package other;

import java.util.*;

public class lc527WordAbbrivation {


    public static void main(String[] args) {
        int j = 2;
        byte d = 0;
        for(int i =0; i< 256; i++){

            System.out.println();
        }
        System.out.println(d >>> 7);

    }

    public List<String> wordsAbbreviation(List<String> dict) {

        List<pair> tmp = new ArrayList<>();
        for (int i = 0; i < dict.size(); i++) {
            pair p = new pair(i, dict.get(i), abbr(dict.get(i), 1));
            tmp.add(p);
        }
        String[] res = new String[dict.size()];
        format(tmp, 1, res);
        return Arrays.asList(res);
    }

    //make a recursion method
    private void format(List<pair> list, int pflen, String[] res) {
        if (list.size() == 1) {
            pair cur = list.get(0);
            res[cur.idx] = cur.abbr;
            return;
        }
        Map<String, List<pair>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            pair p = list.get(i);
            String curkey = abbr(list.get(i).word, pflen);
            if (!map.containsKey(curkey)) {
                map.put(curkey, new ArrayList<>());
            }
            p.abbr = curkey;
            map.get(curkey).add(p);
        }
        for (List arr : map.values()) {
            format(arr, pflen + 1, res);
        }
    }

    private String abbr(String word, int pflen) {
        //internet ,1   i+ + t
        // word  w2d wo1d
        if (word.length() - pflen - 1 <= 1) {// 4 -2-1 meas only one char
            return word;
        }
        String res = word.substring(0, pflen) + (word.length() - pflen - 1) + word.charAt(word.length() - 1);
        if (res.length() == word.length()) {
            return word;
        }
        return res;
    }

    class pair {
        int idx;
        String word;
        String abbr;
        public pair(int idx, String word, String abbr) {
            this.idx = idx;
            this.word = word;
            this.abbr = abbr;
        }
    }
}
