package practice4;

import java.util.Scanner;

public class Test {
    private static char target;

    public static char getRandomChar() {
        target = (char) (0x8e00 + (int) (Math.random() * (0x8f00 - 0x8e00 + 1)));
        return target;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("请用户输入这个中文:");
                System.out.println(getRandomChar());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("请输入:");
                Scanner scanner = new Scanner(System.in);
                String next = scanner.next();
                if (String.valueOf(target).equals(next)) {
                    System.out.println("输入正确");
                } else {
                    System.out.println("输入错误");
                }
            }
        }).start();
    }
}
