package String_II;

/**
 *
 ReOrder Array
 Description
 Given an array of elements, reorder it as follow:

 { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

 { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

 Try to do it in place.

 Assumptions

 The given array is not null
 Examples

 { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }

 { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }

 { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
 */
public class reorderArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        reorderArray t = new reorderArray();
        System.out.println(t.reorder(a));
    }
    public int[] reorder(int[] array) {
        // Write your solution here
        //一个有代表性的题,一定牢记这个分析过程
        if(array.length < 2 || array == null){
            return array;
        }
        if(array.length % 2 == 0){
            recur(array, 0, array.length - 1);
        }else{
            recur(array, 0, array.length - 2);// like
            // abcd123   -> a1b2c3b
        }
        return array;
    }


    private void recur(int[] nums, int left, int right){
        //there are 4 parts to solve
        // 0, leftmid  , mid , rightmid , right
        //base case
        int len = right - left + 1; // very important +1!!!!! think why ??
                                    // try to think array.length is lastidx +1!!
        if(len <= 2){
            return;
        }
            //a b c| d e f g |1 2 3| 4 5 6 7
            //l      lm       m      rm    r

        int mid = left + len / 2;
        int leftmid = left + len / 4;
        int rightmid = mid + len / 4; //or = left + len * 3 / 4;
        System.out.println(mid);
            //a b c| d e f g |1 2 3| 4 5 6 7
            //l      lm       m      rm    r
            // 注意着三个 -1;

        reverse(nums, leftmid, mid - 1); // g f e d 123
        reverse(nums, mid, rightmid - 1);// gfed321

        // 123gfed
        reverse(nums, leftmid, rightmid - 1);//order must be like this !  why??
        //but uf this line goes first we have
        //1: 3 2 1 g f e d
        // 2: ->  g 1 2 3  fed
        //3: g123def




        //start recursion
        // or we use
        //int newmid = left + (leftmid - left) * 2;

        //very important
        System.out.println(mid);
        System.out.println(left + (leftmid - left) * 2 + "   <<<");
        recur(nums, left, left + (leftmid - left) * 2 - 1);// think why not left to ?mid - 1
        // because mid changes after call reverse() method!!!!!!!!!!!!!!!!!!!
                                                                // video string_II 55'37"
        recur(nums, left + (leftmid - left) * 2 , right); // think why not mid to right?
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
