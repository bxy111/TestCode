import java.util.Scanner;

public class ATMDemo {
    private static Scanner sc;
    private static ATM atm;
    public static void main(String[] args) {
        atm = new ATM(1000);
        sc = new Scanner(System.in);
        while (true) {
            //欢迎界面
            displayWelcome();
            String opt = sc.next();
            switch (opt) {
                case "1":
                case "存钱":{
                    saveMoney();
                    break;
                }
                case "2":
                case "取钱":{
                    drawMoney();
                    break;
                }
                case "3":
                case "查询":{
                    queryMoney();
                    break;
                }
                case "4":
                case "退出":{
                    System.out.println("很高兴为您服务，再见！");
                    System.exit(0);
                }
            }
        }
    }
    public static void queryMoney() {
        System.out.printf("您的账户余额:%.2f", atm.getMoney());
        System.out.println("元。");
    }
    public static void drawMoney() {
        System.out.println("请输入取款金额:");
        while (true) {
            double num = sc.nextDouble();
            if (0 > num) {
                System.out.println("输入金额不能小于0，请重新输入:");
                continue;
            }
            if (!atm.drawMoney(num)) {
                System.out.println("您的账户余额不足，请重新操作:");
            } else {
                System.out.println("取款成功。");
            }
            break;
        }
    }
    public static void displayWelcome() {
        System.out.println("***************************");
        System.out.println("********[1. 存钱]**********");
        System.out.println("********[2. 取钱]**********");
        System.out.println("********[3. 查询]**********");
        System.out.println("********[4. 退出]**********");
        System.out.println("***************************");
        System.out.println("请输入:");
    }
    public static void saveMoney() {
        System.out.println("请输入存款金额:");
        while (true) {
            double num = sc.nextDouble();
            if (0 > num) {
                System.out.println("输入金额不能小于0，请重新输入:");
                continue;
            }
            atm.saveMoney(num);
            System.out.println("存款成功。");
            break;
        }
    }
}

class ATM {
    private double money;

    public boolean drawMoney(double money) {
        if (this.money > money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    public double getMoney() {
        return money;
    }

    public void saveMoney(double money) {
        this.money += money;
    }

    public ATM(double money) {
        this.money = money;
    }
}