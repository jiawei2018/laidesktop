package string01;

import java.util.*;

public class isomorphic {
    public static void main(String[] args) {
        char[] sc = "dd".toCharArray();
        String t = "cfa";
        //isIsomorphic(s, t);
        int n = 3224343;
        System.out.println(5 / 10);
       // System.out.println( compress(sc));
    }


    public static int compress(char[] chars) {
        //inplace
        // a d b e a c b
        //           s
        //             f

        StringBuilder sb = new StringBuilder();
        sb.insert(1,' ');
        int slow = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == chars[slow] && i != chars.length  -1){
                continue;
            } else if(chars[i] != chars[slow] || i == chars.length - 1){ // i != slow
                int count = i - slow ;
                if(count > 1){
                    //slow++;
                    while(count > 0 && slow <= i){
                        chars[++slow] = (char)(count % 10 + '0');
                        count /= 10;
                    }
                    chars[++slow] = chars[i];
                }else
                    slow++;
            }
        }
        return slow;
    }

    private static int getTopBit(int num){
        if(num < 10){
            return num;
        }
        int tmp = num;
        while(tmp > 10){
            System.out.println(tmp % 10);
            tmp /= 10;
        }
        return tmp;
    }


    public static boolean isIsomorphic(String s, String t) {
        //assume length is same
        if(s == null && t == null){
            return true;
        }
        if(s.length() != t.length()){
            return false;
        }

        String[] sr = s.split(" ");
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for(int i = 0; i < cs.length; i++){
            if(!map.containsKey(cs[i])){
                map.put(cs[i], new ArrayList<Integer>());
            }
            map.get(cs[i]).add(i);
        }

        Set<Character> used = new HashSet<>();

        for(int i = 0; i < ct.length; i++){
            if(ct[i] == cs[i]){
                continue;
            }else{
                if(!used.contains(ct[i])){
                    replace(cs, map.get(cs[i]), ct[i]);
                    used.add(ct[i]);
                }else
                    return false;
            }
        }
        return true;
    }

    private static void replace(char[] carr, List<Integer> dic, char r){
        for(int i = 0; i < dic.size(); i++){
            carr[dic.get(i)]  = r;
        }
    }
}
