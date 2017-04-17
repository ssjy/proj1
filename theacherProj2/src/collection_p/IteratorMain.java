package collection_p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add("조대화");
		list.add("송정윤");
		list.add("정수홍");
		list.add("박현진");
		list.add("정연욱");
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		System.out.println("------------------");
		
		/*while(it.hasPrevious())
		{
			System.out.println(it.previous());
		}*/
		System.out.println("------------------");
		
		//System.out.println(it.next());
		ListIterator lit = list.listIterator();
		
		while(lit.hasNext())
		{
			System.out.println(lit.next());
		}
		System.out.println("------------------");
		while(lit.hasPrevious())
		{
			System.out.println(lit.previous());
		}
		
		
		ArrayList ar = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			ar.add((int)(Math.random()*100));
		}
		
		System.out.println(ar);
		
		it = ar.iterator();
		
		while(it.hasNext())
		{
			/*if(((int)it.next())%2==0)
				System.out.println(it.next());*/
			
			int buf = (int)it.next();
			if(buf%2==0)
				System.out.println(buf);
		}
		System.out.println();
		ArrayList lotto = new ArrayList<>();
		
		while(true)
		{
			int num = (int)(Math.random()*45)+1;
			
			if(!lotto.contains(num))
				lotto.add(num);
			
			if(lotto.size()==6)
				break;
		}
		Collections.sort(lotto);
		//System.out.println(lotto);
		
		while(true)
		{
			int num = (int)(Math.random()*45)+1;
			
			if(!lotto.contains(num))
			{
				lotto.add(num);
				break;
			}
		}
		
		it = lotto.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
