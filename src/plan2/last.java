package plan2;

public class last {
    public String nearestPalindromic1(String n) {
        //10000   234, 999,1000,  these numbers- 12932, 99800, 12120
        //closest integer (not including itself),
        //corner case
        if (n == null || n.length() == 0) {
            return n;
        }

        if (n.length() == 1) {
            int tmp = Integer.parseInt(n);
            if (tmp >= 1) {
                return String.valueOf(tmp - 1);
            } else {
                return "";
            }
        }
        int pre = Integer.parseInt(n);
        if (n.charAt(n.length() - 1) == '0') {
            pre--;
        }

        int len = String.valueOf(pre).length();
        if (len % 2 == 0) {
            // even
        } else {
            //odd
        }
        return null;
    }


    private boolean isPalin(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }


    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    //ssolution from LC
    public String nearestPalindromic(String n) {
        char[] arr = n.toCharArray();
        int left = 0;
        int right = n.length() - 1;
        while(left < right){
            arr[right--] = arr[left++];
        }

        String curP = String.valueOf(arr);
        String preP = nearestPalindrom(curP, false);
        String nextP = nearestPalindrom(curP, true);

        long num = Long.valueOf(n);
        long cur = Long.valueOf(curP);
        long pre = Long.valueOf(preP);
        long next = Long.valueOf(nextP);

        long d1 = Math.abs(num - pre);
        long d2 = Math.abs(num - cur);
        long d3 = Math.abs(num - next);

        if (num == cur) {
            return d1 <= d3 ? preP : nextP;
        } else if (num > cur) {
            return d2 <= d3 ? curP : nextP;
        } else {
            return d1 <= d2 ? preP : curP;
        }
    }

    private String nearestPalindrom(String curP, boolean dir) {
        int k = curP.length() >> 1;
        int p = curP.length() - k;
        int l = Integer.valueOf(curP.substring(0, p));

        l += (dir ? 1 : -1);

        if (l == 0) {
            return k == 0 ? "0" : "9";
        }

        StringBuilder left = new StringBuilder(String.valueOf(l));
        StringBuilder right = new StringBuilder(left).reverse();
        if (k > left.length()) {
            right.append("9");
        }

        return left.append(right.substring(right.length() - k)).toString();
    }


}
