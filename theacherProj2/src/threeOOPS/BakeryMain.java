package threeOOPS;

/*빵집을 구현하세요

(빵이름, 물, 밀가루, 스페셜...) 등을 넣어 빵들을 리턴해주세요

빵에 레시피에 따라 빵을 생성하세요

===> 
애플파이 1개당: 물 100ml, 밀가루 100g, 사과잼 10g
마카롱 1개당 : 물 200ml, 밀가루 150g, 달걀 흰자 68g,  아몬드분말 78g
식빵 1개당 :물 500ml, 밀가루 350g

빵 : 빵이름, 가격, 열량

리턴을 클래스배열로 할것*/
class Bread{
	String name;
	int price, kcal;
	public Bread(String name, int price, int kcal) {
		super();
		this.name = name;
		this.price = price;
		this.kcal = kcal;
	}
	void print() {
		String str = name + "\t" + price + "\t" + kcal;
		System.out.println(str);
	}
	
	
}

class Recipe
{
	String name; 
	int water, powder;
	RecSp [] sp;
	public Recipe(String name, int water, int powder, RecSp[] sp) {
		super();
		this.name = name;
		this.water = water;
		this.powder = powder;
		this.sp = sp;
	}
	
	
}
class RecSp
{
	
	public RecSp(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	String name;
	int amount;
}
class Bakery
{
	Recipe [] recArr = {
			new Recipe("애플파이", 100, 100, new RecSp []{new RecSp("사과잼", 10)} ),
			new Recipe("마카롱",200, 150, 
					new RecSp []{new RecSp("달걀", 68),
							new RecSp("아몬드분말", 78)} ),
			new Recipe("식빵",500,350,null)		
		};
	
	
	Bread [] retArr = {new Bread("애플파이", 1000,245),
			new Bread("마카롱",3000 ,345),
			new Bread("식빵", 500, 567)};
	
	
	
	
	Bread [] makeBBang(String name, int water, int powder, String []sp, int [] amount)
	{
		Bread [] ret = new Bread [0];
		
		Recipe rec = recipeSearch(name);
		
		
		poss : while(true)
		{
			//만들수 있는지////////////////////////////
			if(water < rec.water || powder < rec.powder)
			{
				break poss;
			}
			
			if(rec.sp!=null)
			{
				for(RecSp rs : rec.sp)
				{
					boolean chk = false;
					
					if(sp==null)
						break poss;
					
					for (int i = 0; i < sp.length; i++) {
						if(rs.name ==sp[i])
						{
							if(rs.amount <=amount[i])
							{
								chk = true;
							}
						}
						
					}
					
					if(!chk)
					{
						break poss;
					}
				}
			}
			
			////////////////////////////
			
			
			water -= rec.water;
			powder -= rec.powder;
			
			if(rec.sp!=null)
			{
				for(RecSp rs : rec.sp)
				{
					for (int i = 0; i < sp.length; i++) {
						if(rs.name ==sp[i])
						{
							amount[i]-=rs.amount;
						}		
					}
				}
			}
			
			
			Bread [] buf = new Bread [ret.length+1];
			
			for (int i = 0; i < ret.length; i++) {
				buf[i] = ret[i];
			}
			
			
			for(Bread sample : retArr)
			{
				if(sample.name == name)
					buf[ret.length] = new Bread(name,sample.price,sample.kcal);
				
			}

			ret = buf;
		}
		
		return ret;
	}
	
	Recipe recipeSearch(String name)
	{
		Recipe ret = null;
		
		for(Recipe rec :recArr)
		{
			if(rec.name == name)
				ret = rec;
		}
		
		return ret;
	}
	
	
}
public class BakeryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bakery dddd = new Bakery();
		
		Bread [] bb = dddd.makeBBang("식빵", 2300, 1360, null, null);
		
		for(Bread br :bb)
			br.print();
		
		bb = dddd.makeBBang("마카롱", 2300, 1360, new String []{"달걀","소세지","아몬드분말"}, new int[]{1000,1234,2000});
		
		for(Bread br :bb)
			br.print();
	}
	

}
