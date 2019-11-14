package layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		
		//FlowLayout:流式布局，默认按照从左到右，从上到下
		//frame.setLayout(new FlowLayout());  //
		//frame.setLayout(new FlowLayout(FlowLayout.RIGHT));  //从右边开始添加组件
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));  //同时设置水平间距和垂直间距
		JButton but1 = new JButton("按钮111");
		frame.add(but1);
		JButton but21 = new JButton("按钮22222111");
		frame.add(but21);
		JButton but31 = new JButton("按钮3333111");
		frame.add(but31);
		
		
		frame.setSize(300, 300);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
