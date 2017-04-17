package basic;

import java.util.Scanner;

public class WhileMovie2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		String str1="", str2="", str3="";
		int curr = 0;////카테고리를 분기
		total:while(true)
		{
			System.out.println("시작:::>");
		
			switch(curr)////1
			{
				case 0:
				System.out.print("영화종류:");
				int cnt = sc.nextInt();	/////각 카테고리 안에서의 분기
				switch(cnt)///////2
				{
					case 1:
						str1= "액션";
						break;
					case 2:
						str1= "비액션";
						break;
					case 3:
						str1= "안액션";
						break;
					
					case 9:
						continue total;
					case 0:
						str1= "종료";
						break total;
						
					default:
						curr=0;
						continue total;
				}
				
				case 1:
				System.out.print("예약인원:");
				cnt = sc.nextInt();
				
				switch(cnt)//////2
				{
					case 1:
						str2= "성인";
						break;
					case 2:
						str2= "학생";
						break;
					case 3:
						str2= "어린이";
						break;
					case 4:
						str2= "아줌마";
						break;
					case 9:
						continue total;
					case 0:
						
						break total;
					default:
						curr=1;
						continue total;
				}
			
			
			
				case 2:
				System.out.print("예약인원수:");
				cnt = sc.nextInt();
				
				if(cnt==9){///////2
			
					continue total;
				}
				
				if(cnt>=0 && cnt<6)
				{
					if(cnt!=0)
						str3 += cnt+"명";
					
					break total;
				}else{
					curr = 2;
					continue total;
				}			
	
			}
		}
	
		System.out.println(str1+str2+str3);
		System.out.println("예약종료");

	}

}
