package Bai1;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String []args) throws IOException
    {
    String pass;
    String pass_t = "secret";
    int n = 3;
    ServerSocket server = new ServerSocket(1234);
    System.out.println("Server is now already");
    //tao 1 socket do ket noi tu client toi server
    Socket connectionSocket = server.accept();
    //tao luong nhan du lieu tu client
    DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
    // tao luong gui du lieu toi client
    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
    // truyen du lieu vao pass
    pass = inFromClient.readLine();
    // kiem tra pass
    if ( pass.equals(pass_t) {
      kq == 1;
    } else {
      kq == 0;
    }
    if (kq == 1 && n > 0) {
      outToClient.writeBytes(kq+'\n');
      //dong luong nhan du lieu tu client
      inFromClient.close();
      //dong luong gui du lieu ve client
      outToClient.close();
      //dong server socket
      server.close();
    } else if (kq == 0 && n > 0) { 
      outToClient.writeBytes(kq+'\n');
      pass = inFromClient.readLine();
      if ( pass.equals(pass_t) {
        kq == 1;
      } else {
        kq == 0;
      }
    } else {
      inFromClient.close();
      //dong luong gui du lieu ve client
      outToClient.close();
      //dong server socket
      server.close();
    }
  }
}
    
