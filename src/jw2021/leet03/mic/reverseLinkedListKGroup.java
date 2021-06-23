package jw2021.leet03.mic;

public class reverseLinkedListKGroup {
      static class ListNode {
       int val;
         ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
       @Override
       public String toString(){
           StringBuilder sb = new StringBuilder();
           sb.append(" [val:" + this.val + "] ");
           ListNode  pr = next;
           while(pr != null){
               sb.append(" [val:" + pr.val + "] ");
               pr = pr.next;
           }
           return sb.toString();
       }
     }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = h1;
        h1.next = new ListNode(2);
        h1 = h1.next;
        h1.next = new ListNode(3);

        reverseLinkedListKGroup t = new reverseLinkedListKGroup();
        ListNode rr = t.reverseKGroup(h2, 3);

        printsl(h2);
        printsl(rr);
    }

    private static void printsl(ListNode sss){
        System.out.println("####");
        while(sss != null){
            System.out.print(sss.val);
            System.out.print(",");
            sss = sss.next;
        }
        System.out.println("####");
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }
        //reverse start from head, so we need a dummy
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next = reverse(prev, k);
        while(next != null) {
            System.out.println(next.val);
            next = reverse(next, k);
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k){
        //reverse reverse head.next as head's k nodes
        //and return the next start of the group
        //return null if there are not enough k node till end;
        // h>1>2>3>4   k = 2
        //     i
        //
// for(语句A; 语句B; 语句C){
//    //循环体
// }
// 语句A→（语句B → 循环体 → 语句C）→（语句B → 循环体 → 语句C）→ ... →退出循环
        //d>1>2>3>n
        //      i
        ListNode tmp = head;
        ListNode tail = head.next;
        //find out n or tail;
        for(int i = 0; i < k; i++) {
            tmp = tmp.next;
            //System.out.println(tmp.val + "   <<tmp");
            if(tmp == null && i <= k - 1 ){
                return null;
            }
        }
        //System.out.println(tmp.val + "   <<tmp");

        ListNode last = tmp.next;//h>1>2>3>null tmp = 3;
        //last is null
        ListNode cur = tail;
        System.out.println(cur.val + "   <<curA");
        while(cur != tmp ) {
            System.out.println(cur.val + "   <<cur");
            head.next = cur.next;//h>2
            //tmp.next = cur;//2>1
            cur.next = last;//bug is here
            last = cur;
            tmp.next = cur;//1>3
            cur = head.next;//cur>2
        }

        return tail;
    }
}
