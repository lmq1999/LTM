package Bai1;

import java.io.DataInputStream;

import java.io.IOException;

import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;

import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {

    public static void main(String []args) throws IOException{
    Scanner sc = new Scanner( System.in );
    //tao moi socket client
    
    DatagramSocket ClientSocket = new DatagramSocket();
    
    System.out.println("Đã kết nối đến server");
    
    //nhap yeu cau tu nguoi dung
    
    DataInputStream inFromUser = new DataInputStream(System.in);
    
    try{
    
    System.out.println("Nhap vao ten web :");
    
    String name =  new String (sc.nextLine());
    
    
    //Khai bao mang byte de chua du lieu gui di server
    
    byte outToServer[];
    
    
    //chuyen kieu du lieu : String -> byte va dua vao mang byte da khai bao o tren
    
    outToServer = name.getBytes();
    
    //lay kich thuoc cua mang
    
    int leng = outToServer.length;
    
    //dia chi may chu
    
    InetAddress address = InetAddress.getByName("Localhost");
    
    // so port
    
    int port = 1024;
    
    // tao goi de gui di
    
    DatagramPacket toServer = new DatagramPacket(outToServer, leng, address, port);
    
    
    // gui goi len server
    
    ClientSocket.send(toServer);
    
    
    //tao goi de nhan du lieu ve
    
    byte inFromServer[];
    
    inFromServer = new byte[256];
    
    //kich thuoc mang nhan du lieu ve
    
    leng = inFromServer.length;
    
    // tao goi nhan du lieu ve
    
    DatagramPacket fromServer = new DatagramPacket(inFromServer, leng);
    
    // nhan goi tra ve tu server
    
    ClientSocket.receive(fromServer);
    
    //khai bao bien de chuyen tu kieu byte sang kieu String
    
    String data;
    
    // dua du lieu tu mang byte vao bien data, lay tu vi tri so 0.
    
    data = (new String(fromServer.getData(),0,fromServer.getLength())).trim();
    
    //in ket qua ra man hinh
    
    System.out.println(""+data);
    
    ClientSocket.close();
    
    }catch (UnknownHostException e){
    
    System.out.println("Server Not Found");
    
    System.exit(1);
    
    }catch (IOException e){
    
    System.out.println("Cannot connect to server");
    
    System.exit(1);
    
    }
 }
}
