package AAAAAAAAAAAAA;

public class LambdaLearn {
    static class L1 implements Love{
        @Override
        public void make() {
            System.out.println("ml2");
        }
    }

    public static void main(String[] args) {


        class L2 implements  Love{
            @Override
            public void make() {
                System.out.println("ml3");
            }
        }


        Love love = new Love() {
            @Override
            public void make() {
                System.out.println("ml4");
            }
        };



        Love love1 = () -> {
            System.out.println("  m  ll");
        };
        love.make();


        Love2 l2 = (int i ) -> {
            System.out.println(" mmmlll" + i);
        };

         l2 = (i) -> {
            System.out.println(" mmmlll" + i);
        };

         l2 = i -> {
            System.out.println(" mmmlll" + i);
        };


        l2 = i -> System.out.println(" mmmlll" + i);

         l2.mk2(123);

    }
}

interface Love{
    void make();
}


interface Love2{
    void mk2(int i);
}