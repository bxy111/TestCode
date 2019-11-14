package com.aowin.stuff.View;

import com.aowin.stuff.Dbconnection.DepartMentDAO;
import com.aowin.stuff.Listener.AddQueryModifyListener;
import com.aowin.stuff.Listener.OptionButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class OptionWin extends JFrame {
    private JPanel num;
    private JPanel numField;
    private boolean isHaveID = true;
    private JTextField id;
    private JTextField name;
    private JComboBox<String> sex;
    private JTextField age;
    private JTextField salary;
    private JComboBox<String> depart;
    private MainWin win;
    private OptionButtonListener optionButton;

    public OptionWin(MainWin window, OptionButtonListener optionButton) throws HeadlessException {
        this.win = window;
        this.optionButton = optionButton;
        initWin();
    }

    public OptionButtonListener getOptionButton() {
        return optionButton;
    }

    public JTextField getId() {
        return id;
    }

    public JTextField getname() {
        return name;
    }

    public JComboBox<String> getSex() {
        return sex;
    }

    public JTextField getAge() {
        return age;
    }

    public JTextField getSalary() {
        return salary;
    }

    public JComboBox<String> getDepart() {
        return depart;
    }

    public void clearData() {
        id.setText("");
        id.setEnabled(true);
        name.setText("");
        sex.setSelectedIndex(-1);
        age.setText("");
        salary.setText("");
        DepartMentDAO departmentDAO = win.getDepartMentDAO();
        Vector<String> names = departmentDAO.queryDepartmentName();
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) depart.getModel();
        model.removeAllElements();
        for (int i = 0; i < names.size(); i++) {
            model.addElement(names.get(i));
        }
        depart.setSelectedItem(null);
        depart.setSelectedIndex(-1);
    }

    public void setData(String[] data) {
        if (!isHaveID) {
            this.add(this.num, 0);
            this.add(this.numField, 1);
            isHaveID = true;
        }
        id.setText(data[0]);
        id.setEnabled(false);
        name.setText(data[1]);
        sex.setSelectedItem(data[2]);
        age.setText(data[3]);
        DepartMentDAO departmentDAO = win.getDepartMentDAO();
        Vector<String> names = departmentDAO.queryDepartmentName();
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) depart.getModel();
        model.removeAllElements();
        for (int i = 0; i < names.size(); i++) {
            model.addElement(names.get(i));
        }
        if (names.contains(data[4])) {
            depart.setSelectedItem(data[4]);
        } else {
            depart.setSelectedItem(null);
        }
        salary.setText(data[5]);
    }

    public void openWinWithoutID() {
        if (isHaveID) {
            this.remove(this.num);
            this.remove(this.numField);
            isHaveID = false;
        }
        this.setVisible(true);
    }

    public void openWinWithID() {
        if (!isHaveID) {
            this.add(this.num, 0);
            this.add(this.numField, 1);
            isHaveID = true;
        }
        this.setVisible(true);
    }

    private void initWin() {
        GridLayout gridLayout = new GridLayout(7, 2);
        this.setLayout(gridLayout);

        JLabel jLabel11 = new JLabel("编号:");
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel1.add(jLabel11);
        JTextField jTextField12 = new JTextField(10);
        JPanel jPanel12 = new JPanel();
        jPanel12.add(jTextField12);
        this.num = jPanel1;
        this.numField = jPanel12;
        this.id = jTextField12;
        this.add(jPanel1);
        this.add(jPanel12);

        JLabel jLabel21 = new JLabel("姓名:");
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel2.add(jLabel21);
        JTextField jTextField22 = new JTextField(10);
        JPanel jPanel22 = new JPanel();
        jPanel22.add(jTextField22);
        this.name = jTextField22;
        this.add(jPanel2);
        this.add(jPanel22);

        JLabel jLabel41 = new JLabel("性别:");
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel4.add(jLabel41);
        Vector<String> items = new Vector<String>();
        items.add("女");
        items.add("男");
        JComboBox<String> combo = new JComboBox<>(items);
        combo.setSelectedIndex(-1);
        JPanel jPanel42 = new JPanel();
        this.sex = combo;
        jPanel42.add(combo);
        this.add(jPanel4);
        this.add(jPanel42);

        JLabel jLabel51 = new JLabel("年龄:");
        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel5.add(jLabel51);
        JTextField jTextField52 = new JTextField(10);
        JPanel jPanel52 = new JPanel();
        jPanel52.add(jTextField52);
        this.age = jTextField52;
        this.add(jPanel5);
        this.add(jPanel52);

        JLabel jLabel61 = new JLabel("工资:");
        JPanel jPanel6 = new JPanel();
        jPanel6.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel6.add(jLabel61);
        JTextField jTextField62 = new JTextField(10);
        JPanel jPanel62 = new JPanel();
        jPanel62.add(jTextField62);
        this.salary = jTextField62;
        this.add(jPanel6);
        this.add(jPanel62);

        JLabel jLabel71 = new JLabel("部门:");
        JPanel jPanel7 = new JPanel();
        jPanel7.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel7.add(jLabel71);
        DepartMentDAO departmentDAO = win.getDepartMentDAO();
        Vector<String> names = departmentDAO.queryDepartmentName();
        JComboBox<String> combo1 = new JComboBox<String>(names);
        combo1.setSelectedItem(null);
        JPanel jPanel72 = new JPanel();
        this.depart = combo1;
        jPanel72.add(combo1);
        this.add(jPanel7);
        this.add(jPanel72);

        JButton confirm = new JButton("确定");
        JPanel jPanel8 = new JPanel();
        jPanel8.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel8.add(confirm);
        JButton cancel = new JButton("取消");
        JPanel jPanel82 = new JPanel();
        jPanel82.add(cancel);
        this.add(jPanel8);
        this.add(jPanel82);

        AddQueryModifyListener addQueryModifyListener = new AddQueryModifyListener(win);
        addQueryModifyListener.setOptionWin(this);
        confirm.addActionListener(addQueryModifyListener);
        cancel.addActionListener(addQueryModifyListener);

        this.setSize(300, 400);
        this.setLocation(200, 0);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
