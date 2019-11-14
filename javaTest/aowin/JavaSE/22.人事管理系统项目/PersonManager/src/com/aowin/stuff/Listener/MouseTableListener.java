package com.aowin.stuff.Listener;

import com.aowin.stuff.Model.Department;
import com.aowin.stuff.Model.DepartmentComparator;
import com.aowin.stuff.Model.Person;
import com.aowin.stuff.Model.PersonComparator;
import com.aowin.stuff.View.MainWin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MouseTableListener extends MouseAdapter {
    private MainWin mainWin;
    private PersonComparator personComparator;
    private DepartmentComparator departmentComparator;

    public MouseTableListener(MainWin mainWin) {
        this.mainWin = mainWin;
        this.personComparator = new PersonComparator();
        this.departmentComparator = new DepartmentComparator();
    }

    private ArrayList<Person> transDataToPerson(DefaultTableModel model) {
        ArrayList<Person> people = new ArrayList<>();
        String[] strings = new String[model.getColumnCount()];

        for (int i = 0; i < model.getRowCount(); i++) {
            Person person = new Person();
            for (int j = 0; j < model.getColumnCount(); j++) {
                strings[j] = (String) model.getValueAt(i, j) == null ? "" : (String) model.getValueAt(i, j);
            }
            person.setId(Integer.parseInt(strings[0]));
            person.setName(strings[1]);
            person.setSex(strings[2]);
            person.setAge(Integer.parseInt(strings[3]));
            person.setDepartment(strings[4]);
            person.setSalary(Integer.parseInt(strings[5]));
            people.add(person);
        }

        return people;
    }

    private ArrayList<Department> transDepartmentDataToPerson(DefaultTableModel model) {
        ArrayList<Department> people = new ArrayList<>();
        String[] strings = new String[model.getColumnCount()];

        for (int i = 0; i < model.getRowCount(); i++) {
            Department person = new Department();
            for (int j = 0; j < model.getColumnCount(); j++) {
                strings[j] = (String) model.getValueAt(i, j) == null ? "" : (String) model.getValueAt(i, j);
            }
            person.setId(Integer.parseInt(strings[0]));
            person.setName(strings[1]);
            person.setManagerName(strings[2]);
            people.add(person);
        }

        return people;
    }

    private void transPersonToData(DefaultTableModel model, ArrayList<Person> people) {
        model.setRowCount(0);
        String[] data = new String[6];
        for (Person p : people) {
            data[0] = String.valueOf(p.getId());
            data[1] = p.getName();
            data[2] = p.getSex();
            data[3] = String.valueOf(p.getAge());
            data[4] = p.getDepartment();
            data[5] = String.valueOf(p.getSalary());
            model.addRow(data);
        }
    }

    private void transDepartmentToData(DefaultTableModel model, ArrayList<Department> people) {
        model.setRowCount(0);
        String[] data = new String[3];
        for (Department p : people) {
            data[0] = String.valueOf(p.getId());
            data[1] = p.getName();
            data[2] = p.getManagerName();
            model.addRow(data);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (mainWin.getUser().isVisible()) {
            if (e.getClickCount() == 2) {
                Point point = e.getPoint(); //点击位置
                JTable userTable = mainWin.getUserTable();
                int index = userTable.columnAtPoint(point);  //列索引
                String name = userTable.getColumnName(index);  //列的名字
                DefaultTableModel model = (DefaultTableModel) userTable.getModel();
                ArrayList<Person> people = transDataToPerson(model);
                personComparator.setIndex(index);
                Collections.sort(people, personComparator);
                transPersonToData(model, people);
            }
        } else if (mainWin.getDepartment().isVisible()) {
            if (e.getClickCount() == 2) {
                Point point = e.getPoint(); //点击位置
                JTable userTable = mainWin.getDepartTable();
                int index = userTable.columnAtPoint(point);  //列索引
                String name = userTable.getColumnName(index);  //列的名字
                DefaultTableModel model = (DefaultTableModel) userTable.getModel();
                ArrayList<Department> people = transDepartmentDataToPerson(model);
                departmentComparator.setIndex(index);
                Collections.sort(people, departmentComparator);
                transDepartmentToData(model, people);
            }
        }
    }
}
