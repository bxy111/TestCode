package Practice4;

import sun.plugin.dom.core.CoreConstants;

public class Stu {
    private int id;
    private String name;
    private Course[] scores;

    public Stu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Stu s = new Stu(1001, "jack");
        Course[] courses = {new Course("english", 88), new Course("math", 90),
                            new Course("chinese", 95)};
        s.setScore(courses);

        s.show();
    }

    public void setScore(Course[] obj) {
        scores = obj;
    }

    public void show() {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i].getScore();
        }
        System.out.println("name is " + name + ",total scores is " + sum);
    }
}

class Course {
    private String title;
    private double score;

    public Course(String title, double score) {
        this.title = title;
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
