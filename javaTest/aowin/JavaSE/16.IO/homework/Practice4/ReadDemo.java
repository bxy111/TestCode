package Practice4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadDemo {
    public static void main(String[] args) {
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("src\\Practice4\\data.txt"));

            Object o = objectInputStream.readObject();
            if (o instanceof Member) {
                System.out.println((Member)o);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
