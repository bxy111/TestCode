package layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BorderLayoutTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		//BorderLayout将窗口分成5个方位，每个方位只能放一个组件（单一组件或容器）
		//一个方位放一个组件默认铺满这个方位（借助JPanel）
		//不一定每个方位上都存放组件
		
		//BorderLayout bl = new BorderLayout();
		BorderLayout bl = new BorderLayout(20,10); //设置方位之间的间距：水平间距，垂直间距
		frame.setLayout(bl);

		JButton but = new JButton("北");
		frame.add(but,BorderLayout.NORTH);  //指定位置放组件
		JButton but1 = new JButton("南");
		frame.add(but1,BorderLayout.SOUTH);
		JButton but2 = new JButton("西");
		frame.add(but2,BorderLayout.WEST);
		JButton but3 = new JButton("东");
		frame.add(but3,BorderLayout.EAST);
//		JButton but4 = new JButton("中间");
//		frame.add(but4,BorderLayout.CENTER);
		
		//借助于JPanel
		JPanel p = new JPanel();
		JButton but5 = new JButton("中间按钮");
		p.add(but5);
		JTextField tf = new JTextField(15);
		p.add(tf);
		frame.add(p,BorderLayout.CENTER);
		

		frame.setSize(300, 300);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
