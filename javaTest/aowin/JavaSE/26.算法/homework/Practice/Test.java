package Practice;

public class Test {
    /**
     * 黄蓉难倒瑛姑的数学题
     * @param x 余数
     * @return
     */
    public static int func1(int x) {
        if (x % 3 == x % 7) {
            return x;
        }
        return func1(x + 5);
    }

    /**
     * 李白买酒的问题
     * @param num
     * @param deep
     * @return
     */
    public static double func(double num, int deep) {
        if (deep == 1) {
            return (num + 1) / 2;
        }
        return func((num + 1) / 2, deep - 1);
    }

    public static void main(String[] args) {
        System.out.println(func(0, 5));
        System.out.println(func1(3));
    }
}
