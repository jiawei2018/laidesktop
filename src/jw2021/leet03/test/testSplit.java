package jw2021.leet03.test;

import java.util.Arrays;

public class testSplit {
    public static void main(String[] args) {
        String s = "1#,2,3,4,5,##6,7,#8,#9,10,##11,#12,#13,##14,####";
        // i: empty element
        //"1#,2,3,4,5,#i#6,7,#8,#9,10,#i#11,#12,#13,#i#14,####";
        for(String i : s.split("#")){
            System.out.println("["+ i+ "]");
        }

        /*
        *  the output is :
[1]
[,2,3,4,5,]
[]
[6,7,]
[8,]
[9,10,]
[]
[11,]
[12,]
[13,]
[]
[14,]
        *
        * */
       // System.out.println(Arrays.toString(s.split("#")) + "  s>" + s.split("#").length);
    }
}
