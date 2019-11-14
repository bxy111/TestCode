public class Practice1 {
    public static void main(String[] args) {
//        编写一个方法，求出数组(作为方法的参数)中的最小值并返回
        int[] iArr = {332,-2,11,3,44,6,754,54345};
        int min = minNum(iArr);
        System.out.println(min);
    }

    public static int minNum(int[] iArr) {
        int min = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            if (min > iArr[i]){
                min = iArr[i];
            }
        }
        return min;
    }
}
