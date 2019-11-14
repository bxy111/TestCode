package practice5;

import java.util.Scanner;

public class Test {
    //    private static Num num = new Num();
    private static int guess = 0;
    private static Object guessObj = new Object();
    private static int src = 0;
    private static boolean isRight = false;
    private static Object isRightObj = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName() + " 产生的随机数是:");
                src = (int) (Math.random() * 100 + 1);
                System.out.println(src);

                while (true) {
                    synchronized (guessObj) {
                        try {
                            guessObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        while (guess != src) {
                            try {
                                if (guess > src) {
                                    System.out.println(Thread.currentThread().getName() + " 猜大了");
                                } else {
                                    System.out.println(Thread.currentThread().getName() + " 猜小了");
                                }
                                synchronized (isRightObj) {
                                    isRight = false;
                                    isRightObj.notify();
                                }
                                guessObj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + " 猜对了，恭喜");
                        synchronized (isRightObj) {
                            isRight = true;
                            isRightObj.notify();
                        }
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
                    synchronized (isRightObj) {
                        while (!isRight) {
                            System.out.println(Thread.currentThread().getName() + " 请用户输入猜测的数字:");
                            synchronized (guessObj) {
                                guess = scanner.nextInt();
                                guessObj.notify();
                            }
                            try {
                                isRightObj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 线程退出");
            }
        }).start();
    }
}
