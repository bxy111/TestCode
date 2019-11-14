package Practice3;

public abstract class GeometricObject {
    public String color;
    public String shape;

    public abstract double perimeter();

    public abstract double area();
}

class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        shape = "triangle";
        color = "red";
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double area() {
        double p = (side1 + side2 + side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
}

class Rectangle extends GeometricObject{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        shape = "rectangle";
        color = "blue";
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }

    @Override
    public double area() {
        return width * height;
    }
}