package debug;

public class tetsOa111 {
    /*
    * oa changed from both side and then -> return refill times.
    *
    * */

    public static void main(String[] args) {
        int[] aa = {3,3,7,3,5};
        tetsOa111 t = new tetsOa111();
        System.out.println(t.solution(aa, 5, 7));
    }
    public int solution(int[] plants, int capacity1, int capacity2) {
        // write your code in Java SE 8
        //corner case
        if(plants.length <= 2){
            return 1;
        }
        int me = capacity1;
        int he = capacity2;
        int times = 2;
        int left = 0;
        int right = plants.length - 1;

        while(left < right){
            if(me < plants[left]){
                me = capacity1;
                times++;
            }
            me -= plants[left];
            if(he < plants[right]){
                he = capacity2;
                times++;
            }
            he -= plants[right];
            left++;
            right--;
        }
        //right -1 == left
        if(right == left){
            if(me + he < plants[plants.length / 2]){
                times++;
            }
        }
        return times;

    }
}
