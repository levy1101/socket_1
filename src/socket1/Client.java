package socket1;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader clientReader = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage;
            String clientMessage;

            while (true) {
                System.out.print("socket1.Client: ");
                clientMessage = clientReader.readLine();
                serverWriter.println(clientMessage);

                if ((serverMessage = serverReader.readLine()) != null) {
                    System.out.println("socket1.Server: " + serverMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
