package threeOOPS;
class Grand
{
	int a = 111111;
	int e = 555555;
}
class Par1 extends Grand
{
	
	public Par1(int a) {
		
		this.a = a;
		arr = new int[a];
	}

	int a =10;
	int [] arr;
	int pa = super.a;
	
	void meth_1()
	{
		System.out.println("부모1 meth_1()");
	}
}

class Par2
{
}
class Child1 extends Par1//, Par2
{
	
	public Child1(int aaa, int b) {
		
		super(3);
		this.b = b;
		this.a = aaa;
	}

	int b = 200;
	int a = 100;
	int pa = super.a;
	//int ga = super.super.a;
	//int e = 500;
	String e = "efefef";
	int ga = super.pa;
	void meth_2()
	{
		System.out.println("자식1 meth_2()");
	}
	
	void meth_1()	//메소드의 오버라이딩은 리턴형이 맞아야 함
	//int meth_1()
	{
		System.out.println("자식1 meth_1()");
		//return 1234;
	}
}

class Child2 extends Par1
{
	
	public Child2() {
		super(7777);
	}
	
	int c = 3333;
	void meth_3()
	{
		System.out.println("자식2 meth_3()");
	}
}
public class InheritanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Par1 pp1 = new Par1(333333);
		Child1 cc1 = new Child1(2323,5645);
		Child2 cc2 = new Child2();
		
		pp1.a = 1234;
		
		System.out.println("pp1.a:"+pp1.a);
		System.out.println("cc1.a:"+cc1.a);
		System.out.println("cc1.pa:"+cc1.pa);
		System.out.println("cc1.ga:"+cc1.ga);
		System.out.println("cc1.e:"+cc1.e);
		//System.out.println("cc1.super.a:"+cc1.super.a);
		System.out.println("cc2.a:"+cc2.a);
		//System.out.println("pp1.b:"+pp1.b);
		System.out.println("cc1.b:"+cc1.b);
		//System.out.println("cc2.b:"+cc2.b);
		
		cc1.meth_1();
		cc1.meth_2();
	}

}
