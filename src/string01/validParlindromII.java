package string01;

public class validParlindromII {
    public static void main(String[] args) {

       String s =  "mississippi";
        //String n = "pi";
            String n = "x";
        System.out.println(strStr(s, n)) ;
        StringBuilder sb = new StringBuilder();
        s = sb.substring(0);
        sb.deleteCharAt(0);
    }
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length() < needle.length()){
            return -1;
        }
        int i = 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        char c = needle.charAt(0);
        while(i <= len1 - len2){
            while(i <= len1 - len2  && haystack.charAt(i) != c ){
                i++;
            }
            if(i <= len1 - len2 &&  isSame(haystack.substring(i,i + len2), needle)){
                return i;
            }else
                i++;

        }


        return  -1;
    }

    private static boolean isSame(String s1, String s2){
        int i = 0;
        while(i < s1.length()){
            if(s1.charAt(i) != s2.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }







    public static boolean validPalindrome(String s) {

        if(s == null || s.length() < 2){
            return true;
        }
        boolean del = false;

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            System.out.println(s.charAt(left) + "      "+ s.charAt(right));
            if(s.charAt(left) != s.charAt(right)){
                if(!del){//chk if we use the del opration
                    if(s.charAt(left + 1) == s.charAt(right)){
                        left++;
                        del = true;
                    } else if(s.charAt(left) == s.charAt(right - 1)){
                        right--;
                        del = true;
                    } else {
                        return false;
                    }
                }else{
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }



}
