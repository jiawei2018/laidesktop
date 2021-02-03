package test001;

import java.math.BigInteger;

public class t1 {
    public static void main(String[] args) {
        cc t = new cc();
        t.setname("lll");
        //System.out.println(t.getname());
        //father f = new father();
       //f.setname("jjj");
        //System.out.println(f.getname());
        //System.out.println(BigInteger.ONE);
        int sum = 0;
        int i = 0;
//        while( ++i < 10){
//            //System.out.println(i);
//            sum += i;
//        }
//        int j = 0;
//        System.out.println( 5 + (++j));
//        int k = 0;
//        String[] aaa = {"aa", "bb"};

        while(true){
            System.out.println(i);
            if(i < 100 && i > 10){
                i += 2;
                continue;
            } else if(i > 111){
                break;
            }
            i++;
            System.out.println("er nv ren");
        }
    }
}
