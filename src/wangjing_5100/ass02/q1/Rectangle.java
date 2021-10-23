package wangjing_5100.ass02.q1;

public class Rectangle extends  Shape {


    //Rectangle: Inherits Shape
    //Fields : width, height
    //Constructors:
    //Rectangle(side) → If single side is given then set width and height to same value. Rectangle(width, height)
    //Rectangle(name, color, width, height)

    private int width;
    private int height;

    public Rectangle(String name, String color, int width, int height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }

    public Rectangle(int side) {
        super("rectangle", "blue");
        this.width = side;
        this.height = side;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getArea() {
        return width * height;
    }

    @Override
    public int getPerimeter() {
        return 2 * (width + height);
    }

}
