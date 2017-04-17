package io_p;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class BufferedReaderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//FileInputStream fis = 
			//		new FileInputStream("fff/littleCow.txt");
			FileReader fr = new FileReader("fff/littleCow.txt");
			BufferedReader br = 
					new BufferedReader(fr);
			
			int data=0;
			/*
			while((data=br.read())!=-1)
			{
				System.out.print((char)data);
			}*/
			String line;
			while((line=br.readLine())!=null)
			{
				data++;
				System.out.println(data+":"+line);
			}
			
			
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
