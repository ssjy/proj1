package basic;

public class Work {
	
	public static void main(String[] args) {
		
		int kor = 47, eng = 78, mat = 46;                             //변수선언
		int sum = kor + eng + mat;                                    //총점
		int gobu = 100;                                               //소수점 자리 이동
		double avg = (double)(int)((double)sum/3 *gobu+0.5)/gobu;     //평균 (형변, 반올림)
		
		/*int chk = 10-(int)kor/10;
		String grade = (chk <5 ? chk : 5) +"등급";*/
		String grade = (char)('A'+(kor >= 60 ? 9-kor/10: 5))+"등급";
		
	/*	String grade = kor >= 90 ? "1등급" :                           // 등급 확인
					   kor >= 80 ? "2등급" :
					   kor >= 70 ? "3등급" : 
					   kor >= 60 ? "4등급" : "5등급";  
		String grade2 = eng >= 90 ? "1등급" : 
						eng >= 80 ? "2등급" :
						eng >= 70 ? "3등급" : 
						eng >= 60 ? "4등급" : "5등급";  
		String grade3 = mat >= 90 ? "1등급" : 
						mat >= 80 ? "2등급" :
						mat >= 70 ? "3등급" : 
						mat >= 60 ? "4등급" : "5등급"; */ 
					   
					   
		System.out.println("총점:" + sum);
		System.out.println("평균:" + avg);
		System.out.println("국어:" + kor + " = " + grade);
		/*System.out.println("영어:" + eng + " = " + grade2);
		System.out.println("수학:" + mat + " = " + grade3);
		*/
	}

}
