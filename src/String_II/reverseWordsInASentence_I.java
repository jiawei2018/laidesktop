package String_II;

/**
 *
 Reverse Words In A Sentence I
 Description
 Reverse the words in a sentence.

 Assumptions

 Words are separated by single space

 There are no heading or tailing white spaces

 Examples

 “I love Google” → “Google love I”

 Corner Cases

 If the given string is null, we do not need to do anything.
 */
public class reverseWordsInASentence_I {
    public static void main(String[] args) {
        String str = "i lo gle.";
        reverseWordsInASentence_I t = new reverseWordsInASentence_I();

        System.out.println(t.reverseWords(str));

    }
    public String reverseWords(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }
        char[] sarr = input.toCharArray();
        reverse(sarr, 0 ,sarr.length - 1);
        int left = 0;
        int right = 0;
        //work but it is not good at all;
//        while(right < sarr.length && left < sarr.length){
//            if(sarr[right]  == ' '){
//                reverse(sarr, left, right - 1);
//                left = right + 1;
//            }else  if(right == sarr.length - 1){
//                reverse(sarr, left, right);
//            }
//                right++;
//        }


        for(int i = 0; i < sarr.length; i++){
            if(sarr[i] != ' ' && (i == 0 || sarr[i] == ' ')){
                left = i;
            }
            if(sarr[i] != ' ' && (i == sarr.length - 1 || sarr[i + 1] == ' ')){
                right = i ;
                reverse(sarr, left, right);
            }
        }

        return String.valueOf(sarr);
    }

    private void reverse(char[] input, int left, int right){
        while(left <= right){
            swap(input, left++, right--);
        }
    }

    private void swap(char[] input, int idxa, int idxb){
        char temp = input[idxa];
        input[idxa] = input[idxb];
        input[idxb] = temp;
    }
}
