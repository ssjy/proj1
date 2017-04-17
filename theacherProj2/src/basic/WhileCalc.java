package basic;

import java.util.Scanner;

public class WhileCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//수1 :
		//연산 (+, - , *, / ,% , c(다시하기),  g(종료)): 
		//---> 잘못된 글자가 들어오면 "연산 불가입니다." 메세지 처리
		//수2:
		Scanner sc = new Scanner(System.in);
		sss:while(true)
		{
			System.out.println(
		"주헌 능치못함이 무슨말이냐 믿는자에게는 능치 못할 일이 없느니라");
			
			System.out.print("수1:");
			int su1 = sc.nextInt();
			
			System.out.println("+, - , *, / ,% , c(다시하기),  g(종료)");
			System.out.print("부호:");
			String code = sc.next();
			
			System.out.print("수2:");
			int su2 = sc.nextInt();
			int calc=0;
			
			String str = su1+code+su2+" = ";
			switch(code)
			{
				case "+":
					
					str+=(su1+ su2);
					break;
				case "-":
					str+=(su1- su2);
					break;
				case "*":
					str+=su1* su2;
					break;
				case "/":
					str+=su1/ su2;
					break;
				case "%":
					str+=su1% su2;
					break;
				case "c":
					str="다시하기";
					break;
				case "g":
					break sss;
				default:
					str="연산 불가입니다.";
					break;
			}
			
			
			
			
			System.out.println("결과:"+str);
		}
		System.out.println("계산기 종료");

	}

}
