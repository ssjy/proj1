package collection_p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List vv = new Vector();
		vv = new ArrayList();
		
		vv.add(1);
		vv.add("추주헌");
		vv.add(new int[]{33,44,55});
		vv.add(new Vector());
		vv.add(new Random());
		
		System.out.println(vv);
		
		for (int i = 0; i <vv.size(); i++) {
			System.out.println(vv.get(i));
		}
		
		vv.add(2, "윤성문");  //원하는 자리에 입력되나 한칸씩 뒤로 밀림
		System.out.println(vv);
		System.out.println("--------add");
		
		vv.set(3, "조대화"); // 원하는 자리에 있던 값 대신 입력됨
		vv.set(5, "추주헌");
		System.out.println(vv);
		System.out.println("--------set");
		
		vv.remove(4);       // 원하는 자리 값 삭제  
		System.out.println(vv);
		System.out.println("--------remove");
		
		List ss = new ArrayList(vv.subList(1, 3)); // vv객체 1,2번을 가지고 있는 새 리스트 생성
		ss.add("송정윤"); // 값 추가
		System.out.println(ss);
		System.out.println("--------");
		
		System.out.println(vv.contains("정수홍")); // 정수홍이라는 값이 있는지 boolean형으로 알려줌
		System.out.println(vv.indexOf("추주헌")); // 추주헌이라는 값이 있는 자리
		System.out.println(vv);
		//vv.retainAll(ss);
		//vv.removeAll(ss);
		
		vv.remove(0);
		System.out.println(vv);
		
		Collections.sort(vv);     // vv를 정렬
		
		System.out.println(vv);
	//----------------------------------------------------------------//
		   //기존의 야구팀원리스트--------> 1군리스트
		   //2군리스트
		   //FA리스트----> FA 가능 리스트
		   // 변경전
		   //1군 리스트  박재상, 박정권, 최정, 김광현, 엄정욱, 박희수, 이호준
		   //2군 리스트  이호준 , 엄정욱, 박재홍, 이신협, 장동건
		   //FA리스트  이병규,이승엽, 박정권, 장동건, 박용택, 홍성흔
		   // 변경후
		   //1군      박재상, 최정, 김광현, 박희수
		   //2군      이호준 , 엄정욱, 박재홍, 이신협, 
		   //FA 가능  이병규,이승엽, 박용택, 홍성흔

		List t1 = new ArrayList();
		List t2 = new ArrayList();
		List fa = new ArrayList();
		
		t1.add("박재상");
		t1.add("박정권");
		t1.add("최정");
		t1.add("김광현");
		t1.add("엄정욱");
		t1.add("박희수");
		t1.add("이호준");
		t2.add("이호준");
		t2.add("엄정욱");
		t2.add("박재홍");
		t2.add("이신협");
		t2.add("장동건");
		fa.add("이병규");
		fa.add("이승엽");
		fa.add("박정권");
		fa.add("장동건");
		fa.add("박용택");
		fa.add("홍성흔");
		
		System.out.println("t1:"+t1);
		System.out.println("t2:"+t2);
		System.out.println("fa:"+fa);
		
		List 임종천 = new Vector(fa);
		fa.removeAll(t1);
		fa.removeAll(t2); 
		
		t1.removeAll(t2);
		t1.removeAll(임종천);
		t2.removeAll(임종천);
		
		
		System.out.println("t1:"+t1);
		System.out.println("t2:"+t2);
		System.out.println("fa:"+fa);

	}

}
