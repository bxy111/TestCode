package practice3;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new BorderLayout());
        JTextField jTextField = new JTextField(20);
        jTextField.setText("0");
        jFrame.add(jTextField, BorderLayout.NORTH);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(4, 4));
        jFrame.add(jPanel, BorderLayout.CENTER);

        ButtonListener buttonListener = new ButtonListener(jTextField);

        String[] chars = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        for (int i = 0; i < chars.length; i++) {
            JButton jButton = new JButton(chars[i]);
            jButton.addActionListener(buttonListener);
            jPanel.add(jButton);
        }


        jFrame.setSize(300, 300);
        jFrame.setLocation(200, 0);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Calculator");
    }
}
