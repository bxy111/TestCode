//1. 设计学生类（Student）
//        属性：名字、性别、年龄
//        方法功能：获得名字、学习（无返回值）、设置年龄。

public class Student {
    private String name;
    private String sex;
    private int age;

    public static void main(String[] args) {
        Student s = new Student();
        s.setAge(10);
        s.setSex("男");
        s.setName("小明");
        s.learn();
        System.out.println(s);
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

    public void learn() {
        System.out.println("我在学习中。。。");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
