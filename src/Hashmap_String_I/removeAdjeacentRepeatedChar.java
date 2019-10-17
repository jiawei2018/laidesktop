package Hashmap_String_I;

/**
 * Remove Adjacent Repeated Characters IV
 * Description
 * Repeatedly remove all adjacent, repeated characters in a given string from left to right.
 *
 * No adjacent characters should be identified in the final string.
 *
 * Examples
 *
 * "abbbaaccz" → "aaaccz" → "ccz" → "z"
 * "aabccdc" → "bccdc" → "bdc"
 * Hard
 */
public class removeAdjeacentRepeatedChar {
    public String deDup(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }
        char[]  carr = input.toCharArray();
        //char c = carr[0];
        int idx = 0;
        for(int i  = 1; i < input.length(); i++){
            if (idx == -1 || carr[i] != carr[idx]) {
                carr[++idx] = carr[i];
            }else{
                idx--;//pop
                while(i + 1 < input.length() && carr[i] == carr[i + 1]){
                    i++;//此处虽然是最后一个相同元素,但是在进入for循环会自动i++,又会吧这个跳过去
                }
            }
        }
        return new String(carr, 0 , idx + 1);//呼应 idx = -1;
    }

    public static void main(String[] args) {
        String s = "abbbaz";
        removeAdjeacentRepeatedChar t = new removeAdjeacentRepeatedChar();
        System.out.println(t.deDup(s));
    }

}
