package bit;

public class hexrep {
    public static String hex(int number) {
        // Write your solution here
        char[] map = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            sb.append(map[number % 16]);
            number /= 16;
        }
        return sb.append("x0").reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(hex(9999));
    }
}
