package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TCPClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocketChannel socket = null;
		
		try {
			socket = SocketChannel.open();
			socket.configureBlocking(true);
			
			System.out.println("[����õ�]");
			socket.connect(new InetSocketAddress("192.168.1.16", 7777));
			System.out.println("[���Ἲ��]");
			
			Charset charset = Charset.forName("UTF-8");
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			int cnt = socket.read(buf);
			
			buf.flip();
			String data = charset.decode(buf).toString();
			System.out.println("[���� ������]:"+data);
			
			buf = charset.encode("[���� ������]:"+data);
			socket.write(buf);
			System.out.println("[������ ������ ���ۿϷ�]");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
