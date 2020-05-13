package Bai2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client extends Thread {
    private final Socket socket;
    private final InputStream in;
    private final OutputStream out;

    public Client(String serverAddress, int serverPort) throws UnknownHostException, IOException {
        socket = new Socket(InetAddress.getByName(serverAddress), serverPort);
        in = socket.getInputStream();
        out = socket.getOutputStream();
    }

    private void send(String message) throws IOException {
        out.write(message.getBytes());
    }

    @Override
    public void run() {
        byte[] buffer = new byte[2048];
        try {
            while (true) {
                int receivedBytes = in.read(buffer);
                if (receivedBytes < 1)
                    break;
                String message = new String(buffer, 0, receivedBytes);
                System.out.println(message);
            }
        } catch (IOException e) {
        }
        close();
        System.exit(0);
    }

    private void close() {
        try {
            socket.close();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = null;
        String username = scanner.nextLine();
        try {
            client = new Client("127.0.0.1", 1000);
            client.send(username);
            client.start();
            while (true) {
                String message = scanner.nextLine();
                client.send(message);
            }
        } catch (IOException e) {
        }
        if (client != null)
            client.close();
        scanner.close();
    }
}
