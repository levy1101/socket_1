package socket2;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = clientReader.readLine();

                if (clientMessage.equals("time")) {
                    Date currentTime = new Date();
                    clientWriter.println("Server time: " + currentTime.toString());
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

