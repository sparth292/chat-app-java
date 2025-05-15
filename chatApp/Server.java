package ChatAppGUI;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        Socket s1;
        s1 = ss.accept();
        System.out.println("Client aya chat pe");
        
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(s1.getInputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message = "";
        DataOutputStream dataOutputStream = new DataOutputStream(s1.getOutputStream());
        
        String serverMessage = "";

        while(!(message.equalsIgnoreCase("quit") || serverMessage.equalsIgnoreCase("quit"))){

            message = dataInputStream.readUTF(); 
            System.out.println("Client : " + message);

            System.out.println("Enter a message : ");
            serverMessage = bufferedReader.readLine(); 

            dataOutputStream.writeUTF(serverMessage);


            
        }
        dataOutputStream.close();
        dataInputStream.close();
        s1.close();
        bufferedReader.close();
        ss.close();
    }
}
