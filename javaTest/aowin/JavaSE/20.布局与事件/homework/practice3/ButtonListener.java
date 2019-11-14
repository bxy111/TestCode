package practice3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextField field;
    private String first;
    private String option;

    public ButtonListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "+":
            case "-":
            case "/":
            case "*": {
                String text = field.getText();
                first = text;
                field.setText("0");
                option = actionCommand;
                System.out.println(actionCommand);
                break;
            }
            case "=": {
                String text = field.getText();
                if (option == null || first == null || text == null) {
                    field.setText("没有输入操作符，就直接点击了=号，请重新运行程序");
                    System.out.println(option);
                    System.out.println(first);
                    System.out.println(text);
                    option = "=";
                    first = null;
                    break;
                } else if (option.equals("/") && text.equals("0")) {
                    field.setText("除数不能为0");
                    option = "=";
                    first = null;
                    break;
                }
                double a = Double.valueOf(first);
                double b = Double.valueOf(text);
                switch (option) {
                    case "+": {
                        field.setText(String.valueOf(a + b));
                        break;
                    }
                    case "-": {
                        field.setText(String.valueOf(a - b));
                        break;
                    }
                    case "*": {
                        field.setText(String.valueOf(a * b));
                        break;
                    }
                    case "/": {
                        field.setText(String.valueOf(a / b));
                        break;
                    }
                }
                option = "=";
                first = null;
                break;
            }
            default: {
                String text = field.getText();
                if ("=".equals(option)) {
                    text = actionCommand;
                    option = null;
                } else if ("0".equals(text)) {
                    if (".".equals(actionCommand)) {
                        text += actionCommand;
                    } else {
                        text = actionCommand;
                    }
                } else {
                    text += actionCommand;
                }
                field.setText(text);
            }
        }
    }
}
