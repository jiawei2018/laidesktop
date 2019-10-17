package slidingWindows;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class containsDupII {
    public static void main(String[] args) {
        containsDupII t = new containsDupII();
        int[] is = {1,2,3,1};
        System.out.println(t.containsNearbyDuplicate(is, 3));
        TreeSet<Integer> f = new TreeSet<>();
        f.ceiling(5);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
            if(i > k){
                //remove leftmost
                set.remove(nums[i - k]);
            }
            if(!set.add(i)){
                return true;
            }
            System.out.println(set);
        }
        return false;
    }
}
