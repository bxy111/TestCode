public class Practice3 {
    public static void main(String[] args) {
//        编写方法 public static int trans(char ch)， 将数字字符转换成对应的数字。如果可以转换，返回对应的数字；如果不能转换，则返回-1。
//        例如:
//        传入的字符是’2’,返回整数2;传入的字符是'a'等非数字字符,返回整数-1

        System.out.println(trans(args[args.length - 1].charAt(0)));
    }

    public static int trans(char c) {
        if (c >= '0' && c <= '9'){
            return (int)c - 48;
        }else{
            return -1;
        }
    }
}
