package threeOOPS;
class Coffee
{
	String name;
	int price;
	int kcal;
	
	Coffee init(String name,int price,int kcal)
	{
		this.name = name;
		this.price = price;
		this.kcal = kcal;
		return this;
	}
	
	void print()
	{
		String str = name+"\t"+price+"\t"+kcal;
		
		System.out.println(str);
	}
}
class Cafe
{
	
	
	Coffee makeCoffee(int water, String bean, String sp)
	{
		
		
		/*String [] name ={"아메리카노","아프리카노","아시아노","유럽이노"};
		int [] price ={3000,4000,5500, 6200};
		int [] kcal = {29,30,43,250};*/
		
		Coffee [] cfs = {
				 new Coffee().init("아메리카노", 3000, 29),
				 new Coffee().init("아프리카노", 4000, 30),
				 new Coffee().init("아시아노", 5500, 43),
				 new Coffee().init("유럽이노", 6200, 250)
		};
		
		String [] bb = {"강남콩","강북콩"};
		String [][] ss = {{null,"녹용"},{null,"소세지"}};
		
		int cnt=0;
		for (int i = 0; i < bb.length; i++) {
		
			if(bb[i]==bean)
			{
				cnt=i;
			}
		}
		
		int spCnt=0;
		for (int i = 0; i < ss[cnt].length; i++) {
			if(ss[cnt][i]==sp)
			{
				spCnt=i;
			}
		}
		cnt+=spCnt*2;
		
		int [] waterLimit = {100,150,210,110};
		
		
		Coffee ret = null;
		if(waterLimit[cnt] <= water)
		{
			ret=cfs[cnt];
		}
		
		return ret;
	}
}
public class CafeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cafe smith = new Cafe();
		Coffee cf = smith.makeCoffee(112,"강북콩", "소세지");
		
		if(cf!=null)
			cf.print();
		else
			System.out.println("커피가 없어요");
		
	}

}
