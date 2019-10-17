package string01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class anagramGroup {

    public static void main(String[] args) {
        for(int i  = 0; i < 255; i++){
            System.out.println((char)i + "  " + i);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if(strs == null || strs.length == 0){
            return res;
        }

        for(String w : strs){
            String str = myHash(w);

            //myHash(w);
        }

        String s = "";
        s.toLowerCase();
        for(List<String> li : map.values()){
            res.add(li);
        }
        System.out.println(res);
        return null;
    }
    private String myHash(String word){
        if(word == null || word.length() == 0){
            return word;
        }
        int[] dic = new int[26];
        for(int i = 0; i < word.length(); i++){
            dic[word.charAt(i) -'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(dic[i] != 0){
                sb.append((char)(i + 'a')).append(dic[i]);
            }
        }
        //System.out.println(sb);
        return sb.toString();
    }
}
