package br.com.ifce.ppd.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientGui extends JFrame implements ActionListener, KeyListener, Runnable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    ServerSocket ss;

    private JPanel connectionArea, chatArea, gameArea;
    private JPanel eastPanel;

    /*ConnectionArea*/
    private JLabel labelConnection;
    private JButton buttonRestart, buttonStart;


    /*ChatArea*/
    private JTextField textField;
    private JButton buttonSend;
    private JTextArea textArea;
    private JScrollPane scrollText;

    public ClientGui() {
        this.sizeAndShow();
        this.buildPanel();
        this.buildGameArea();
    }

    public void sizeAndShow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 300);
        //this.setMinimumSize(new Dimension(500, 200));
        this.setVisible(true);
        this.requestFocus();
    }


    public void buildConnectionArea() {

        this.connectionArea = new JPanel();
        this.connectionArea.setPreferredSize(new Dimension(300, 100));
        this.connectionArea.setLayout(new GridLayout(3, 1));
        this.connectionArea.setBorder(BorderFactory.createTitledBorder("Connection Area"));

        this.labelConnection = new JLabel("DISCONNECTED");
        this.labelConnection.setForeground(Color.red);

        this.buttonStart = new JButton("Start");
        this.buttonStart.setPreferredSize(new Dimension(5, 5));
        this.buttonRestart = new JButton("Restart");
        this.buttonRestart.setPreferredSize(new Dimension(5, 5));

        this.connectionArea.add(labelConnection);
        this.connectionArea.add(buttonStart);
        this.connectionArea.add(buttonRestart);
    }


    public void buildChatArea() {
        this.chatArea = new JPanel();
        this.chatArea.setPreferredSize(new Dimension(300, 200));
        this.chatArea.setLayout(new BorderLayout());
        this.chatArea.setBorder(BorderFactory.createTitledBorder("Chat"));

        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.scrollText = new JScrollPane(textArea);
        this.chatArea.add(scrollText, BorderLayout.CENTER);

        JPanel panelText = new JPanel();
        panelText.setLayout(new BorderLayout());
        this.textField = new JTextField();
        this.textField.setToolTipText("Type your message here");
        this.textField.setPreferredSize(new Dimension(220, 30));
        panelText.add(textField, BorderLayout.WEST);

        this.buttonSend = new JButton("Send");
        this.buttonSend.setToolTipText("Click to send your message");
        panelText.add(buttonSend, BorderLayout.EAST);

        this.chatArea.add(panelText, BorderLayout.SOUTH);
    }

    public void buildGameArea() {

        this.eastPanel.setLayout(new GridLayout(2, 1));
        this.eastPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel sidePanel = new JPanel();
         /*
         sidePanel.setLayout(new GridBagConstraints());
         GridBagConstraints c = new GridBagConstraints();
         c.fill = GridBagConstraints.BOTH;
         c.gridx = 8;
         c.gridy = 0;
         c.fill = GridBagConstraints.BOTH;
         c.weighty = 1;
         c.ipady = 10;*/

        /*Connection Area*/
        //c.gridx = 1;
        //c.gridx = 0;
        this.buildConnectionArea();
        sidePanel.add(this.connectionArea);

        /*Chat Area*/
        //c.gridx = 2;
        //c.gridx = 1;
        this.buildChatArea();
        sidePanel.add(this.chatArea);


        this.eastPanel.add(sidePanel);
    }

    public void buildPanel() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        this.eastPanel = new JPanel();
        c.add(eastPanel, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        /*
         *nomeDoSocket.println(textArea.getText());
         * nomeDoSocket.flush();
         * textArea.setText("");
         * textArea.requestFocus();
         */

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void run() {

    }
}
