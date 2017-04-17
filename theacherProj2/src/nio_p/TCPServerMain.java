package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TCPServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ServerSocketChannel server = null; 
		try {
			server = ServerSocketChannel.open();
			
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			Charset charset = Charset.forName("UTF-8");
			
			
			while(true)
			{
				
				System.out.println("[서버대기]");
				
				SocketChannel client = server.accept();
				InetSocketAddress addr = (InetSocketAddress)client.getRemoteAddress();
				System.out.println("연결성공:"+addr.getHostName());
				
				
				ByteBuffer buf = charset.encode("전쟁나면 도망갈꺼야");
				client.write(buf);
				System.out.println("[데이터 전송완료]:"+addr.getHostName());
				
				
				buf = ByteBuffer.allocate(1024);
				int cnt = client.read(buf);
				
				buf.flip();
				String data = charset.decode(buf).toString();
				System.out.println("["+addr.getHostName()+"에서 받은 데이터]:"+data);
				
				
				
			}
			
			
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
