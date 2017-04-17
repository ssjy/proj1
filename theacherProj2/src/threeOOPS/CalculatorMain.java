package threeOOPS;

import java.util.Arrays;

class Calculator
{
	int add(int x, int y)
	{
		return x+y;
	}
	int sub(int x, int y)
	{
		return x-y;
	}
	int mul(int x, int y)
	{
		return x*y;
	}
	int div(int x, int y)
	{
		return x/y;
	}
	
	int baesu(int start, int end, int gap)
	{
		int ret =0;
		
		/*for (int i = start; i <=end; i++) {
			if(i%gap==0)
			{
				ret+=i;
			}
		}*/
			
			start+=gap-start%gap;
			for (; start <=end; start+=gap) {
			{
				ret+=start;
			}
		}
		
		return ret;
	}
	
	int [] sosu(int start, int end)
	{
		int [] ret = new int[0];
		
		for (int i = start; i <=end; i++) {
			boolean chk = false;
			
			for (int j = 2; j < i; j++) {
				if(i%j==0)
					chk = true;
			}
			
			
			
			if(!chk)
			{
				int [] buf = new int[ret.length+1];
				for (int j = 0; j < ret.length; j++) {
					buf[j] = ret[j];
				}
				buf[ret.length]= i;
				ret = buf;
			}
		}
		
		return ret;
	}
	
}
public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cc = new Calculator();
		int res = cc.add(4, 5);
		System.out.println(res);
		System.out.println(cc.add(4, 5));
		System.out.println(cc.sub(4, 5));
		System.out.println(cc.mul(4, 5));
		System.out.println(cc.div(4, 5));
		
		//baesu(7, 200, 3) ==> 7-> 200, 3의 배수들의 합 
		System.out.println(cc.baesu(7, 20, 3));
		//9,12,15,18
		//sosu(5, 213)    소수 들을 리턴
		
		for(int bb : cc.sosu(5, 213))
		{
			System.out.print(bb+",");
		}
		
	}

}
