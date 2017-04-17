package io_p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferdWriterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("fff/bbb.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("À±¼º¹® ¸Þ·Õ\n");
			bw.write("ÃßÁÖÇå¾¾ »óÃ³ ¹ÞÁö ¸¶¼¼¿ä");
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
