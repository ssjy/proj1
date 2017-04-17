package basic;

public class ForFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int h = 1; h <=12; h++) {
			System.out.println(h+" 시\n");
			for (int m = 0; m <60; m++) {
				System.out.println("\t"+h+":"+m);
				//System.out.println(h);
			}
			
			//System.out.println(m);
		}
		
		
		///구구단을 완성해보세요
		for (int i = 1; i <10; i++) {
			System.out.println(" ===== "+i+"단 ===== ");
			for (int k = 1; k <10; k++) {
				System.out.println(i+" X " +k+" = "+i*k);
			}
		}
		
		
		for (int i = 1; i <10; i++) {
			System.out.println(" ===== "+i+"단 ===== ");
			for (int k = 1; k <10; k++) {
				System.out.println(i+" X " +k+" = "+i*k);
			}
		}
		
		System.out.println();
		
		for (int i = 1; i <10; i++) {
			
			for (int k = 1; k <10; k++) {
				System.out.print(k+" X " +i+" = "+i*k+"\t");
			}
			System.out.println();
		}
		
		
	}

}
