package practice1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerChat {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ArrayList<Socket> sockets = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(6000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            Socket accept = null;
            try {
                accept = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            sockets.add(accept);
            new WorkThread(accept, sockets).start();
            System.out.println("new client connect.");
        }
    }
}

class WorkThread extends Thread {
    private Socket socket;
    private ArrayList<Socket> al;

    public WorkThread(Socket socket, ArrayList<Socket> al) {
        this.socket = socket;
        this.al = al;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            while (true) {
                //接受客户端输入
                String s = bufferedReader.readLine();
                //转发到所有客户端
                for (Socket socket : al) {
                    OutputStream outputStream = socket.getOutputStream();
                    PrintStream printStream = new PrintStream(outputStream);
                    printStream.println(s);
                    printStream.flush();
                }
            }
        } catch (IOException e) {
            al.remove(socket);
            System.out.println("client exit, so this thread exit.");
        }
    }
}