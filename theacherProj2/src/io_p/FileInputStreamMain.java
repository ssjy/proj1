package io_p;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Arrays;

public class FileInputStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fis = 
					new FileInputStream("fff/littleCow.txt");
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			byte [] buf = new byte[10];
			
			int data;
			
			
			while((data=fis.read())!=-1)
			{
				System.out.print((char)data);
			}

			/*while(fis.available()>0)
			{
				data = fis.read(buf);
				bos.write(buf, 0, data);
			}*/
			
			System.out.println(Arrays.toString(bos.toByteArray()));
			//System.out.println(new String(bos.toByteArray()));
			
			bos.close();
			fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
