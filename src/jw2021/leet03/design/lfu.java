package jw2021.leet03.design;

import java.util.HashMap;
import java.util.Map;

public class lfu {

    public static void main(String[] args) {
        LFUCache t = new LFUCache(2);
        //["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

        t.put(1,1);
        t.put(2,2);
        t.get(1);
        t.put(3,3);
        t.get(2);
        t.get(3);
        t.put(4,4);
        t.get(1);
        t.get(3);
        t.get(4);

    }

    static class LFUCache {
        Map<Integer, Node> map;
        Map<Integer, DLL> dllMap;
        int minFreq;
        final int limit;
        int count;
        public LFUCache(int capacity) {
            limit = capacity;
            map = new HashMap<>();
            dllMap = new HashMap<>();
            count = 0;
        }

        public int get(int key) {
            //if we have then return the val and then update the freq for that node;
            if(!map.containsKey(key)){
                return -1;
            }
            Node cur = map.get(key);
            update(cur);

            return cur.val;
        }

        private void update(Node node){
            //find out the node, remove from origional dll and added to new dll;
            DLL cur = dllMap.get(node.freq);
            cur.removeNode(node);
            int oldf = node.freq;
            // we also need to check the minfreq if this is only node then must del that dll and then
            //update hte minFreq!!!
            if(oldf == minFreq && cur.getNodeCount() == 0){
                //dllMap.remove(oldf);
                minFreq++;
            }

            int newf = oldf + 1;

            node.freq = newf;

            //if we have the new freq dll, then add to head; or we create a new dll
            //for this freq;
            if(dllMap.containsKey(newf)) {
                DLL dll = dllMap.get(newf);
                dll.addNode(node);
            } else {
                //create a new dll;
                DLL dll = new DLL();
                dll.addNode(node);
            }
        }

        private Node removeLeast(){
            DLL min = dllMap.get(minFreq);
            Node rm = min.delLast();
            count--;
            if(min.getNodeCount() == 0){
                dllMap.remove(minFreq);
                minFreq++;//looks like useless
            }
            return rm;
        }

        public void put(int key, int value) {

            // since 0 <= capacity we need to handle corner case cap == 0;
            if(limit == 0) {
                return;
            }
            //if this is old key  we need to update  the old one;
            if(map.containsKey(key)) {
                Node cur = map.get(key);
                cur.val = value;
                update(cur);
            } else {
                //new key chsck limit

                Node node = new Node(key, value, 1);
                if(count == limit) {
                    //need to remove one;
                    Node rm = removeLeast();
                    map.remove(rm.key);
                }
                minFreq = 1;//this is a new one, so start from 1;

                if(!dllMap.containsKey(minFreq)) {
                    dllMap.put(minFreq, new DLL());
                }
                DLL min = dllMap.get(minFreq);
                min.addNode(node);
                map.put(key, node);
                count++;
            }
        }

        class Node {
            int key , val, freq;
            Node prev;
            Node next;
            Node(){
            }
            Node(int k, int v, int f){
                key = k;
                val = v;
                freq = f;
            }
        }

        //doublely linkedlist
        class DLL{
            Node head;
            Node tail;
            int count;
            DLL(){
                head = new Node();
                tail = new Node();
                link(head, tail);
            }

            public void addNode(Node node) {
                //add to head; most recently
                Node next = head.next;
                link(head, node);
                link(node, next);
                count++;
            }

            public Node delLast(){
                Node cur = tail.prev;
                Node last = cur.prev;
                link(last, tail);
                count--;
                return cur;
            }

            public void removeNode(Node node){
                Node prev = node.prev;
                Node next = node.next;
                link(prev, next);
                count--;
            }

            private void link(Node a, Node b){
                a.next = b;
                b.prev = a;
            }

            public int getNodeCount(){
                return count;
            }
        }


    }
}
