package socket2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());

        JLabel clockLabel = new JLabel();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket("localhost", 12345);
                    PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    serverWriter.println("time");
                    String serverResponse = serverReader.readLine();

                    clockLabel.setText(serverResponse);

                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        timer.start();

        frame.add(clockLabel);
        frame.setVisible(true);
    }
}

