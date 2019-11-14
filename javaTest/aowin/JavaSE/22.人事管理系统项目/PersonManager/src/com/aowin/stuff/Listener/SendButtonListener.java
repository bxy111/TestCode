package com.aowin.stuff.Listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendButtonListener implements ActionListener {
    private Socket socket;
    private JTextArea jTextArea;
    private String name;
    private PrintStream printStream;

    public SendButtonListener(Socket socket, JTextArea jTextArea, String name) {
        this.socket = socket;
        this.jTextArea = jTextArea;
        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = jTextArea.getText();
        if ("".equals(text)) {
            return;
        }
        jTextArea.setText("");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        String content = "["+ name + "-" + format + "]:" + text;

        if (printStream == null) {
            OutputStream outputStream = null;
            try {
                outputStream = socket.getOutputStream();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("get socket output stream failed");
                return;
            }
            printStream = new PrintStream(outputStream);
        }
        printStream.println(content);
        printStream.flush();
    }
}
