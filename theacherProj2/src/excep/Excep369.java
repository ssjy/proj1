package excep;

import java.util.Arrays;

public class Excep369 {
	
	static int[] 임종천을만들자(int i)
	{
		int [] 임종천 = new int[0];
		
		for(int k =i ;k>0;k/=10)
		{
			int b = k%10;
			
			int [] buf = new int[임종천.length+1];
			for(int m =0; m<임종천.length;m++)
			{
				buf[m] = 임종천[m];
			}
			buf[임종천.length] = b;
			임종천 = buf;
			
		}
		
		return 임종천;
	}
	
	static String 임종천을출력해(int [] 임종천,  String 글자)
	{
		String str ="";
		int cnt=0;
		int i=0;
		//System.out.println(Arrays.toString(임종천));
		for (int j = 임종천.length-1; j >=0 ; j--) {
			i *=10;
			i+=임종천[j];
		}
		
		
		for (int j = 0; j < 임종천.length; j++) {
			
			try{
				int ccc = 1234/(임종천[j]%3);
			}catch(Exception e){
				try {
					int ccc = 1234/(임종천[j]);
					str+=글자;
					cnt++;
				} catch (Exception e2) {
					
				}
				
			}
		}
		try {
			int cde = 1234/cnt;
		} catch (Exception e) {
			str+=i;
		}
		
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i < 3456; i++) {
			
			System.out.println(i+":"+임종천을출력해(임종천을만들자(i),  "짝"));
		}
	}

}
