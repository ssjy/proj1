package io_p;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DatainputStreamMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		try {
			FileInputStream fis = new FileInputStream("fff/ddd.abc");
			DataInputStream dis = new DataInputStream(fis);
			
			
			System.out.println(dis.readInt());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF()); //utf로 빼면 다른 자료형으로 다 변형가능함
			
			dis.close();
			fis.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
