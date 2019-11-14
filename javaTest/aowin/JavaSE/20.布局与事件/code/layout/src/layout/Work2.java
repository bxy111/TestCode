package layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Work2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		GridLayout gl = new GridLayout(5, 2);
		frame.setLayout(gl);
		
		JLabel l1 = new JLabel("Name");
//		Font font = new Font("隶书", Font.BOLD, 15);
//		l1.setFont(font);
		frame.add(l1);
		
		
		
		JTextField tf = new JTextField(10);
		JPanel p = new JPanel();
		//给JPanel增加布局
		p.setLayout(new FlowLayout());
		JLabel ll = new JLabel("           ");
		JLabel ll2 = new JLabel("           ");
		p.add(ll);
		p.add(ll2);
		p.add(tf);
		frame.add(p);
		
		JLabel l2 = new JLabel("Favourite Sports");
		frame.add(l2);
		
		JCheckBox box1 = new JCheckBox("basketball");
		JCheckBox box2 = new JCheckBox("pingpong");
		JCheckBox box3 = new JCheckBox("football");
		JPanel p1 = new JPanel();
		p1.add(box1);
		p1.add(box2);
		p1.add(box3);
		frame.add(p1);
		
		JLabel l3 = new JLabel("Gender");
		frame.add(l3);
		
		JRadioButton rb1 = new JRadioButton("Male");
		JRadioButton rb2 = new JRadioButton("Female");
		//逻辑分组，实现单选
		ButtonGroup g = new ButtonGroup();
		g.add(rb1);
		g.add(rb2);
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 1));
		p2.add(rb1);
		p2.add(rb2);
		frame.add(p2);
		
		
		JLabel l4 = new JLabel("Comments");
		frame.add(l4);
		
		JTextArea area = new JTextArea(2, 2);
		frame.add(area);
		
		JButton but1 = new JButton("submit");
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		p3.add(but1);
		frame.add(p3);
		
		JButton but2 = new JButton("reset");
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p4.add(but2);
		frame.add(p4);
		
		frame.setSize(300, 600);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
