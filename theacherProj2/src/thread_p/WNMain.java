package thread_p;

class Product{
	
	boolean chk = false;
	String data;
	
	synchronized void put(String data)
	{
		if(!chk)
		{
			this.data = data;
			
			chk =true;
			System.out.println("입고:"+data);
		}else{
			try {
				wait();
				//현재 들어온 쓰레드가 나가지 못하고 block 대기
				  // 쓰레드 실행으로 인한 프로세스의 낭비를 막음
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	synchronized String get()
	{
		if(!chk)
		{
			try {
				wait();
				//현재 들어온 쓰레드가 나가지 못하고 대기
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		chk =false;
		System.out.println("출고:"+data);
		
		return data;
	}
	
}

class Factory extends Thread
{
	Product pro;

	public Factory(String name,Product pro) {
		super(name);
		// TODO Auto-generated constructor stub
		this.pro = pro;
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(getName()+"_"+i+"번째 입고 시도");
			
			
			pro.put(getName());
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

class Buyer extends Thread
{
	Product pro;

	public Buyer(String name,Product pro) {
		super(name);
		// TODO Auto-generated constructor stub
		this.pro = pro;
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(getName()+"_"+i+"번째 물건사기 시도");
			
			System.out.println(getName()+"_"+i+"::"+pro.get());
			
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

public class WNMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product pro = new Product();
		Factory fc_1 = new Factory("라디오", pro);
		Factory fc_2 = new Factory("tv", pro);
		Buyer bu_1 = new Buyer("bu_1", pro);
		Buyer bu_2 = new Buyer("bu_2", pro);
		
		fc_1.start();
		fc_2.start();
		bu_1.start();
		bu_2.start();
	}

}
