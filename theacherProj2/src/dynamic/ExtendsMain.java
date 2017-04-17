package dynamic;
class ClaPar
{
	int a = 10;
	void meth_1()
	{
		System.out.println("ClaPar meth_1()");
	}
}

class ClaMister
{

}

class ClaChild extends ClaPar //, ClaMister
{
	int a = 100;
	int b = 2000;
	void meth_1()
	{
		System.out.println("ClaChild meth_1()");
	}
	void meth_2()
	{
		System.out.println("ClaChild meth_2()");
	}
}
class ClaBro extends ClaPar
{
	int c = 3456;
}

public class ExtendsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClaChild cc1 = new ClaChild();
		ClaBro cc2 = new ClaBro();
		ClaPar pp1 = new ClaPar();
		
		ClaPar pp2 = new ClaChild();
		pp2.meth_1();
		System.out.println(pp2.a);
		System.out.println("_--------------");
		cc1.meth_1();
		cc1.meth_2();
		System.out.println("cc1.a:"+cc1.a);
		System.out.println("cc1.b:"+cc1.b);
		//System.out.println("cc1.c:"+cc1.c);
		
		
		cc2.meth_1();
		//cc2.meth_2();
		System.out.println("cc2.a:"+cc2.a);
		//System.out.println("cc2.b:"+cc2.b);
		System.out.println("cc2.c:"+cc2.c);
		
		
		pp1.meth_1();
		//pp1.meth_2();
		System.out.println("pp1.a:"+pp1.a);
		//System.out.println("pp1.b:"+pp1.b);
	}

}
