package Practice2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDemo {
    public static void main(String[] args) {
        File file = new File("src\\Practice2\\file.txt");
        FileInputStream fileInputStream = null;
        PrintStream ps = System.out;

        try {
            fileInputStream = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buf)) != -1) {
                ps.write(buf, 0, len);
                ps.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ps.println();
        ps.print("文件名：");
        ps.println(file.getName());
        ps.print("文件路径：");
        ps.println(file.getAbsolutePath());
        ps.print("文件最后修改时间：");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ps.println(simpleDateFormat.format(new Date(file.lastModified())));
        ps.print("文件大小：");
        ps.println(file.length());

        if (ps != null) {
            ps.close();
        }
    }
}
