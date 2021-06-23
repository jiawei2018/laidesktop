package sometests;

import java.security.KeyPair;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;

public class speed_test {


    public static void main(String[] args) {
        speed_test tt = new speed_test();

         tt.test01(10);

    }

    private void test01(int testTimes){
        long s1 = System.currentTimeMillis();
        runit(testTimes, this::fromMap);
        long l1 = System.currentTimeMillis() - s1;
        System.out.println("fromMap  " + l1);

        long s2 = System.currentTimeMillis();
        runit(testTimes, this::fromswitch);
        long l2 = System.currentTimeMillis() - s2;
        System.out.println("fromswitch  " + l2);

        long s3 = System.currentTimeMillis();
        runit(testTimes, this::backDir);
        long l3 = System.currentTimeMillis() - s3;
        //System.out.p<>rintln("backDir  " + l3);
        TreeSet<KeyPair>  s = new TreeSet<>(Comparator.comparingInt(Object::hashCode));




    }

    private void runit(int times, Function<Character, Character> function){
        for(int i = 0; i < times; i++) {
            System.out.println( function.apply(genRandomChar()));
            //function.apply(genRandomChar());
        }
    }

    private char genRandomChar( ) {
        //for(int i = 0; i < times; i++) {
            int rdint = (int)(Math.random() * 4);

            if(rdint == 0) {
                 return 'U';
            } else if(rdint == 1){
                return 'D';
            } else if(rdint == 2) {
                return 'R';
            } else if(rdint == 3) {
                return 'L';
            }

            return '/';
        //}
    }


    Map<Character, Character>  chmap = Map.of('U','D','D','U','L','R','R','L');

    private char fromMap(char c){
        return chmap.get(c);
    }

    private char fromswitch(char c) {
        switch (c) {
            case 'U':
                return 'D';
            case 'D':
                return 'U';
            case 'R':
                return 'L';
            case 'L':
                return 'R';
             default:
                    return 'X';
        }

    }

    char[][] dirMap= {{'U','D'},{'D','U'},{'L','R'},{'R','L'}};
    private char backDir(char dir){
        for(char[] cc: dirMap){
            if(dir == cc[0]){
                return cc[1];
            }
        }
        return 'X';
    }


}
