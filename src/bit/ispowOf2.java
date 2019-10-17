package bit;

public class ispowOf2 {
    public static void main(String[] args) {
        isPowerOfTwo(-2147483648);
    }
    public static boolean isPowerOfTwo(int number) {
        // Write your solution here
//        if(number <= 0){
//            return false;
//        }


        //we dont need check, if negative, must
        int count = 0;
        while(number > 0){//make sure number is positive ,otherwise count == 0
            count += (number & 1);
            number >>= 1;
        }
        return count == 1;
    }

    // return ((number & (number - 1)) == 0) && (number > 0);
}
