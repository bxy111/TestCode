package Practice4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OuterDemo {
    public static void main(String[] args) {
        Class<Outter> outterClass = Outter.class;
        try {
            Outter outter = outterClass.newInstance();
            Field in = outterClass.getDeclaredField("in");
            in.setAccessible(true);
            Object o = in.get(outter);

            Class<?> aClass = o.getClass();
            Method test = aClass.getDeclaredMethod("test");
            test.setAccessible(true);
            test.invoke(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
