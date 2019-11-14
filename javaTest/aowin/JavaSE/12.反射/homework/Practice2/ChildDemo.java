package Practice2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ChildDemo {
    public static void main(String[] args) {
        Class<Child> childClass = Child.class;
        try {
            Method eat = childClass.getDeclaredMethod("eat", int.class);
            Child child = childClass.newInstance();
            eat.invoke(child, 5);
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

class Child {
    public void eat(int num) {
        System.out.println("吃了" + num + "个苹果。");
    }
}
