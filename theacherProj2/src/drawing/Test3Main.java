package drawing;




class Test3
{
	int [] arr = {10,20,30,40};
	
	int meth_1()
	{
		return 100;
	}
	
	void meth_2()
	{
		int a = meth_1();
	}
	
	void meth_3(int c)
	{
		arr[2] = c;
	}
}
public class Test3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test3 tt3 = new Test3();
		tt3.meth_2();
		tt3.meth_3(30000);
	}

}
