package Practice1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws NumberNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayDemo ad = new ArrayDemo();
        int num = 0;

        System.out.println("请输入10个不同整数:");
        while (true) {
            if (num == 10) {
                break;
            }
            int n = sc.nextInt();
            try {
                ad.insert(n);
                num++;
            } catch (DuplicateValueException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("请输入想要在数组中查找的数:");
        int n = sc.nextInt();
        if (!ad.isExist(n)) {
            throw new NumberNotFoundException("num " + n + " is not found is the array.");
        }
    }
}
