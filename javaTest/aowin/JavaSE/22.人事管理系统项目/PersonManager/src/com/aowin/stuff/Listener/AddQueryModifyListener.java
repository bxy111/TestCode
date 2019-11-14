package com.aowin.stuff.Listener;

import com.aowin.stuff.Model.Department;
import com.aowin.stuff.Model.Person;
import com.aowin.stuff.View.DepartmentWin;
import com.aowin.stuff.View.MainWin;
import com.aowin.stuff.View.OptionWin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddQueryModifyListener implements ActionListener {
    private MainWin mainWin;
    private OptionWin optionWin;
    private DepartmentWin departmentWin;

    public AddQueryModifyListener(MainWin mainWin) {
        this.mainWin = mainWin;
    }

    public void setOptionWin(OptionWin optionWin) {
        this.optionWin = optionWin;
    }

    public void setDepartmentWin(DepartmentWin departmentWin) {
        this.departmentWin = departmentWin;
    }

    private Person getPersonData() {
        JTextField id = optionWin.getId();
        String text2 = id.getText();

        JTextField getname = optionWin.getname();
        String name = getname.getText();
        if ("".equals(name)) {
            JOptionPane.showMessageDialog(optionWin, "姓名为空", "提示", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        JComboBox<String> sex = optionWin.getSex();
        int selectedIndex = sex.getSelectedIndex();
        if (-1 == selectedIndex) {
            JOptionPane.showMessageDialog(optionWin, "未选择性别", "提示", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        JTextField age = optionWin.getAge();
        JTextField salary = optionWin.getSalary();
        String text1 = salary.getText();
        String text = age.getText();
        int ageNum;
        int salaryNum;
        try {
            ageNum = Integer.parseInt(text);
            if (ageNum <= 18 || ageNum >= 65) {
                JOptionPane.showMessageDialog(optionWin, "年龄不在合法范围内(18<age<65)", "提示",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (NumberFormatException excep) {
            JOptionPane.showMessageDialog(optionWin, "年龄输入错误", "提示", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        try {
            salaryNum = Integer.parseInt(text1);
            if (salaryNum <= 1000 || salaryNum >= 100000) {
                JOptionPane.showMessageDialog(optionWin, "工资不在合法范围内(1000<salary<100000)", "提示",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (NumberFormatException excep) {
            JOptionPane.showMessageDialog(optionWin, "工资输入错误", "提示", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        JComboBox<String> depart = optionWin.getDepart();
        String departName = (String) depart.getSelectedItem();
        if (null == departName) {
            JOptionPane.showMessageDialog(optionWin, "未选择部门", "提示", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Person person;
        if ("".equals(text2)) {
            person = new Person(name, selectedIndex == 1 ? "男" : "女", departName, salaryNum, ageNum);
        } else {
            person = new Person(Integer.parseInt(text2), name, selectedIndex == 1 ? "男" : "女", departName, salaryNum,
                    ageNum);
        }
        return person;
    }

    private Department getDepartmentData() {
        JTextField id = departmentWin.getId();
        String text2 = id.getText();

        JTextField getname = departmentWin.getname();
        String name = getname.getText();
        if ("".equals(name)) {
            JOptionPane.showMessageDialog(optionWin, "部门名为空", "提示", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        JTextField manager = departmentWin.getManager();
        String managerName = manager.getText();
        if ("".equals(managerName)) {
            JOptionPane.showMessageDialog(optionWin, "部门经理为空", "提示", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Department person;
        if ("".equals(text2)) {
            person = new Department(name, managerName);
        } else {
            person = new Department(Integer.parseInt(text2), name, managerName);
        }
        return person;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "确定": {
                if (mainWin.getUser().isVisible()) {
                    mainWin.setEnabled(true);
                    if ("新增".equals(optionWin.getTitle())) {
                        Person personData = getPersonData();
                        if (personData == null) {
                            break;
                        }
                        mainWin.getPersonDAO().insertData(personData);
                        optionWin.getOptionButton().updateData();
                    } else if ("修改".equals(optionWin.getTitle())) {
                        Person personData = getPersonData();
                        if (personData == null) {
                            break;
                        }
                        mainWin.getPersonDAO().updateData(personData);
                        optionWin.getOptionButton().updateData();
                    } else if ("查询".equals(optionWin.getTitle())) {
                        StringBuilder stringBuilder = new StringBuilder("");
                        JTextField getname = optionWin.getname();
                        String name = getname.getText();
                        if (!"".equals(name)) {
                            stringBuilder.append("Name like \"%" + name + "%\"" + " and ");
                        }
                        JComboBox<String> sex = optionWin.getSex();
                        int selectedIndex = sex.getSelectedIndex();
                        if (selectedIndex != -1) {
                            stringBuilder.append("Sex=" + selectedIndex + " and ");
                        }
                        JTextField age = optionWin.getAge();
                        JTextField salary = optionWin.getSalary();
                        String text1 = salary.getText();
                        String text = age.getText();
                        if (!"".equals(text1)) {
                            stringBuilder.append("Salary=\"" + text1 + "\"" + " and ");
                        }
                        if (!"".equals(text)) {
                            stringBuilder.append("Age=\"" + text + "\"" + " and ");
                        }
                        JComboBox<String> depart = optionWin.getDepart();
                        String departName = (String) depart.getSelectedItem();
                        if (null != departName) {
                            stringBuilder.append("Department=\"" + departName + "\"");
                        }
                        String newString;
                        if (stringBuilder.toString().endsWith(" and ")) {
                            newString = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 5);
                        } else {
                            newString = stringBuilder.toString();
                        }
                        ArrayList<Person> people = mainWin.getPersonDAO().queryByString(newString);
                        String[] data = new String[6];
                        DefaultTableModel model = (DefaultTableModel) mainWin.getUserTable().getModel();
                        model.setRowCount(0);
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
                    optionWin.setVisible(false);

                    break;
                } else if (mainWin.getDepartment().isVisible()) {
                    mainWin.setEnabled(true);
                    if ("新增".equals(departmentWin.getTitle())) {
                        Department personData = getDepartmentData();
                        if (personData == null) {
                            break;
                        }
                        mainWin.getDepartMentDAO().insertData(personData);
                        departmentWin.getOptionButton().updateData();
                    } else if ("修改".equals(departmentWin.getTitle())) {
                        Department personData = getDepartmentData();
                        if (personData == null) {
                            break;
                        }
                        mainWin.getDepartMentDAO().updateData(personData);
                        departmentWin.getOptionButton().updateData();
                    } else if ("查询".equals(departmentWin.getTitle())) {
                        StringBuilder stringBuilder = new StringBuilder("");
                        JTextField getname = departmentWin.getname();
                        String name = getname.getText();
                        if (!"".equals(name)) {
                            stringBuilder.append("NAME=\"" + name + "\"" + " and ");
                        }
                        JTextField manager = departmentWin.getManager();
                        String managerText = manager.getText();
                        if (!"".equals(managerText)) {
                            stringBuilder.append("Manager=\"" + managerText + "\"" + " and ");
                        }
                        String newString;
                        if (stringBuilder.toString().endsWith(" and ")) {
                            newString = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 5);
                        } else {
                            newString = stringBuilder.toString();
                        }
                        ArrayList<Department> people = mainWin.getDepartMentDAO().queryByString(newString);
                        String[] data = new String[6];
                        DefaultTableModel model = (DefaultTableModel) mainWin.getDepartTable().getModel();
                        model.setRowCount(0);
                        for (Department p : people) {
                            data[0] = String.valueOf(p.getId());
                            data[1] = p.getName();
                            data[2] = p.getManagerName();
                            model.addRow(data);
                        }
                    }
                    departmentWin.setVisible(false);
                    break;
                }
            }
            case "取消": {
                mainWin.setEnabled(true);
                if (mainWin.getUser().isVisible()) {
                    optionWin.setVisible(false);
                } else if (mainWin.getDepartment().isVisible()) {
                    departmentWin.setVisible(false);
                }
                break;
            }
        }
    }
}
