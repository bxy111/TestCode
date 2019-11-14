package Practice4;

import java.io.*;

public class WriteDemo {
    public static void main(String[] args) {
        ObjectOutputStream objectOutputStream = null;

        try {
//            objectInputStream = new ObjectInputStream(new FileInputStream("src\\Practice4\\data.txt"));
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\Practice4\\data.txt"));

            objectOutputStream.writeObject(new Member("xiaoming", "123456", "男", "浙江杭州"));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
