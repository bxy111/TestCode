package socket4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(666);
		
		Socket socket = server.accept();
		
		//服务器不断接收客户端的消息
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while(true) {
			String msg = reader.readLine();
			System.out.println("客户端说：" + msg);
		}
		
	}

}
