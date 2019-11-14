package Practice1;

public class ArrayDemo {
    private int[] nums;
    private int index;

    public ArrayDemo() {
        nums = new int[10];
        index = 0;
    }

    public boolean insert(int n) throws DuplicateValueException {
        if (index >= 10) {
            System.out.println("the array is full, insert data failed.");
            return false;
        }
        if (isExist(n)) {
            throw new DuplicateValueException("num " + n + " is duplicate, insert it failed.");
        }
        nums[index++] = n;
        return true;
    }

    public boolean isExist(int n) {
        for (int i = 0; i < index; i++) {
            if (n == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
