package inter;
interface InAAA
{
	int a = 10; //(final static)
	
	void meth_1();
}

interface InBBB
{
	int a = 1000;
	int b = 2000;
	
	void meth_1();
	void meth_2();
}

class InAAAImpl implements InAAA, InBBB
{
	
	public void meth_1()
	{
		System.out.println("InAAAImpl meth_1()");
	}
	
	public void meth_2()
	{
		System.out.println("InAAAImpl meth_2()");
	}
}
public class InterfaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InAAA inA = new InAAA() {
			
			@Override
			public void meth_1() {
				// TODO Auto-generated method stub
				System.out.println("생성시 재정의한 meth_1()");
			}
		}; 
		
		
		
		inA.meth_1();
		System.out.println("inA.a:"+inA.a);
		//inA.a = 1234;
		System.out.println("InAAA.a:"+InAAA.a);
		
		System.out.println("-----------------------");
		InAAAImpl inAIm = new InAAAImpl();
		inAIm.meth_1();
		//System.out.println("inAIm.a:"+inAIm.a);
		//System.out.println("InAAAImpl.a:"+InAAAImpl.a);
		System.out.println("inAIm.b:"+inAIm.b);
		System.out.println("InAAAImpl.b:"+InAAAImpl.b);
		
		System.out.println("-----------------------");
		inA = inAIm;
		inA.meth_1();
		System.out.println("inA.a:"+inA.a);
		//System.out.println("inA.b:"+inA.b);
		System.out.println("-----------------------");
		InBBB inB = inAIm;
		inB.meth_1();
		System.out.println("inB.a:"+inB.a);
		System.out.println("inB.b:"+inB.b);
		
	}
	
	////  추주헌을 구현하세요
	/// 엄마를 만날때 - 밥 줘요, 잔소리좀 
	/// 선생님 만날때 - 가르쳐주세요, 잔소리좀
	/// 윤성문 만날때 - 사랑합니다, 잔소리좀

}
