package threeOOPS;

//핸드폰을 두개 사서 
//핸드폰1 ->전화를 하고, 사진을 찍고
//핸드폰2 ->전화를 하고, 게임을 해요

//핸드폰을  --> 정의
//두개 ---> 선언
//사서 ---> 생성

class WaterBottle
{
	String cover;
	int water;
	String cap;
	
	void print()
	{
		String str = cover+"\t"+water+"\t"+cap;
		
		System.out.println(str);
	}
}



class HandPhone
{
	String battery, name;
	
	int price, energy=100;
	
	void tel(String number)
	{
		if(this.energy<=0)
		{
			System.out.println(name+ " 배터리가 없어요");
		}else{
			int energy = 20;
			this.energy-=energy;
			number="010-5555-5555";
			System.out.println(name+" "+ number+" 전화해요:"+this.energy);
			
		}
		
	}
	
	void repair(String [] center)
	{
		center[0]="배쨈";
		System.out.println(name+" "+center[0]+" 을 고쳐요");
	}
	
	
	
	String photo(String target)
	{
		int use = 30;
		energy-=use;
		
		System.out.println(name+" 사진을 찍어요:"+energy);
		
		return name+"의 "+target+" 사진";
	}
	void game()
	{
		int use = 50;
		energy-=use;
		System.out.println(name+" 게임해요:"+energy);
		
		return;
	}
	
	
	WaterBottle makeBottle()
	{
		WaterBottle ret = new WaterBottle();
		
		ret.cover = "아이시스";
		ret.water = 500;
		ret.cap = "플라스틱";
		
		return ret;
	}
	
}
public class HandPhoneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandPhone ad = new HandPhone();
		HandPhone gg = new HandPhone();
		
		ad.name = "아이폰7";
		ad.battery = "일체형";
		ad.price = 100;
		
		gg.name = "갤럭시S7";
		gg.battery = "폭파형";
		gg.price = 92;
		
		String num ="010-1234-5678"; 
		ad.tel(num);
		System.out.println("num:"+num);
		
		String pic = ad.photo("공부 ");
		System.out.println(pic);
		
		gg.tel("010-9876-5432");
		gg.game();
		gg.game();
		gg.tel("010-1111-2222");
		
		String [] center = {"액정","카메라","버튼"};
		gg.repair(center);
		System.out.println("center[0]:"+center[0]);
		
		/*WaterBottle wb = gg.makeBottle();
		wb.print();*/
		gg.makeBottle().print();
	}

}
