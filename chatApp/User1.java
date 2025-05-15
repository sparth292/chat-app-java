package ChatAppGUI;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class User1 {
    public static void main(String[] args) throws Exception{
     
    Socket socket = new Socket("localhost", 9999);
    System.out.println("Connecting to the server");
    
    DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

    String message = "";
    String reply = "";

    while(!(message.equalsIgnoreCase("quit") || reply.equalsIgnoreCase("quit"))) {

        System.out.println("Enter a message : ");
        message = bufferedReader.readLine();

        dataOutputStream.writeUTF(message);
        reply = dataInputStream.readUTF();
        System.out.println("Server: " + reply);
   }
   
   socket.close();
   dataInputStream.close();
   dataOutputStream.close();
   bufferedReader.close();
   
    }
    
}
