package layout;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayoutTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		//GridLayout:格子布局，将界面分成几行几列的表格
		//每个组件占满一个格子
		//按照从左到右，从上到下顺序
		//如果组件的数量和格子的数量不匹配，行数不变，通过修改列的数量来匹配组件数量
		
//		GridLayout gl = new GridLayout();  //一行一列
//		frame.setLayout(gl);
//		JButton but = new JButton("button");
//		frame.add(but);
//		JButton but2 = new JButton("button22222");
//		frame.add(but2);  //多出一列
		
		//GridLayout gl = new GridLayout(3, 2);  //3行2列
		GridLayout gl = new GridLayout(3, 2,20,10);  //3行2列，设置水平间距和垂直间距
		frame.setLayout(gl);
		for(int i=0;i<10;i++) {
			JButton but = new JButton("but---" + i);
//			JPanel p = new JPanel();
//			p.add(but);
			frame.add(but);
		}
		
		
		
		frame.setSize(300, 300);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
