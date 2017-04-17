package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

class TCPSingleSender extends Thread{
	SocketChannel socket;
	String name;
	

	public TCPSingleSender(SocketChannel client) {
		this.socket = client;
		try {
			name = "["+InetAddress.getLocalHost().getHostName()+"]";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			try {
				if(socket!=null && socket.isOpen())
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Charset charset = Charset.forName("UTF-8");
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			
			ByteBuffer buf = charset.encode(name+sc.nextLine());
			try {
				socket.write(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		}
	}
}


class TCPSingleReciever extends Thread{
	SocketChannel socket;
	
	public TCPSingleReciever(SocketChannel client) {
		this.socket = client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Charset charset = Charset.forName("UTF-8");
		
		while(true)
		{
			
			
			try {
				ByteBuffer buf = ByteBuffer.allocate(1024);
				int cnt = socket.read(buf);
				
				if(cnt==-1)
					throw new IOException();
				buf.flip();
				String data = charset.decode(buf).toString();
				System.out.println(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				try {
					if(socket!=null && socket.isOpen())
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
			
			
			
		}
	}
}

public class TCPChatSingleChatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocketChannel socket = null;
		
		try {
			socket = SocketChannel.open();
			socket.configureBlocking(true);
			
			System.out.println("[연결시도]");
			socket.connect(new InetSocketAddress("192.168.0.29", 7777));
			System.out.println("[연결성공]");
			
			new TCPSingleSender(socket).start();
			new TCPSingleReciever(socket).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			try {
				if(socket!=null && socket.isOpen())
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
	}

}
