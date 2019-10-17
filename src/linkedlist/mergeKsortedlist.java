package linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * WJ
 * Merge K Sorted Lists
 * Description
 * Merge K sorted lists into one big sorted list in ascending order.
 *
 * Assumptions
 *
 * ListOfLists is not null, and none of the lists is null.
 */
public class mergeKsortedlist {
      class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
          this.value = value;
          next = null;
        }
      }

        public ListNode merge(List<ListNode> listOfLists) {
            // Write your solution here/.
            PriorityQueue<ListNode> minheap = new PriorityQueue<>(new curCompareter());
            ListNode dummy = new ListNode(0);

            for(int i = 0 ; i < listOfLists.size(); i++){
                ListNode cur = listOfLists.get(i);
                //if(cur != null){
                    minheap.offer(cur);
               // }else{
               //     continue;
                //}
            }

            while(!minheap.isEmpty()){
                ListNode minHead = minheap.poll();
                dummy.next = minHead;
                dummy = dummy.next;
                minHead = minHead.next;
                if(minHead != null){
                    minheap.offer(minHead);
                }
            }

            return dummy.next;
        }



        class curCompareter implements Comparator<ListNode> {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.value == o2.value){
                    return 0;
                }
                return  o1.value < o2.value ? -1 : 1;
            }
        }

}
