package mytest;

public class sqrttest {
    public long mysqrt(long nums) {

        long left = 1;
        long right = nums;
        int count = 0;
        while (left <= right) {
            count++;
            long mid = left + (right - left) / 2;// remember every time overflow
            if (mid == nums / mid || (mid < nums / mid) && ((mid + 1) > nums / (mid + 1))) {
                System.out.println(count + "   1");
                return mid;
            } else if (mid < nums / mid) {//remember this !!!!!!!!!!
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public long sq2(long num) {

        long tmp;
        long init = num >> 1;// meanss /2
        int count = 0;
        while (true) {
            count++;
            tmp = init;
            init = (init + num / init) / 2;
            if (tmp == init || tmp < init) {
                break;
            }
        }
        System.out.println(count + "  << newton ");
        return tmp;
    }


    public static void main(String[] args) {
        sqrttest t = new sqrttest();
        long ins = 99999999999l;
        System.out.println(t.mysqrt(ins) + "   <<binary search");
        System.out.println(t.sq2(ins) + "   newton");
        System.out.println(Math.sqrt(ins) + "     <<3");
    }
}
