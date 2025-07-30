// Task: Implement a Chat Application

// Develop a chat application using Java and
// networking libraries like Socket or Java NIO.
// This task will enhance their knowledge of
// network programming, client-server
// architecture, and message exchange.

import java.io.*;
import java.net.*;

public class task1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Input and Output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // For sending message from server console
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread to receive messages
            Thread receive = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Client: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });

            // Thread to send messages
            Thread send = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = consoleInput.readLine()) != null) {
                        out.println(msg);
                    }
                } catch (IOException e) {
                    System.out.println("Error sending message.");
                }
            });

            receive.start();
            send.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
