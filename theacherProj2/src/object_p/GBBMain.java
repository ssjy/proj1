package object_p;

import java.util.Scanner;

public class GBBMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String [] index = {"가위","바위","보","종료"};
		
		String [][] res = {
				{"비김","패","승"},
				{"승","비김","패"},
				{"패","승","비김"}
		};
		while(true)
		{
			System.out.println("추억의 게임 가위바위보");
			for (int i = 0; i < index.length; i++) {
				System.out.print(i+"."+index[i]+", ");
			}
			System.out.print("\n입력:");
			int user=sc.nextInt();
			
			if(user==3)
				break;
			
			int com = (int)(Math.random()*3);
			
			System.out.println("게이머:"+index[user]);
			System.out.println("컴퓨터:"+index[com]);
			System.out.println("결과:"+res[user][com]);
			
		}
		System.out.println("게임종료");
	}

}
