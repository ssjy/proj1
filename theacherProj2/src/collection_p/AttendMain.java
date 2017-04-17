package collection_p;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class AtCom implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		String me = (String)o1;
		String you = (String)o2;
		
		int res =me.substring(me.indexOf("_")+1).compareTo(
				you.substring(you.indexOf("_")+1));
		
		if(res==0) res =1;
		return res;
	}
}
public class AttendMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 학생이름_0313152012
	      // 월일시분초
	// 추주헌_0313152012
	
	// 먼저 입실한 사람 순서대로 출력하세요
	// 단 동일시간에 입실하였을 경우 입실순서별로 출력할 것
		String [] arr={
				"주민제_085923",
				"선한비_090712",
				"임희준_084312",
				"김경환_091212",
				"지승우_101115",
				"김민석_130000",
				"임종천_110403",
				"이혜신_084613",
				"정연욱_090522",
				"박현진_130000",
				"정수홍_084312",
				"송정윤_084613",
				"조대화_084312"
		};
		
		TreeSet ts = new TreeSet(new AtCom());
		
		for(String st: arr)
			ts.add(st);
		
		Iterator it = ts.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
			
			
	}

}
