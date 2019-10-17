package debug;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class roboloxMJ {
    public static void main(String[] args) {
        String s  = "ababab";
        System.out.println(getMaxOccurrences(s, 2, 4, 3));
    }

    public static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
        // Write your code here
        if(s == null || maxLength < minLength){
            return 0;
        }
        if(maxUnique == 0){
            return 0;
        }
        set = new HashSet<>();
        fmap = new HashMap<>();
        int max = 0;
        int k = minLength;
        int p = maxLength;
        for(int i = 0; i < s.length(); i++){

            for(int j = i + k; j <= s.length() && j <= p + i ; j++){
                String sub = s.substring(i, j);
                int status = insert(sub, maxUnique);
                if(status == -1){
                    break;
                }
                max = Math.max(max, status);
            }
        }
        return max;
    }

    static Set<Character> set;
    static Map<String, Integer> fmap;

    private static int insert(String word, int maxU){
        set.clear();
        for(char c : word.toCharArray()){
            set.add(c);
            if(set.size() > maxU){
                return -1;//not a valid substring
            }
        }
        fmap.put(word, fmap.getOrDefault(word, 0) + 1);
        return fmap.get(word);
    }

}
