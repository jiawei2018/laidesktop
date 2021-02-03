package test001;

import java.util.ArrayList;
import java.util.List;

public class testjava8 {
    public static void main(String[] args) {
        tt();
    }


    public static void tt(){
        List e = new ArrayList<>();
        String[] strs = new String[26];
        for(int i = 0; i < 26; i++){
            strs[i] = String.valueOf(i + 'a');
            e.add(strs[i]);
        }

        e.forEach(System.out::println);

    }
}
