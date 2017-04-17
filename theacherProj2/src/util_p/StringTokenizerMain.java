package util_p;

import java.util.StringTokenizer;

public class StringTokenizerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "√ﬂ¡÷«Â.±Ë¡¯«‚,,¿±º∫πÆ,πŒ¡§»∆";
		
		String [] arr = str.split(",");
		
		for(String st: arr)
		{
			System.out.println(st);
		}
		
		System.out.println("------------------");
		StringTokenizer stk = new StringTokenizer(str,",.");
		
		//System.out.println(stk);
		
		while(stk.hasMoreTokens())
		{
			System.out.println(stk.nextToken()); 
			
		}

	}

}
