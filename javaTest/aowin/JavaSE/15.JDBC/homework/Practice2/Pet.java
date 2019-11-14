package Practice2;

public class Pet {
    private int id;
    private String name;
    private String type;
    private String color;
    private double price;

    public Pet(int id, String name, String type, String color, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public Pet(String name, String type, String color, double price) {
        this.id = 0;
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
