package br.com.ifce.ppd.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel connectionArea, chatArea, gameArea;
    private JPanel eastPanel;

    /*ConnectionArea*/
    private JLabel labelConnection;
    private JButton buttonConnect, buttonStart;


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
        this.setSize(900, 900);
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

        this.buttonConnect = new JButton("Connect");
        this.buttonConnect.setPreferredSize(new Dimension(5, 5));
        this.buttonStart = new JButton("Start");
        this.buttonStart.setPreferredSize(new Dimension(5, 5));

        this.connectionArea.add(labelConnection);
        this.connectionArea.add(buttonConnect);
        this.connectionArea.add(buttonStart);
    }


    public void buildChatArea() {
        this.chatArea = new JPanel();
        this.chatArea.setPreferredSize(new Dimension(300, 200));
        this.chatArea.setLayout(new BorderLayout());
        this.chatArea.setBorder(BorderFactory.createTitledBorder("Chat"));

        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.scrollText = new JScrollPane(textArea);
        //messagePanel.add(scrollText, BorderLayout.CENTER);
        this.chatArea.add(scrollText, BorderLayout.CENTER);

        JPanel panelText = new JPanel();
        panelText.setLayout(new BorderLayout());
        this.textField = new JTextField();
        //textField.setFont(f);
        this.textField.setToolTipText("Type your message here");
        this.textField.setPreferredSize(new Dimension(220, 30));
        panelText.add(textField, BorderLayout.WEST);

        this.buttonSend = new JButton("Send");
        this.buttonSend.setToolTipText("Click to send your message");
        //buttonSend.addActionListener(new SenderListener());
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
}
