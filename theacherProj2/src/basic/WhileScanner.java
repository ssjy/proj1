package basic;

import java.util.Scanner;

public class WhileScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String nn = sc.next();
		System.out.println(nn);
		/*System.out.print("a입력:");
		int a = sc.nextInt();
		
		System.out.println("a:"+(a+100));
		*/
		
		www:while(true)
		{
			System.out.println("재미로 보는 오늘의 점괘");
			System.out.println("점괘:1~3,  종료:0");
			System.out.print("입력:");
			int input = sc.nextInt();
			
			
			
			/*if(input==0)
				break;*/
			
			String str="";
			
			switch(input)
			{
				case 1:
					str="오늘은 복권데이";
					break;
				case 2:
					str="이러나 저러나";
					break;
				case 3:
					str="당장 헤어져!!!";
					break;
				case 0:
					break www;
				default:
					str="잘못누르셨습니다.";
					break;
			}
			System.out.println("결과:"+str);
		}
		
		System.out.println("종료");

	}

}
