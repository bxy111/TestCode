package Practice1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) {
        Class<Fruit> fruitClass = Fruit.class;
        try {
            Constructor<Fruit> constructor = fruitClass.getConstructor();
            Fruit fruit = constructor.newInstance();

            Constructor<Fruit> constructor1 = fruitClass.getDeclaredConstructor(int.class);
            constructor1.setAccessible(true);
            Fruit fruit1 = constructor1.newInstance(10);

            System.out.println(fruit);
            System.out.println(fruit1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Fruit {
    private int num;

    public Fruit() {
    }

    private Fruit(int num) {
        this.num = num;
    }

    public void set(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "num=" + num +
                '}';
    }
}
