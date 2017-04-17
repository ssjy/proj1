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
				
				System.out.println("[�������]");
				
				SocketChannel client = server.accept();
				InetSocketAddress addr = (InetSocketAddress)client.getRemoteAddress();
				System.out.println("���Ἲ��:"+addr.getHostName());
				
				
				ByteBuffer buf = charset.encode("���ﳪ�� ����������");
				client.write(buf);
				System.out.println("[������ ���ۿϷ�]:"+addr.getHostName());
				
				
				buf = ByteBuffer.allocate(1024);
				int cnt = client.read(buf);
				
				buf.flip();
				String data = charset.decode(buf).toString();
				System.out.println("["+addr.getHostName()+"���� ���� ������]:"+data);
				
				
				
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
