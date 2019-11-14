package practice1;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChat {
    public static void main(String[] args) {
        ClientWin hello = new ClientWin("QQ");
        hello.openWin();

        new ClientThread(hello.getDisplay(), hello.getSocket()).start();
        System.out.println("client start.");
    }
}

class ClientThread extends Thread {
    private JTextArea jTextArea;
    private Socket socket;

    public ClientThread(JTextArea jTextArea, Socket socket) {
        this.jTextArea = jTextArea;
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String s = null;
            while (true) {
                s = bufferedReader.readLine();
                String text = jTextArea.getText();
                text = text + s + "\n";
                System.out.println(text);
                jTextArea.setText(text);
            }
        } catch (IOException e) {
            System.out.println("client thead exit.");
            return;
        }
    }
}
