package oops;
class ConstShape
{
	int area, border;
	String name;
	double pi = 3.14;
	
	ConstShape(int w, int h)
	{
		name = "사각형";
		area = w*h;
		border = (w+h)*2;
		//print();
	}
	
	ConstShape(int r)
	{
		name = "원";
		area = (int)(r*r*pi);
		border = (int)(r*2*pi);
		//print();
	}
	
	void print()
	{
		String str = name+"\t"+area+"\t"+border;
		System.out.println(str);
	}
}
public class ConstShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstShape [] cs= {
				new ConstShape(4, 5),
				new ConstShape(5)
		};
		
		for(ConstShape cc: cs)
		{
			cc.print();
		}
	}

}
