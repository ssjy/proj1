package lamda;

interface AAA{
	void print(int a);
	
	
}

interface Func{
	int calc(int a, int b);
}

public class LamdaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("생성시 정의한 run");
			}
		}).start();
		
		
		
		new Thread(()->System.out.println("람다식으로 정의한 run")).start();
		
		
		//(a)->System.out.println(a);
		
		
		AAA a1 = new AAA() {

			@Override
			public void print(int a) {
				// TODO Auto-generated method stub
				System.out.println("생성시 print() 재정의"+a);
			}
			
			
			
		};
		
		a1.print(10);
		
		
		AAA a2 = (a)->{System.out.println("람다식으로 재정의"+a);};
		
		a2.print(20);
		
		Func add;
		
		int x = 2;
		
		if(x%2==0)
			add= (a,b)->a+b;
		
		else
			add= (a,b)->a-b;
		
		System.out.println(add.calc(10, 20));
		
	}
	
	

}
