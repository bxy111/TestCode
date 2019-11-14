package com.aowin.stuff.Model;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    private int[] indexArr = new int[6];
    private int index = 0;

    public void setIndex(int index) {
        this.index = index;
        this.indexArr[index]++;
    }

    @Override
    public int compare(Person o1, Person o2) {
        switch (index) {
            case 0:{
                if (indexArr[index]%2 == 0){
                    return o2.getId() - o1.getId();
                } else {
                    return o1.getId() - o2.getId();
                }
            }
            case 1:{
                if (indexArr[index]%2 == 0){
                    return o2.getName().compareTo(o1.getName());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
            case 2:{
                if (indexArr[index]%2 == 0){
                    return o2.getSex().compareTo(o1.getSex());
                } else {
                    return o1.getSex().compareTo(o2.getSex());
                }
            }
            case 3:{
                if (indexArr[index]%2 == 0){
                    return o2.getAge() - o1.getAge();
                } else {
                    return o1.getAge() - o2.getAge();
                }
            }
            case 4:{
                if (indexArr[index]%2 == 0){
                    return o2.getDepartment().compareTo(o1.getDepartment());
                } else {
                    return o1.getDepartment().compareTo(o2.getDepartment());
                }
            }
            case 5:{
                if (indexArr[index]%2 == 0){
                    return o2.getSalary() - o1.getSalary();
                } else {
                    return o1.getSalary() - o2.getSalary();
                }
            }
            default:{
                return 0;
            }
        }
    }
}
