package excep;

public class TryTryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("try 시작");

			try {
				System.out.println("try try 시작");
				//int b = 10/0;
				System.out.println("try try 끝");
				
			} catch (Exception e) {
				System.out.println("try catch 시작");
				
				System.out.println("try catch 끝");
			}
			
			int a = 10/0;
			
			System.out.println("try 끝");
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("catch 시작");

			try {
				System.out.println("catch try 시작");
				int b = 10/0;
				System.out.println("catch try 끝");
				
			} catch (Exception ee) {
				System.out.println("catch catch 시작");
				
				System.out.println("ca"
						+ "tch catch 끝");
			}
			System.out.println("catch 끝");
		}
	}

}
