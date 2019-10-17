package bit;

public class allUnique_I {
    public boolean allUnique(String word) {
        // Write your solution here
        if(word.length() > 26){
            return false;
        }
        int map = 0;
        for(int i = 0; i < word.length(); i++){
            int tmp = word.charAt(i) - 'a';
            if(  ((map >> tmp) & 1)== 1){
                return false;
            }else{
                map |= (1 << tmp);
            }
        }
        return true;
    }
}
