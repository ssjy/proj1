package threeOOPS;

//// 두개의 커피점에서 커피를 판매하세요
/// 메뉴 : 아메리카노(원두:20), 카푸치노(원두:15, 우유:10), 
///       카라멜마끼아또(원두:10,우유:10,카라멜:5)
///       유자차(유자:30), 쌍화차(쌍화:25), 경찰차(경찰:15)

///  원두는 본사에서 받아 처리
///  나머지 재료는 각 지점에서 처리
class Material
{
	String name;
	int amount;
	public Material(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	 void print() {
		System.out.println(name + ":" + amount);
	}
	
	
}
class Dabang
{
	static int bean = 100;
	String name;
	
	
	public Dabang(String name) {
		super();
		this.name = name;
	}

	Material [] mater;
	
	void makeBeverage(String order)
	{
		switch(order)
		{
			case "아메리카노":
				bean-=20;
				break;
			case "카푸치노":
				bean-=15;
				 mater[0].amount-=10;
				break;
			case "카라멜마끼아또":
				bean-=10;
				mater[0].amount-=10;
				mater[1].amount-=5;
				break;
			case "유자차":
				mater[2].amount-=30;
				break;
			case "쌍화차":
				mater[3].amount-=25;
				break;
			case "경찰차":
				mater[4].amount-=15;
				break;
		}
		
		print(order);
	}
	
	void print(String order)
	{
		System.out.println(name+" "+order+" 나왔어요==============");
		
		System.out.println("원두:"+bean);
		for(Material mm: mater)
		{
			mm.print();
		}
		
	}
	
}
public class StaticCoffeeMain {

	public static void main(String[] args) {
		Dabang cf1 = new Dabang("떼루와");
		Dabang cf2 = new Dabang("혼자와");
		cf1.mater = new Material[]{
				new Material("우유", 100),
				new Material("카라멜", 80),
				new Material("유자", 70),
				new Material("쌍화", 85),
				new Material("경찰", 90)
			};
		cf2.mater = new Material[]{
				new Material("우유", 100),
				new Material("카라멜", 80),
				new Material("유자", 70),
				new Material("쌍화", 85),
				new Material("경찰", 90)
			};
		
		cf1.makeBeverage("아메리카노");
		cf2.makeBeverage("아메리카노");
		cf1.makeBeverage("카푸치노");
		cf2.makeBeverage("카푸치노");
	}
}
