package lccontest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class debug01 {
    public static void main(String[] args) {
        String str1 = "/";
        String str2 = "a\\s\\ddf";// will print out =>     a\s\ddf
        //System.out.println(str2);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("V");
        //System.out.println("\n"); //will print out 2 empty row
        System.out.println("V");
        //System.out.println(Arrays.toString(str2.split("\\\\")));
    }

    class Node {
        int val;
        boolean test;
    }


    Map<String, String> map = new HashMap<String, String>();

    public String encode(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() <= 4) return s;
        if (map.containsKey(s)) return map.get(s);
        String res = s;
        for (int k = s.length() / 2; k < s.length(); k++) {
            String pattern = s.substring(k, s.length());
            int times = countRepeat(s, pattern);
            if (times * pattern.length() != s.length()) continue;
            String cur = times + "" + "[" + encode(pattern) + "]";
            if (cur.length() < res.length()) {
                res = cur;
            }
        }

        for (int i = 1; i < s.length(); i++) {
            String left = encode(s.substring(0, i));
            String right = encode(s.substring(i));
            String cur = left + right;
            if (cur.length() < res.length()) {
                res = cur;
            }
        }
        map.put(s, res);
        return res;
    }

    private int countRepeat(String s, String pattern) {
        int times = 0;
        while (s.length() >= pattern.length()) {
            String sub = s.substring(s.length() - pattern.length());
            if (sub.equals(pattern)) {
                times++;
                s = s.substring(0, s.length() - pattern.length());
            } else
                return times;
        }
        return times;
    }


}
