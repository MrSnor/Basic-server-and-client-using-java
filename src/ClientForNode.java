import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientForNode {
    public static void main(String[] args) {
        try {
            // Create a socket connection to the Node server
            Socket socket = new Socket("localhost", 3000);

            // Create input and output streams for the socket
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            // Create a Scanner to get user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text to send to the server: ");
            String userInput = scanner.nextLine();

            // Send user input to the server
            out.println(userInput);

            // Read the response from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Close the socket and streams
            out.close();
            in.close();
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
