package practice1;

public class ThreadTest {
    public static void main(String[] args) {
        Thread stu1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("学生1 跑步中...");
            }
        });
        Thread stu2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("学生2 跑步中...");
            }
        });
        Thread stu3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("学生3 跑步中...");
            }
        });

        stu1.start();
        stu2.start();
        stu3.start();

        try {
            stu1.join();
            stu2.join();
            stu3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("比赛结束!");
    }
}
