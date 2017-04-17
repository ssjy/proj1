package object_p;

import java.util.Scanner;

public class ChamChamCham {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String [] index = {"종료","왼쪽","오른쪽"};
		while(true)
		{
			System.out.println("추억의 게임 참참참");
			for (int i = 0; i < index.length; i++) {
				System.out.print(i+"."+index[i]+", ");
			}
			System.out.print("\n입력:");
			int user=sc.nextInt();
			
			if(user==0)
				break;
			
			int com = (int)(Math.random()*2)+1;
			
			String res = "패";
			if(user==com) res = "승";
			
			System.out.println("게이머:"+index[user]);
			System.out.println("컴퓨터:"+index[com]);
			System.out.println("결과:"+res);
			
		}
		System.out.println("게임종료");
	}

}
