package Bai2;

import java.net.*;
import java.io.*;

public class server {
  public static void main(String []args) throws IOException
  {
    String a = "Chao ban, ban ten gi?";
    int port = 1000;
    String b,c;
    
    InetAddress address = InetAddress.getByName("Localhost");
    int port = fromClient.getPort();
    
    DatagramPacket toClient = new DatagramPacket(a, address, port);
    serverSocket.send(toClient1);
    
    DatagramPacket fromClient = new DatagramPacket(inFromClient, b);
    b = (new String(fromClient1.getData()).trim();
    
    c = ("Rat vui duoc ket noi voi :"+b);
    DatagramPacket toClient2 = new DatagramPacket(c, address, port);
    serverSocket.send(toClient2);
    serverSocket.close();
   }
}
    
    
