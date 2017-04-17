package thread_p;

import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

class MulTimer extends Thread // 타이머 클래스
{
	MulExamData md;   // 데이터가 들어가 있는 클래스 md선언 
	@Override
	public void run() {  //작동시키는 메소드
		// TODO Auto-generated method stub
		for (int i = 10; i >0; i--) {  // 10부터 1까지 포문 돔
			try {
				
				sleep(1000);            //  1초마다 쉼
				
				if(md.chk) break;       // 초기값false가 true라면 for문 나가기  
				System.out.println(i);  // i출력
			} catch (InterruptedException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		md.chk=true; //md의 chk값에 true 대입
		System.out.println("시험 종료"); // 시험 종료 출력
		md.print(); //md의 프린트 메소드로 간다
	}
}

class MulExam extends Thread  // 시험 클래스
{
	MulExamData md;
	
	@Override
	public void run() {
		
		Iterator<String> it = md.map.keySet().iterator();
		// TODO Auto-generated method stub
		md.cnt=0;
		while(it.hasNext())
		{
			
			String key = it.next();
			if(md.chk) break;
			String input = JOptionPane.showInputDialog(key);
			if(md.chk) break;
			md.solve(key,input);
			
				
			System.out.println("입력값:"+input);
		}
		md.chk=true;
	}
}
class MulExamData  //멀이그잼 데이터 클랫 정의
{
	LinkedHashMap<String, String> map = new LinkedHashMap<>(); //순서대로 정렬되는 map맴 생성 
	LinkedHashMap< String,String> ok = new LinkedHashMap<>(); // 순서대로 정렬되는 ok맵 생성 
	LinkedHashMap< String,String> nono = new LinkedHashMap<>();// 순서대로 정렬되는 nono맵 생성
	boolean chk = false; //chk 초기화 값 false
	int cnt; // cnt 변수 선언
	void solve(String key,String input) //솔브 메소드 (인자값으로 key와 input을 받는다)
	{
		if(map.get(key).equals(input)) //map맵의 키의 값과 input이 같다면
		{
			ok.put(cnt+". "+key, map.get(key)); //ok맵에 추가(key = cnt+인자값key,value = map의 키값)
		}else{                         //map맵의 키 값과 input이 다르다면 
			nono.put(cnt+". "+key, input+"("+map.get(key)+")"); //nono맵에 추가(key = cnt+인자값key,value = map의 키값) 
	  	}
		cnt++; //카운트 1씩 증가 
	}
	
	void print() // 프린트 메소드 
	{
		timeover(); //타임오버 메소드로 간다 
		
		
		System.out.println("정답>>>>"); // 출력
		printModule(ok);               //프린트모듈에 ok를 인자값으로 보냄
		System.out.println("오답>>>>"); // 출력
		printModule(nono);            //프린트모듈의 nono를 인자값으로 보냄
	}
	void timeover() //타임오버 메소드 
	{
		Iterator<String> it = map.keySet().iterator(); // 스트링받는it
		
		for (int i = 0; i <cnt; i++) { //cnt 카운트된 갯수만큼 for문 돌림
			it.next(); // it의 객체들이 나옴
		}
		
		while(it.hasNext()) //다음값이 있다면
		{
			String key = it.next(); // key는 it의 객체 대입
			nono.put(cnt+". "+key, "시간초과("+map.get(key)+")"); // nono맵에 추가(key = cnt+key,value = 시간초과map의 키값) 
			cnt++; //카운트를 늘림
		}
		
		
	}
	void printModule(LinkedHashMap< String,String> map) //프린트모듈 메소드(맵을 인자값으로 받는다)
	{
		Iterator it = map.entrySet().iterator(); // 이터레이터로 객체를 편하게 뽑기 위해 map맵을 set형태이터레이터로 it에 대입 
		
		while(it.hasNext()) // 반복(it의 다음값이 존대한다면)
		{
			System.out.println(it.next()); // 출력(it의 다음 객체값 차례대로 출력됨)
		}
	}
}

public class ExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MulTimer mm = new MulTimer();
		MulExam me = new MulExam();
		
		MulExamData md = new MulExamData();
		md.map.put("2+3", "5");
		md.map.put("4*5", "20");
		md.map.put("8-5", "3");
		md.map.put("15/3", "5");
		md.map.put("9%4", "1");
		
		mm.md = md;
		me.md = md;
		
		mm.start();
		me.start();
	}

}
