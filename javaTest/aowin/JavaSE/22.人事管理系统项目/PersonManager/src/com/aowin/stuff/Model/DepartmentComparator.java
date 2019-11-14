package com.aowin.stuff.Model;

import java.util.Comparator;

public class DepartmentComparator implements Comparator<Department> {
    private int[] indexArr = new int[3];
    private int index = 0;

    public void setIndex(int index) {
        this.index = index;
        this.indexArr[index]++;
    }

    @Override
    public int compare(Department o1, Department o2) {
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
                    return o2.getManagerName().compareTo(o1.getManagerName());
                } else {
                    return o1.getManagerName().compareTo(o2.getManagerName());
                }
            }
            default:{
                return 0;
            }
        }
    }
}
