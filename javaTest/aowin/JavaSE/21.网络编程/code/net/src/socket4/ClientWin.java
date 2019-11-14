package socket4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ClientWin extends JFrame{
	private JTextField tf;
	private JButton but;
	private Socket socket;
	
	public ClientWin(Socket socket) {
		this.socket = socket;
		this.setLayout(new FlowLayout());
		
		tf = new JTextField(15);
		this.add(tf);
		but = new JButton("发送");
		this.add(but);
		
		but.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//发送消息
				try {
					PrintStream out = new PrintStream(socket.getOutputStream());
					out.println(tf.getText());
					out.flush();
					tf.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		this.setSize(300, 300);
		this.setLocation(200, 200);
		
	}
	
	
	public void showWin() {
		this.setVisible(true);
	}
	

}
