package String_II;

/**
 * WJ
 * Reverse String
 * Description
 * Reverse a given string.
 *
 * Assumptions
 */
public class reverseString {
    public String reverse(String input) {
        // Write your solution here
        char[] carr = input.toCharArray();
        reverse(carr, 0 ,carr[carr.length - 1]);
        return String.valueOf(carr);
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
