package net_p;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UniCastReciever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket ds = new DatagramSocket(7777);

			byte[] arr = new byte[1024];

			DatagramPacket data = new DatagramPacket(arr, arr.length);
			while (true) {
				ds.receive(data);

				System.out.println("¹ÞÀ½:" + new String(arr));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
