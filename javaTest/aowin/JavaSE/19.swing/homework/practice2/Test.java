package practice2;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        GridLayout gridLayout = new GridLayout(5, 2);
        jFrame.setLayout(gridLayout);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(0xCECFFF));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        jPanel.setLayout(flowLayout);
        JLabel jLabel = new JLabel("Name:");
        jPanel.add(jLabel);
        jFrame.add(jPanel);

        JPanel jPanel12 = new JPanel();
        jPanel12.setBackground(new Color(0xCECFFF));
        jPanel12.setLayout(flowLayout);
        JTextField jTextField12 = new JTextField(15);
        jPanel12.add(jTextField12);
        jFrame.add(jPanel12);

        JPanel jPanel21 = new JPanel();
        jPanel21.setBackground(new Color(0xCEFFFF));
        GridLayout gridLayout1 = new GridLayout(3, 1);
        jPanel21.setLayout(gridLayout1);
        JLabel jLabel21 = new JLabel("Favorite sports:");
        jPanel21.add(jLabel21);
        jFrame.add(jPanel21);

        JPanel jPanel22 = new JPanel();
        jPanel22.setBackground(new Color(0xCEFFFF));
        jPanel22.setLayout(gridLayout1);
        JCheckBox cricket = new JCheckBox("Cricket");
        cricket.setBackground(new Color(0xCEFFFF));
        JCheckBox badminton = new JCheckBox("Badminton");
        badminton.setBackground(new Color(0xCEFFFF));
        JCheckBox golf = new JCheckBox("Golf");
        golf.setBackground(new Color(0xCEFFFF));
        jPanel22.add(cricket);
        jPanel22.add(badminton);
        jPanel22.add(golf);
        jFrame.add(jPanel22);

        JPanel jPanel31 = new JPanel();
        jPanel31.setBackground(new Color(0XCEFFCE));
        GridLayout gridLayout2 = new GridLayout(2, 1);
        jPanel31.setLayout(gridLayout2);
        JLabel jLabel31 = new JLabel("Gender:");
        jPanel31.add(jLabel31);
        jFrame.add(jPanel31);

        JPanel jPanel32 = new JPanel();
        jPanel32.setBackground(new Color(0XCEFFCE));
        jPanel32.setLayout(gridLayout2);
        JRadioButton male = new JRadioButton("Male");
        male.setBackground(new Color(0XCEFFCE));
        JRadioButton female = new JRadioButton("Female");
        female.setBackground(new Color(0XCEFFCE));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        jPanel32.add(male);
        jPanel32.add(female);
        jFrame.add(jPanel32);

        JPanel jPanel41 = new JPanel();
        jPanel41.setBackground(new Color(0xFFCFCE));
        GridLayout gridLayout3 = new GridLayout(1, 1);
        jPanel41.setLayout(gridLayout2);
        JLabel jLabel41 = new JLabel("Comments:");
        jPanel41.add(jLabel41);
        jFrame.add(jPanel41);

        JPanel jPanel42 = new JPanel();
        jPanel42.setBackground(new Color(0xFFCFCE));
        jPanel42.setLayout(gridLayout3);
        JTextArea jTextArea = new JTextArea(2, 10);
//        jTextArea.setBackground(new Color(0xFFCFCE));
        jTextArea.setLineWrap(true);
        JScrollPane sp = new JScrollPane(jTextArea);
        jPanel42.add(sp);
        jFrame.add(jPanel42);

        JPanel jPanel51 = new JPanel();
        jPanel51.setBackground(Color.red);
        FlowLayout flowLayout1 = new FlowLayout(FlowLayout.RIGHT);
        jPanel51.setLayout(flowLayout1);
        JButton submit = new JButton("Submit");
        jPanel51.add(submit);
        jFrame.add(jPanel51);

        JPanel jPanel52 = new JPanel();
        jPanel52.setBackground(Color.red);
        FlowLayout flowLayout2 = new FlowLayout(FlowLayout.LEFT);
        jPanel52.setLayout(flowLayout2);
        JButton reset = new JButton("Reset");
        jPanel52.add(reset);
        jFrame.add(jPanel52);

        jFrame.setSize(400, 400);
        jFrame.setLocation(200, 0);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("SWING控件演示");
    }
}
