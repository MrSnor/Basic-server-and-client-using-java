import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String args[]) {
    try {
      // Instantiate a ServerSocket object and bind it to port 3000
      // This will simply run the server on port 3000
      ServerSocket server = new ServerSocket(3000);
      System.out.println("Server started. Listening on port " + 3000);

      // Now we will wait for the client to connect to our server
      // The accept() method will block the execution until a client connects to the
      // server
      Socket socket = server.accept();
      System.out.println("Client connected: " + socket);

      // Now we will create and object of DataInputStream to read the message sent by
      // the client
      DataInputStream in = new DataInputStream(socket.getInputStream());

      String message = in.readUTF();

      System.out.println(message);

      // Now we will close the connection
      server.close();
    } catch (Exception e) {
      // If any exception occurs we will print it on the console
      System.out.println(e);
    }
  }
}