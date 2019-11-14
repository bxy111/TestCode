package practice2;

public class DeadLockTest {
    private static String obj1 = new String("");
    private static String obj2 = new String("");

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + " get obj1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + " get obj2");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + " get obj2");
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread().getName() + " get obj1");
                    }
                }
            }
        }).start();
    }
}
