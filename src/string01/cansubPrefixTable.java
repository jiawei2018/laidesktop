package string01;

import myHelperUtil.MyPrintHelper;

public class cansubPrefixTable {
    public static void main(String[] args) {
        String s = "ada";
       // System.out.println(repeatedSubstringPattern(s)) ;
        char[] t = "abcabcabc".toCharArray();
        prefixtable(t, new int[t.length]);
        repeat("abcabcabc");
    }
    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() < 2){
            return false;
        }
        // int[] dict = new int[26];
        // for(char c : s.toCharArray()){
        //     dict[c - 'a'] = 1;
        // }
        // int kinds = 0;
        // for(int i = 0; i < 26; i++){
        //     if(dict[i] == 1) kinds++;
        // }

        for(int i = 1; i <= s.length() / 2; i++){
            if(s.length() % i != 0){
                continue;
            }
            String cur = s.substring(0, i);
            System.out.println(cur);
            // if(!hasAllChar(cur, dict)){
            //     continue;
            // }
            if(cansub(s, cur)){
                return true;
            }
        }
        return false;
    }

    private static boolean cansub(String big, String sub){
        int len = sub.length();
        int idx = 0;
        for(int i = len; i < big.length(); i++){
            if(big.charAt(i) != sub.charAt(i % len)){
                return false;
            }
        }
        return true;
    }


    public static void prefixtable(char[] carr, int[] prefix){
        prefix[0] = 0;
        int len = 0;
        int i = 1;
        while(i < carr.length){
            System.out.println(i + "   " + len);
            if(carr[i] == carr[len]){
                len++;
                prefix[i] = len;
                i++;
            } else {
                if(len > 0){
                    len = prefix[len - 1 ];
                }else {
                    prefix[i] = len - 1;
                    i++;
                }
            }
        }

    }

    public static boolean repeat(String s) {
        int prefixTable[] = new int[s.length()];
        int i = 0;
        int j = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                prefixTable[j++] = ++i;
            } else if (i > 0) {
                i = prefixTable[i - 1];
            } else if (i == 0) {
                j++;
            } else
                i = 0;
        }
        //MyPrintHelper.printArray(prefixTable);
        return true;
       // return prefixTable[s.length() - 1] > 0 && s.length() % (s.length() - prefixTable[s.length() - 1]) == 0;
    }


    // private boolean hasAllChar(String s, int[] dict){
    //     //must contains all chars in substring
    //     int[] cur = new int[26];
    //     for(char c : s.toCharArray()){
    //         cur[c - 'a'] = 1;
    //     }
    //     for(int i = 0; i < 26; i++){
    //         if(cur[i] != dict[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
