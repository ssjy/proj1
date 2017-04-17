package oops;
class DragonMoney
{
	String name;
	static int totMoney =100;
	int myMoney =0;
	
	DragonMoney init(String name)
	{
		this.name = name;
		return this;
	}
	
	void showMeTheMoney(int money)
	{
		if(name=="아빠")
		{
			System.out.println("건강하게만 벌어다오");
			return;
		}
		totMoney-=money;
		myMoney+=money;
		
		System.out.println(name+":"+money+"("+myMoney+")");
		System.out.println("\t잔액:"+totMoney);
	}
	
	void missionComplete(int money)
	{
		if(name!="아빠")
		{
			System.out.println(name+" 건강하게만 자라다오");
			return;
		}
		totMoney+=money;
		myMoney+=money;
		
		System.out.println(name+":"+money+"("+myMoney+")");
		System.out.println("\t잔액:"+totMoney);
	}
}
public class DragonMoneyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DragonMoney son = new DragonMoney().init("아들");
		DragonMoney dau = new DragonMoney().init("딸");
		DragonMoney scv = new DragonMoney().init("아빠");
		
		/*son.name = "아들";
		dau.name = "딸";
		scv.name = "아빠";*/
		
		son.showMeTheMoney(30);
		dau.showMeTheMoney(27);
		son.missionComplete(40);
		scv.missionComplete(70);
		dau.showMeTheMoney(16);
		scv.showMeTheMoney(16);
		son.showMeTheMoney(11);
	}

}
