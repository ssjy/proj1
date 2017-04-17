package excep;

public class Try369 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i <=20; i++) {
			try {
				int a =1234/(i%10%3);
				
				System.out.println(i);
			} catch (Exception e) {
				try {
					int b = 123456/(i%10);
					System.out.println("¦");
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(i);
				}
				
			}
		}
	}

}
