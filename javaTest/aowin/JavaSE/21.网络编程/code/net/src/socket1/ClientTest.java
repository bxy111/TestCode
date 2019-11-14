package socket1;

import java.io.OutputStream;
import java.net.Socket;

public class ClientTest {
	public static void main(String[] args)throws Exception {
		//客户端
//		Socket socket = new Socket("192.168.0.101", 666);
		Socket socket = new Socket("localhost", 666);
		
		//客户端向服务器端发送消息==》客户端使用输出流    服务器端使用输入流
		OutputStream out = socket.getOutputStream();
		out.write('a');
		out.flush();
		
		
	}

}
