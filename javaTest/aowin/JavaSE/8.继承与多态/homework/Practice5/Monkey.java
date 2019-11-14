package Practice5;

public class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("咿咿呀呀......");
    }
}

class People extends Monkey {

    public People(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("小样的，不错嘛！会说话了！");
    }

    public void think() {
        System.out.println("别说话！认真思考！");
    }

    public static void main(String[] args) {
        Monkey m = new Monkey("monkey");
        People n = new People("people");

        m.speak();
        n.speak();
        n.think();
    }
}
