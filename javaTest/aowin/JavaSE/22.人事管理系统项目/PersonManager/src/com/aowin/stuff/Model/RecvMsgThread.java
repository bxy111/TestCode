package com.aowin.stuff.Model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecvMsgThread extends Thread{
    private JTextArea jTextArea;
    private Socket socket;

    public RecvMsgThread(JTextArea jTextArea, Socket socket) {
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
                jTextArea.setText(text);
            }
        } catch (IOException e) {
            System.out.println("client thead exit.");
        }
    }
}
