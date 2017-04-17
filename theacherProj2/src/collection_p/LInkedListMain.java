package collection_p;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LInkedListMain {
	
	static void add_1(String name, List list)
	{
		long st = System.currentTimeMillis();
		for (int i = 0; i <1000000; i++) {
			list.add(100);
		}
		System.out.println(name+" 순차 add:"+
		(System.currentTimeMillis()-st));
	}
	
	static void add_2(String name, List list)
	{
		long st = System.currentTimeMillis();
		for (int i = 0; i <10000; i++) {
			list.add(500,100);
		}
		System.out.println(name+" 비순차 add:"+
		(System.currentTimeMillis()-st));
	}
	
	static void remove_2(String name, List list)
	{
		long st = System.currentTimeMillis();
		for (int i = 0; i <10000; i++) {
			list.remove(100);
		}
		System.out.println(name+" 비순차 remove:"+
		(System.currentTimeMillis()-st));
	}
	
	static void remove_1(String name, List list)
	{
		long st = System.currentTimeMillis();
		for (int i = list.size()-1; i>=0; i--) {
			list.remove(i);
		}
		System.out.println(name+" 순차 remove:"+
		(System.currentTimeMillis()-st));
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List ar = new ArrayList();
		List li = new LinkedList();
		
		add_1("ar", ar);
		add_1("li", li);
		
		add_2("ar", ar);
		add_2("li", li);
		
		remove_2("ar", ar);
		remove_2("li", li);
		
		remove_1("ar", ar);
		remove_1("li", li);
	}

}
