package dynamic;
class FiPar
{
	int a =10;
	final int b = 20;
	int meth_1(int c)
	{
		System.out.println("부모 메소드_1():"+c);
		return c+100;
	}
	
	final int meth_2(int d)
	{
		System.out.println("부모 메소드_2():"+d);
		return d+200;
	}
}
class FiChild extends FiPar
{
	int a = 10;
	int b = 20;
	
	int meth_1(int c)
	{
		System.out.println("자식 메소드_1():"+c);
		return c+100;
	}
	
	/*int meth_2(int d)//final 된 메소드는 오버라이딩 불가
	{
		System.out.println("자식 메소드_2():"+d);
		return d+200;
	}*/
}
public class FinalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiPar pp = new FiPar();
		pp.a = 1000;
		//pp.b = 2000;
		System.out.println("pp.a:"+pp.a);
		System.out.println("pp.b:"+pp.b);
		System.out.println("pp.m1():"+pp.meth_1(300));
		System.out.println("pp.m2():"+pp.meth_2(600));
		System.out.println("-----------------------");
		FiChild cc = new FiChild();
		cc.a = 1000;
		cc.b = 2000;
		System.out.println("cc.a:"+cc.a);
		System.out.println("cc.b:"+cc.b);
		System.out.println("cc.m1():"+cc.meth_1(300));
		System.out.println("cc.m2():"+cc.meth_2(600));
		System.out.println("-----------------------");
		
		FiPar pc = new FiChild();
		pc.a = 1000;
		//pc.b = 2000;
		System.out.println("pc.a:"+pc.a);
		System.out.println("pc.b:"+pc.b);
		System.out.println("pc.m1():"+pc.meth_1(300));
		System.out.println("pc.m2():"+pc.meth_2(600));
		System.out.println("-----------------------");
		
		
		
		
	}

}
