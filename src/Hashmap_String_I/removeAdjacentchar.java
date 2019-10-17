package Hashmap_String_I;

/**
 *
 Remove Adjacent Repeated Characters I
 Description
 Remove adjacent, repeated characters in a given string,
 leaving only one character for each group of such characters.

 Assumptions

 Try to do it in place.
 Examples

 “aaaabbbc” is transferred to “abc”
 Corner Cases

 If the given string is null, we do not need to do anything.
 */
public class removeAdjacentchar {
    public String deDup(String input) {
       if(input == null || input.length() <= 1){
           return input;
       }
       char[] carry = input.toCharArray();
       int slowidx = 1;
       for(int i = 1; i < input.length(); i++){
           if(carry[i] == carry[slowidx-1]){
            continue;
           }else{
            carry[slowidx++] = carry[i];
           }
       }
       return new String(carry, 0, slowidx);
    }

    public static void main(String[] args) {
        String s = "aaaabbbc";
        removeAdjacentchar t = new removeAdjacentchar();
        System.out.println(t.deDup(s));
    }
}
