package Hashmap_String_I;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove given characters in input string,
 * the relative order of other characters should be remained.
 * Return the new string after deletion.
 *
 * Assumptions
 *
 * The given input string is not null.
 * The characters to be removed is given by another string, it is guaranteed to be not null.
 * Examples
 *
 * input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
 */
public class removeCertainCharaters {
    public String remove(String input, String t) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return null;//or ""
        }
        char[] ca = input.toCharArray();

        Set<Character> set = new HashSet<>();
        for(int i = 0; i < t.length(); i++){
            set.add(t.charAt(i));
        }
        int slow = 0;
        for(int i = 0; i < ca.length; i++){
            if(!set.contains(ca[i])){
                ca[slow++] = ca[i];//表示slow-1位置是处理过的
            }
        }
        String res = new String(ca, 0, slow);


        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String st2 = "az";
        removeCertainCharaters t = new removeCertainCharaters();
        System.out.println(t.remove(s1,st2));
    }
}
