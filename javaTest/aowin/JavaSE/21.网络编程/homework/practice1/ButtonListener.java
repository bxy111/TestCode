package practice1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ButtonListener implements ActionListener {
    private JTextArea src;
    private Socket socket;

    public ButtonListener(JTextArea src, Socket socket) {
        this.src = src;
        this.socket = socket;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = src.getText();
        if ("".equals(text)) {
            return;
        }
        src.setText("");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        String content = "client[" + format + "]:" + text;

        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println(content);
            printStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
