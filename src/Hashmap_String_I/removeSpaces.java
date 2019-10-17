package Hashmap_String_I;

/**
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 *
 * Assumptions:
 *
 * The given string is not null.
 * Examples:
 *
 * “  a” --> “a”
 * “   I     love MTV ” --> “I love MTV”
 * Easy
 */
public class removeSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        char[] carr = input.toCharArray();
        int slowidx = 0;
        for(int i = 0; i < carr.length; i++){
            if( carr[i] != ' ' ||  slowidx > 0 && carr[slowidx - 1] != ' ' && carr[i] == ' '){
                carr[slowidx++] = carr[i];
            }
        }
        if(slowidx != 0 && carr[slowidx] == ' '){
            return new String(carr, 0, slowidx - 1);
        }else
            return new String(carr, 0 , slowidx);

    }
}
