package socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",666);
			
			//客户端发送一条消息再接收服务器端的回复
			PrintStream out = new PrintStream(socket.getOutputStream());
			out.println("hello,server");  //一定用println==>匹配readLine()
			out.flush();
			
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = reader.readLine();
			System.out.println("服务器端说：" + msg);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
