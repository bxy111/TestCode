//5.定义一个名为Vehicles（交通工具的类），该类中包含String类型的成员属性brand(商标)和color(颜色)，
//        还应包含方法run(行驶，在控制台显示"我已经开动了")和showInfo（显示信息，在控制台显示商标和颜色）
public class Vehicles {
    private String brand;
    private String color;

    public Vehicles(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public static void main(String[] args) {
        Vehicles v = new Vehicles("benz", "black");
        v.run();
        v.show();
    }

    public void run() {
        System.out.println("我已经开动了");
    }

    public void show() {
        System.out.println("brand=" + brand + ", color=" + color);
    }
}
