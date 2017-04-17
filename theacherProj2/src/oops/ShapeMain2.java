package oops;

import java.util.Scanner;

class ClaShape2
{
	int type, rank, sort ;
	double area, border, jum;
	String [] name = {"사각형","삼각형","원"}; 
	
	ClaShape2 init(int w, int h)
	{
		type = 0;
		area = w*h;
		border = (w+h)*2;
		cal();
		//print();
		return this;
	}
	ClaShape2 init(int w, int h, int d)
	{
		type = 1;
		area = w*h/2;
		border = w+h+d;
		cal();
		//print();
		return this;
	}
	ClaShape2 init(int r)
	{
		double pi = 3.14;
		type = 2;
		area = r*r*pi;
		border = r*pi*2;
		cal();
		//print();
		return this;
	}
	
	void cal()
	{
		jum = area+border;
		jum = round(jum);
		area = round(area);
		border = round(border);
		
	}
	double round(double dd )
	{	
		return (double)(int)(dd*100)/100;
	}
	void print()
	{
		String str = name[type]+"\t"
				+area+"\t"
				+border+"\t"
				+jum+"\t"
				+rank;
		System.out.println(str);
	}
}
class ShapeAcc
{
	String [] index = {"합계","평균","최대","최소"};
	ClaShape2 [] arr = new ClaShape2[index.length];
	int sort, cnt=0;
	ShapeAcc init()
	{
		for (int i = 0; i < arr.length; i++) {
			arr[i]= new ClaShape2();
			arr[i].name=index;
			arr[i].type = i;
		}
		
		arr[3].area = 999999;
		arr[3].border = 999999;
		arr[3].jum = 999999;
		
		return this;
	}
	
	void cal(ClaShape2 sh)
	{
		cnt++;
		
		arr[0].area+= sh.area;
		arr[0].border+= sh.border;
		arr[0].jum+= sh.jum;
		
		arr[1].area= arr[1].round(arr[0].area/cnt);
		arr[1].border= arr[1].round(arr[0].border/cnt);
		arr[1].jum= arr[1].round(arr[0].jum/cnt);
		
		if(arr[2].area<sh.area)
			arr[2].area=sh.area;
		if(arr[2].border<sh.border)
			arr[2].border=sh.border;
		if(arr[2].jum<sh.jum)
			arr[2].jum=sh.jum;
		
		if(arr[3].area>sh.area)
			arr[3].area=sh.area;
		if(arr[3].border>sh.border)
			arr[3].border=sh.border;
		if(arr[3].jum>sh.jum)
			arr[3].jum=sh.jum;
		
	}
	
}
class ShapeLogic
{
	String [] index = {"입력순서","전체등수","합계 등수"};
	ClaShape2 [] arr;
	int kind;
	ShapeAcc [] acc;
	int maxType=-1;
	int [] shapeType;
	
	void init(ClaShape2 [] arr)
	{ 
		this.arr = arr;
		
		input();
	 	cal();
	 	acc();
	 	rank();
	 	print();
	}
	void input()
	{
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < index.length; i++) {
			System.out.print(i+"."+index[i]);
			
			if(i<index.length-1)
				System.out.print(", ");
		}
		System.out.print("\n입력:");
		kind = sc.nextInt();
		
	}
	
	void cal()
	{
		for(ClaShape2 sh: arr)
		{
			if(maxType<sh.type)
				maxType=sh.type;
		}
		shapeType = new int[maxType+1];
		for(ClaShape2 sh: arr)
		{
			shapeType[sh.type]++;
		}
		
	}
	
	void acc()
	{
		
		if(kind==2)
		{
			acc = new ShapeAcc[shapeType.length];
			for (int i = 0; i < acc.length; i++) {
				acc[i]= new ShapeAcc().init();
				acc[i].sort =0;
				for (int k = 0; k <= i; k++) {
					acc[i].sort+=shapeType[k];
				}
				acc[i].sort--;
			}
		}else{
			acc = new ShapeAcc[1];
			acc[0] =new ShapeAcc().init();
			acc[0].sort = arr.length-1;
			
			
			
		}
		
		for(ClaShape2 sh: arr)
		{
			if(kind==2)
			{
				acc[sh.type].cal(sh);
			}else{
				acc[0].cal(sh);
			}
		}
		
	}
	
	
	
	void rank()
	{
		for(ClaShape2 me: arr)
		{
			me.rank=1;
			if(kind==2)
			{
				for (int i = 0; i < me.type; i++) {
					me.sort+=shapeType[i];
				}
				
			}
			for(ClaShape2 you: arr)
			{
				if(me.jum<you.jum)
				{
					if(kind==2)
					{
						if(me.type==you.type)
						{
							me.rank++;
							me.sort++;
						}
					}else{
						me.rank++;
						if(kind==1)
							me.sort++;
					}
				}
					
			}
		}
	}
	
	void print()
	{
		for (int i = 0; i < arr.length; i++) {
			for(ClaShape2 sh :arr)
			{
				if(i==sh.sort)
					sh.print();
			}
			
			for(ShapeAcc sa :acc)
			{
				if(i==sa.sort)
				{
					System.out.println("----------------------------------------------");
					for(ClaShape2 sh :sa.arr)
					{
						sh.print();
					}
					System.out.println("----------------------------------------------");
				}
			}
		}
	}
	
}
public class ShapeMain2 {

	public static void main(String[] args) {
		
		ClaShape2 [] arr ={
				new ClaShape2().init(4, 5),
                new ClaShape2().init(4, 5, 9),
                new ClaShape2().init(5),
                new ClaShape2().init(5, 6),
                new ClaShape2().init(3, 4, 5),
                new ClaShape2().init(3),
                new ClaShape2().init(2, 3),
                new ClaShape2().init(6, 4, 9),
                new ClaShape2().init(7),
                new ClaShape2().init(4, 10),
                new ClaShape2().init(5, 5, 5),
                new ClaShape2().init(4)
		};
		
		
		new ShapeLogic().init(arr);
	}
}
