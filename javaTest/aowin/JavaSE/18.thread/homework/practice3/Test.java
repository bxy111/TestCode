package practice3;

public class Test {
    public static void main(String[] args) {
        TaskThread taskThread = new TaskThread();

        taskThread.show();
        System.out.println("第一次调用完成");
        taskThread.show();
        System.out.println("第二次调用完成");
    }
}

class TaskThread extends Thread {
    public void show() {
        start();
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 5) {
            System.out.println(this.getName() + " 线程启动");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}