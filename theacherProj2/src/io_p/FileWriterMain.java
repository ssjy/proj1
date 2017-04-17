package io_p;

import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "fff/bsy.jpg";

		try {

			int data;
			FileReader fr = new FileReader(name);
			
			FileWriter fw = new FileWriter("fff/www.jpg");

			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
				fw.write(data);
			}

			fw.close();
			fr.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
