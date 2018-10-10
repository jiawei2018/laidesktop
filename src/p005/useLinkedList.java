package p005;

public class useLinkedList {
    class ListNode{
        int value;
        ListNode next;
        public ListNode(int val){
            this.value = val;
        }
    }


    class Stack{
        int length;
        ListNode head;

        public boolean  push(int val){
            ListNode tmp = new ListNode(val);
            tmp.next = head;
            head = tmp;
            length++;
            return true;
        }

        public Integer  pop(){
            if(head != null){
                int res = head.value;
                head = head.next;
                length--;
                return res;
            }else
            return null;
        }

        public Integer peek(){
            if(head != null){
               // head = head.next;
               // length--;
                return head.value;
            }else
                return null;
        }


        public int size(){
            return length;
        }

        public boolean isEmpty(){
            return head == null;
        }

    }


    class Queue{
        int length;
        ListNode head;
        ListNode tail;

        public boolean offer(int val){
//            ListNode tmp = new ListNode(val);           wrong answer
//            while(tail.next != null){
//                tail = tail.next;
//            }
//
//            tail.next = tmp;
//            tail = tmp;

            if(head == null){
                head = new ListNode(val);
                tail = head;
            }else{
                tail.next = new ListNode(val);
                tail = tail.next;
            }
                return true;
        }

        public Integer poll(){
            if(head != null){
                int res = head.value;
                head = head.next;
                length--;
                return res;
            }else
            return null;
        }

        public int size(){
            return length;
        }

        public Integer peek(){
            if(head != null){
                int res = head.value;
                return res;
            }else
            return null;
        }

        public boolean isEmpty(){
            return head == null;
        }

    }

   ///////////////////////////////////////////with array


   class StackB{
        int[] nums = new int[10];//assume length is big enough
        int headidx = 0;
        int tailidx = 1;
        int size;

        public boolean push(int val){
            if(tailidx == nums.length - 1){
                System.out.println("Stack full!!");
                return false;//stack full!
            }

            nums[tailidx] = val;
            size++;
            tailidx++;
            return true;
        }

        public Integer pop(){
            if(tailidx > headidx && size > 0){
                int tmp = nums[tailidx - 1];
                tailidx--;
                size--;
                return tmp;
            }else
            return null;
        }

        public Integer peek(){
            if(tailidx > headidx && size > 0){
                int tmp = nums[tailidx - 1];
                return tmp;
            }else
                return null;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0 ;
        }


   }






    class QueueB{
        int[] nums = new int[10];
        int headidx = 0;
        int tailidx = 1;
        int size;
        // if tail = head +1 is empty, if tail = head, full
        //circular array!
        public boolean offer(int val){
            if(tailidx == headidx){//not full
                System.out.println("Queue full!!");
                return false;
            }
            nums[tailidx] = val;
            size++;
            if(tailidx == nums.length - 1 && headidx != 0){
                tailidx = 0;
            }else
                tailidx++;
            return true;
        }

        public Integer poll(){
            if(size != 0){
                if(headidx < nums.length - 1){
                    headidx++;
                    size--;
                    return nums[headidx + 1];
                }else{
                    headidx =0;
                    size--;
                    return nums[headidx];
                }
            }else
            return null;
        }

        public Integer peek(){
            if(size != 0){
                if(headidx < nums.length - 1){
                    return nums[headidx + 1];
                }else{
                    return nums[0];
                }
            }else
                return null;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

    }





}
