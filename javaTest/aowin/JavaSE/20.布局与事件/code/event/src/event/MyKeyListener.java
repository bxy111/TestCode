package event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

//键盘事件
public class MyKeyListener extends KeyAdapter{
	
	@Override
	public void keyTyped(KeyEvent e) {
		JTextField tf  = (JTextField) e.getSource();
		char c = e.getKeyChar();  //输入的字符
		System.out.println(c);
		
	}

}
