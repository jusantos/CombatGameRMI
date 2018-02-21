package br.com.ifce.ppd.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = this.socket.getInputStream();
            OutputStream outputStream = this.socket.getOutputStream();

            outputStream.write(("Server threat working").getBytes());
            outputStream.close();
            inputStream.close();
            System.out.println("Request processed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
