package Practice3;

public class Animal {
    public void bark() {
        System.out.println("动物叫。。。");
    }
}

class Cat extends Animal {
    @Override
    public void bark() {
        System.out.println("喵喵。。。");
    }
}

class Dog extends Animal {
    @Override
    public void bark() {
        System.out.println("汪汪。。。");
    }
}
