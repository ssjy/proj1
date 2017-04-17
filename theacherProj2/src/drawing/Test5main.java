package drawing;
class Test5Sub
{
	int a=10;
	int b;
	
	Test5Sub init(int b)
	{
		this.b = b;
		a += b;
		return this;
	}
}
class Test5
{
	Test5Sub one = new Test5Sub();
	Test5Sub [] arr;
	
	void init(Test5Sub [] arr)
	{
		one.init(100);
		one.b = arr[1].a+arr[0].b;
	}
}
public class Test5main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test5 tt5 = new Test5();
		tt5.init(
			new Test5Sub[]{
				new Test5Sub().init(3),
				new Test5Sub().init(4),
				new Test5Sub().init(5)
			}
		);
	}

}
