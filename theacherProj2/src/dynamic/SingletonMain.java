package dynamic;
class SinAAA
{
	int a=10;
	SinAAA()
	{
		System.out.println("SinAAA 생성자");
	}
}

class SinBBB
{
	private int a=20;
	
	private static SinBBB me; // 여기부터
	
	private SinBBB()
	{
		System.out.println("SinBBB 생성자");
	}
	
	static SinBBB getInIn()
	{
		if(me==null)
			me = new SinBBB();
		
		return me;
	}                            // 여기까지보면 겟인스턴스를 한 것을 알수있다.

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	
}
public class SingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinAAA a1 = new SinAAA();
		SinAAA a2 = new SinAAA();
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a1.a);
		System.out.println(a2.a);
		System.out.println("----------------------");
		SinBBB b1 = SinBBB.getInIn();
		SinBBB b2 = SinBBB.getInIn();
		
		//b1.me = SinBBB.getInIn();
		//b1.me = null;
		//b1.a = 20000;
		b1.setA(20000);
		//SinBBB.a = 2222;
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1.getA());
		System.out.println(b2.getA());
	}

}
