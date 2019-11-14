package Practice3;

import java.util.*;

public class StuTest {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("xiaoming", 001));
        students.add(new Student("honghong", 002));
        students.add(new Student("baibai", 003));
        students.add(new Student("lili", 004));
        students.add(new Student("junjun", 005));

        Collections.sort(students, new StuCompare("id", "降序"));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}

class StuCompare implements Comparator<Student>{
    private String field;
    private String order;

    public StuCompare() {
        this.field = "id";
        this.order = "升序";
    }

    public StuCompare(String field, String order) {
        this.field = field;
        this.order = order;
    }

    @Override
    public int compare(Student o1, Student o2) {
        int result = 0;

        if (field.equals("score")) {
            result = o1.totalScore() - o2.totalScore();
        } else {
            result = o1.getId() - o2.getId();
        }

        if (order.equals("降序")) {
            result = -result;
        }

        return result;
    }
}

class Student {
    private String name;
    private int id;
    private int[] scores = new int[5];
    private int total;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;

        for (int i = 0; i < scores.length; i++) {
            scores[i] = (int) (Math.random() * 51 + 50);
            total += scores[i];
        }
    }

    public int getId() {
        return id;
    }

    public int totalScore() {
        return total;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", scores=" + Arrays.toString(scores) +
                ", total=" + total +
                '}';
    }
}