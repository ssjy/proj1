package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;




public class TCPSingleServer {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocketChannel server = null; 
		try {
			server = ServerSocketChannel.open();
			
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
		
				
				System.out.println("[서버대기]");
				
				SocketChannel client = server.accept();
				System.out.println("연결성공:");
				
				
				new TCPSingleSender(client).start();
				new TCPSingleReciever(client).start();
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				server.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
