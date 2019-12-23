package myUS;

public abstract class Spy {
    String name;
    int classify;
    SpyType type;
    public Spy(String name, int classify, SpyType type){
        this.name = name;
        this.classify = classify;
        this.type = type;
    }


    public abstract DNA getDNA(DNA_method method);

    public abstract void findTarget(Target target);

    public abstract boolean unionFind(Spy spy);


    public String toString(){
       return name;
    }
}
