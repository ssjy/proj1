package dynamic;
abstract class AbsPar
{
	int a = 10;
	int b = 20;
	
	void meth_1()
	{
		System.out.println("부모 meth_1()");
	}
	
	abstract void meth_2();
}

class AbsChild extends AbsPar
{
	
	void meth_2() {
		System.out.println("자식 meth_2()");
		
	}
}

public class AbstractMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbsPar pp = new AbsPar(){
			void meth_2() {
				System.out.println("생성시 오버라이딩 meth_2()");
				
			}
		};
		
		pp.meth_1();
		pp.meth_2();
		
		System.out.println("------------------");
		
		AbsChild cc = new AbsChild(){
			void meth_2() {
				System.out.println("자식 생성시 오버라이딩 meth_2()");
				meth_3();
				
			}
			
			void meth_3() {
				System.out.println("자식 생성시 meth_3()");
				System.out.println("super.a:"+super.a);
				System.out.println("this.a:"+this.a);
				System.out.println("a:"+a);
				System.out.println("abc:"+abc);
				System.out.println("-----------------");
				
			}
			
			int a = 1234;
			int abc = 5678;
		};
		cc.meth_1();
		cc.meth_2();
		//cc.meth_3();
		
		System.out.println(cc.a);
	}
	
	
	///// 플레이어를 만드세요
	
	///  MP3(음악파일), 게임기(게임), TV(채널)
	
	// 플레이어에 반드시 있어야 하는 기능: 재생, 일시정지, 종료
	
	/// 부가적 기능은 알아서 넣으세요
	
	
	
	

}
