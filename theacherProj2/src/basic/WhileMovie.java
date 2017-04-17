package basic;

import java.util.Scanner;

public class WhileMovie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		//while scanner 을 이용하여 영화예약 프로그램을 생성하세요

		// 영화종류
		//1. 액션  2. 비액션   3. 안액션   4. 다시예매    0. 종료

		// 예약인원
		//1. 성인   2. 학생   3. 어린이    4. 아줌마  5. 다시하기   0. 종료

		// 예약 인원수
		//1~ 5명   9.처음으로   0. 종료

		/////정상예매시  영화예약 내용 화면 출력할 것
		
		Scanner sc = new Scanner(System.in);
		String str1="", str2="", str3="";
		total:while(true)
		{
			System.out.println("시작:::>");
		
			movie:while(true)
			{
				System.out.print("영화종류:");
				int cnt = sc.nextInt();
				switch(cnt)
				{
					case 1:
						str1= "액션";
						break movie;
					case 2:
						str1= "비액션";
						break movie;
					case 3:
						str1= "안액션";
						break movie;
					
					case 9:
						continue total;
					case 0:
						str1= "종료";
						break total;
					
				}
			}
			kind:while(true)
			{
				System.out.print("예약인원:");
				int cnt = sc.nextInt();
				
				switch(cnt)
				{
					case 1:
						str2= "성인";
						break kind;
					case 2:
						str2= "학생";
						break kind;
					case 3:
						str2= "어린이";
						break kind;
					case 4:
						str2= "아줌마";
						break kind;
					case 9:
						continue total;
					case 0:
						
						break total;
					
				}
			}
			
			
			reser:while(true)
			{
				System.out.print("예약인원수:");
				int cnt = sc.nextInt();
				
				if(cnt==9){
			
					continue total;
				}
				
				if(cnt>=0 && cnt<6)
				{
					if(cnt!=0)
						str3 += cnt+"명";
					
					break total;
				}			
				
				
				
			}
		}
	
		System.out.println(str1+str2+str3);
		System.out.println("예약종료");

	}

}
