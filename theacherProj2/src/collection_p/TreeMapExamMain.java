package collection_p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class TTStud                                                 // 클래스 정의
{
	String name, res;                                         //멤버변수 이름,결과
	LinkedHashMap<String, Integer> jum = new LinkedHashMap(); //지정한대로 들어가는 링크드해시맵<key=문자열,value=숫자>으로 점수 생성
	LinkedHashMap<String,String> kind = new LinkedHashMap();  //<key=문자열,value=문자열>인 kind 맵 생성
	int sum, avg, rank, num;                                  //합계,평균,순위,번호
	
	TTStud(String ban, int num,String name, int kor,int eng, int mat, int lol) // 생성자 
	{
		this(ban, num, name, kor, eng, mat);    
		jum.put("롤",lol);                             // 점수에 대입(key=롤,value=lol점수)
		kind.put("성", "남자");                         // 종류에 대입(key=성,value=남자)
		
		cal();                                      //계산메소드로 ㄱㄱ
	}
	
	TTStud(String ban,int num, String name, int kor,int eng, int mat) //생성자 오버라이딩
	{
		this.num = num;                             
		this.name = name;
		jum.put("국어",kor);                          //점수에 대입 (key=국어,value=kor 점수)
		jum.put("영어",eng);                          //점수에 대입 (key=영어,value=eng 점수)
		jum.put("수학",mat);                          //점수에 대입 (key=수학,value=mat 점수)
		kind.put("반", ban);                         // 종류에 대입(key=반,value=ban이름)
		kind.put("성", "여자");                       // 종류에 대입(key=성,value=여자)
		kind.put("전체", "전체");                      // 종류에 대입(key=전체,value=전체)
		
		cal();                                       //계산메소드로 ㄱㄱ
	}
	
	void cal()                                       // 계산 메소드
	{
		sum =0;                                      // 합계의 초기화 0
		
		Collection<Integer> vv = jum.values();        //콜렉션(구조)<숫자> vv = 점수의 values
		
		for (Integer oo : vv) {                       //확장된포문 vv의 하나하나의 객체를 oo라 한다
			sum += oo;                                //합계+=oo를 합한값(남자면 국,영,수,롤 4과목 더한값/여자면 국,영,수 3과목 합한값)
		}
		
		avg = sum/jum.size();                          //평균 = 합계/점수의 사이즈(배열일때 점수의 길이와 같음)
		
		res = "불합격";                                 //결과의 초기화 = 불합격
		if(avg>=70) res="합격";                         //평균이 70과 같거나 크다면 결과=합격
	}

	@Override
	public String toString() {                         // 출력 메소드
		return  kind.get("반") + "\t" + name + "\t" + num + "\t" + kind.get("성") + "\t" + jum
				+ "\t" + sum + "\t" + avg + "\t" + rank;
	}
	
	
}

class TTStCom implements Comparator{  //비교자를 인터페이스로 받는 클래스 선언 
	Object kind;                      // 객체 kind(종류)선언

	public TTStCom(Object kind) {     //생성자 (인수로 종류 객체를 받는 생성자) 
		super();                      //부모클래스 상속
		this.kind = kind;
	}

	@Override
	public int compare(Object o1, Object o2) {   //(인수로 객체 o1과 o2를 받는 비교메소드 )
		// TODO Auto-generated method stub
		HashMap str = new HashMap<>();            //정렬이 되지않는 해시맵 str생성
		str.put("반", "개나리, 소나리, 닭나리, 말마리");  //str에 대입(key=반,value=개,소,닭,말)
		str.put("성", "남자, 여자");                 //str에 대입(key=성,value=남자,여자)
		str.put("전체", "전체");                    //str에 대입(key=전체,value=전체)
		
		int res=1;                            //결과 초기화 1 
		
		if(kind instanceof String)            //종류를 스트링으로 변환가능여부가 true라면 
		{
	
			res = ((String)str.get(kind)).indexOf(((String)o1))-  //결과= 스트링으로 형변환한 str의 종류.객체1(나)의 숫자 - 
			((String)str.get(kind)).indexOf(((String)o2));         // 스트링으로 형변환한 str의 종류.객체2(너)의 숫자 - 
	
		}else{                                //스트링 변환이 안되는 경우 faulse라면 
			TTStud me = (TTStud)o1;           // 클래스 나 = 클래스 형변환 객체 o1
			TTStud you = (TTStud)o2;          // 클래스 너 = 클래스로 형변환한 객체 o2
			
			res = you.avg-me.avg;              // 결과는 너의평균-나의 평균 (오름차순)
			if(res==0) res = me.num - you.num; // 결과값이 0이라면 결과는 나의 번호-너의 번호(내림차순) 
		}
		
		return res; //결과값을 리턴한다
	}
}

public class TreeMapExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TTStud> input = new ArrayList();                 //클래스자료형?을 받는 리스트 생성 
		
		input.add(new TTStud("소나리",2,"윤지섭",88,89,87,74 ));   //리스트input에 대입 (클래스 생성자(값))
		input.add(new TTStud("개나리",3,"김경호",78,87,65,54 ));
		input.add(new TTStud("소나리",1,"주민제", 43,32,21 ));
		input.add(new TTStud("말마리",2,"선한비",34,56,78 ));
		input.add(new TTStud("개나리",2,"송정윤", 89,90,98));
		input.add(new TTStud("말마리",2,"정수홍", 87,76,65,54));
		input.add(new TTStud("개나리",5,"박현진",89,90,98));
		input.add(new TTStud("소나리",2,"정연욱", 12,23,34,45));
		
		Scanner sc = new Scanner(System.in);  //스캐너 사용
		
		String [] kind = {"전체","반","성","성,반"};  //종류배열 선언  전체,반,성,성반
		
		for (int i = 0; i < kind.length; i++) {   //종류의 길이만큼 도는 포문
			System.out.print(i+","+kind[i]+" ");  //전체 , 전체의 종류 /반 ,  반의 종류 ...
		}
		System.out.print("\n입력:");  // 입력 출력
		
		int no = sc.nextInt();  // 번호를 입력하면 다음줄로 넘어감
		
		String [] arr = kind[no].split(","); //종류의 번호.,를 기준으로 나눔 즉, 반일때 개,소,닭,말이 나뉨

		TreeMap total = new TreeMap(new TTStCom(arr[0]));  // 정렬이 가능한 맵으로 토탈 선언 (비교클래스 생성자의 배열의 0번째)
		
		for(TTStud ts : input)                                 // 확장된포문 리스트를 돌림
		{
			TreeMap nowMap = total;                            // 정렬되는 맵으로 nowMap에 토탈(비교클래스)을 대입
			//TTStud ts = (TTStud)oo;

			for (int i = 0; i < arr.length-1; i++) {                 //종류의 원소값을 뺸것들의 길이-1만큼 도는 포문
				if(nowMap.containsKey(ts.kind.get(arr[i])))             //nowMap에 키값으로 input에 있는 하나의 객체의 종류에서 배열의 몇번째(같은종류)가 있다면 
					nowMap = (TreeMap)nowMap.get(ts.kind.get(arr[i]));  //nowMap=정렬가능한 트리맵으로 형변환한 나우맵의 input의 객체 종유의 배열
				else{
					TreeMap bufMap = new TreeMap(new TTStCom(arr[i+1]));
					nowMap.put(ts.kind.get(arr[i]),bufMap);
					
					nowMap = bufMap;
				}
			}

			TreeSet<TTStud> nowSS;
			
			if(nowMap.containsKey(ts.kind.get(arr[arr.length-1])))
				nowSS = (TreeSet)nowMap.get(ts.kind.get(arr[arr.length-1]));
			else{
				nowSS = new TreeSet(new TTStCom(0));
				nowMap.put(ts.kind.get(arr[arr.length-1]),nowSS);
			}
			
			nowSS.add(ts);
		}
		
		mapPrint(total);
	
	}
	
	static void mapPrint(TreeMap map)
	{
		Iterator it = map.keySet().iterator();

		while(it.hasNext())
		{
			TTStud sum = new TTStud("",999,"합계", 0,0,0,0);
			Object key = it.next();
			
			System.out.println(key+">>>>>>");
			
			Object obj = map.get(key);
			if(obj instanceof TreeMap)
				mapPrint((TreeMap)obj);
			else{
				Iterator<TTStud> sit = ((TreeSet)map.get(key)).iterator();
				
				while(sit.hasNext())
				{
					TTStud now = sit.next();
					
					Iterator<String> jit = now.jum.keySet().iterator();
					while(jit.hasNext())
					{
						String jkey = jit.next();
						int jjj = sum.jum.get(jkey)+now.jum.get(jkey);
						sum.jum.put(jkey, jjj);
					}
					
					System.out.println(now);
				}
				System.out.println(sum);
			}			
		}
	}
	

}
