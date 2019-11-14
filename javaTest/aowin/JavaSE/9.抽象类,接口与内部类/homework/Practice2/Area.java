package Practice2;

public interface Area {
    public double calculateArea();
}

class MyCircle implements Area {
    private double radius;

    public MyCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class MyRectangle implements Area{
    private double width;
    private double height;

    public MyRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
