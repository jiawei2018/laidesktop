package dp1;

public class jujmp {
    public static boolean canJump(int[] array) {
        // Write your solution here
        if(array.length == 1){
            return array[0] >= 1;
        }
        boolean[] can = new boolean[array.length];
        can[can.length - 1] = true;
        for(int i = array.length - 2; i >= 0; i-- ){
            if(i + array[i] >= array.length - 1){
                can[i] = true;
            }else{
                for(int j = array[i]; j >= 1; j--){
                    if(can[i + j]){
                        can[i] = true;
                    }
                }

            }
        }

        Math.random();
        return can[0];
    }

    public static void main(String[] args) {
        int[] a = {2,1,1,0,3};
        System.out.println(canJump(a));
    }
}
