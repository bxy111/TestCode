package socket2;

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
			
			//先接收客户端消息再回复
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = reader.readLine();
			System.out.println("客户端说：" + msg);
			
			//回复
			PrintStream out = new PrintStream(socket.getOutputStream());
			out.println("hello");
			out.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
