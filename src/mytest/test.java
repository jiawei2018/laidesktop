package mytest;

public class test {
    public static void main(String[] args) {
        //recur(25000 + 3125 + 16); max 28141 in stack
        recur(500000);
        test01(5);
    }

    private static  void recur(int num){
        String s1 = "aa";
        String s2 = "a a";
        System.out.println(s1.compareTo(s2));
        Character.isDigit('d');
        Character.toLowerCase('v');
        Character.toUpperCase(' ');
    }

    private static void test01(int input){
        for(int i= 0; i < 3; i++){
            System.out.println(i);
            if(i == 2) {
                i = -1;
            }
        }

    }

}
