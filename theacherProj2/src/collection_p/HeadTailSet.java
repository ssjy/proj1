package collection_p;

import java.util.Comparator;
import java.util.TreeSet;
class HeadCom implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
	
		
		int me = (int)o1;
		int you = (int)o2;
		System.out.println(you+":"+me);
		return me-you;
	}
}
public class HeadTailSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr ={34,45,2354,11,66,77,65,77,88,88,23,34};
		
		TreeSet set = new TreeSet<>(new HeadCom());
		for(int aa: arr)
		{
			set.add(aa);
		}
		
		System.out.println("set:"+set);
		System.out.println("headSet:"+set.headSet(65));
		System.out.println("tailSet:"+set.tailSet(65));
		
		/// 용접시 철판 두께를 적정치에 가까운 순으로 출력하세요
		/// 합격 두께 : 65
		
		TreeSet hs = new TreeSet<>(new HeadCom());
		hs.addAll(set.headSet(65));
		System.out.println("hs:"+hs);
	}

}
