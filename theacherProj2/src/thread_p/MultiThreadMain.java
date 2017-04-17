package thread_p;

class MulTh extends Thread
{

	public MulTh(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			try {
				sleep(50);
				System.out.print(getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

public class MultiThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MulTh t1 = new MulTh("+");
		MulTh t2 = new MulTh("/");
		
		t1.start();
		t2.start();
	}

}
