package String_II;

import myHelperUtil.MyPrintHelper;

import java.util.Arrays;

public class numberOfMatchingsubsq {

    public static void main(String[] args) {
        numberOfMatchingsubsq t = new numberOfMatchingsubsq();
        String s = "fuckyou";
        String[] arr = {"fu","kc"};
        t.numMatchingSubseq(s,arr);
    }
    public int numMatchingSubseq(String S, String[] words) {
        int n=S.length();
        int[][] next= new int[n+1][26];
        char[] sc= S.toCharArray();

        Arrays.fill(next[n],-1);
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<26;j++){
                next[i][j]=next[i+1][j];
            }
            next[i][sc[i]-'a']=i+1;
        }
        MyPrintHelper.printArray(next);
        int res=0;
        for(int i=0;i<words.length;i++){
            if(isSubseq(next,words[i])) res++;
        }
        return res;

    }

    public boolean isSubseq(int[][] next,String s){
        char[] sc= s.toCharArray();
        int j=0;
        for(int i=0;i<sc.length;i++){
            char c= sc[i];
            if(next[j][c-'a']>-1) j=next[j][c-'a'];
            else return false;
        }
        return true;
    }
}
