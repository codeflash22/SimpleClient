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
        
        while(!input.nextLine().equals("bye")){
            String msg = new String(dis.readUTF());
            System.out.println(msg);
            dos.writeUTF(input.nextLine());
        }
        
        dis.close();
        dos.close();
        sock.close();
    }
    
}
