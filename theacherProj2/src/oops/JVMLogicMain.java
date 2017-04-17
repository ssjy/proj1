package oops;
class JVMLogic
{
	ClaShape2 [] arr;
	
	int [] logic ={init(), print()};
	
	int init()
	{
		arr =new ClaShape2 []{
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
		return 100;
	}
	
	int print()
	{
		for(ClaShape2 cs :arr)
		{
			cs.print();
		}
		return 100;
	}
}
public class JVMLogicMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JVMLogic();
	}

}
