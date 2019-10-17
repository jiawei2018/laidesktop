package string01;

import java.util.ArrayList;
import java.util.List;

public class textJustification {
    public static void main(String[] args) {
        String[] tt = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int  m = 16 ;
        System.out.println(fullJustify(tt, 16));

    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        //no corner case at here
        int i = 0;//the word idx in words[];
        while(i < words.length){
            int start = i;
            int remlen = maxWidth - words[i].length();
            while(i < words.length - 1 && words[i + 1].length() + 1 <= remlen){
                remlen -= words[++i].length() + 1;
            }
            int end = i;
            res.add(format(words, maxWidth, start, end));
            i++;
        }
        return res;
    }

    private  static String format(String[] words, int maxWidth, int start, int end){
        //start end  represent the word range for current row;
        StringBuilder res = new StringBuilder();
        if(start == end && end != words.length - 1 ){//only one word
            res.append(words[start]);
            int remain = maxWidth - words[start].length();
            while(remain > 0){
                res.append(' ');
                remain--;
            }
            return res.toString();
        }else if(end == words.length - 1){//last.row;
            while(start <= end){
                res.append(words[start++]).append(' ');
            }
            while(res.length() < maxWidth){
                res.append(' ');
            }
            return res.toString();
        }
        //normal row
        int allLen = 0;
        int numWords = end - start + 1;
        for(int i = start; i <= end; i++){
            allLen += words[i].length();
        }
        int before = allLen + numWords - 1; //thats how long before justifing
        int needSpace = maxWidth - before;
        int eachSpace = needSpace / (numWords - 1);
        int remSpace = needSpace % (numWords - 1);
        while(start <= end){
            if(remSpace > 0){
                res.append(words[start++]).append(genSpace(eachSpace + 1 + 1));
                remSpace -- ;
            }else {
                res.append(words[start++]).append(genSpace(eachSpace + 1));
            }
        }
        return res.toString().trim();
    }

    private  static String genSpace(int num){
        char[] carr = new char[num];
        for(int i = 0; i < carr.length; i++){
            carr[i] = ' ';
        }
        return String.valueOf(carr);
    }
}
