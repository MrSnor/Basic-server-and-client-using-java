import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {

        try {
            // Now we will create a socket object and connect it to the server
            // Here localhost means that the server is running on the same machine as the
            // client
            // If the server is running on a different machine then we will have to enter
            // the IP address of that machine instead of localhost
            // 3000 is the port number on which the server is running
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Connected to server at " + socket);
            // Now we will create an object of DataOutputStream to send the message to the
            // server
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            Scanner sc = new Scanner(System.in);
            // Now we will ask the user to enter the message that he wants to send to the
            // server
            System.out.println("Enter the message that you want to send to the server:");
            String message = sc.nextLine();

            // Now we will send the message to the server
            out.writeUTF("message = " + message);

            // Now we will close the connection
            out.flush();
            // flush method forces any buffered output bytes to be written out

            out.close();
            socket.close();
            sc.close();
        }
        // If any exception occurs we will print it on the console
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
