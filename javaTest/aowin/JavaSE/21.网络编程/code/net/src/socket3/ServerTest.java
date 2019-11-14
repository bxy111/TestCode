package socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(666);
			Socket socket = server.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			PrintStream out = new PrintStream(socket.getOutputStream());
		
			while(true) {
				//接收客户端发送过来的消息
				
				String msg = reader.readLine();
				System.out.println("客户端说：" + msg);
				
				//服务器端回复消息
				
				System.out.println("请输入回复给客户端的消息：");
				msg = console.readLine();
				
				
				out.println(msg);
				out.flush();
			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
