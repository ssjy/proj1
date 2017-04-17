package threeOOPS;


class ClaStatic
{
	int a = giveA();
	
	int giveA()
	{
		System.out.println("giveA()");
		return 10;
	}
	int c = 30;
	int b =  20;
	static int d = giveD();
	
	int giveB()
	{
		System.out.println("giveB()");
		return c;
	}
	
	static int giveD()
	{
		System.out.println("giveD()");
		return 40;
	}
	
	
	static void meth_1()
	{
		int abc;
		//static int efg;
		System.out.println("static meth_1()시작--------------");
		meth_3();
		//meth_4();
		System.out.println(d);
		//System.out.println(a);
		System.out.println("static meth_1() 끝--------------");
	}
	
	void meth_2()
	{
		int abc;
		//static int efg;
		
		System.out.println("instance meth_2() 시작--------------");
		meth_3();
		meth_4();
		System.out.println(d);
		System.out.println(a);
		System.out.println("instance meth_2() 끝--------------");
	}
	
	static void meth_3()
	{
		System.out.println("static meth_3()");
	}
	
	void meth_4()
	{
		System.out.println("instance meth_4()");
	}
	
	
}
public class StaticMain {

	static void meth4()
	{
		System.out.println("meth_4()");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ClaStatic.d);
		System.out.println("-------------------");
		ClaStatic cs1 = new ClaStatic();
		System.out.println("-------------------");
		ClaStatic cs2 = new ClaStatic();
		System.out.println("-------------------");
		cs1.a =1111;
		cs1.d =4444;
		System.out.println(cs1.a);
		//System.out.println(ClaStatic.a);
		System.out.println(cs1.b);
		System.out.println(cs1.d);
		System.out.println("-------------------");
		System.out.println(cs2.a);
		//System.out.println(ClaStatic.a);
		System.out.println(cs2.b);
		System.out.println(cs2.d);
		cs1.meth_1();
		cs1.meth_2();
		meth4();
	}

}
