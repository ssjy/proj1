package io_p;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamMain {

	public static void main(String[] args) {
		try {
			FileOutputStream fos 
			= new FileOutputStream("fff/ddd.abc");
			
			DataOutputStream dos =
					new DataOutputStream(fos);
			
			dos.writeInt(123456);
			dos.writeBoolean(true);
			dos.writeDouble(123.456);
			dos.writeUTF("À±¼º¹® ¾È¸¶Á» ÇØºÁ");
			
			dos.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
