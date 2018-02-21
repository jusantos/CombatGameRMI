package br.com.ifce.ppd.client;

import java.io.*;
import java.net.Socket;

import static br.com.ifce.ppd.constants.ServerConstants.SERVER_ADDRESS;
import static br.com.ifce.ppd.constants.ServerConstants.SERVER_PORT;

public class TCPClient {
    private Socket socket;
    private OutputStream ou;
    private Writer ouw;
    private BufferedWriter bfw;

    public void listenTo() throws IOException {
        InputStream in = socket.getInputStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader bfr = new BufferedReader(inr);
        String msg = "";

        while (!"Sair".equalsIgnoreCase(msg))

            if (bfr.ready()) {
                msg = bfr.readLine();
                if (msg.equals("Sair"))
                    System.out.println();
                //Mostrar na tela que chat está desconectado
                else
                    System.out.println();
                //Postar msg
            }
    }

    public void connect() throws IOException {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        ou = socket.getOutputStream();
        ouw = new OutputStreamWriter(ou);
        bfw = new BufferedWriter(ouw);
        bfw.write("Samuel" + "\r\n");
        bfw.flush();
    }
}
