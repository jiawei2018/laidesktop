package String_II;

public class rightSHiftByNCharacters {
    public String rightShift(String input, int n) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }

        n = n % input.length();
        char[] scarr = input.toCharArray();
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!notice this is right shift !!!!
        //so if left shift we must use
        reverse(scarr ,scarr.length - n, scarr.length - 1);
        reverse(scarr ,0, scarr.length - n - 1);
        reverse(scarr ,0, scarr.length - 1);

        //下面这个虽然对,但是不要用!
        //为什么不用见reorderArray 那道题的注解
//        reverse(scarr, 0, scarr.length - 1);
//        reverse(scarr, 0, n - 1);
//        reverse(scarr, n, scarr.length - 1);

        return String.valueOf(scarr);
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
