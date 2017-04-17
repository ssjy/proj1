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
				System.out.println("������ ������ run");
			}
		}).start();
		
		
		
		new Thread(()->System.out.println("���ٽ����� ������ run")).start();
		
		
		//(a)->System.out.println(a);
		
		
		AAA a1 = new AAA() {

			@Override
			public void print(int a) {
				// TODO Auto-generated method stub
				System.out.println("������ print() ������"+a);
			}
			
			
			
		};
		
		a1.print(10);
		
		
		AAA a2 = (a)->{System.out.println("���ٽ����� ������"+a);};
		
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
