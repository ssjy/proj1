package net_p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

class MultiCastRecieverMain extends Thread {
	ChatHome gu;

	public MultiCastRecieverMain(ChatHome gu) {
		// TODO Auto-generated constructor stub
		this.gu = gu;
	}

	public void run() {
		try {
			MulticastSocket ms = new MulticastSocket(7777);
			InetAddress is = InetAddress.getByName("230.0.0.1");
			ms.joinGroup(is);

			byte[] arr = new byte[1024];
			DatagramPacket ds = new DatagramPacket(arr, arr.length);

			ms.receive(ds);
			gu.ta.append("\n"+new String(arr).trim());
			gu.ta.setText(" ");
			
			
			ms.leaveGroup(is);
			
			gu.ta.setCaretPosition(gu.ta.getDocument().getLength());
			gu.tf.setFocusable(true);
			
			//System.out.println(new String(arr));
			// ms.leaveGroup(is);
			// ms.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
