package event;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		JButton but = new JButton("点击试试看~~~");
		frame.add(but);
		
		//为按钮增加事件处理器，处理按钮点击事件（是按钮的默认行为）
		//关联事件处理器
		but.addActionListener(new ButtonListener());
		
		JTextField tf = new JTextField(15);
		frame.add(tf);
		
		//为输入框增加事件处理器
		//对于TextField来说，组件用来输入。当输入完毕点击回车键确认后
		tf.addActionListener(new TextListener());
		
		
		//给TextField增加鼠标事件：MouseListener    MouseAdapter
		//每个组件上可以增加多个时间处理器，用来处理不同的事件
		//tf.addMouseListener(new MyMouseListener());
		tf.addMouseListener(new MyMouseAdapter());
		
		
		//给TextField增加键盘事件:KeyListener   KeyAdapter
		tf.addKeyListener(new MyKeyListener());
		
		
		
		frame.setSize(300, 300);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
