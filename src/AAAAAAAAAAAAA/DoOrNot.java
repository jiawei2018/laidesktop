package AAAAAAAAAAAAA;

import java.util.Date;

public class DoOrNot {

    public static void main(String[] args) {
        long curt = System.currentTimeMillis();
        double sqrt = Math.sqrt(curt);
        String str = String.valueOf(sqrt);
        int last = (str.charAt(str.length() - 1) - '0');
        System.out.println(last % 2 == 0 ? "Go/Do/Yes" : "Not/Stay/Hold");

        Object a = new Object();
        //
    }

}
