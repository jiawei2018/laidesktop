package bit;

public class numOfDiffBit {
    public int diffBits(int a, int b) {
        // Write your solution here
        int tmp = a ^ b;
        int count = 0;
        while(tmp != 0){
            count += (tmp & 1);
            tmp >>>= 1;// mistake must be this
        }
        return count;
    }
}
