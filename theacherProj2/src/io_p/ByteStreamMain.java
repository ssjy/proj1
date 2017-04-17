package io_p;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte [] inArr = {4,-128,-127,-3,-2,-1,0,1,2,3,11,56,76,126,127};
		byte [] outArr;
		for(byte bb : inArr)
		{
			System.out.println(bb+":"+(int)bb); //보이는 그대로 출력
		}
		
		System.out.println("-------------------------");
		
		ByteArrayInputStream bis = new ByteArrayInputStream(inArr); //숫자배열을 불러옴
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); //숫자배열을 출력하기위함
		
		int data; //숫자형 변수선언
		int cnt =0; 
		while((data = bis.read())!=-1) //data는 숫자배열을 대입한 것과 같고 음수가 아닐때(더이상 읽어드릴 값이 없을때 -1반환하는 int read)
		{
			cnt++; // cnt상승
			System.out.println(data+":"+(byte)data); // data는 양수로만 나옴 + byte로 형변환한 data는 원래값대로나옴
			bos.write(data); //bos에 각 data대입
			
		}
		System.out.println("-------------------------");
		System.out.println(cnt);
		System.out.println("-------------------------");
		outArr = bos.toByteArray(); // 보스.바이트어레이를 배열에 대입
		try {
			bis.close(); // 불러오는 배열 닫음
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(inArr));
		System.out.println("-------------------------");
		System.out.println(Arrays.toString(outArr));
		
		
		
		/*System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());*/
	}

}
