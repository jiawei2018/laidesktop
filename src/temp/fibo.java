package temp;

public class fibo {
    public static long fibo(int k ){
        if(k <= 0){
            return 0;
        }

        int[] fibo = new int[k + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2; i <= k; i++){
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[k];
    }

    public static void main(String[] args) {
        System.out.println(fibo(0));

       for(int i = 0; i < 25; i ++){
           System.out.println(fibo(i));
       }
    }
}
