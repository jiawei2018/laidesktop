package String_I;

public class rabinKarp {
    public static void main(String[] args) {
        String s1 = "山下还有一天行程的地方，有座跳跃的溪流从隘口一路流下，在松树耸峙而成的高墙间开出一条道路";
        String s2 = "路";
        rabinKarp t = new rabinKarp();
        System.out.println(t.rabinKarp(s1, s2)) ;
    }

    public int rabinKarp(String large, String small){
        //this method is to determin if small is substring of  large
        if(small.length() > large.length()){
            return -1;
        }
        if(small.length() == 0){
            return 0;
        }
        //large prime to fit our collision  needs eg. when met abc ,we need > 26 when asc we need >256..
        int largeprime = 101;//we can use 997, 9999991, 999983
        int prime = 31;

        int seed = 1;
        int targetHash = small.charAt(0) % largeprime;

        for(int i = 1; i < small.length(); i++){
            seed = moduleHash(seed, 0, prime, largeprime);
            targetHash = moduleHash(targetHash, small.charAt(i), prime, largeprime);
        }

        int hash = 0;
        for(int i = 0; i < small.length(); i++){
            hash = moduleHash(hash, large.charAt(i), prime, largeprime);
        }
        if(hash == targetHash && equals(large, 0, small)){
            return 0;
        }

        for( int i = 1; i < large.length() - small.length(); i++){
            hash = nonNegative(hash - seed * large.charAt(i - 1)% largeprime, largeprime);
            hash = moduleHash(hash, large.charAt(i + small.length() - 1), prime, largeprime);

            if(hash == targetHash && equals(large, i, small)){
                return i;
            }
        }
        return -1;
    }

    public  boolean equals(String large, int start, String small){
        for(int i = 0; i < small.length(); i++){
            if(small.charAt(i) != large.charAt(start + i)){
                return false;
            }
        }
        return true;
    }


    private int moduleHash(int hash, int addition, int prime, int largePrime) {
        return (hash * prime % largePrime + addition) % largePrime;
    }

    private int nonNegative(int hash, int largePrime){
        if(hash < 0){
            hash += largePrime;
        }
            return hash;
    }



}
