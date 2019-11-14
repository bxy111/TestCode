package Practice2;

public class A {
    public String name;
    public int age;

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void speek() {
        System.out.println("A在说话");
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class B extends A {
    public String name;

    public B(String name, int age) {
        super(name, age);
        this.name = name + "123";
    }

    @Override
    public void speek() {
        System.out.println("B在说话");
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                "age=" + age +
                '}';
    }
}