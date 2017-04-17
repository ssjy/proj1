package threeOOPS;

class AAA	//클래스의 정의::::> 클래스의 형태를 알려줌
{
	int a; 	//멤버변수::::> 속성
	
	void meth()	//메소드:::>기능
	{
		System.out.println("AAA의 meth()");
	}
	
	/*	클래스의 정의부에 실행구문(제어문) 등을 사용할 수 없다. 
	 for()
	{}
	*/
}
public class ClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AAA a1;		//클래스 변수 선언:::> 접근자를 선언
		a1 = new AAA();	//클래스의 생성
		AAA a2 = new AAA();	//클래스의 생성
		
		//주소  = 동적할당:::>생성자
		a1.meth();	//클래스의 호출
		System.out.println(a1.a);
		a1.a = 1000;
		System.out.println("a1.a:"+a1.a);
		System.out.println("a2.a:"+a2.a);
		
		
		
	}

}
