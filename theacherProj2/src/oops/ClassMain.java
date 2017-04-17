package oops;

class AAA
{
	int abc = 10;
	int asdf;
	String str;
	
	void meth()
	{
		System.out.println("AAA.meth() ¿‘¥œ¥Ÿ.");
	}
}

public class ClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AAA a1;
		a1 = new AAA();
		AAA a2 = new AAA();
		
		
		System.out.println(a1);
		a1.meth();
		System.out.println(a2);
		a2.meth();
		
		System.out.println("a1.abc:"+a1.abc);
		System.out.println("a2.abc:"+a2.abc);
		a1.abc = 1000;
		System.out.println("a1.abc:"+a1.abc);
		System.out.println("a2.abc:"+a2.abc);
		
		
		BBB b1 = new BBB();
		System.out.println(b1);
		System.out.println(b1.qwer);
		System.out.println(b1.str);
		System.out.println(b1.arr[0]);
		System.out.println(a1.asdf);
		System.out.println(a1.str);
	}

}
