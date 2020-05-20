package Bai1;

import java.net.*;
import java.io.*;

public class client {
   
     public static void main(String []args) throws IOException 
    { 
        String a,kq; 
        Socket ClientSocket = new Socket("Localhost", 4567); 
        System.out.println("Connected to server"); 
        
        DataInputStream inFromUser = new DataInputStream(System.in); 
        DataInputStream inFromServer = new DataInputStream(ClientSocket.getInputStream()); 
        DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream()); 
        
        System.out.println("nhap vao so a :"); 
        a=inFromUser.readLine(); 
        outToServer.writeBytes(a+'\n'); 
        
        kq=inFromServer.readLine(); 
        System.out.println(" "+kq); 
        
        outToServer.close(); 
        inFromServer.close(); 
        ClientSocket.close(); 
    } 
}
