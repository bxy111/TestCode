public class Exercise3 {
    public static void main(String[] args) {
//        定义一个长度为20的int类型的数组并赋值1到20，然后打印出数组的值
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
