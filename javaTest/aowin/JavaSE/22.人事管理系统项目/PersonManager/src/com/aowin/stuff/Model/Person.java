package com.aowin.stuff.Model;

public class Person {
    private int id;
    private String name;
    private String sex;
    private String department;
    private int salary;
    private int age;

    public Person() {
    }

    public Person(int id, String name, String sex, String department, int salary, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public Person(String name, String sex, String department, int salary, int age) {
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
