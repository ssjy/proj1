package thread_p;

class Mother
{
	int total =100;
	
	
	synchronized boolean showMeTheMoney(int money, String name)
	{
		if(!name.equals("아빠"))
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return total>=money;
		}
		System.out.println("scv 주제에");
		return false;
		
	}
	
	synchronized boolean missionComplete(int money,String name)
	{
		if(name.equals("아빠"))
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 100<money;
		}
		System.out.println("건강하게만 자라다오");
		return false;
		
	}
}

class DragonMoney extends Thread
{
	Mother mom;
	int myMoney=0;
	public DragonMoney(String name,Mother mom) {
		super(name);
		// TODO Auto-generated constructor stub
		this.mom = mom;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(mom.total>0)
		{
			int money= (int)(Math.random()*50+1);
			
			if(mom.showMeTheMoney(money, getName()))
			{
				mom.total-=money;
				myMoney += money;
				
				System.out.println(getName()+":"+money+"("+myMoney+")");
				System.out.println("\t잔액:"+mom.total);
			}
			
			money= (int)(Math.random()*150+1);
			
			if(mom.missionComplete(money, getName()))
			{
				mom.total+=money;
				myMoney += money;
				
				System.out.println(getName()+":"+money+"("+myMoney+")");
				System.out.println("\t잔액:"+mom.total);
			}
		}
	}
}

public class SynchMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mother mom = new Mother();
		
		DragonMoney son = new DragonMoney("아들", mom);
		DragonMoney dau = new DragonMoney("딸", mom);
		DragonMoney scv = new DragonMoney("아빠", mom);
		
		son.start();
		dau.start();
		scv.start();
	}

}
