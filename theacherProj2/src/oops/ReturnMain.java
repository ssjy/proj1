package oops;
class ClaRet
{
	int a = 10;
	
	void void_meth()
	{
		System.out.println("ClaRet void_meth()");
		return;
	}
	int int_meth()
	{
		System.out.println("ClaRet int_meth()");
		return 100;
	}
	
	int mem_meth()
	{
		System.out.println("ClaRet mem_meth()");
		
		return a;
	}
	
	int plus(int x, int y)
	{
		System.out.println("ClaRet plus("+x+","+y+")");
		return x+y;
	}
}

class ShapeData
{
	String name;
	int area, border;
}

class RetShape
{
	int recArea(int x, int y)
	{
		return x*y;
	}
	int recBorder(int x, int y)
	{
		return (x+y)*2;
	}
	
	int [] rec(int x, int y)
	{
		//int aa =  x*y;
		//int bb = (x+y)*2; 
		//int [] res = {aa,bb};
		//int [] res = { x*y,(x+y)*2};
		int [] res = { recArea(x, y), recBorder(x, y)};
		return res;
	}
	
	ShapeData shapeData_rec(int x, int y)
	{
		
		ShapeData res = new ShapeData(); 
		res.area=recArea(x, y);
		res.border=recBorder(x, y);
		return res;
	}
}
public class ReturnMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClaRet cr = new ClaRet();
		cr.void_meth();
		//void rrr = cr.void_meth();
		int abc = cr.int_meth();
		System.out.println(abc);
		System.out.println("--------------");
		System.out.println(cr.int_meth()+50);
		System.out.println("--------------");
		System.out.println(cr.mem_meth());
		System.out.println("--------------");
		System.out.println(2*cr.plus(4, 5));
		System.out.println("--------------");
		System.out.println(4+5*2);
		
		/////사각형 넓이, 둘레길이를 구하는 클래스를 구현하세요
        ///넓이, 둘레길이는 메소드로 처리해 주세요
		RetShape rs = new RetShape();
		System.out.println("넓이:"+rs.recArea(4, 5));
		System.out.println("둘레:"+rs.recBorder(4, 5));
		
		/*int [] rr = rs.rec(4, 5);
		System.out.println("넓이:"+rr[0]);
		System.out.println("둘레:"+rr[1]);*/
		
		System.out.println(rs.rec(4, 5)[0]);
		System.out.println(rs.rec(4, 5)[1]);
		
		System.out.println(new RetShape().rec(4, 5)[0]);
		
		
		/////////////////////////////////////////////--->
		int [][] arr = {
				{12,34},{45,56},{67,78}
		};
		
		int sum =0;
		for(int [] aaa : arr)
		{
			System.out.println(new RetShape().rec(aaa[0],aaa[1])[0]);
			sum += new RetShape().rec(aaa[0],aaa[1])[0];
		}
		System.out.println(sum); 
		
		System.out.println("-------------------------------");
		
		ShapeData sd = rs.shapeData_rec(5, 6);
		System.out.println(sd.area);
		System.out.println(sd.border);
		System.out.println(rs.shapeData_rec(5, 6).area);
		System.out.println(new RetShape().shapeData_rec(5, 6).area);
		System.out.println("-------------------------------");
		 sum =0;
		for(int [] aaa : arr)
		{
			
			sum += new RetShape().shapeData_rec(aaa[0],aaa[1]).area;
		}
			System.out.println(sum); 
		
	}

}
