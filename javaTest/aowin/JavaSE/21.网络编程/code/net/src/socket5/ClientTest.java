package socket5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTest {

	public static void main(String[] args)throws Exception {
		Socket socket = new Socket("localhost", 666);
		
		ClientWin win = new ClientWin(socket);
		win.showWin();
		
		//不断接收服务器端回复的消息
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while(true) {
			String msg = reader.readLine();
			System.out.println("服务器发送：" + msg);
		}
		
	}

}
