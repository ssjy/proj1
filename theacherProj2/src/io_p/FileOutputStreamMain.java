package io_p;

import java.io.FileOutputStream;

public class FileOutputStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String str = "�İ����� ��������� �Ǿ��� �ٵ�\���� �����ٴ�!!!!";
		String str = "ejfowefjeojfoewf";
		
		try {
			FileOutputStream fos = new FileOutputStream("fff/abcd.txt");
			
			//fos.write('A');
			
			for (int i = 0; i < str.length(); i++) {
				fos.write(str.charAt(i));
				// str�� i��°�� fos�� �����´�.
				
			}
			
			
			fos.close(); // �ݴ´�.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
