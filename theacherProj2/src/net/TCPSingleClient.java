package net;

import java.net.Socket;
 
 
 
public class TCPSingleClient {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        try {
            Socket socket = new Socket("192.168.0.29", 7777);
            ChatForm win = new ChatForm("클라이언트");
            //System.out.println("서버연결 성공");
            win.ta.setText("서버연결 성공");
            if(socket!=null)
            {
                win.tf.setEnabled(true);
            }
            new TCPSingleReceiver(socket,win).start();
            new TCPSingleSender(socket,win).start();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
 
}