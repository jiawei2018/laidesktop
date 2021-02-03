package IWillSuccess;

public class test {
    public static void main(String[] args) {
        String a = "worder";
        String b = "w3";
        System.out.println(isMatch(a, b));
    }

    private static boolean isMatch(String input, String abbr){
        //determine if a word has a abbr
        // word, w2d
        int i = 0;//idx at input
        int leni = input.length();
        int j = 0;// idx at abbr
        int lenj = abbr.length();
        while(i < leni && j < lenj){
            if(!Character.isDigit(abbr.charAt(j))){
                if(abbr.charAt(j++) != input.charAt(i++)) {
                    return false;
                }
            } else {//is decimal
                int num = 0;
                while( j < lenj &&  Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j++) - '0');
                }
                i += num;
            }
        }
        return i == leni && j == lenj;
    }
}
