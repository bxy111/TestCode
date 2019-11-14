package socket4;

import java.net.Socket;

public class ClientTest {

	public static void main(String[] args)throws Exception {
		Socket socket = new Socket("localhost", 666);
		
		ClientWin win = new ClientWin(socket);
		win.showWin();
	}

}
