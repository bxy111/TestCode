package Practice3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
    public void calculate() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 0;
        System.out.println("请输入两个正整数:");
        a = scanner.nextInt();
        b = scanner.nextInt();
        if (a <= 0 || b <= 0) {
            throw new InvalidInputException("You must enter positive number");
        }
        System.out.println(a/b);
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
            exceptionTest.calculate();
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("InputMismatchException enter......");
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
