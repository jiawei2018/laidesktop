package Hashmap_String_I;
/*
 WJ
Determine If One String Is Another's Substring
Description
Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assumptions

Both large and small are not null
If small is empty string, return 0
Examples

“ab” is a substring of “bcabc”, return 2
“bcd” is not a substring of “bcabc”, return -1
"" is substring of "abc", return 0
 */
public class determinIfOneStringIsAnotherSubstring {
//    public int strstr(String large, String small) {
//        if(large.length() < small.length()){
//            return -1;
//        }
//        if(small.length() == 0){
//            return 0;
//        }
//         int smallLen = small.length();
//         int len = large.length();
//
//        for(int i = 0; i <= (len - smallLen); i++){//mistake
//            String str = large.substring(i , i + smallLen);
//            if(isSame(str, small)){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private boolean isSame(String a, String b){
//        for(int i = 0; i < a.length(); i++){
//            if(a.charAt(i) != b.charAt(i)){
//                return false;
//            }
//        }
//        return true;
//    }





//    public static void main(String[] args) {
//        String s = "absec";
//        String f = "X";
//        determinIfOneStringIsAnotherSubstring t = new determinIfOneStringIsAnotherSubstring();
//        System.out.println(t.strstr(s , f));
//    }
}
