package oops;
class MethLogic
{
	void cal(MethData [] arr)
	{
		for(MethData me: arr)
		{
			me.rank=1;
			for(MethData com: arr)
			{
				if(me.area<com.area)
				me.rank++;
			}
		}
		
		print(arr);
	}
	
	void print(MethData [] arr)
	{
		for(MethData me: arr)
		{
			me.print();
		}
	}
}
class MethData
{
	String name;
	int r, h, l, rank;
	double area,border;
	
	void init1(String name,	int [] arr)
	{
		this.name = name;
		this.r = arr[0];
		this.h = arr[1];
		this.l = arr[2];
		cal();
		//print();
	}
	
	void init(String name,	int r,int h,int l)
	{
		this.name = name;
		this.r = r;
		this.h = h;
		this.l = l;
		cal();
		//print();
	}
	void print()
	{
		System.out.println(name+":"+area+"("+border+")\t"+rank);
	}
	
	
	
	void cal()
	{
		
		switch(name)
		{
			case "원":
				circle();
				break;
			case "사각형":
				rectangle();
				break;
			case "삼각형":
				triangle();
				break;
		}
		
		
	}
	
	
	void circle()
	{
		
		double pi = 3.14;
		area =r*r*pi;
		border= r*2*pi;
		
	}
	void rectangle()
	{
		
		area = r*h;
		border= (r+h)*2;
		
	}
	void triangle()
	{
		
		area = r*h/2;
		border= r+h+l;
		
	}
}
public class MethodClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethData md1 = new MethData();
		MethData md2 = new MethData();
		
		
		
		md1.init("원", 5, 0, 0);
		md2.init1("사각형", new int [] {5, 4, 0});
		
		MethData [] arr = {md1, md2};
		/*MethLogic ml = new MethLogic();
		ml.cal(arr);
		//ml.print(arr);
*/		new MethLogic().cal(arr);

	}

}
