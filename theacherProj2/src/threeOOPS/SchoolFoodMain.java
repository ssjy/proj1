package threeOOPS;

import java.util.Arrays;

class Food{
	String name,main;
	String [] mat;
	int price;
	public Food(String name, String main, String[] mat, int price) {
		super();
		this.name = name;
		this.main = main;
		this.mat = mat;
		this.price = price;
	}
	void print() {
		String str="Food [name=" + name + ", main=" + main + ", mat=" + Arrays.toString(mat) + ", price=" + price + "]";
		System.out.println(str);
	}	
}

class FoodSet{
	String name;
	Food [] menu;
	
	int price;

	public FoodSet(String name,Food[] menu) {
		super();
		this.name = name;
		this.menu = menu;
		cal();
	}
	void cal()
	{
		price = 0;
		for(Food mm: menu)
		{
			price+=mm.price*0.9;
		}
	}
	void print()
	{
		System.out.println("set메뉴:"+name+"["+price+"]---------------");
		for(Food mm: menu)
		{
			mm.print();
		}
		
	}
	
	
}
class SchoolFood
{
	String name;
	
	Food [] rec;
	
	FoodSet [] sets;
	
	
	Food cooking(String main)
	{
		Food ret = null;
		
		for(Food ff: rec)
		{
			if(ff.name == main)
			{
				return ff;
			}
		}
		System.out.println("이 메뉴는 없는 메뉴입니다.");
		return ret;
	}
	
	FoodSet cookingSet(String name)
	{
		for(FoodSet ss : sets)
		{
			if(name==ss.name)
				return ss;
		}
		return null;
	}
	
	Food cooking(String main, String sub1)
	{
		Food ret = null;
		
		Food [] bufadqd = mainChk(main);
		
		if(bufadqd.length==0)
		{
			System.out.println("이 메뉴는 없는 메뉴입니다.");
			return null;
		}
		ret = subChk(bufadqd, new String []{sub1});
		if(null==ret)
		{
			System.out.println("이 메뉴는 없는 메뉴입니다.");
		}
		
		
		return ret;
	}
	
	Food cooking(String main, String sub1, String sub2)
	{
		Food ret = null;
		
		Food [] bufadqd = mainChk(main);
		
		if(bufadqd.length==0)
		{
			System.out.println("이 메뉴는 없는 메뉴입니다.");
			return null;
		}
		ret = subChk(bufadqd, new String []{sub1, sub2});
		if(null==ret)
		{
			System.out.println("이 메뉴는 없는 메뉴입니다.");
		}
		
		
		return ret;
	}
	
	
	
	Food subChk(Food [] arr, String [] sub)
	{
		Food ret = null;
		
		for(Food ff: arr)
		{
			if(ff.mat!=null)
			{
				if(ff.mat.length == sub.length)
				{
					int cnt=0;
					for(String ss: sub)
					{
						for(String mm : ff.mat)
						{
							if(mm == ss)
								cnt++;
						}
					}
					if(cnt== sub.length)
					{
						ret = ff;
					}
					
				}
			}
		}
		
		return ret;
	}
	
	Food [] mainChk(String main)
	{
		Food [] ret = new Food [0];
		//for(Food ff: rec)
		for(int ff =0;ff< rec.length;ff++)
		{
			if(rec[ff].main == main)
			{
				Food [] 임종천 = new Food [ret.length+1];
				for (int i = 0; i < ret.length; i++) {
					임종천[i]=ret[i];
				}
				임종천[ret.length]=rec[ff];
				ret = 임종천;
			}
		}
		return ret;
	}
}
////분식집을 구현하세요

/// 음식을 주문하세요
// 메뉴 : 떡볶이, 라볶이, 치즈라볶이
//      라면, 떡라면, 치즈떡라면, 만두라면
///-------------------------------------
//셋트메뉴를 주문하세요
/// 가격할인 발생할 것
/// 동시주문의 갯수가 3개 이상일 경우 서비스 메뉴 나갈것
public class SchoolFoodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchoolFood sf = new SchoolFood();
		sf.rec =new Food[] {
				new Food("떡볶이","떡볶이",null, 3000),
				new Food("라볶이", "떡볶이",new String[]{"라면"}, 4500),
				new Food("치즈떡볶이","떡볶이", new String[]{"치즈"}, 3500),
				new Food("치즈라볶이","떡볶이", new String[]{"라면","치즈"}, 5500),
				new Food("라면", "라면",null, 2500),
				new Food("치즈라면","라면", new String[]{"치즈"}, 3000),
				new Food("떡라면", "라면",new String[]{"떡"}, 3500),
				new Food("치즈떡라면", "라면",new String[]{"떡","치즈"}, 4000),
				new Food("만두라면", "라면", new String[]{"만두"}, 3500),
				new Food("김밥", "김밥",null, 1500),
				new Food("참치김밥", "김밥",new String[]{"참치"}, 1500),
				new Food("돈가스김밥", "김밥",new String[]{"돈가스"}, 1500),
				new Food("모듬김밥", "김밥",new String[]{"참치","치즈"}, 1500),
				
				
			};
		
		sf.sets = new FoodSet []{
				new FoodSet("떡라",new Food[]{sf.rec[0], sf.rec[4]}),
				new FoodSet("라라떡",new Food[]{sf.rec[1], sf.rec[6]}),
				new FoodSet("김라떡",new Food[]{sf.rec[0], sf.rec[4],sf.rec[9]}),
				new FoodSet("모김라떡",new Food[]{sf.rec[2], sf.rec[7],sf.rec[12]})
		};;
		sf.cooking("라면").print();
		sf.cooking("라면","떡").print();
		sf.cooking("라면","치즈","떡").print();
		sf.cookingSet("떡라").print();
		sf.cookingSet("라라떡").print();
	}

}
