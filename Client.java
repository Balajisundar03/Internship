import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 1234);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            // Thread to read messages from the server
            new Thread(() -> {
                String response;
                try {
                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Read input from user and send to server
            String userInput;
            while ((userInput = keyboard.readLine()) != null) {
                out.println(userInput);
                if (userInput.equalsIgnoreCase("/exit")) {
                    break;
                }
            }

            socket.close();
            System.out.println("Disconnected from chat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
