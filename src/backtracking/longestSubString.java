package backtracking;

public class longestSubString {
    public String longestPalindrome(String input) {
        // Write your solution here
        if(input.length() < 2){
            return input;
        }
        int len = input.length();
        String res = "";
        boolean[][] isp = new boolean[len][len];
        int max = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= i; j++){
                if( input.charAt(j) == input.charAt(i) ){
                    if(i - j < 2 ||isp[j + 1][i - 1] == true){
                        isp[j][i] = true;
                        int cur = i - j;
                        System.out.println(cur);
                        if(cur > max){
                            max = cur;
                            res = input.substring(j,i+ 1);
                        }
                    }
                }
            }
        }
    return res;
    }

    public static void main(String[] args) {
        longestSubString t = new longestSubString();
        System.out.println(t.longestPalindrome("aaabbba"));
    }
}
