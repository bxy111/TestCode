package Practice4;

import java.util.Scanner;

public class ReadLineDemo {
    public static void main(String[] args) {
        ReadLineDemo readLineDemo = new ReadLineDemo();
        try {
            readLineDemo.readData();
        } catch (EmptyStringException e) {
            e.printStackTrace();
        } catch (IncludeNumberException e) {
            e.printStackTrace();
        }
    }

    public void readData() throws EmptyStringException, IncludeNumberException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一行:");
        String line = scanner.nextLine();
        if ("".equals(line)) {
            throw new EmptyStringException("input is empty string");
        } else if (containNum(line)) {
            throw new IncludeNumberException("input contain num");
        }
    }

    public boolean containNum(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                return true;
            }
        }
        return false;
    }
}
