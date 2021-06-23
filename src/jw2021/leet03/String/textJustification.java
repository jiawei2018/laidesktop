package jw2021.leet03.String;

import java.util.ArrayList;
import java.util.List;

public class textJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int limit = maxWidth;
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) {
            return res;
        }
        int idx = 0;
        while(idx < words.length) {
            int lineLen = words[idx].length();
            int right = idx + 1;
            while(right < words.length){
                if(lineLen + 1 + words[right].length() > limit) {
                    //if the line len > limit,
                    break;
                }
                lineLen += words[right].length() + 1;
                right++;
            }
            //get number of words in this line
            //1      2   3
            int num = right - idx - 1;//number of empties  between words 'a b c' -> 2 empties
            StringBuilder sb = new StringBuilder();
            if(num == 0 || right == words.length) {
                //last or single line
                for(int i = idx + 1; i < right; i++){
                    sb.append(" ");//since i is start from second word
                    sb.append(words[i]);
                }
                if(sb.length() < limit){
                    sb.append(genSp(limit - sb.length()));
                }
                res.add(sb.toString());
            } else {
                //normal line, nned to handle the extra space;
                int fixSpace = (limit - lineLen) / num;
                int changedSpace = (limit - lineLen) % num;

                for(int i = idx + 1; i < right; i++){
                    sb.append(" ");
                    sb.append(genSp(fixSpace));
                    sb.append(words[i]);
                    if(changedSpace > 0){
                        sb.append(" ");
                        changedSpace--;
                    }
                }
                res.add(sb.toString());
            }
            idx = right;

        }

        return res;
    }

    private String genSp(int num){
        if(num <= 0){
            return "";
        }
        return " " + genSp(num - 1);
    }
}
