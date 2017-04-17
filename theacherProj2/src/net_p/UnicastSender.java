package net_p;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UnicastSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramSocket ds = new DatagramSocket(); //데이타그램소켓은 서버소켓과 소켓의 역할을 모두함
			InetAddress addr = InetAddress.getLocalHost(); //내 ip주소 
			
			String buf = "윤성문 샐러드가 그리 마싰냐?";
			DatagramPacket data ;
			Scanner sc = new Scanner(System.in);
			while(true)
			{
				System.out.print("입력:");
				buf = sc.nextLine();
				data = new DatagramPacket(
						buf.getBytes(),          //배열
						buf.getBytes().length,   //배열크기
						addr,                    //ip
						7777                     //port번호
					);
				ds.send(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
