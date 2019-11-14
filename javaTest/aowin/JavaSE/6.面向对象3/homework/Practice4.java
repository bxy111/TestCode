public class Practice4 {
    public static void main(String[] args) {
        Swap.exchange(10, 39);
        Swap.exchange(new Purse(100), new Purse(200));
        Swap.exchange2(new Purse(150), new Purse(300));
    }
}

class Swap {
    static void exchange(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
        System.out.println(i + " " + j);
    }

    static void exchange(Purse i, Purse j) {
        Purse tmp = i;
        i = j;
        j = tmp;
        System.out.println(i);
        System.out.println(j);
    }

    static void exchange2(Purse i, Purse j) {
        int tmp = i.getMoney();
        i.setMoney(j.getMoney());
        j.setMoney(tmp);
        System.out.println(i);
        System.out.println(j);
    }
}

class Purse {
    private int money;

    public Purse(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Purse{" +
                "money=" + money +
                '}';
    }
}
