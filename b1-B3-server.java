package Bai1;

import java.io.DataInputStream;

import java.io.IOException;

import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;

import java.net.UnknownHostException;

public class Server {

public static void main(String []args) throws IOException

{
    String s1 = "dantri.com";
    String s2 = "24h.com.vn";
    String s3 = "vnexpress.net";
    // tao ket noi
    
    DatagramSocket serverSocket = new DatagramSocket(1024);
    
    //thong bao server da san sang ket noi
    
    System.out.println("Server đã sẵn sàng");
    
    //tao mang byte de chua du lieu gui len tu client
    
    byte inFromClient[];
    
    inFromClient = new byte[256];
    
    int leng = inFromClient.length;
    
    serverSocket.receive(fromClient);
    
    // tao goi de nhan du lieu gui len tu client

    DatagramPacket fromClient = new DatagramPacket(inFromClient, leng);
    
    // nhan goi ve server
    
    serverSocket.receive(fromClient);
    //tao bien data kieu string de lay du lieu trong goi ra
    
    String data,data1;
    
    data = (new String(fromClient.getData(),0,inFromClient.length)).trim();
    String ip;
    //xu ly
    if (s1.equals(data)) {
        ip = "222.255.27.51";
    } else if (s2.equals(data)){
        ip = "125.212.247.65";
    } else if (s3.equals(data)){
        ip = "111.65.250.2";
    } else {
        ip = "Khong ton tai";
    }
    data1 = String.valueOf(ip);
    // dong goi ket qua
    byte outToClient[];
    outToClient = data1.getBytes();
    
    //lay kich thuoc mang
    leng = outToClient.length;
    InetAddress address = fromClient.getAddress();

    // lay so port
    
    int port = fromClient.getPort();
    
    // tao goi de gui ve client
    
    DatagramPacket toClient = new DatagramPacket(outToClient, leng, address, port);
    //gui goi ve client
    
    serverSocket.send(toClient);
    
    //dong socket
    
    serverSocket.close();
    
    }
}
