package com.aowin.stuff.Model;

public class Department {
    private int id;
    private String name;
    private String managerName;

    public Department() {

    }

    public Department( String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }
    public Department(int id, String name, String managerName) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
