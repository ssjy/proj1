package io_p;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerExamInMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fis = 
					new FileInputStream("fff/eee.txt"); //파일 명 하나 지정해서 불러옴
			ObjectInputStream ois = new ObjectInputStream(fis); // 객체로 받음
			
			((StudReg)ois.readObject()).print(); 
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
