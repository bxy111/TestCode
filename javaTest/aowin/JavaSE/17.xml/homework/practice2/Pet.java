package practice2;

public class Pet {
    private String name;
    private String type;
    private String color;
    private double price;

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }
}
