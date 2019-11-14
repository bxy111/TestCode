public class Printer {
//    5.打印机类,该类具有以下性质
//    包含三个重载的方法 print；
//    当print(n)时，打印从1 到 n的所有数字；
//    当print(m, n)时，打印从m 到n的所有数字；
//    当print(m, n, p)时，打印从m到n的所有数字，步长为p

    public void print(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public void print(int m, int n) {
        for (int i = m; i <= n; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public void print(int m, int n, int p) {
        for (int i = m; i <= n; i+=p) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Printer p = new Printer();

        p.print(10);
        p.print(20, 30);
        p.print(10, 30, 3);
    }
}
