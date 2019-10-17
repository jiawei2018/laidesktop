package slidingWindows;

import java.util.HashSet;
import java.util.Set;

public class longestSubStringWithoutRepeat {
    public static void main(String[] args) {
        longestSubStringWithoutRepeat t = new longestSubStringWithoutRepeat();

        System.out.println(t.lengthOfLongestSubstring("cbefgbch"));
    }

    public int lengthOfLongestSubstring(String s) {
        //use set to chk
        if(s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int fast = 0;
        int slow = 0;
        int max = 0;
        while(fast < s.length()){
            char cur = s.charAt(fast);
            if(set.add(cur)){
                fast++;
            } else {
                while(slow < fast && s.charAt(slow) != cur){
                    set.remove(s.charAt(slow++));
                }
                set.remove(s.charAt(slow++));
            }
            max = Math.max(max, fast - slow);
        }
        return max;
    }
}
