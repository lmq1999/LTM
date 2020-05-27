package Bai2;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.format.DateTimeFormatter;  
public class Server {
 
    public static void main(String []args) throws IOException{
 
        // Current Date
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        String DateTime1 = currentDateTime.format(format1);   
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        String Date1 = currentDateTime.format(format2);   
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("hh:mm:ss");  
        String Time1 = currentDateTime.format(format3);   
        DatagramSocket serverSocket = new DatagramSocket(1024);

        //thong bao server da san sang ket noi
        
        System.out.println("Server đã sẵn sàng");
        
        //tao mang byte de chua du lieu gui len tu client
        
        byte inFromClient[];
        
        inFromClient = new byte[256];
        
        int leng = inFromClient.length;
        
        DatagramPacket fromClient = new DatagramPacket(inFromClient, leng);
        
        serverSocket.receive(fromClient);
        
        String data;
        
        data = (new String(fromClient.getData(),0,inFromClient.length)).trim();
        
        int a;
        String kq;

        a = Integer.parseInt(data);
        
        if (a == 1) {
            kq = Date1;
        }else if (a == 2){
            kq = Time1;
        }else if (a == 3){
            kq = DateTime1;
        } else {
            kq = "Khong ton tai";
        }
        byte outToClient[];

        outToClient = kq.getBytes();
        
        //lay kich thuoc mang
        
        leng = outToClient.length;
        
        //lay dia chi cua may khach, no nam luon trong goi ma da gui len server
        
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
