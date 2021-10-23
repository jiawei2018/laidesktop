package wangjing_5100.ass02.q1;

public class Square extends Shape {
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    //Square: Inherits Shape
    //Fields: side
    //Constructors:
    //Square(side)
    //Square(name, color, side)
    private int side;
    public Square(String name, String color, int side) {
        super(name, color);
        this.side = side;
    }

    public Square(int side) {
        super("square", "golden");
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }

    @Override
    public int getPerimeter() {
         return 4 * side;
    }
}
