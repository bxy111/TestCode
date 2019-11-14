package practice;

public class Classroom {
    private Student[] data;
    private int size;       //数组的大小
    private int index;      //当前数组中的元素个数

    /**
     * @param size classroom的初始大小
     */
    public Classroom(int size) {
        this.size = size;
        this.data = new Student[size];
        this.index = 0;
    }

    public static void main(String[] args) {
        Classroom classroom = new Classroom(5);
        classroom.add(new Student(1, "gailun"));
        classroom.add(new Student(2, "kate"));
        classroom.add(new Student(3, "temo"));

        classroom.add(1, new Student(4, "anni"));
        classroom.add(1, new Student(5, "manwang"));
        classroom.add(1, new Student(6, "hanbin"));

        System.out.println(classroom);
//        classroom.remove(6);
        classroom.remove(0);
        System.out.println(classroom);
        System.out.println(classroom.get(4));
        classroom.set(3, new Student(7, "jianiao"));
        System.out.println(classroom);
    }

    /**
     * @return the size of data
     */
    public int getCapacity() {
        return size;
    }

    /**
     * @return the num of element in the data
     */
    public int getElementNum() {
        return index;
    }

    private String outOfBoundsMsg(int pos) {
        return "pos: " + pos + ", Size: " + this.index;
    }

    /**
     * 确保数组有空间存放新增的元素
     */
    private void ensureSize() {
        if (index >= size) {
            //数组需要扩容
            Student[] students = new Student[size * 2];
            System.arraycopy(data, 0, students, 0, size);
            data = students;
            size *= 2;
        }
    }

    public boolean add(Student s) {
        ensureSize();
        data[index++] = s;
        return true;
    }

    public boolean add(int pos, Student s) {
        if (pos > index || pos < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(pos));
        }
        ensureSize();
        System.arraycopy(data, pos, data, pos + 1,
                index - pos);
        data[pos] = s;
        index++;
        return true;
    }

    public Student remove(int pos) {
        if (pos >= index || pos < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(pos));
        }
        Student oldValue = data[pos];
        int numMoved = index - pos - 1;
        if (numMoved > 0) {
            System.arraycopy(data, pos + 1, data, pos, numMoved);
        }
        data[--index] = null;
        return oldValue;
    }

    public Student get(int pos) {
        if (pos >= index || pos < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(pos));
        }

        return data[pos];
    }

    public Student set(int pos, Student s) {
        if (pos >= index || pos < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(pos));
        }

        Student oldValue = data[pos];
        data[pos] = s;
        return oldValue;
    }

    @Override
    public String toString() {
        System.out.println("容量:" + getCapacity());
        System.out.println("元素个数:" + getElementNum());
        for (Student s : data) {
            if (s != null) {
                System.out.println(s);
            }
        }
        return "";
    }
}
