package drawing;
class Test4Sub
{
	int a;
	double d;
	
	void init(int a, double d)
	{
		this.a = a;
		this.d = d;
	}
	
}
class Test4
{
	Test4Sub ts;
	int a = 100;
	
	void init(int a, double d)
	{
		ts = new Test4Sub();
		ts.init(a, d);
	}
	
	void cal(int a)
	{
		ts.d = ts.a +a;
	}
}

public class Test4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test4 tt4 = new Test4();
		
		tt4.init(120, 345.678);
		tt4.cal(20);
		tt4.a = tt4.ts.a +100;
	}

}
