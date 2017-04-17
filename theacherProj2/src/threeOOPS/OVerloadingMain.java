package threeOOPS;
class ClaOVerload
{
	void meth(int a, String b)
	{
		System.out.println("기본메소드:"+a+","+b);
		
	}
	
	void meth(int a)
	{
		System.out.println("매개변수의 갯수가 다른 경우:"+a);
		
	}
	
	void meth(int a, int b)
	{
		System.out.println("매개변수의 자료형이 다른경우:"+a+","+b);
		
	}
	
	void meth( String b, int a)
	{
		System.out.println("매개변수의 순서가 다른 경우:"+a+","+b);
		
	}
}
public class OVerloadingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClaOVerload ov = new ClaOVerload();
		ov.meth(10, "힘을 내세요");
		ov.meth(20);
		ov.meth(30,40);
		ov.meth("잠깐 쉴까요?",50);
	}
	
	//// 컴퓨터를 조립하세요
	// 태블릿 - 본체(이름,가격)
	// 노트북 - 본체(이름,가격), 마우스(이름,가격)
	// 데스크탑 - 본체(이름,가격), 마우스(이름,가격), 키보드(이름,가격)
	///  컴퓨터 - 제품명, 가격 , 부품 등에 대한 정보가 보일 것
	
	
	
	/////// 종류를 구분하세요
	/// 마우스 - 무선/유선, 게이밍/일반
	/// 키보드 - 기계식/전자식, 무선/유선, led/페인팅
	//// 클래스로 입력받고, 클래스를 출력할 것
	///  컴퓨터 - 제품명, 가격 , 제원 등에 대한 정보가 보일 것
	
	

}
