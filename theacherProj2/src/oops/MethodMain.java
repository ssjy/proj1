package oops;

class ClaMeth
{
	int a = 10,d=6666;
	String b = "bbb";
	
	//System.out.println("meth_1() 다.");
	
	class ClaInner // innerClass
	{
		void meth_7()  //
		{
			
		}
	}
	
	void meth_1()	//메소드의 정의 
	{
		int c = 200;
		System.out.println("meth_1() 다."+a+c);
		/// 멤버변수 와 지역변수 동시 사용가능
	}
	/*void meth_1()	//같은 이름의 메소드 정의 불가 
	{	}*/
	void meth_2()	//메소드의 정의 
	{
		//System.out.println("meth_2() 다."+a+c);
		///다른 메소드의 지역변수 사용 불가
		int b = 1234;
		System.out.println("meth_2() 다."+a+b+this.b);
	}
	void meth_3(int d)//매개변수 --> 지역변수
	{
		//int d = 5555;
		System.out.println("meth_3() 다."+d+this.d);
		this.d = d;
	}
	
	void meth_4(int e)
	{
		System.out.println("meth_4() 다.");
		meth_5(e+100);
	}
	void meth_5(int e)
	{
		System.out.println("meth_5() 다.:"+e);
	}
	
	void meth_6()
	{
		System.out.println("meth_6() 다.:");
		
		/*void meth_7()  //메소드 안에서 메소드 정의 불가
		{
			
		}*/
		class ClaInner // 메소드 안에서 클래스 정의 가능
		{
			void meth_7()  //메소드 안 클래스 안 메소드 정의
			{
				
			}
		}
		
	}
	
	void loop_1()
	{
		System.out.println("loop_1()");
		loop_2();
	}
	void loop_2()
	{
		System.out.println("loop_2()");
		loop_3();
	}
	void loop_3()
	{
		System.out.println("loop_3()");
		//loop_1();
	}
	void getValue(int a)
	{
		a = 500;
		System.out.println("getValue("+a+")");
	}
	
	void getAddress(int [] abcd)
	{
		abcd = new int [5];
		System.out.println("getAddress-abcd:"+abcd);
		abcd[1] = 500;
		
		System.out.println("getAddress-abcd[1]:"+abcd[1]);
	}
	
}
public class MethodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClaMeth cm1 = new ClaMeth();
		ClaMeth cm2 = new ClaMeth();
		cm1.meth_1();
		cm1.meth_2();
		System.out.println("cm1.d:"+cm1.d);
		cm1.meth_3(4000);
		System.out.println("cm1.d:"+cm1.d);
		cm1.meth_4(456);
		cm1.loop_1();
		int aaa = 5;
		int [] arr = {3333,4444,5555,6666,7777};
		System.out.println("aaa:"+aaa);
		cm1.getValue(aaa);
		System.out.println("aaa:"+aaa);
		System.out.println("arr[1]:"+arr[1]);
		System.out.println("arr:"+arr);
		cm1.getAddress(arr);
		System.out.println("arr:"+arr);
		System.out.println("arr[1]:"+arr[1]);
	}

}
