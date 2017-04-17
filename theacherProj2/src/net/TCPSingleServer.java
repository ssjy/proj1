package net;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 

 
 
class TCPSingleSender extends Thread implements ActionListener{
    DataOutputStream dos;
    String name;
    ChatForm win;
    public TCPSingleSender(Socket socket,ChatForm win ) {
        this.win = win;
        // TODO Auto-generated constructor stub
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            name = "["+socket.getLocalAddress()+"]";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
       
        
        win.tf.addActionListener(this);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            String msg =win.tf.getText();
            dos.writeUTF(name+msg);
            win.ta.append("\n"+msg);
            win.tf.setText("");
            
            win.ta.setCaretPosition(win.ta.getDocument().getLength());
            ////스크롤바(JTextArea)의 위치를 맨 밑으로 이동
                                   //맨 밑 : JTextArea 내용의 길이
            win.tf.setFocusable(true);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
 
class TCPSingleReceiver extends Thread
{
    DataInputStream dis;
    ChatForm win;
    public TCPSingleReceiver(Socket socket ,ChatForm win) {
        // TODO Auto-generated constructor stub
        this.win = win;
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(dis!=null)
        {
            try {
                //System.out.println(dis.readUTF());
                win.ta.append("\n"+dis.readUTF());
                win.ta.setCaretPosition(win.ta.getDocument().getLength());
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
 
public class TCPSingleServer {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ServerSocket server= new ServerSocket(7777);
            ChatForm win = new ChatForm("서버");
            //System.out.println("서버준비 완료");
            win.ta.setText("서버준비 완료");
            Socket client = server.accept();
            
            if(client!=null)
            {
                win.tf.setEnabled(true);
            }
            
            new TCPSingleSender(client, win).start();
            new TCPSingleReceiver(client, win).start();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
}