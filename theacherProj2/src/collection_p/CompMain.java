package collection_p;

import java.util.Comparator;
import java.util.TreeSet;

class StrCom implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		Comparable me= (Comparable)o1;
		Comparable you= (Comparable)o2;
		
		//return you.compareTo(me);
		return me.compareTo(you)*-1;
	}
}

public class CompMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr = {"√ﬂ¡÷«Â","±Ë¡¯«‚","¿±º∫πÆ","πŒ¡§»∆","¿±¡ˆº∑","±Ë∞Ê»£"};
		
		TreeSet set = new TreeSet<>();
		TreeSet set2 = new TreeSet<>(new StrCom());
		
		for(String st: arr)
		{
			set.add(st);
			set2.add(st);
		}
		
		System.out.println(set);
		System.out.println(set2);
	}

}
