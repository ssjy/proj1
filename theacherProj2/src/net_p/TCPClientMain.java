package net_p;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TCPClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//Socket socket = new Socket("192.168.1.33", 7777);
			Socket socket = new Socket("192.168.0.29", 7777);
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			System.out.println(dis.readUTF());
			
			dis.close();
			is.close();
			socket.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
