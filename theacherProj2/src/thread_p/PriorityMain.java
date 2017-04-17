package thread_p;
class ProTh extends Thread
{
	public ProTh(String name) {
		super(name);
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 1000; i++) {
			System.out.print(getName());
		}
	}
}

public class PriorityMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProTh t1 = new ProTh("+");
		ProTh t2 = new ProTh("/");
		t1.setPriority(1);
		t2.setPriority(10);
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start();
		t2.start();
		
		
	}

}
