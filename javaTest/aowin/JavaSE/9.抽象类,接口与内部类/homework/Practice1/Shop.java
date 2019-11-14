package Practice1;

public class Shop {
    private ComputeTotalSales[] cts = new ComputeTotalSales[10];
    private int index;

    public static void main(String[] args) {
        Shop sp = new Shop();
        sp.add(new Television());
        sp.add(new Computer());
        sp.add(new Mobile());
        System.out.println(sp.show());
    }

    public double show() {
        double sum = 0;

        for (int i = 0; i < index; i++) {
            sum += cts[i].totalSalesByYear();
        }
        return sum;
    }

    public boolean add(ComputeTotalSales obj) {
        if (index >= 10) {
            return false;
        }
        cts[index++] = obj;
        return true;
    }

}
