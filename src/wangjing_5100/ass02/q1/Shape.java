package wangjing_5100.ass02.q1;

public class Shape {
    //Fields : name, color, area, perimeter
    //Constructors :
    //Shape(name, color)
    //Shape(name, color, perimeter, area)
    //1) Create getter and setter methods for all classes.
    //2) Create printShape() method in Shape class that returns desired string output.
    //3) Override the getArea() and getPerimeter() getter methods of Shape in Rectangle and Square to give desired output.

    private String name;
    private String color;
    private int area, perimeter;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }


    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Shape(String name, String color, int perimeter, int area) {
        this.name = name;
        this.color = color;
        this.perimeter = perimeter;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String printShape() {
        return "The " + name + " has a " + color + " color";
    }

}
