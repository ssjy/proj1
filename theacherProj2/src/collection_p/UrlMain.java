package collection_p;

import java.util.Stack;

class Url{
	String now=null;
	
	Stack back = new Stack(); //back 이라는 새로운 스택 생성
	Stack next = new Stack(); //next 이라는 새로운 스택 생성
	
	void goUrl(String url) //매개변수 url받음
	{
		System.out.println("--------goUrl("+url+")");
		
		next.clear(); //앞부분 null값 없애줌
		
		if(now!=null)  //now의 값이 null이 아니라면 
			back.push(now); // 백에 있는 vow를 울력
		
		now =url; // 현재는 url값 대입
		
		print();
	}
	
	void goBack()
	{
		System.out.println("--------goBack()");
		
		if(!back.isEmpty()) // back의 값이 널이아니라면
		{
			next.push(now); // 앞으로.now
			
			now = (String)back.pop();// 현재=뒤.삭제
			print();
		}
		else{
			System.out.println("뒤가 없어요");
		}
		
		
	}
	
	void goNext()
	{
		System.out.println("--------goNext()");
		
		if(!next.isEmpty()) // 다음이 비어있지않다면
		{
			back.push(now); //뒤. 출력(현재)
			
			now = (String)next.pop(); //현재= 다음.삭제
			print();
		}
		else{
			System.out.println("앞이 없어요");
		}	
	}
	
	void print()
	{
		System.out.println("현재:"+now);
		System.out.println("뒤로:"+back);
		System.out.println("앞으로:"+next);
	}
}
public class UrlMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Url uu = new Url();
		uu.goUrl("나베르");
		uu.goUrl("구그레");
		uu.goUrl("나테");
		uu.goUrl("다움");
		
		uu.goBack();
		uu.goBack();
		uu.goBack();
		uu.goBack();
		uu.goBack();
		
		uu.goNext();
		uu.goUrl("야후");
	}

}
