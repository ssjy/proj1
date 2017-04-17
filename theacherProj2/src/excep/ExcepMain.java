package excep;

public class ExcepMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*try{
			
		}*/
		try{
			int a = 10;
			
			int [] arr = {10,20,30};
			
			//arr[5] =3000;
			
			a = 10/0;
			
			System.out.println("a:"+a);
	
			
		}catch(ArithmeticException e){
			System.out.println("수학적 에러발생");
			//System.exit(0);
			
		}catch(Exception e){
			System.out.println("일반 에러발생");
			return;
		}finally{
			System.out.println("클래스 종료");
		}
		
		
	}

}
