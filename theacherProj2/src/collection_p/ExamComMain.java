package collection_p;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class StudCom{
	String name;
	
	int [] jum;
	
	int sum, avg;

	public StudCom(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		
		jum = new int[]{kor, eng, mat};
		
		cal();
	}
	
	void cal()
	{
		sum =0;
		for(int jj: jum)
		{
			sum+=jj;
		}
		avg = sum/jum.length;
		
	}

	@Override
	public String toString() {
		return "StudCom [name=" + name + ", jum=" + Arrays.toString(jum) + ", sum=" + sum + ", avg=" + avg + "]";
	}
		
}
class ExamCOm implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		StudCom me = (StudCom)o1;
		StudCom you = (StudCom)o2;
		int res;
		
		if(0== (res = you.avg-me.avg)) {
			if(0==(res=me.name.compareTo(you.name)))
				res=1;
		}
		
		return res;
	}
}
public class ExamComMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet set = new TreeSet<>(new ExamCOm());
		
		set.add(new StudCom("ttt", 88, 87, 89));
		set.add(new StudCom("bbb", 78, 77, 76));
		set.add(new StudCom("ttt", 88, 87, 89));
		set.add(new StudCom("ddd", 99, 98, 99));
		
		Iterator it = set.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
