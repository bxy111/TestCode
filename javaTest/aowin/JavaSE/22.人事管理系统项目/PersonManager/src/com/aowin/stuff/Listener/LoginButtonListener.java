package com.aowin.stuff.Listener;

import com.aowin.stuff.Dbconnection.UserDAO;
import com.aowin.stuff.Model.UserInfo;
import com.aowin.stuff.View.MainWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonListener implements ActionListener {
    private JTextField user;
    private JTextField password;
    private JLabel dis;
    private JFrame win;

    public LoginButtonListener(JTextField user, JTextField password, JLabel dis, JFrame win) {
        this.user = user;
        this.password = password;
        this.dis = dis;
        this.win = win;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if ("登录".equals(actionCommand)) {
            String username = user.getText();
            String pass = password.getText();
            UserInfo userInfo = new UserInfo(username, pass);
            boolean b = new UserDAO().queryUser(userInfo);
            if (b) {
                win.setVisible(false);
                //切换页面
                MainWin mainWin = new MainWin(username);
                mainWin.openWin();
            } else {
                dis.setText("用户名或者密码错误");
                dis.setForeground(Color.red);
            }
        } else {
            //点击取消，则退出程序
            System.exit(0);
        }
    }
}
