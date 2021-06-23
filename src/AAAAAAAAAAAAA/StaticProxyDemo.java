package AAAAAAAAAAAAA;
/*
* proxy and real obj implement same interface
*proxy proxys the real obj
*
* */
public class StaticProxyDemo {
    public static void main(String[] args) {

        new Thread(() -> System.out.println("something")).start();
        new MaZai(new Me("n")).gohouGong();

        MaZai mz1 = new MaZai(new Me("wei"));

        mz1.gohouGong();
    }


}

interface HouGong{
    void gohouGong();
}


class Me implements HouGong{
    private String me;
    public Me(String name){
        this.me = name;
    }

    @Override
    public void gohouGong() {
        System.out.println(me + " going to hou gong");
        System.out.println(me + " shuang!");
    }
}


class MaZai implements  HouGong{

    private HouGong person;
    public MaZai(HouGong person){
        this.person = person;
    }

    @Override
    public void gohouGong() {
        before();
        this.person.gohouGong();
        after();
    }

    private void after() {
        System.out.println("clean up");
    }

    private void before() {
        System.out.println("get girls ready.");
    }
}