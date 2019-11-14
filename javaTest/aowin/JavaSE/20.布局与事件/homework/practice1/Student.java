package practice1;

public class Student {
    private String name;
    private int classNo;
    private double score;

    public Student(String name, int classNo, double score) {
        this.name = name;
        this.classNo = classNo;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getClassNo() {
        return classNo;
    }

    public double getScore() {
        return score;
    }
}
