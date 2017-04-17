package oops;
class JVM
{
	int a = 10;
	void meth_1()
	{
		int b=100;
		System.out.println("meth_1() 시작:"+a+","+b);
		meth_2();
		a+=10;
		b+=100;
		System.out.println("meth_1() 끝:"+a+","+b);
	}
	void meth_2()
	{
		int b=100;
		System.out.println("meth_2() 시작:"+a+","+b);
		meth_3();
		a+=10;
		b+=100;
		System.out.println("meth_2() 끝:"+a+","+b);
	}
	void meth_3()
	{
		int b=100;
		System.out.println("meth_3() 시작:"+a+","+b);
		a+=10;
		b+=100;
		System.out.println("meth_3() 끝:"+a+","+b);
	}
}
public class JVMMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JVM jj = new JVM();
		jj.meth_1();
	}

}
