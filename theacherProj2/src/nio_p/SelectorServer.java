package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SelectorServer {

	Selector selector;
	ServerSocketChannel server;
	List<Client> list = new ArrayList<>();
	
	public SelectorServer() {
		// TODO Auto-generated constructor stub
		try {
			selector = Selector.open();
			server = ServerSocketChannel.open();
			server.configureBlocking(false);
			server.bind(new InetSocketAddress(7777));
			
			server.register(selector, SelectionKey.OP_ACCEPT);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Thread th = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					try {
						int cnt = selector.select();
						
						if(cnt ==0)
							continue;
						
						Set<SelectionKey> keys = selector.selectedKeys();
						Iterator<SelectionKey>it = keys.iterator();
						
						while(it.hasNext())
						{
							SelectionKey key = it.next();
							
							if(key.isAcceptable()){
								accept(key);
							}else if(key.isReadable()){
								Client client = (Client)key.attachment();
								client.recieve(key);
							}else if(key.isWritable()){
								Client client = (Client)key.attachment();
								client.send(key);
							}
							
							it.remove();
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		th.start();
		
		
	}
	void accept(SelectionKey key )
	{
		
		try {
			ServerSocketChannel server = (ServerSocketChannel)key.channel();
			SocketChannel socket = server.accept();
			Client client = new Client(socket);
			list.add(client);
			String msg = socket.getRemoteAddress()+" ¿¬°á:"+list.size();
			
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class Client{
		SocketChannel socket;
		String msg;

		public Client(SocketChannel socket) throws IOException {
			this.socket = socket;
			socket.configureBlocking(false);
			SelectionKey key = socket.register(selector, SelectionKey.OP_READ);
			
			key.attach(this);
		}

		void recieve(SelectionKey key )
		{
			
			try {
				ByteBuffer buf = ByteBuffer.allocate(1024);
				int cnt = socket.read(buf);
				
				if(cnt==-1) throw new Exception();
				
				buf.flip();
				Charset charset = Charset.forName("UTF-8");
				String data = charset.decode(buf).toString();
				
				for(Client cc: list)
				{
					cc.msg = data;
					SelectionKey ccKey = cc.socket.keyFor(selector);
					ccKey.interestOps(SelectionKey.OP_WRITE);
				}
				
				selector.wakeup();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				try {
					list.remove(this);
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			
		}
		
		void send(SelectionKey key )
		{
			try {
				Charset charset = Charset.forName("UTF-8");
				ByteBuffer buf = charset.encode(msg);
				socket.write(buf);
				
				key.interestOps(SelectionKey.OP_READ);
				selector.wakeup();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SelectorServer();
	}

}
