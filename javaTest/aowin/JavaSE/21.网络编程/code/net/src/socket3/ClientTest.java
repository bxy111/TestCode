package socket3;

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
			
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			PrintStream out = new PrintStream(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//客户端从控制台上读取一句话发送给服务器端
			while(true) {
				
				System.out.println("请输入发送给服务器的消息：");
				String msg = console.readLine();
				
				
				out.println(msg);
				out.flush();
				
				//读取服务器回复的消息
				
				msg = reader.readLine();
				System.out.println("服务器说：" + msg);
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
