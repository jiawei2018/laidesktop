package sample;

public class shuffle {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        shuffle t = new shuffle();

        for(int i = 0 ; i < 100; i++){
            t.shuffle(a);
            //System.out.println(a.toString());
        }

    }
    public void shuffle(int[] array) {
        // Write your solution here.
        if(array.length < 2){
            return;
        }
        for(int i = 0; i < array.length; i++){
            int curlen = array.length - i;
            int rand = (int)( Math.random() * curlen);
            System.out.println(rand);
            swap(array, i + rand, i);
        }


    }

    private void swap(int[] array, int idxa, int idxb){
        int temp = array[idxa];
        array[idxa] = array [idxb];
        array[idxb] = temp;
    }
}
