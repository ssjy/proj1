package net_p;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UnicastSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramSocket ds = new DatagramSocket(); //����Ÿ�׷������� �������ϰ� ������ ������ �����
			InetAddress addr = InetAddress.getLocalHost(); //�� ip�ּ� 
			
			String buf = "������ �����尡 �׸� �����?";
			DatagramPacket data ;
			Scanner sc = new Scanner(System.in);
			while(true)
			{
				System.out.print("�Է�:");
				buf = sc.nextLine();
				data = new DatagramPacket(
						buf.getBytes(),          //�迭
						buf.getBytes().length,   //�迭ũ��
						addr,                    //ip
						7777                     //port��ȣ
					);
				ds.send(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
