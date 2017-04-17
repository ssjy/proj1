package excep;

class MyExcep extends Exception
{
	int num;
	String [] arr = {"À±¼º¹® ¶§¸®±â","À±¼º¹® ²¿Áý±â","À±¼º¹® ¹°±â"};
	public MyExcep(String message) {
		// TODO Auto-generated constructor stub
		
		super(message);
	}
	
	public MyExcep(int i) {
		// TODO Auto-generated constructor stub
		num = i;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return arr[num];
	}
}

public class UserExcepMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//int a = 10/0;
			throw new MyExcep(0);
		} catch (MyExcep e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
			e.printStackTrace();
			
		}
	}

}
