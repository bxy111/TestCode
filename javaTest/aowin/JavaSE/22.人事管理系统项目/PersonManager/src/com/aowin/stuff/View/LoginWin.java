package com.aowin.stuff.View;

import com.aowin.stuff.Listener.LoginButtonListener;

import javax.swing.*;
import java.awt.*;

public class LoginWin extends JFrame {
    public static void main(String[] args) {
        LoginWin loginWin = new LoginWin();
        loginWin.openWin();
    }

    public void openWin() {
        this.setLayout(new GridLayout(4, 1));

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2));
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel jLabel = new JLabel("用户:");
        jPanel1.add(jLabel);
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField jTextField = new JTextField(10);
        jPanel3.add(jTextField);
        jPanel.add(jPanel1);
        jPanel.add(jPanel3);
        this.add(jPanel);

        JPanel jPanel21 = new JPanel();
        jPanel21.setLayout(new GridLayout(1, 2));
        JPanel jPanel22 = new JPanel();
        jPanel22.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel jLabel21 = new JLabel("密码:");
        jPanel22.add(jLabel21);
        JPanel jPanel23 = new JPanel();
        jPanel23.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPasswordField jTextField21 = new JPasswordField(10);
        jPanel23.add(jTextField21);
        jPanel21.add(jPanel22);
        jPanel21.add(jPanel23);
        this.add(jPanel21);

        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel jLabel3 = new JLabel();
        jPanel5.add(jLabel3);
        this.add(jPanel5);

        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new GridLayout(1, 2));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton login = new JButton("登录");
        jPanel2.add(login);
        JPanel jPanel43 = new JPanel();
        jPanel43.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton cancel = new JButton("取消");
        jPanel43.add(cancel);
        jPanel4.add(jPanel2);
        jPanel4.add(jPanel43);
        this.add(jPanel4);

        //绑定button事件
        LoginButtonListener loginButtonListener = new LoginButtonListener(jTextField, jTextField21, jLabel3, this);
        login.addActionListener(loginButtonListener);
        cancel.addActionListener(loginButtonListener);

        this.setSize(300, 300);
        this.setLocation(300, 200);
        this.setVisible(true);
        this.setTitle("登录窗口");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
