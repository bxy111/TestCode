package layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		//frame.setLayout(new FlowLayout());
		frame.setLayout(null);
		JButton but = new JButton("按钮");
		but.setSize(100, 60);
		but.setLocation(50, 100);
		frame.add(but);
		
		
		frame.setSize(300, 300);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
