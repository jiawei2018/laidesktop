package test001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class testlinkedlistmerge {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode head = l1;
        for(int i = 0; i < 8; i++){
            l1.next = new ListNode(10 - i);

            l1 = l1.next;
        }
       // System.out.println(l1);
       // System.out.println(head);
        testlinkedlistmerge t = new testlinkedlistmerge();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        System.out.println(head);
        t.sortList(head);
        System.out.println(dummy.next);
        StringBuilder sb = new StringBuilder();
        //sb.ap
        Map<Integer, Integer[]> map = null;
        List<Integer> r  = new ArrayList<>();
        for(int i : r){
            System.out.println(i);
        }
    }



    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //WRONG VERSION
//        while(fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }


        //System.out.println(slow.val + "   " + head.val);
        ListNode halfhead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(halfhead);
        return  merge(left, right);
    }


    private ListNode merge(ListNode ln1, ListNode ln2){
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(ln1 != null && ln2 != null){
            if(ln1.val < ln2 .val){
                res.next = ln1;
                ln1 = ln1.next;
            } else {
                res.next = ln2;
                ln2 = ln2.next;
            }
            res = res.next;
        }
        res.next = ln1 == null ? ln2 : ln1;
        return dummy.next;
    }

}
class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }

       @Override
        public String toString(){
           String s = "";
           ListNode cur = next;
           while(cur != null){
               s += String.valueOf(cur.val) + " -> ";
               // cur.next = next;
                cur = cur.next;
           }
           return s;
       }
   }