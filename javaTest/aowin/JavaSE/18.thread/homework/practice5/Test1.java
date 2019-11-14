package practice5;

import java.util.Scanner;

public class Test1 {
    private static Num num = new Num();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName() + " 产生的随机数是:");
                num.setSrc((int) (Math.random() * 100 + 1));
                System.out.println(num.getSrc());

                while (true) {
                    synchronized (num) {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        while (num.getGuess() != num.getSrc()) {
                            try {
                                if (num.getGuess() > num.getSrc()) {
                                    System.out.println(Thread.currentThread().getName() + " 猜大了");
                                } else {
                                    System.out.println(Thread.currentThread().getName() + " 猜小了");
                                }
                                num.notifyAll();
                                num.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + " 猜对了，恭喜");
                        num.notifyAll();
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 线程退出");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    synchronized (num) {
                        while (num.compare() != 0) {
                            System.out.println(Thread.currentThread().getName() + " 请用户输入猜测的数字:");
                            num.setGuess(scanner.nextInt());
                            try {
                                num.notifyAll();
                                num.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        num.notifyAll();
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 线程退出");
            }
        }).start();
    }
}
