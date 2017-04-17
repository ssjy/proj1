package object_p;

public class WrapperMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int aa = "123456";
		int aa = Integer.parseInt("123456");
		Integer it = new Integer("123456");
		//aa = it;
		aa = it.intValue();
		
		System.out.println(it+100);
		
		double dd = Double.parseDouble("123.456");
		
		System.out.println(aa+100);
		System.out.println(dd+100);
	}

}
