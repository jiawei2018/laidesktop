package string01;

import java.util.ArrayList;
import java.util.List;

public class encodeDecode {
    public static void main(String[] args) {
         List<String> tt = new ArrayList<>();
         tt.add("hello");
         tt.add("world");

         String en = encode(tt);
        System.out.println(en);
        List<String> de = decode(en);
        System.out.println(de);
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            String cur = strs.get(i);

            System.out.println(cur + strs.size() + "  " + i);
            sb.append(cur.length()).append('$').append(cur);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int right = s.indexOf('$', i);
            int curlen = Integer.valueOf(s.substring(i, right));
            //3$acd
            //01234
            res.add(s.substring(right + 1, right + curlen + 1));
            i = right + curlen + 1;
        }
        return res;

    }
}
