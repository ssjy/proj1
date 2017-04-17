package io_p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "fff/littleCow.txt";
		
		try {
			FileInputStream fis = 
					new FileInputStream(name);
			
			int data;
			
			
			while((data=fis.read())!=-1)
			{
				System.out.print((char)data);
			}
			
			fis.close();
			
			System.out.println("\n-------------------");
			
			FileReader fr = 
					new FileReader(name);
			
			
			while((data=fr.read())!=-1)
			{
				System.out.print((char)data);
			}
			
			fr.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
