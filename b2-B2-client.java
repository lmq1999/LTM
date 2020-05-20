package Bai2;

import java.net.*;
import java.io.*;

public class client {
   public static void main(String []args) throws IOException 
   { 
      String a, b, c;
      int port = 1000;
      DatagramSocket ClientSocket = new DatagramSocket();
      DataInputStream inFromUser = new DataInputStream(System.in)
      try
      {
          DatagramPacket fromServer1 = new DatagramPacket(inFromServer, a);
          ClientSocket.receive(fromServer);
          System.out.println(+a);

          System.out.println("Nhap vao ten :");
          b = Integer.parseInt(inFromUser();

          InetAddress address = InetAddress.getByName("Localhost");
          DatagramPacket toServer = new DatagramPacket(b, address, port);
          ClientSocket.send(toServer);

          DatagramPacket fromServer2 = new DatagramPacket(inFromServer, c);
          ClientSocket.receive(fromServer2);
          System.out.println(+c);

          ClientSocket.close()
       }catch (UnknownHostException e)
        {
        System.out.println("Server Not Found");
        System.exit(1);
        }catch (IOException e)
        {
        System.out.println("Cannot connect to server");
        System.exit(1);
  }
}
      
