package Bai1;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String []args) throws IOException 
    { 
        String so,kq; 
        
        // tao server socket 
        ServerSocket server = new ServerSocket(4567); 
        System.out.println("Server is now already"); 
        Socket connectionSocket = server.accept(); 
        DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream()); 
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
        so1 = inFromClient.readLine(); 
        if (a<2)
        {
            ketqua="khong phai so nt";
            outToClient.writeBytes(kq+'\n');
        }
        for(int i=2;i<=Math.sqrt(a);i++)
            if (a%i==0)
            {
                ketqua="so nt";
                outToClient.writeBytes(kq+'\n');
            }
                else
            {
                ketqua="khong phai so nt";
                outToClient.writeBytes(kqa+'\n');
            }
       
        inFromClient.close(); 
        outToClient.close(); 
        server.close(); 
    } 
}
