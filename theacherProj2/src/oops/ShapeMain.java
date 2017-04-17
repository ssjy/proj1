package oops;

class ClaShape
{
	String name;
	double area, border;
	
	void rectangle(int w, int h)
	{
		name = "사각형";
		area = w*h;
		border = (w+h)*2;
		print();
	}
	void triangle(int w, int h, int d)
	{
		name = "삼각형";
		area = w*h/2;
		border = w+h+d;
		print();
	}
	void circle(int r)
	{
		double pi = 3.14;
		name = "원";
		area = r*r*pi;
		border = r*pi*2;
		print();
	}
	void print()
	{
		System.out.println(name+":"+area+"("+border+")");
	}
}
public class ShapeMain {

	public static void main(String[] args) {
		ClaShape cs = new ClaShape();
		cs.rectangle(4, 5);
		cs.triangle(4, 5, 9);
		cs.circle(5);
	}
}
