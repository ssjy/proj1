package threeOOPS;
class Const
{
	int sum, b, c;
	int avg;
	Const(int a)
	{
		
		System.out.println("사용자 정의 생성자");
		this.a=a;
	}
	
	
	Const(int a, int b, int c)
	{
		
		System.out.println("사용자 정의 생성자");
		this.a=a;
		this.b = b;
		this.c =c;
		
		cal();
		print();
	}
	
	
	void cal()
	{
		sum = a+b+c;
		avg = sum/3;
	}
	
	void print()
	{
		System.out.println(sum);
		System.out.println(avg);
	}
	
	
	
	Const()
	{
		this(5678);
		System.out.println("기본생성자");
		
		
	}
	
	int a = giveA();
	
	int giveA()
	{
		//Const();
		//this();
		System.out.println("giveA()");
		return 10;
	}
	
	
}
public class ConstructorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Const co1 = new Const();
		System.out.println(co1.a);
		//co1.Const();
		new Const(89,96,65);
		
		Const [] arr = {
				new Const(89,96,65),
				new Const(89,26,65),
				new Const(83,96,65)
		};
		
	}
	
	////분식집을 구현하세요
	
	/// 음식을 주문하세요
	// 메뉴 : 떡볶이, 라볶이, 치즈라볶이
	//      라면, 떡라면, 치즈떡라면, 만두라면
///-------------------------------------
//   셋트메뉴를 주문하세요
	/// 가격할인 발생할 것
/// 동시주문의 갯수가 3개 이상일 경우 서비스 메뉴 나갈것

}
