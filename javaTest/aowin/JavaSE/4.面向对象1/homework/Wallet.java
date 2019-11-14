//2. 设计一个钱包purse，可以对里面的余额成员变量int money 进行操作：取钱、存钱。
//        注意与实际操作匹配：
//        如存钱后钱包的钱会增长，取钱要判断钱包目前的钱是否足够取

public class Wallet {
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
//    存钱
    public boolean saveMoney(int num) {
        if (0 > num) {
            return false;
        }
        this.money += num;
        return true;
    }
//    取钱
    public boolean drawMoney(int num) {
        if (0 > num || this.money < num) {
            return false;
        }else {
            this.money -= num;
        }
        return true;
    }

    public static void main(String[] args) {
        Wallet w = new Wallet();
        w.setMoney(1000);
        boolean b = w.drawMoney(100);
        System.out.println(b);
        System.out.println(w.getMoney());
    }
}
