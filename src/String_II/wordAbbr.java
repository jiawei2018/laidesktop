package String_II;

import java.util.*;

public class wordAbbr {
    public static void main(String[] args) {
       // String[] sa = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        String[] sa = {"abcdefg","abccefg","abcckkg"};
        wordAbbr t = new wordAbbr();
        System.out.println(t.wordsAbbreviation(Arrays.asList(sa)));
        //t.wordsAbbreviation(Arrays.asList(sa));
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        List<pair> tmp = new ArrayList<>();
        for(int i = 0; i < dict.size(); i++){
            pair p = new pair(i, dict.get(i), abbr(dict.get(i), 1));
            tmp.add(p);
        }
        String[] res = new String[dict.size()];
        format(tmp, 1, res);
        return Arrays.asList(res);
    }

    //make a recursion method
    private void format(List<pair> list, int pflen, String[] res){
        if(list.size() == 1){
            pair cur = list.get(0);
            res[cur.idx] = cur.abbr;
            return;
        }
        Map<String, List<pair>> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            pair p = list.get(i);
            String curkey = abbr(list.get(i).word, pflen);
            if(!map.containsKey(curkey)){
                map.put(curkey, new ArrayList<>());
            }
            p.abbr = curkey;
            map.get(curkey).add(p);
        }
        for(List arr : map.values()){//or use a queue, change to iterate method
            format(arr, pflen + 1, res);
        }

    }

    private String abbr(String word, int pflen){
        //internet ,1   i+ + t
        if(word.length() - pflen - 1 <= 1){
            return word;
        }
        String res = word.substring(0, pflen) +(word.length() - pflen - 1) +word.charAt(word.length() - 1);
        if(res.length() == word.length()){
            return word;
        }
        return res;
    }

    class pair{
        int idx;
        String word;
        String abbr;
        public pair(int idx, String word, String abbr){
            this.idx = idx;
            this.word = word;
            this.abbr = abbr;
        }
        @Override
        public String toString(){
           return "[str: " + this.word  + " abbr: " + this.abbr + " idx:"+this.idx +"]";
        }
    }
}
