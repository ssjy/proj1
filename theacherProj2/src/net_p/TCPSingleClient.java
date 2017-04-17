package net_p;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;



public class TCPSingleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket = new Socket("192.168.0.29", 7777);
			TCPSingleGUI win = new TCPSingleGUI("클라이언트");
			//System.out.println("서버연결 성공");
			win.ta.setText("서버연결 성공");
			
			new TCPSingleReceiver(socket,win).start();
			new TCPSingleSender(socket,win).start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
