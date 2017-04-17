package excep;

public class ThrowExceptionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("try 矫累");
			//int a = 10/0;
			/*Exception ex = new Exception();
			throw ex;*/
			throw new Exception("规蓖不促绊 构扼窍瘤 富磊");
			//System.out.println("try 场");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch"+e.getMessage());
		}
	}

}
