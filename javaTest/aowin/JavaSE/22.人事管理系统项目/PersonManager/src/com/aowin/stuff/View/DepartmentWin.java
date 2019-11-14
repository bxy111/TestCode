package com.aowin.stuff.View;

import com.aowin.stuff.Listener.AddQueryModifyListener;
import com.aowin.stuff.Listener.OptionButtonListener;

import javax.swing.*;
import java.awt.*;

public class DepartmentWin extends JFrame {
    private JPanel num;
    private JPanel numField;
    private boolean isHaveID = true;
    private JTextField id;
    private JTextField name;
    private JTextField manager;
    private MainWin win;
    private OptionButtonListener optionButton;

    public DepartmentWin(MainWin window, OptionButtonListener optionButton) throws HeadlessException {
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

    public JTextField getManager() {
        return manager;
    }

    public void clearData() {
        id.setText("");
        id.setEnabled(true);
        name.setText("");
        manager.setText("");
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
        manager.setText(data[2]);
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
        GridLayout gridLayout = new GridLayout(4, 2);
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

        JLabel jLabel21 = new JLabel("部门名:");
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel2.add(jLabel21);
        JTextField jTextField22 = new JTextField(10);
        JPanel jPanel22 = new JPanel();
        jPanel22.add(jTextField22);
        this.name = jTextField22;
        this.add(jPanel2);
        this.add(jPanel22);

        JLabel jLabel51 = new JLabel("部门经理:");
        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel5.add(jLabel51);
        JTextField jTextField52 = new JTextField(10);
        JPanel jPanel52 = new JPanel();
        jPanel52.add(jTextField52);
        this.manager = jTextField52;
        this.add(jPanel5);
        this.add(jPanel52);

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
        addQueryModifyListener.setDepartmentWin(this);
        confirm.addActionListener(addQueryModifyListener);
        cancel.addActionListener(addQueryModifyListener);

        this.setSize(300, 400);
        this.setLocation(200, 0);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
