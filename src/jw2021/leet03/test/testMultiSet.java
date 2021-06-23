package jw2021.leet03.test;

import java.util.Collection;

public class testMultiSet {
    public static void main(String[] args) {
        MultiSet<String> multiSet = new MultiSet<>();

        multiSet.add("abs");
        multiSet.add("abs");
        multiSet.add("abs");
        multiSet.add("abs");
        multiSet.add("abs");
        multiSet.add("abs");

        System.out.println(multiSet.size());
        System.out.println(multiSet.getCount("asd"));
        System.out.println(multiSet.getCount("abs"));
         multiSet.remove();
        System.out.println(multiSet.getCount("abs"));
    }

    private <V extends Collection> V testMultiSet(){
        return null;
    }




}
