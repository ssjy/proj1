package io_p;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteSteamBufMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] inArr = { 4, -128, -127, -3, -2, -1, 0, 1, 2, 3, 11, 56, 76, 126, 127 };
		byte[] outArr;
		byte[] buf = new byte[7];
		int cnt = 0;

		ByteArrayInputStream bis = new ByteArrayInputStream(inArr);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		System.out.println("inArr:" + Arrays.toString(inArr)); //불러올 숫자가 있는 배열
		System.out.println("buf:" + Arrays.toString(buf)); // 7칸있는 배열

		cnt = bis.read(buf, 2, 3);
		// param 0:어디에 쓰겠다,
		// param 1:buf의 몇번째 부터
		// param 2:원본에서 몇개 가져오기
		// ret : 가져온 갯수

		System.out.println("read후의 buf:" + Arrays.toString(buf));

		System.out.println("cnt:" + cnt);
		System.out.println("bis.available():" + bis.available());
		// available() 남아있는 갯수(가져올 수 있는 갯수)

		bos.write(buf, 3, 2);
		// param 0:어디에서 가져오겠다.
		// param 1:buf의 몇번째 부터
		// param 2:buf에서 몇개 가져오기

		System.out.println(Arrays.toString(bos.toByteArray())); //바이트 배열 반환

		cnt = bis.read(buf);
		// param : 어디에서 가져오겠다.
		// buf의 0번째 부터
		// buf의 길이까지 가져오기
		// ret : 가져온 갯수

		bos.write(buf);
		// param 0:어디에서 가져오겠다.
		// 0번째 부터
		// buf의 길이까지 가져오기
	}

}
