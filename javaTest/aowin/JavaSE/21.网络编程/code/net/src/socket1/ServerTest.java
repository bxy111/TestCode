package socket1;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args)throws Exception {
		//服务器
		ServerSocket server = new ServerSocket(666); //指定服务端口
		//接收一个客户端Socket
		Socket socket = server.accept();  //阻塞式方法
		
		//接收数据
		InputStream in = socket.getInputStream();
		int b = in.read(); //阻塞式
		System.out.println((char)b);
		
		
		System.out.println("end");
		
		
	}

}
