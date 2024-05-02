package socket1;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("socket1.Server is running...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("socket1.Client connected.");

            BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            String serverMessage;

            while (true) {
                if ((clientMessage = clientReader.readLine()) != null) {
                    System.out.println("socket1.Client: " + clientMessage);
                }

                System.out.print("socket1.Server: ");
                serverMessage = serverReader.readLine();
                clientWriter.println(serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
