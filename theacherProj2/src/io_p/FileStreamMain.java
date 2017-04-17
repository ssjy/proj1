package io_p;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FileStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fis = 
					new FileInputStream("fff/bsy.jpg"); // 파일을 불러온다
			
			FileOutputStream fos = 
					new FileOutputStream("fff/sss.jpg"); //파일을 가져온다
			
			byte [] buf = new byte[1024];
			
			int data;
			
			while(fis.available()>0)
			{
				data = fis.read(buf);
				
				fos.write(buf, 0, data); //버프에 0번째부터 data값을 가져온다
				
				System.out.println(Arrays.toString(buf));
			}
			
			fos.close();//가져오는 거 닫고
			fis.close();//불러오는거 닫음
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
