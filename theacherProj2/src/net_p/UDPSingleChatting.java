package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import net.ChatForm;

class UDPSingleSender extends Thread implements ActionListener{
	
	String name;
	ChatForm win;
	int port;
	String ip;
	public UDPSingleSender(ChatForm win, String ip, int port) {
		// TODO Auto-generated constructor stub
		
		try {
			
			this.win = win;
			this.ip = ip;
			this.port = port;
			
			name = "["+InetAddress.getLocalHost()+"] ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			win.tf.addActionListener(this);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
        	
        	
        	DatagramSocket ds = new DatagramSocket();
			InetAddress addr = InetAddress.getByName(ip);
			
			String buf = name+" "+win.tf.getText();
			
			DatagramPacket data = new DatagramPacket(
					buf.getBytes(), 
					buf.getBytes().length, 
					addr, 
					port
				);
			ds.send(data);
			win.ta.append("\n"+"[³ª] "+win.tf.getText());
            win.tf.setText("");
            
            
            win.ta.setCaretPosition(win.ta.getDocument().getLength());
            win.tf.setFocusable(true);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

class UDPSingleReceiver extends Thread
{
	int port;
	ChatForm win;
	
	
	/**
	 * @param win
	 * @param port
	 */
	public UDPSingleReceiver(ChatForm win, int port) {
		this.win = win;
		this.port = port;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			DatagramSocket ds = new DatagramSocket(port);
		
			byte [] arr = new byte[1024];
			DatagramPacket data = new DatagramPacket(arr, arr.length);
			
			while(true)
			{
				
				ds.receive(data);
				win.ta.append("\n"+new String(arr).trim());
                win.ta.setCaretPosition(win.ta.getDocument().getLength());
		
			}
				
			
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class UDPSingleChatting {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int port =7777;
			ChatForm win = new ChatForm("UDP Single");
			win.tf.setEnabled(true);
			
			
			new UDPSingleSender(win,"192.168.1.10",port).start();
			new UDPSingleReceiver(win,port).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
