package thread_p;

public class SRSMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		JoinTh t1 = new JoinTh("*");
		JoinTh t2 = new JoinTh("**");
		JoinTh t3 = new JoinTh("***");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(Thread.activeCount());
		Thread.sleep(2000);
		//t1.suspend();
		//Thread.sleep(2000);
		//t2.suspend();
		
		//Thread.sleep(2000);
		//System.out.println(Thread.activeCount());
		//t1.resume();
		//Thread.sleep(3000);
		t1.stop();
		//t2.stop();
		Thread.sleep(3000);
		System.out.println(Thread.activeCount());
		//t3.stop();
		
		t1 = new JoinTh("´º*");
		t1.start();
	}

}
