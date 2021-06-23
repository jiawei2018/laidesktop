package jw2021.leet03.mic;

import java.util.HashSet;
import java.util.Set;

public class ReverseStrByWord {

    public static void main(String[] args) {
        String s = " the sky is blue";

        ReverseStrByWord t = new ReverseStrByWord();
        t.reverseWords(s);
    }

    public String reverseWords(String s) {

        s = s.trim();
        Set<int[]> tt = new HashSet<>();

        tt.add(new int[]{0,1});
        tt.add(new int[]{0,1});
        tt.add(new int[]{1,1});
        System.out.println(tt);

        char[] carr = s.toCharArray();

       // reverse(carr, 0, carr.length - 1);
        //"a book" -> 'koob a'
       // reverseAllWord(carr);
        return null;
       // return removeSpace(carr);
    }

    private void reverseAllWord(char[] carr) {
        System.out.println(String.valueOf(carr));
        for( int i = 0; i < carr.length; i++) {
            if(carr[i] == ' ') continue;
            System.out.println(carr[i] + "  " + i);
            int j = i;
            while(j < carr.length && j != ' '){
                //corner case 'a book'
                j++;
            }
            //range is i to j-1
            reverse(carr, i, j - 1);
            i = j - 1;
        }
        System.out.println(String.valueOf(carr));
    }

    private String removeSpace(char[] carr){
        // 'a    book'

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < carr.length; i++){
            if (carr[i] != ' ') {
                int j = i;
                while(j < carr.length && carr[j] != ' '){
                    sb.append(carr[j]);
                    j++;
                }
                sb.append(' ');
                i = j-1;
            }
        }
        return sb.toString().trim();
    }




    private void reverse(char[] carr, int i, int j){
        int left = i;
        int right = j;
        while(left < right) {
            char tmp = carr[left];
            carr[left] = carr[right];
            carr[right] = tmp;
            left++;
            right--;
        }
        //System.out.println(String.valueOf(carr));
    }

}
