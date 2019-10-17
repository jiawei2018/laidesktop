package String_II;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * Description
 * Given a string, find the longest substring without
 * any repeating characters and return the length of it. The input string is guaranteed to be not null.
 *
 * For example, the longest substring without
 * repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
 */
public class longestSubstringWithoutRepeatingCharater {
    public static void main(String[] args) {
        String str = "利无尽处，命有尽时，不怠可焉。利无独据，远有兴衰，存畏警焉。";
        longestSubstringWithoutRepeatingCharater t = new longestSubstringWithoutRepeatingCharater();
        System.out.println(t.longest(str));
    }

    public int longest(String input) {
        // Write your solution here
        //now works
        if(input == null){
            return 0;
        }
        if(input.length() <= 1){
            return input.length();
        }
        int startidx = 0;
        int endidx = 0;
        int maxlen = 0;
        Set<Character> set = new HashSet<>();
        char[] carr = input.toCharArray();

        while(endidx < carr.length){
            if(set.add(carr[endidx])){
                endidx++;
            }else{
                set.remove(carr[startidx++]);
            }
            maxlen = Math.max(maxlen, set.size());
        }
        return maxlen;
    }
}
