package simpleclient;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author Faisal
 */
public class SimpleClient {

    public static void main(String[] args) throws IOException {
        
        Socket sock = new Socket("localhost",1000);
        
        DataInputStream dis = new DataInputStream(sock.getInputStream());
        DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

        Scanner input = new Scanner(System.in);
        
        do{
            String msg = new String(dis.readUTF());
            System.out.println("Client: " + msg);
            String str =input.nextLine();
            dos.writeUTF(str);
            
            if(str.equalsIgnoreCase("bye"))
                break;
        }while(true);
        
        dos.close();
        dis.close();
        sock.close();
    }
    
}
