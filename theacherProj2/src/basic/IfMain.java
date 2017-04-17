package basic;

public class IfMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int jum =78;
		
		String grade="초기초기";
		if(jum>=90)
		{
			System.out.println("난 참이야");
			System.out.println("수");
			System.out.println("못한 내가");
			grade="A";
		}
		
		else if(jum>=80){
			System.out.println("난 우");
			grade="B";
		}	
		else if(jum>=70){
			System.out.println("난 미");
			grade="C";
		}	
		
		else{
			System.out.println("나머지");
			//grade="F";
		}
		System.out.println("IfMain 클래스 종료");
		System.out.println(grade);
		
/*		// 자동차 성능 테스트를 해보세요
		// 각 점수는 만점 :100점 
		//평점 : 속도 50%, 안정성 : 30%, 연비 : 20%


		예시 :  속도 78, 안정성 82  연비 67
		평점 :  78*0.5  +  82 *0.3  +  67 *0.2
		     
		//평점 80 이상 -  우수, 70이상 - 보통 , 나머지 - 불량
		//모든 점수가 80점이상인 경우 베스트
*/		
		
		int speed = 58, safe = 88, fuel=87;
		double tot = speed*0.5+safe*0.3+fuel*0.2;
		
		String res = "점수:"+tot+", 결과:";
		
		if(tot>=80){
			res+="우수";
			if(speed>=80 && safe>=80 && fuel>=80)
				res+="(베스트)";
			
		}else if(tot>=70){
			res+="보통";
		}else{
			res+="불량";
		}
		
		System.out.println(res);
		//System.out.print();
		System.out.println("ㅎㅎㅎㅎㅎ");
	}

}
