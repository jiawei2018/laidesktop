package debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc386 {
    public static void main(String[] args) {
        lc386 t = new lc386();
        System.out.println(t.lexicalOrder(132));
        System.out.println(count);
    }

    public List<Integer> lexicalOrder(int n) {
        if(n == 1) {
            return Arrays.asList(1);
        }
        List<Integer> res = new ArrayList<>();
        //count = 0;
        recur(res, n, 0);
        return res;
    }
    static int count = 0;
    private void recur(List<Integer> res, int n, int prev) {
        count++;
        if(prev > 0) {
            res.add(prev);
            //return;
        }
        if(prev > 0) {
            int next = prev * 10;
            if(next <= n) {
                recur(res, n, next);
            }
        }
        for(int i = 1; i <= 9; i++) {
            int next = prev * 10 + i;
            if(next <= n) {
                recur(res, n, next);
            }
        }

    }
}
