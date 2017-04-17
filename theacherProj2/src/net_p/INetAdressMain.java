package net_p;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class INetAdressMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InetAddress ip;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println(ip.getHostName());
			System.out.println(ip.getHostAddress());
			System.out.println(ip);
			System.out.println("------------------------");
			InetAddress [] arr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress addr: arr)
			{
				System.out.println(addr);
			}
			System.out.println("------------------------");
			ip = InetAddress.getLocalHost();
			System.out.println(ip);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
