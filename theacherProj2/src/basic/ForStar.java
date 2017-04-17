package basic;

public class ForStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i <5; i++) { //줄
			for (int j = 0; j <=i; j++) {//칸(별)
				System.out.print("*");//별을 한개씩 출력
			}
			
			System.out.println();//줄바꾸기
		}
		
		System.out.println();
		
		for (int i = 0; i <5; i++) { //줄
			for (int j = 5; j >i; j--) {//칸(별)
				System.out.print("*");//별을 한개씩 출력
			}
			
			System.out.println();//줄바꾸기
		}
		
		
		System.out.println();
		
		for (int i = 0; i <5; i++) { //줄
			for (int j = 5-1; j >i; j--) {//빈칸
				System.out.print(" ");//빈칸을 한개씩 출력
			}
			
			for (int j = 0; j <=i; j++) {//칸(별)
				System.out.print("*");//별을 한개씩 출력
			}
			
			
			System.out.println();//줄바꾸기
		}
	}

}
