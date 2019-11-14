package practice2;

import javax.swing.*;
import java.awt.*;

public class TestWin extends JFrame {
    private JTextField field;
    private JButton but;

    public JTextField getField() {
        return field;
    }

    public void setField(JTextField field) {
        this.field = field;
    }

    public JButton getBut() {
        return but;
    }

    public void setBut(JButton but) {
        this.but = but;
    }

    public void openWin() {
        this.setLayout(new FlowLayout());
        field = new JTextField(15);
        this.add(field);

        but = new JButton("转移");
        this.add(but);

        this.setSize(200, 300);
        this.setLocation(200, 0);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
