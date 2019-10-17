package bit;

public class allUnique_2 {
    public static  boolean allUnique(String word) {
        // Write your solution here
        int[] map = new int[8];
        for(int i = 0; i < word.length(); i++){
            int curchar  = word.charAt(i);
            int row = curchar / 32;
            int col = curchar % 32;
            if(((map[row] >> col) & 1)== 1){ // mistake!!!!!!!!!!!!! again
                return false;
            }else{
                map[row] |= (1 << col);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allUnique("123,./}{+_>"));
        //llUnique("123,./");
    }
}
