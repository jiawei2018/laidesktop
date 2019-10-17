package mytest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class testmemo {

    public int longestChain(List<String> dict){
        // data structure
        Map<String, Integer> memo = new HashMap<>();
        int globalMax = 1;

        for(String word : dict){
            globalMax = Math.max(globalMax, dfsChain(word, dict, memo));
        }

        return globalMax;
    }

    private int dfsChain(String word, List<String> dict, Map<String,Integer> memo){
        if(!dict.contains(word)) return 0;
        if(memo.containsKey(word)) return memo.get(word);

        int max = 0;
        for(int i = 0; i < word.length(); i++){
            String newWord = word.substring(0, i) + word.substring(i + 1);
            max = Math.max(max, dfsChain(newWord, dict, memo));
        }
        max++;
        memo.put(word, max);
        return max;
    }

}
