package collection_p;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class PlayerCom implements Comparator{ // 비교자를 받는 클래스 선언
	
	@Override
	public int compare(Object o1, Object o2) {  // 비교메소드 오버라이딩 (객체 o1,객체 o2)
		// TODO Auto-generated method stub       
		String str ="out,1,2,3,h";         //     str 대입 (성적)

		return str.indexOf(((String)o1))-     
				str.indexOf(((String)o2));    
		// 리턴은 indexof((스트링)형변환한 객체 o1)=>숫자가 들어옴(0,1,2,3,4) - (스트링)형변환한 o2  
		//==>결국 정렬 방향을 어떻게 할 것인가를 말해주는 것 (음수면 왼쪽, 정수면 오른쪽)
	}
}

public class HashBaseBall {

	//out, 1,2,3,h
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr={"23-1","5-1","7-2","23-out","11-1",
				"23-h","6-1","2-2","23-1","7-3","2-2",
				"23-out"};  // 등번호 선수-아웃,1루타,2루타,홈런
		
		//LinkedHashMap player = new LinkedHashMap();
		TreeMap player = new TreeMap(); // 트리맵 선언과 생성 (트리맵은 정렬)
		
		for(String str: arr)
		{
			//String pp = str.substring(0,str.indexOf("-"));
			
			int pp = 
			Integer.parseInt(str.substring(0,str.indexOf("-"))); //pp= 등번호 숫자
			String hit = str.substring(str.indexOf("-")+1); // hit = 히트성적
			
			//HashMap nowPP;
			TreeMap nowPP; // 트리맵 선언
			
			if(player.containsKey(pp))   // 플레이어 트리맵 안에 pp라는 키값이 있다면
				nowPP = (TreeMap)player.get(pp);  // nowPP에 플레이어에 pp값(등번호)을 대입
			else                                   // 없다면
				nowPP = new TreeMap(new PlayerCom()); // nowPP에 새로운 트리맵(위 클래스 생성자)생성
			
			player.put(pp, nowPP); //플레이어에 key는 pp(등번호), value는 nowPP=>트리맵(키-홈,아웃/ 밸류- 몇개 쳤는지) 
			
			int a = 1;	// 안타횟수 
			if (nowPP.containsKey(hit))	// key 값을 물어본다. key값이 있다면, 즉!홈,1,2,3 아웃인 값이 있다면
				a += (int) nowPP.get(hit);	//Object value = map.get(key); key 를 보고 value 값을 가지고 온다.
			   // 안타에 nowPP에서 가져온 히트 값을 더한것을 대입 

			nowPP.put(hit, a); // nowPP에  key 값은 성적,a는 횟수
			
		}
		Iterator it = player.keySet().iterator(); // 이터레이터 it =  플레이어에 키셋으로 이터레이터
		
		while(it.hasNext()) // 다음 값이 있다면 반복
		{
			Object key = it.next();  //키 = 다음 값 나와
			System.out.println(key+">>>"); // 등번호 >>>
			
			TreeMap ppp = (TreeMap)player.get(key); // (형변환)히트의 키값
			
			Iterator pit = ppp.keySet().iterator();  // 
			
			while(pit.hasNext())
			{
				Object kkey = pit.next(); // nowPP의 키값인 몇루타인지 성적
				System.out.println("\t"+kkey+":"+ppp.get(kkey));
			}	//                       성적 : 성적을 몇번 쳤는지
			
		}	
		
		
	}

}
