package slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class longest3contigus {


    public static void main(String[] args) {
        longest3contigus t = new longest3contigus();
        int[] f = new int[]{2,3,4,4,5,5};
        System.out.println(t.isPossible(f));
    }



    public boolean isPossible(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, Integer> worked = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            int cur = nums[i];
            if (map.get(cur) == 0 ){
                continue;
            } else if (worked.getOrDefault(cur, 0) > 0 ) {//cur can append toi some one already valid
                worked.put(cur, worked.get(cur) - 1);
                worked.put(cur + 1, worked.getOrDefault(cur + 1 , 0) + 1);
            } else if( map.getOrDefault(cur + 1, 0) > 0 && map.getOrDefault(cur + 2, 0) > 0){//cur can be a valid start of 3 contigous of some
                map.put(cur + 1, map.get(cur + 1) - 1);
                map.put(cur + 2, map.get(cur + 2) - 1);
                worked.put(cur + 3, worked.getOrDefault(cur + 3, 0) + 1);
            } else {
                return false;
            }
            map.put(cur, map.get(cur) - 1);
        }
        return true;
    }


}
