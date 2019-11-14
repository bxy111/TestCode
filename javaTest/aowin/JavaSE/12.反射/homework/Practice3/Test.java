package Practice3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入要查询的类全名（包名+类名）:");
        Scanner sc = new Scanner(System.in);
        String className = sc.next();

        Class treeNodeClass = null;
        try {
            treeNodeClass = Class.forName(className);
            System.out.println("-----------属性----------------");
            Field[] declaredFields = treeNodeClass.getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println(f);
            }
            System.out.println("-----------构造方法------------");
            Constructor<?>[] declaredConstructors = treeNodeClass.getDeclaredConstructors();
            for (Constructor cs : declaredConstructors) {
                System.out.println(cs);
            }
            System.out.println("-----------对象方法------------");
            Method[] declaredMethods = treeNodeClass.getDeclaredMethods();
            for (Method m : declaredMethods) {
                System.out.println(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
