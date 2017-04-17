package dynamic;
///////////
//////핸드폰을 조립해서 판매하세요
/// 기기종류 : 핸드폰 ---> 전화, 사진찍기, 인터넷 
///  기기타입 : 안드로이드폰, 아이폰, ms폰
////안드로이드 - 구글 크롬, 구글 플레이, 폭탄, 카메라
///   아이폰  - 쉬리, 안들림, 카메라
///   ms폰 - 익스플로러, 느린부팅, 엑셀, 포토샵, 카메라

class HandPhone
{
	String name;
	
	
	public HandPhone(String name) {
		super();
		this.name = name;
	}

	void tel()
	{
		System.out.println(name+ " 전화해요");
	}
	
	void photo(){
		System.out.println(name+ " 사진찍어요");
	}
	
	void internet(){
		System.out.println(name+ " 인터넷 해요");
	}
}

class Android extends HandPhone
{

	public Android() {
		super("안드로이드");
		// TODO Auto-generated constructor stub
	}
	
	void photo(){
		System.out.println(name+ " 카메라로 사진찍어요");
	}
	
	void internet(){
		System.out.println(name+ " 구글 크롬 해요");
	}
	
	void play(){
		System.out.println(name+ " 구글 플레이 해요");
	}
	void bomb(){
		System.out.println(name+ " 구글 폭탄 해요");
	}
	
}

class IPhone extends HandPhone
{

	public IPhone() {
		super("아이폰");
		// TODO Auto-generated constructor stub
	}
	
	void photo(){
		System.out.println(name+ " 고화질 카메라로 사진찍어요");
	}
	
	void internet(){
		System.out.println(name+ " 쉬리 해요");
	}
	
	void tel(){
		System.out.println(name+ " 안들려요");
	}
	
}

public class HandPhoneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HandPhone [] phones = {
				new Android(),
				new IPhone()
		};
		
		for(HandPhone hp : phones)
		{
			hp.internet();
			hp.tel();
			hp.photo();
			//hp.play();
			System.out.println("-----------------");
			
		}
		
		((Android)phones[0]).bomb();
	}

}
