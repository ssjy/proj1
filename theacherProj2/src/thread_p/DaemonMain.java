package thread_p;
class DaeTh extends Thread
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				sleep(3000);
				System.out.println("자동저장");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class TTT extends Thread
{

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 20; i++)  {
			try {
				sleep(1000);
				System.out.println("TTT"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
public class DaemonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaeTh dd = new DaeTh();
		TTT tt = new TTT();
		dd.setDaemon(true);
		dd.start();
		tt.start();
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("저장"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
