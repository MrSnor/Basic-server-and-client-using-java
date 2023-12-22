import java.io.*;
import java.net.*;

public class Server2 {
  private static final int SERVER_PORT = 1234;

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);) {

      System.out.println("Server started. Listening on port " + SERVER_PORT + "...");

      while (true) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket);

        handleClient(clientSocket);

        clientSocket.close();
        System.out.println("Client disconnected: " + clientSocket);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void handleClient(Socket clientSocket) {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

      String message;
      while ((message = reader.readLine()) != null) {
        System.out.println("Received from client: " + message);

        // Send a response to the client
        writer.println("Server received: " + message);

        // Exit the loop if the client types 'quit'
        if (message.equalsIgnoreCase("quit")) {
          break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
