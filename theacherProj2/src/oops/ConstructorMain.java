package oops;
class ClaConst
{
	
	ClaConst()
	{
		this(1234);
		System.out.println("내가 기본생성자다");
		b = 2222;
		
		
	}
	
	ClaConst(int b)
	{
		System.out.println("난 사용자 지정 생성자다:"+b);
		this.b = b;
	}
	
	int b = giveB();
	
	int giveB()
	{
		System.out.println("giveB()");
		return 20;
	}
}
public class ConstructorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClaConst cc = new ClaConst(5678);
		System.out.println(cc.b);
	}

}
