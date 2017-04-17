package inter;
///기능
	//// mp3 - 듣기, 멈추기
	/// 카메라 - 찍기, 보기
	/// 전화   - 듣기, 전화하기
	/// 핸드폰 - mp3, 카메라, 전화
	
	/// 구현
	///  어른폰 을 만들어 주세요
interface Mp3
{
	void listen();
	void stop();
}
interface Phone
{
	void listen();
	void tel();
}
interface Camera
{
	void photo();
	void view();
}

interface HandPhone extends Mp3, Phone, Camera
{
}

class PhoneData
{
	int listen, tel, photo;

	String name;
	
	
	
	public PhoneData(String name) {
		super();
		this.name = name;
	}



	public String toString() {
		return name+"[listen=" + listen + ", tel=" + tel + ", photo=" + photo + "]";
	}
	
	
}
class AdultPhone implements HandPhone
{
	//String name;
	PhoneData data;
	PhoneData totData;
	
	public AdultPhone(String name,PhoneData totData) {
		super();
		data = new PhoneData(name);
		this.totData = totData;
	}

	@Override
	public void listen() {
		// TODO Auto-generated method stub
		System.out.println(data.name+" 들어요");
		data.listen++;
		totData.listen++;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println(data.name+" 멈춰요");
	}

	@Override
	public void tel() {
		// TODO Auto-generated method stub
		System.out.println(data.name+" 전화해요");
		data.tel++;
		totData.tel++;
	}

	@Override
	public void photo() {
		// TODO Auto-generated method stub
		System.out.println(data.name+" 사진을 찍어요");
		data.photo++;
		totData.photo+=8;
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		System.out.println(data.name+" 사진을 봐요");
	}
}
public class AdultPhoneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PhoneData totData = new PhoneData("전체");
		AdultPhone ap = new AdultPhone("어른폰1", totData);
		AdultPhone ap2 = new AdultPhone("어른폰2", totData);
		
		Mp3 mp3 = ap;
		Phone ph = ap2;
		Camera cm = ap;
		
		mp3.listen();
		mp3.stop();
		ph.tel();
		ph.listen();
		cm.photo();
		cm.view();
		
		System.out.println(ap.data.toString());
		System.out.println(ap2.data.toString());
		System.out.println(totData.toString());
	}

}
