package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

public class ButtonListener implements ActionListener{

	//处理事件的方法
	//参数e：事件对象
	public void actionPerformed(ActionEvent e) {
		//获取事件源(发生事件的组件)
		Object obj = e.getSource();  //button
		//System.out.println("事件源：" + obj);
		
		//获取按钮上的文字
		JButton but = (JButton) obj;
		String text = but.getText();
		System.out.println(text);
		String command = e.getActionCommand();  //按钮上的指令
		System.out.println(command);
		long l = e.getWhen();  //发生时间
		System.out.println(new Date(l));
	}

}
