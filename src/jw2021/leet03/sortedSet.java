package jw2021.leet03;

import java.util.*;

public class sortedSet {


    public static void main(String[] args) {
        sortedSet t = new sortedSet();
        t.test();


        TreeSet<Node> treeSet1 = new TreeSet<>((a,b ) -> {
            if(a.name.equals(b.name)){
                return 0;
            }
            return b.value - a.value;
        });


        //treeSet1 .add(new Node("abc", 1));

    }

    private void test() {
        MySet myset = new MySet();

        TreeSet<Node> treeSet1 = new TreeSet<>((a,b ) -> {
            if(a.name.equals(b.name)){
                return 0;
            }
            return b.value - a.value;
        });
        treeSet1.add(new Node("abc", 1));
        treeSet1.add(new Node("abc", 3));
        System.out.println(treeSet1);
        treeSet1.add(new Node("abcd", 1));
        treeSet1.add(new Node("abcd", 6));
        //treeSet1.add(new Node("abc", 1));
        System.out.println(treeSet1);

//        myset.addOrUpdate(new Node("abc", 1));
//        myset.addOrUpdate(new Node("abc", 2));
//        myset.addOrUpdate(new Node("abc", 3));
//        myset.addOrUpdate(new Node("abcd", 5));
//        myset.addOrUpdate(new Node("abcd", 6));
//        myset.addOrUpdate(new Node("abd", 2));
//        myset.addOrUpdate(new Node("abd", 4));
//        myset.addOrUpdate(new Node("abd", 6));
//        myset.addOrUpdate(new Node("abd", 8));

    }


      class MySet{
        Map<String, Integer> map;
        TreeSet<Node> treeSet;

        MySet() {
            map = new HashMap<>();
            treeSet = new TreeSet<>((a, b) -> {
                if(a.name.equals(b.name)) {
                    return a.value - b.value;
                }
                //return 0;
                return a.name.compareTo(b.name);
            });
        }

        void addOrUpdate(Node node) {
            //always keep two sets has the same eles;
            if(map.containsKey(node.name)) {
                //should update
                Node node1 = new Node(node.name, map.get(node.name));
                treeSet.remove(node1);//del the old ones
            }
            treeSet.add(node);
            map.put(node.name, node.value);

            System.out.println("map " + map);
            System.out.println("treeset" + treeSet);
        }

        void remove () {

        }

        int getMax() {
            return 0;
        }


        int getMin() {
            return 0;
        }
    }




    class Node  {
        String name;
        int value;
        Node (String s, int v) {
            name = s;
            value = v;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj.getClass() != this.getClass()) {
                return false;
            }

            Node other = (Node) obj;
            if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
                return false;
            }

            return true;
        }

        @Override
        public String toString() {
            return name +" :" +value;
        }
    }

}
