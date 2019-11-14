public class Practice2 {
    public static void main(String[] args) {
        Shop shop = new Shop(60);

        System.out.println(shop.getComputers()[54]);
    }
}

class Shop {
    private int num;
    private Computer[] computers;

    public Shop(int num) {
        this.num = num;
        computers = new Computer[num];
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                computers[i] = new Computer("Dell", i + 20);
            } else {
                computers[i] = new Computer("hp", i + 30);
            }
        }
    }

    public Computer[] getComputers() {
        return computers;
    }
}

class Computer {
    private String brand;
    private double price;

    public Computer(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
