package dynamic;
class Shape
{
	int area;
	int border;
	
	void calArea(){
		System.out.println("부모 calArea()");
	}
	
	void cal()
	{
		calArea();
		System.out.println("area:"+area);
	}
	
}

class Rectangle extends Shape
{
	int x, y;

	public Rectangle(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	void calArea(){
		System.out.println("사각형 calArea()");
		area = x*y;
	}
		
}

class Circle extends Shape
{
	int r;
	double pi = 3.14;

	
	
	public Circle(int r) {
		super();
		this.r = r;
	}



	void calArea(){
		System.out.println("원 calArea()");
		area = (int)(r*r*pi);
	}
		
}


public class ShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Rectangle rec1 = new Rectangle(4, 5);
		
		//rec1.calArea();
		//rec1.cal();
		
		/*Shape sh = new Rectangle(4, 5);
		
		sh.cal();
		
		sh = new Circle(5);
		
		sh.cal();*/
		
		
		Shape [] arr = {
				new Rectangle(4, 5),
				new Circle(5)
		};
		
		for(Shape sh: arr)
		{
			sh.cal();
		}
		
	}

}
