package String_II;

import java.util.*;

/**
 *
 All Anagrams
 Description
 Find all occurrence of anagrams of a given
 string s in a given string l. Return the list of starting indices.

 Assumptions

 s is not null or empty.
 l is not null.
 Examples

 l = "abcbac", s = "ab", return [0, 3]
 since the substring with length 2 starting
 from index 0/3 are all anagrams of "ab" ("ab", "ba").
 */
public class allAnegram {
    public List<Integer> allAnagrams(String sh, String lo) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if(lo.length() == 0){
            return res;
        }


        if(sh.length() > lo.length()){
            return res;
        }
        //make a map for lo
        Map<Character, Integer> map = intomap(sh);
         int matches = 0;

         for(int i =0; i < lo.length(); i++){
             char tmp = lo.charAt(i);

             Integer count = map.get(tmp);// count is the number of needed count ;
             if(count != null){
                 map.put(tmp, count - 1);
                 if(count == 1){
                     matches++;
                 }
             }

             if(i >= sh.length()){
                 tmp = lo.charAt(i - sh.length());// the char we removed
                 count = map.get(tmp);
                 if(count != null){
                     map.put(tmp, count + 1);
                     if(count == 0){
                         matches--;
                     }
                 }
             }

             //0 1 2 3 4 5 6
             //a a b d e f d    <= lo
             //  a b <= sh
             //if i =2 ,and len =2 then, a.idx = 2-2,  b .idx = 2-2 + 1
             if(matches == map.size()){
                 res.add(i  - sh.length() + 1);
             }

         }//for loop
            return res;
    }

    private Map<Character, Integer> intomap(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            Integer count = map.get(str.charAt(i)); //注意这个用法, 必须这样用!!!!老师已经提醒过了!!!
            //尽量不要用 containsKey!!!
            if(count != null){
                map.put(str.charAt(i),  count + 1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        return map;
    }






}
