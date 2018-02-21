package br.com.ifce.ppd.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static br.com.ifce.ppd.constants.ServerConstants.SERVER_PORT;

public class TCPServer {
    static Boolean serverIsOn = true;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server listening on port " + SERVER_PORT);

        while (serverIsOn) {
            Socket socket = serverSocket.accept();
            new Thread(new ServerThread(socket)).start();
        }
    }

}
