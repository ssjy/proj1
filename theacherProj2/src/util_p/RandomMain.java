package util_p;

import java.util.Random;

public class RandomMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rr1 = new Random();
		Random rr2 = new Random(5);
		Random rr3 = new Random(5);
		
		System.out.println(rr1.nextInt());
		System.out.println(rr1.nextBoolean());
		System.out.println(rr1.nextDouble());
		System.out.println(rr1.nextInt(10));
		
		System.out.println("rr1--------------------");
		for (int i = 0; i <100; i++) {
			System.out.println(rr1.nextInt());
		}
		System.out.println("rr2--------------------");
		for (int i = 0; i <100; i++) {
			System.out.println(rr2.nextInt());
		}
		System.out.println("rr3--------------------");
		for (int i = 0; i <100; i++) {
			System.out.println(rr3.nextInt());
		}
	}

}
