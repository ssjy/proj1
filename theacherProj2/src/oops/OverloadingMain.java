package oops;

class ClaOver
{
	void meth(int a, String b)
	{
		System.out.println("메소드 원본입니다.:"+a+b);
	}
	
	void meth(int a)
	{
		System.out.println("인수의 갯수가 다른 경우입니다.:"+a);
	}
	void meth(int a, int b)
	{
		System.out.println("인수의 자료형이 다른 경우입니다.:"+a+b);
	}
	
	void meth(String b, int a)
	{
		System.out.println("인수의 순서가 다른 경우입니다.:"+a+b);
	}
	
	/*void meth(int a, String c)
	{
		System.out.println("인수의 이름이 다른것으로는 오버로딩 조건에 맞지 않음.:"+a+c);
	}
	
	int meth(int a, String b)
	{
		System.out.println("리턴형과 오버로딩은 상관없음:"+a+b);
		
		return 1234;
	}
	*/
}

public class OverloadingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClaOver co = new ClaOver();
		co.meth(10,"abc");
		co.meth(10);
		co.meth(20,30);
		co.meth("qwer",30);
	}

}
