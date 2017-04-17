package oops;

class SelfCall
{
	void meth(int n)
	{
		System.out.println("나 시작:"+n);
		if(n<5)
		{	
			meth(n+1);
		}
		System.out.println("나 끝:"+n);
	}
	
	int add(int n)
	{
		n-=n%2;
		int res=0;
		System.out.println("add 시작:"+n+","+res);
		if(n>0)
			res = n + add(n-1);
		System.out.println("add 끝:"+n+","+res);
		return res;
	}
	
	String str="";
	void memAsc(int n)
	{
		
		if(n>0)
			memAsc(n-1);
		
		str+="*";
		System.out.println(str);
	}
	
	String asc(int n)
	{
		String str="*";
		if(n>0)
			str+=asc(n-1);
		
		System.out.println(str);
		
		return str;
	}
	
	String asc2(int n)
	{
		String str="*";
		if(n>0)
			str+=asc2(n-1);
		
		return str;
	}
	
	void desc(int n)
	{
		System.out.println(asc2(n));
		if(n>0)
			desc(n-1);
	}
	
	
	
}
public class SelfCallMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelfCall sss = new SelfCall();
		//sss.meth(0);
		
		System.out.println(sss.add(7));
		sss.memAsc(5);
		System.out.println();
		sss.asc(5);
		System.out.println();
		
		sss.desc(5);		
	}

}
