package prctice01;

public class mincut_other {

    public int minCuts(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        int[] minCut = new int[array.length + 1];
        for(int i = 1; i < minCut.length; i++){//here
            minCut[i] = i - 1;
            for(int j = 0; j < i; j++){
                if(isPalindrome(array, j, i - 1)){
                    if(j == 0){
                        minCut[i] = 0;
                    }else{
                        minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                    }
                }
            }
        }
        return minCut[minCut.length - 1];
    }


    private boolean isPalindrome(char[] array, int i, int j){
        while(i < j){
            if(array[i] != array[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        mincut_other t = new mincut_other();
        System.out.println(t.minCuts("aab"));

    }

}
