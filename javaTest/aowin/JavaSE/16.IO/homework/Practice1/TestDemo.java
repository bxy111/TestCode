package Practice1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestDemo {
    public static void main(String[] args) {
        InputStream is = System.in;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src\\Practice1\\file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int data;
        System.out.println("请输入字符串,输入#号结束程序");
        while (true) {
            try {
                if (!((data = is.read()) != -1)) {
                    break;
                } else {
                    if (data == '#') {
                        break;
                    } else if (data >= 'a' && data <= 'z'){
                        data = data - 32;
                    }
                    fos.write(data);
                    fos.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
