package practice1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;

    public ButtonActionListener(JTextField f1, JTextField f2, JTextField f3) {
        this.field1 = f1;
        this.field2 = f2;
        this.field3 = f3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if ("查询".equals(actionCommand)) {
            String name = field1.getText();
            StuDAO stuDAO = new StuDAO();
            Student student = stuDAO.queryByName(name);
            if (student != null) {
                field2.setText(String.valueOf(student.getClassNo()));
                field3.setText(String.valueOf(student.getScore()));
            }
        } else {
            field1.setText("");
            field2.setText("");
            field3.setText("");
        }
    }
}
