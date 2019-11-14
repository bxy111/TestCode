package event;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lianxi1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		
		Vector<String> leftData = new Vector<String>();
		leftData.add("语文");
		leftData.add("数学");
		leftData.add("英语");
		leftData.add("JAVA");
		
		
		JList<String> leftList = new JList<String>(leftData);
		frame.add(leftList);
		
		JPanel p = new JPanel();
		JButton but1 = new JButton(">>");
		JButton but2 = new JButton("<<");
		//上下排列按钮
		p.setLayout(new GridLayout(2, 1));
		p.add(but1);
		p.add(but2);
		
		frame.add(p);
		
		Vector<String> rightData = new Vector<String>();
		JList<String> rightList = new JList<String>(rightData);
		frame.add(rightList);
		
		
		//增加事件处理
		MoveListener l = new MoveListener(leftList,rightList,leftData,rightData);
		but1.addMouseListener(l);
		but2.addMouseListener(l);
		
		
		
		frame.setSize(300, 300);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
