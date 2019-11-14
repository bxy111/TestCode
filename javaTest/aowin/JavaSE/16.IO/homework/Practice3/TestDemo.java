package Practice3;

import java.io.*;

public class TestDemo {
    public static void main(String[] args) {
        FileReader fr= null;
        FileWriter fileWriter = null;

        try {
            fr = new FileReader("src\\Practice3\\data.txt");
            fileWriter = new FileWriter("src\\Practice3\\data.txt");

            fileWriter.write("3.1415926");
            fileWriter.flush();

            char[] chars = new char[64];
            fr.read(chars);
            System.out.println(Double.valueOf(String.valueOf(chars)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
