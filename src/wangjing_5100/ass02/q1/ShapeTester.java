package wangjing_5100.ass02.q1;

public class ShapeTester {
    public static void main(String[] args) {
        Shape shape1 = new Shape("Shape1", "pink");
        System.out.println("shape1");
        System.out.println(shape1.printShape());
        Shape shape2 = new Shape("Shape2", "orange", 20, 30);
        System.out.println("shape2");
        System.out.println("area : " + shape2.getArea() + " perimeter : " + shape2.getPerimeter());  System.out.println(shape2.printShape());
        Rectangle rectangle1 = new Rectangle(2);
        System.out.println("rectangle1");
        System.out.println("area : " + rectangle1.getArea() + " perimeter : " + rectangle1.getPerimeter());
        Rectangle rectangle2 = new Rectangle("Rectangle", "Purple",4, 7);
        System.out.println("rectangle2");
        System.out.println("area : " + rectangle2.getArea() + " perimeter : " + rectangle2.getPerimeter());  System.out.println(rectangle2.printShape());
        Square square1 = new Square(3);
        System.out.println("square1");
        System.out.println("area : " + square1.getArea() + " perimeter : " + square1.getPerimeter());
        Square square2 = new Square("Square" , "black", 7);
        System.out.println("square2");
        System.out.println("area : " + square2.getArea() + " perimeter : " + square2.getPerimeter());  System.out.println(square2.printShape());
    }

}
