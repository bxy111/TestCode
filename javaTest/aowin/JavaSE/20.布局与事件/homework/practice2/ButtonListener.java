package practice2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextField srcField;
    private JTextField dstField;

    public ButtonListener(JTextField srcField, JTextField dstField) {
        this.srcField = srcField;
        this.dstField = dstField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = srcField.getText();
        dstField.setText(text);
        srcField.setText("");
    }
}
