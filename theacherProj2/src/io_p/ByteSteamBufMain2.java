package io_p;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteSteamBufMain2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte [] inArr = {4,-128,-127,-3,-2,-1,0,1,2,3,11,56,76,126,127};
		byte [] outArr;
		byte [] buf = new byte[4];
		int cnt=0, len;
		
		ByteArrayInputStream bis = new ByteArrayInputStream(inArr);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		
		
		
		while(bis.available()>0) // 인풋스트림에 남아있는 갯수가 0보다 크면 반복
		{
			cnt++;
			len=bis.read(buf); // buf만큼 읽어옴
			bos.write(buf,0,len); //버프에 0번째부터 len을 가져온다
			
			System.out.println(Arrays.toString(buf));
		}
		System.out.println("-------------------");
		outArr = bos.toByteArray(); //배열 반환
		System.out.println(cnt);
		System.out.println("inArr"+Arrays.toString(inArr));
		System.out.println("outArr"+Arrays.toString(outArr));
	}

}
