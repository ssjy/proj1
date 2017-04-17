package drawing;

class TestPar
{
	int b = 89;
	void meth_3()
	{
		
	}
}

class Test2 extends TestPar
{
	//int b = 123456;
	int a = 1234;
	
	void meth_1()
	{
		int abc = 5678;
	}
	void meth_2(int c)
	{
		int d = c;
	}
	
	/*void meth_3()
	{
		
	}*/
}
public class Test2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 tt2 = new Test2();
		tt2.meth_1();
		int a = 5555;
		tt2.meth_2(a);
	}

}
