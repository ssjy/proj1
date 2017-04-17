package oops;

class StaShape
{
	int area, border;
	StaShape init(int area, int border)
	{
		this.area = area;
		this.border = border;
		return this;
	}
	
	void print()
	{
		String str = area+","+border;
		System.out.println(str);
	}
}

class ClaStaticSort
{
	int c = 30;
	int a = giveA();
	static int d=40;
	static int b = giveB();
	StaShape [] arr;
	
	int e = print();
	
	int giveA()
	{
		StaShape sh = new StaShape();
		arr = 
			new StaShape[]{new StaShape().init(4, 5)};
		System.out.println("giveA()");
		return c;
	}
	
	int print()
	{
		for(StaShape sh: arr)
		{
			sh.print();
		}
		return 0;
	}
	
	
	
	
	static int giveB()
	{
		System.out.println("giveB()");
		return d;
	}
}
public class StaticSortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ClaStaticSort.b);
		ClaStaticSort cs1;
		System.out.println("선언만 -----------------");
		cs1 = new ClaStaticSort();
		System.out.println("cs1 생성후-----------------");
		ClaStaticSort cs2 = new ClaStaticSort();
		System.out.println("cs2 생성후-----------------");
		System.out.println(cs1.a);
		System.out.println(cs1.b);
	}

}
