package B1;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String []args) throws IOException
    {
        // khoi tao 3 bien kieu String
        String pass;
        int kq,n;
        n=3;
        //tao socket de ket noi toi server
        Socket ClientSocket = new Socket("127.0.0.1",1234);
        //thong bao da ket noi thanh cong
        System.out.println("Connected to server");
        //tao luong nhap du lieu tu ban phim
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in))
        // nhap lieu tu ban phim
        System.out.println("nhap mat khau :");
        pass=inFromUser.readLine();
        // gui len server
        outToServer.writeBytes(pass+'\n');
        // Nhan ket qua tu server
        kq=inFromServer.readLine();;
        if (kq == 1 && n > 0) {
          System.out.println("Pass dung");
        } else if (kq == 0 && n > 0 {
          System.out.println("Pass sai, nhap lai:");
          System.out.println("nhap mat khau :");
          pass=inFromUser.readLine();
          // gui len server
          outToServer.writeBytes(pass+'\n');
          // Nhan ket qua tu server
          kq=inFromServer.readLine();;
          --n;
        } else {
        System.out.println("Pass sai, het so lan nhap");
        }
        //dong luong gui du lieu len server
        outToServer.close();
        //dong luong nhan du lieu tu server
        inFromServer.close();
        //dong socket client
        ClientSocket.close();
    }
 }
        
        
        
        
