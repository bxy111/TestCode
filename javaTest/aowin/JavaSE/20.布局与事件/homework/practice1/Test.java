package practice1;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new GridLayout(4, 2));

        JLabel name = new JLabel("姓名");
        jFrame.add(name);
        JTextField jTextField = new JTextField(10);
        jFrame.add(jTextField);

        JLabel classNo = new JLabel("班级");
        jFrame.add(classNo);
        JTextField jTextField1 = new JTextField(10);
        jFrame.add(jTextField1);

        JLabel score = new JLabel("成绩");
        jFrame.add(score);
        JTextField jTextField2 = new JTextField(10);
        jFrame.add(jTextField2);

        JButton query = new JButton("查询");
        jFrame.add(query);
        JButton clear = new JButton("清空");
        jFrame.add(clear);

        ButtonActionListener buttonActionListener = new ButtonActionListener(jTextField, jTextField1, jTextField2);
        query.addActionListener(buttonActionListener);
        clear.addActionListener(buttonActionListener);

        jFrame.setSize(250, 200);
        jFrame.setLocation(200, 0);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
