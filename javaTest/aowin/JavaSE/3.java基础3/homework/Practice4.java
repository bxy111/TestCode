public class Practice4 {
    public static void main(String[] args) {
//        编写方法 public static boolean isPrime(int num)，判断参数是否为质数
        if (isPrime(Integer.valueOf(args[0]))){
            System.out.println("是质数");
        }else{
            System.out.println("不是质数");
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
