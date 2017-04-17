package basic;

public class HomeWorkMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///구구단
		int col = 4;
		int dan = 9;
		for (int i = 1; i <=dan; i+=col) {
			System.out.println(i+"단");
			for (int j = 1; j < 10; j++) {
				
				int limit = i+col;
				if(limit> dan){ limit = dan+1;}
				for (int k = i; k <limit; k++) {
					System.out.print(
					k+ " x " +j +" = "+i*j+"\t");
				}
				System.out.println();
				
				
			}
		}
		
		
		////369
		
		for(int i = 1;i<100;i++)
		{
			String str = "";
			/*int ten = i/10;
			int one = i%10;*/
			
			
			if (i/10 % 3==0 && i/10!=0) str +="짝";
			if (i%10 % 3==0 && i%10!=0) str +="짝";
			if (str=="") str+=i;
			
			System.out.println(str);
		}
		
		///별
		
/*		3번

	    *
	   **
	  ***
	 ****
	*****








	4번

	 *****
	  ****
	   ***
	    **
	     *




	5번

	      *
	     ***
	    *****
	   *******
	  *********




	6번

	  *********
	   *******
	    *****
	     ***
	      *
	 */
		
		int line = 5;
		String str = "*";
		
		for (int i = 0; i <line; i++) {
			str = "*";
			//if(i%2==0) str="&";
			for (int k = 1; k <=i; k++) {
				System.out.print(" ");
			}
			for (int k = line; k >i; k--) {
				str = "*";
				if(k%2==0) str="&";
				System.out.print(str);
			}
			System.out.println();
		}
		
		System.out.println();
		for (int i = 0; i <line; i++) {
			for (int k = line-1; k >i; k--) {
				
				System.out.print(" ");
			}
			for (int k = 0; k <=i*2; k++) {
				System.out.print(str);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i <line; i++) {
			
			for (int k = 1; k <=i; k++) {
				System.out.print(" ");
			}
			for (int k = line*2; k-1 >i*2; k--) {
			
				System.out.print(str);
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		for (int i = 0; i <line; i++) {
			for (int k = line; k >i; k--) {
				
				System.out.print(str);
			}
			for (int k = 0; k <=i*2; k++) {
				System.out.print(" ");
			}
			for (int k = line; k >i; k--) {
				
				System.out.print(str);
			}
			System.out.println();
		}
		for (int i = 0; i <line; i++) {
			
			for (int k = 0; k <=i; k++) {
				System.out.print(str);
			}
			for (int k = line*2; k-1 >i*2; k--) {
			
				System.out.print(" ");
			}
			for (int k = 0; k <=i; k++) {
				System.out.print(str);
			}
			System.out.println();
		}
		
		System.out.println();
		for (int i = 0; i <line; i++) {
			for (int k = 0; k <=line*2; k++) {
				str="*";
				if(k >= line-i && k <= line+i) str="_";
				 
				System.out.print(str);
			}
			System.out.println();
		}
		for (int i = 0; i <line; i++) {
			for (int k = 0; k <=line*2; k++) {
				str="*";
				if(k>i && k<line*2-i) str="_";
				 
				System.out.print(str);
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		
		for (int i = 0; i <line; i++) {
			for (int k = 0; k <=line*2; k++) {
				str="_";
				if(k>i && k<line*2-i) str="*";
				 
				System.out.print(str);
			}
			System.out.println();
		}
		for (int i = 0; i <line; i++) {
			for (int k = 0; k <=line*2; k++) {
				str="_";
				if(k >= line-i && k <= line+i) str="*";
				
				
				System.out.print(str);
			}
			System.out.println();
		}
		
		
		/////////
		
		System.out.println();
		for (int i = 0; i <line*2; i++) {
			for (int k = 0; k <=line*2; k++) {
				str="*";
				if((line>i && k >= line-i && k <= line+i) || 
				(line<=i && k>i-line && k<line*3-i)) str="_"; 
				
				
				System.out.print(str);
			}
			System.out.println();
		}
		
	}

}
