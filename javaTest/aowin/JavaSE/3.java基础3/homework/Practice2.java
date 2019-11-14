import javax.xml.stream.events.EndDocument;

public class Practice2 {
    public static void main(String[] args) {
//        编写方法，打印1-100之间所有的偶数，每行显示10个数字，每个数字之间用空格或","隔开。
        printEven(1, 100);
    }

    public static void printEven(int start, int end) {
        int j = 0;
        for (int i = start; i <= end; i++) {
            if (i%2 == 0 ){
                j++;
                if (j%10 != 0){
                    System.out.print(i + "\t");
                }else{
                    System.out.print(i + "\n");
                }
            }
        }
    }
}
