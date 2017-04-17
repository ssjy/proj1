package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

class MultiCastSender extends Thread implements ActionListener {

	ChatHome gu;

	public MultiCastSender(ChatHome gu) {
		super();
		this.gu = gu;
	}

	public void run() {
		gu.tf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			MulticastSocket ms = new MulticastSocket();
			String msg = "µþ±â ºßÆä¢¾"+gu.tf.getText();
			InetAddress is = InetAddress.getByName("230.0.0.1");
			Scanner sc = new Scanner(System.in);

			System.out.println("ÀÔ·Â:");
			msg = sc.nextLine();
			DatagramPacket ds = new DatagramPacket(msg.getBytes(), msg.getBytes().length, is, 7777);
			ms.send(ds);

			//ms.close();
		} catch (IOException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
	}

}
