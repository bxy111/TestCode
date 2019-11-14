package socket5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTest {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(666);
			List<Socket> slist = new ArrayList<Socket>(); //保存所有客户端的socket
			while(true) {
				Socket socket = server.accept();
				slist.add(socket);
				new MsgThread(socket,slist).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


class MsgThread extends Thread{
	private Socket socket ;
	private List<Socket> slist;
	
	public MsgThread(Socket socket,List<Socket> slist) {
		this.socket = socket;
		this.slist = slist;
	}
	
	public void run() {
		//不断接收客户端的消息
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String line = reader.readLine();
				System.out.println("客户端说：" + line);
				//转发给所有的客户端
				
				for(Socket s:slist) {
					PrintStream out = new PrintStream(s.getOutputStream());
					out.println(line);
					out.flush();
				}
				
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
