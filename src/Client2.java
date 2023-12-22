import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client2 {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Create a Scanner object to read user inputs
            Scanner scanner = new Scanner(System.in);

            // Loop to continuously read user inputs and send them to the server
            while (true) {
                System.out.print("Enter a message (type 'quit' to exit): ");
                String message = scanner.nextLine();

                // Send the user input to the server
                writer.println(message);

                // Exit the loop if the user types 'quit'
                if (message.equalsIgnoreCase("quit")) {
                    break;
                }

                // Receive and display the server response
                String response = reader.readLine();
                System.out.println( response);
            }

            scanner.close();
            socket.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
