package temp;

public class reverseWord {

    public static void main(String[] args) {
        String s = "the blue!";

        reverseWords(s);
    }
    public static String reverseWords(String s) {
        if(s == null || s.length() < 2){
            return s;
        }

        char[] carr = s.trim().toCharArray();

        reverse(carr, 0, carr.length -1);
        int i = 0;
        while(i < carr.length){
            if(carr[i] == ' '){
                i++;
                continue;
            }
            int start = i;
            while(i < carr.length && carr[i] != ' '){
                i++;
            }
//            if(i >= carr.length){
//                reverse(carr, start, carr.length - 1);
//            }
            reverse(carr, start, i - 1);
        }

        System.out.println(String.valueOf(carr));



        StringBuilder res = new StringBuilder();


        return res.toString();
    }

    private static  void reverse(char[] s, int start, int end) {
        if(s == null || s.length < 2){
            return;
        }
        int left = start;
        int right = end;
        while( left < right){
            swap(s, left++, right--);
        }
    }

    private static void swap(char[] s, int a, int b){
        char t = s[a];
        s[a] = s[b];
        s[b] = t;
    }
}
