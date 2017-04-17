package semi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TCPMulServer {
	
	HashMap<String, ObjectOutputStream>list =new HashMap<>();
	
	public TCPMulServer() {
		// TODO Auto-generated constructor stub
		Collections.synchronizedMap(list);
		
		try {
			ServerSocket server = new ServerSocket(7777);
			
			System.out.println("���� ����");
			
			while(true)
			{
				Socket client = server.accept();
				new TCPMulSrvReceiver(client).start();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	class TCPMulSrvReceiver extends Thread
	{
		ObjectInputStream dis;
		ObjectOutputStream dos;
		/**
		 * @param dis
		 * @param dos
		 */
		public TCPMulSrvReceiver(Socket socket) {
			try {
				this.dis = new ObjectInputStream(socket.getInputStream());
				this.dos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String name=null;
			NetData nd = new NetData();
			nd.kind = "chat";
			nd.id =null;
			try {
				name=dis.readUTF();
				
				System.out.println("### "+name+" ����");
				
				nd.data = "### "+name+" ����";
				sendToAll(nd);
				list.put(name, dos);
				nd.data = "### ������ ��:"+list.size();
				System.out.println("### ������ ��:"+list.size());
				sendToAll(nd);
				
				while(dis!=null)
				{
					NetData rd = (NetData)dis.readObject();
					
					if(rd.id==null)
						sendToAll(rd);
					else
						sendToOne(rd);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}finally{
				list.remove(name);
				nd.data = "### "+name+" ����";
				sendToAll(nd);
				nd.data = "### ������ ��:"+list.size();
				sendToAll(nd);
				//System.out.println("### "+name+" ����");
				//System.out.println("### ������ ��:"+list.size());
			}
		}
		
	}
	
	void sendToAll(NetData nd)
	{
		Iterator<String> it = list.keySet().iterator();
		while(it.hasNext())
		{
			try {
				String id = it.next();
				list.get(id).writeObject(nd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void sendToOne(NetData nd)
	{
		try {
		
			list.get(nd.id).writeObject(nd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPMulServer();
	}

}
