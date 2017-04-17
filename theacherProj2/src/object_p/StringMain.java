package object_p;

public class StringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "眠林清 玫犁";
		String str2 = "眠林清 玫犁";
		String str3 = new String("眠林清 玫犁");
		System.out.println(str1);
		System.out.println(str1.hashCode());
		System.out.println(str1.toString());
		System.out.println(str2);
		System.out.println(str2.hashCode());
		System.out.println(str2.toString());
		System.out.println("眠林清 玫犁");
		System.out.println("眠林清 玫犁".hashCode());
		System.out.println("眠林清 玫犁".toString());
		System.out.println(str3);
		System.out.println(str3.hashCode());
		System.out.println(str3.toString());
		
		System.out.println(str1.getClass());
		System.out.println(str2.getClass());
		System.out.println("眠林清 玫犁".getClass());
		
		System.out.println(str1=="眠林清 玫犁");
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str3=="眠林清 玫犁");
		
		System.out.println("---------------------");
		System.out.println(str1.equals("眠林清 玫犁"));
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str3.equals("眠林清 玫犁"));
		System.out.println(str1.length());
		
	}

}
