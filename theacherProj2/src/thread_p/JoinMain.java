package thread_p;
class JoinTh extends Thread
{

	public JoinTh(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			try {
				sleep(1000);
				System.out.println(getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class JoinMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JoinTh t1 = new JoinTh("+");
		JoinTh t2 = new JoinTh("/");
		JoinTh t3 = new JoinTh("&");
		
		//t1.join();
		
		t1.start();
		t1.join(3000); // 3초동안 다른 start를 막는다. 즉 내것만 3초동안 보여짐
		
		t2.start();
		t2.join();
		
		t3.start();
		
		//t1.join();
	}

}
