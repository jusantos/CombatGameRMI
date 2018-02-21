package br.com.ifce.ppd.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    static final Integer PORT_SERVER = 2222;
    static Boolean serverIsOn = true;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT_SERVER);
        System.out.println("Server listening on port " + PORT_SERVER);

        while (serverIsOn) {
            Socket socket = serverSocket.accept();
            new Thread(new ServerThread(socket)).start();
        }
    }

}
