package util_p;

import java.io.FileInputStream;
import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*char [] str = new char[1024];
		int cnt=0;
		while(true)
		{
			str[cnt] = (char)System.in.read();
				
			if(str[cnt]=='\r')  //엔터값 '\r'은 13과 같음
				break;
			
			cnt++;
		}
		char [] res = new char[cnt];
		for (int i = 0; i < res.length; i++) {
			res[i]=str[i];
		}
		
		System.out.println(res);*/
		//System.out.println(cnt);
		
		Scanner sc = new Scanner(System.in);
		
		FileInputStream fis = new FileInputStream("fff/love.txt");
		sc = new Scanner(fis);
		
		int aa = sc.nextInt();
		double dd = sc.nextDouble();
		sc.nextLine();
		String str = sc.nextLine();
		
		
		System.out.println(aa);
		System.out.println(dd);
		System.out.println(str);
		
	}

}
