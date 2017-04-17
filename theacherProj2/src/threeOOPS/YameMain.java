package threeOOPS;

class SunIn
{
	Device assemble(Goods frame)
	{
		Device ret = new Device();
		
		ret.name = "태블릿";
		
		ret.goods= frame;
		
		ret.price = frame.price;
		ret.print();
		return ret;
	}
	
	Device assemble(Goods frame, Mouse mouse)
	{
		Device ret = null;
		if(mouse.type)
		{
			
			ret = new Device();
			ret.name = "노트북";
			
			ret.goods= frame;
			ret.mouse = mouse;
			ret.price = frame.price+mouse.price;
			ret.print();
		}else{
			System.out.println("마우스 쫌!!!!");
		}
		return ret;
	}
	Device assemble(Goods frame, Mouse mouse, Keyboard keyboard)
	{
		Device ret = null;
		
		if(keyboard.option != "전자식")
		{
			System.out.println("키보드 정말");
			return ret;
		}
		ret = new Device();
		
		ret.name = "데스크탑";
		
		ret.goods= frame;
		ret.mouse = mouse;
		ret.keyboard = keyboard;
		ret.price = frame.price+mouse.price+keyboard.price;
		ret.print();
		return ret;
	}
}

class Goods
{
	String name, kind;
	int price;
	
	Goods init(String kind, String name,	int price)
	{
		this.kind = kind;
		this.name = name;
		this.price = price;
		return this;
	}

	public String toString() {
		return "["+kind+ ", " +name + ", " + price + "]";
	}	
}

class Mouse extends Goods{
	boolean type;
	Mouse init2(String name,	int price, boolean type )
	{
		this.type = type;
		init("마우스", name,	price);
		return this;
	}
	
	public String toString2() {
		return toString()+", "+type;
	}
}

class Keyboard extends Goods{
	
	boolean type;
	String option;
	Keyboard init2(String name,	int price, boolean type,String option )
	{
		this.type = type;
		this.option = option;
		init("키보드", name,	price);
		return this;
	}
	
	public String toString2() {
		return toString()+", "+type+", "+option;
	}
}


class Device
{
	String name;
	Goods goods;
	Mouse mouse;
	Keyboard keyboard;
	
	int price;
	
	
	
	
	void print()
	{
		String str = name+"\t";
		
		switch(name)
		{
			case "데스크탑":
				str+=keyboard.toString2()+"\t";
			case "노트북":
				str+=mouse.toString2()+"\t";
			case "태블릿":
				str+=goods.toString();
				
		}
		
		
		str+=price;
		System.out.println(str);
	}
}

public class YameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SunIn jj119 = new SunIn();
		
		Device com = jj119.assemble(new Goods().init("본체","어른패드", 90));
		//com.print();
		com = jj119.assemble(new Goods().init("본체","예스트북", 20),
				new Mouse().init2("찍찍", 8, false));
		//com.print();
		com = jj119.assemble(
				new Goods().init("본체","삼송", 50),
				new Mouse().init2("찍찍이", 2, false),
				new Keyboard().init2("키키키", 3, false, "전자식"));
		//com.print();
	}

}
