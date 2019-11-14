public class Student {
//    1. 定义一个表示学生信息的类Student，要求如下：
//    成员变量：
//    no表示学号,name表示姓名,sex表示性别,age表示年龄,java表示Java课程成绩
//    方法成员：
//    getNo()：获得学号；
//    getName()：获得姓名；
//    getSex()：获得性别；
//    getAge()获得年龄；
//    getJava()：获得Java 课程成绩
//    创建两个该类的对象，存储并输出两个学生的信息,计算并输出这两个学生Java语言成绩的平均值
//            在创建对象时就给属性赋值

    private int no;
    private String name;
    private String sex;
    private int age;
    private int java;

    public Student(int no, String name, String sex, int age, int java) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.java = java;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", java=" + java +
                '}';
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "honghong", "女", 18, 85);
        Student s2 = new Student(2, "xiaoming", "男", 17, 90);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println((double) (s1.getJava() + s2.getJava()) / 2);
    }
}
