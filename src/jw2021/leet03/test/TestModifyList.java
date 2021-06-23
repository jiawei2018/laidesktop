package jw2021.leet03.test;

import java.util.ArrayList;
import java.util.List;

public class TestModifyList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("vvz");
        System.out.println(list);

        for(String str : list){

            if(str.startsWith("a")){
                str = "rem";
            }

        }

        System.out.println(list);
    }
}
