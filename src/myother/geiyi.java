package myother;

public class geiyi {

    public static void main(String[] args) {

        String input = "jw";

        String str = input.toLowerCase();
        for(char c : str.toCharArray()){
            System.out.println(c + " is: " + charToInt(c));
        }

    }

    private static int charToInt(char c){
        return c - 'a' + 1;
    }
}
