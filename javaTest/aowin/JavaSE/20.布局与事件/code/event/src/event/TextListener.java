package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TextListener implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();  //事件源
		System.out.println("事件源：" + obj);
		JTextField tf = (JTextField) obj;
		System.out.println("输入内容：" + tf.getText());
	}

}
