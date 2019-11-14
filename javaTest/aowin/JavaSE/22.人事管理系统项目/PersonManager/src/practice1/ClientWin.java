package practice1;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.Socket;

public class ClientWin extends JFrame {
    private String name;
    private JTextArea display;
    private Socket socket;

    public ClientWin(String name) throws HeadlessException {
        this.name = name;
    }

    public JTextArea getDisplay() {
        return display;
    }

    public Socket getSocket() {
        return socket;
    }

    public void openWin() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 6000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        this.socket = socket;

        this.setLayout(new BorderLayout());
        JTextArea jTextArea = new JTextArea(15, 20);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        this.add(jScrollPane, BorderLayout.NORTH);
        this.display = jTextArea;

        JTextArea jTextField = new JTextArea(2, 20);
        jTextField.setLineWrap(true);
        JScrollPane jScrollPane1 = new JScrollPane(jTextField);
        this.add(jScrollPane1, BorderLayout.CENTER);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton send = new JButton("send");
        jPanel.add(send);
        this.add(jPanel, BorderLayout.SOUTH);

        send.addActionListener(new ButtonListener(jTextField, socket));

        this.setSize(400, 400);
        this.setLocation(200, 0);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(name);
    }
}
