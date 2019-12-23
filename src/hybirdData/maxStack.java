package hybirdData;

import java.util.TreeSet;

public class maxStack {
    public static void main(String[] args) {
        MaxStack t = new MaxStack();
        //MaxStack t = new
        //["MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"]
        //[[],[5],[1],[5],[],[],[],[],[],[]]
        t.push(5);
        t.push(1);
        t.push(5);
        System.out.println(t.top());
        System.out.println(t.popMax());
        System.out.println(t.top());
        System.out.println(t.peekMax());
        System.out.println(t.pop());
        System.out.println(t.top());
    }

    static class MaxStack {
        Node head;
        Node tail;
        int time;

        // we also can use maxheap, but remove will be o(n)...so bbst is much better
        TreeSet<Node> treeSet = new TreeSet<>((a, b) -> {
            if(a.val == b.val) {
                return a.timeStamp - b.timeStamp;// we here treat as  5.1, 5.2, ... FINALL
            }
            return a.val - b.val;
        });

        public MaxStack() {
            time = 0;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            //idx = 0;
        }

        public void push(int x) {
            //time ++
            //insert in both dll and treeset;
            System.out.println("push");
            Node newNode = new Node(x, time);
            time++;
            Node prev = tail.prev;

            newNode.prev = prev;

            newNode.next = tail;
            prev.next = newNode;
            tail.prev = newNode;

            treeSet.add(newNode);
        }

        public int pop() {
            System.out.println("pop");
            //remove from treeset and dll;last one

            Node del = tail.prev;
            int res = del.val;
            remove(del);
            return res;
        }

        public int top() {
            //peek
            System.out.println("peek");
            return tail.prev.val;
        }

        public int peekMax() {
            System.out.println("peekmax");
            return treeSet.last().val;
        }

        public int popMax() {
            //find out which and remove
            System.out.println("popmax");
            Node del = treeSet.last();
            int res = del.val;
            remove(del);
            return res;
        }

        //remove spicific node from dll and treeset
        private boolean remove(Node node){
            System.out.println("remove");

            Node next = node.next;
            Node prev = node.prev;
            System.out.println("1");

            next.prev = prev;
            System.out.println(prev);
            prev.next = next;
            System.out.println("3");
            //ALSO remove from treeset
            treeSet.remove(node);
            return true;
        }

        static class Node{
            Node prev;
            Node next;
            int val;
            int timeStamp;
            public Node(int v, int t){
                val = v;
                timeStamp = t;
            }
            @Override
            public String toString(){
                return ""+val +", t:"+timeStamp;
            }
        }
}

}
