package basic;

public class SwitchEaxm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//직급별 월급을 계산 하세요
	    //부장 : 50%, 과장 : 30%, 대리 : 20%, 사원:10%
	    //월급 :  기본급 + 기본급*보너스
	    //직급과 기본급은 입력받아 처리
	  String grade = "과장";
	  
	  int base = 300;
	  double rate=0;
	  
	  switch(grade)
	  {
	  	case "부장":
	  		rate=0.5;
	  		break;
	  	case "과장":
	  		rate=0.3;
	  		break;
	  	case "대리":
	  		rate=0.2;
	  		break;
	  	case "사원":
	  		rate=0.1;
	  		break;
	  }
		
	  int money = (int)(base*(1+rate));
	  System.out.println("직급:"+grade);
	  System.out.println("기본급:"+base);
	  System.out.println("월급:"+money);
		
		double jum = 100;
		String str;
		
		switch((int)jum/10)
		{
			case 9:
			case 10:
				str="수";
				break;
			case 8:
				str="우";
				break;
			case 6:
				str="양";
				break;
			case 7:
				str="미";
				break;
			default :
				str="가";
				break;
		}
		
		
		System.out.println(jum+":"+str);
		
		
		
		double rr = 3.6;
		
		switch((int)(rr*2))
		{
			case 9:
				str = "A+";
				break;
			case 8:
				str = "A";
				break;
			case 7:
				str = "B+";
				break;
			case 6:
				str = "B";
				break;
			case 5:
				str = "C+";
				break;
			case 4:
				str = "C";
				break;
			case 3:
				str = "D+";
				break;
			case 2:
				str = "D";
				break;
			
			default :
				str = "F";
				break;
		}
		
		System.out.println(rr+":"+str);
		
		String str2 = ""+(char)('A'+4-(int)rr);
		
		switch((int)(rr%1+0.5))
		{
			case 1:
				str2+="+";
		}
		
		System.out.println(str2);
		
		System.out.println();
		
		
	}

}
