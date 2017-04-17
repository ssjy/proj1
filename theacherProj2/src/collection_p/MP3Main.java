package collection_p;
//mp3 노래듣기를 구현하세요
//1. 노래 정보 :  트랙번호, 노래제목, 가수
//2. 노래 리스트 -->next 에 넣기
//3. 구현내용 다음곡, 이전곡, 트랙번호

import java.util.Stack;
import java.util.regex.Pattern;

class Music{
	String title, singer;
	int tr;
	public Music(int tr, String title, String singer) {
		super();
		this.tr = tr;
		this.title = title;
		this.singer = singer;
	}
	@Override
	public String toString() {
		return tr + ". " + title + " (" + singer + ")";
	}
	
	boolean sch(boolean kind, String ppp)
	{
		String txt = title;
		
		if(kind) txt = singer;
		
		return Pattern.matches(".*"+ppp+".*", txt);
	}
}

class MP3
{
	Music now=null;
	
	Stack back = new Stack();
	Stack next = new Stack();
	int tot =0;
	
	void input(String title, String singer)
	{
		next.add(0,new Music(next.size()+1,title, singer));
		
		tot = next.size();
	}
	
	boolean nextModule()
	{
		boolean res = false;
		
		if(!next.isEmpty())
		{
			if(now!=null)
				back.push(now);
			
			now = (Music)next.pop();
			
			res = true;
		}
		
		return res;
	}
	
	boolean backModule()
	{
		boolean res = false;
		
		if(!back.isEmpty())
		{
			if(now!=null)
				next.push(now);
			
			now = (Music)back.pop();
			
			res = true;
		}
		
		return res;
	}
	
	void goNext()
	{
		System.out.println("goNext()>>>>>>>");
		if(nextModule())
			print();
		else
			System.out.println("재생할 곡이 없습니다.");
		
	}
	
	void goBack()
	{
		System.out.println("goBack()>>>>>>>");
		if(backModule())
			print();
		else
			System.out.println("뒤로갈 곡이 없습니다.");
		
	}
	
	void goTr(int tr)
	{
		System.out.println("goTr("+tr+")>>>>>>>");
		
		if(tr>tot || tr<0)
		{
			System.out.println("트랙번호 확!");
			return;
		}
		
		goTrModule(tr);
		
		print();
	}
	
	
	void goTrModule(int tr)
	{

		while(true)
		{
			if(now.tr>tr)		backModule();
			else if(now.tr<tr)	nextModule();
				
			if(now.tr==tr)	break;
		}
		
		
	}
	
	boolean schModule(boolean kind, String ppp)
	{
		boolean chk=false;
		while(!next.isEmpty())
		{
			if(now.sch(kind, ppp)){ 
				chk = true;
				break;
			}
			
			nextModule();
		}
		return chk;
	}
	
	
	void sch(boolean kind, String ppp)
	{
		int nowNum = now.tr;
		String txt = "제목";
		if(kind) txt ="가수";
		System.out.println("sch("+txt+", "+ppp+")>>>>>>>");
		
		boolean chk = schModule(kind, ppp);
		
		if(!chk){
			while(!back.isEmpty())
			{
				backModule();
			}
			chk = schModule(kind, ppp);
		}
		
		
		if(!chk){
			System.out.println("찾으시는 곡이 없습니다.");
			goTrModule(nowNum);
		}
		print();
		
	}
	
	void print()
	{
		System.out.println("재생곡:"+now);
		System.out.println("뒤로:"+back);
		System.out.println("앞으로:"+next);
	}
}

public class MP3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MP3 yoyo = new MP3();
		yoyo.input("시간을 달려서", "여자친구");
		yoyo.input("운동장을 달려서", "남자친구");
		yoyo.input("연병장을 달려서", "군대친구");
		yoyo.input("강미장을 달려서", "네모친구");
		yoyo.input("신검장을 달려서", "주헌친구");
		yoyo.input("앞자리를 달려서", "성문때려");
		yoyo.input("동사무소를 달려서", "한비결혼");
		yoyo.input("속초를 달려서", "애좀봐줘");
		yoyo.input("스미스를 달려서", "살려자요");
		yoyo.input("주말을 달려서", "숙제해와");
		
		yoyo.print();
		
		yoyo.goNext();
		yoyo.goNext();
		yoyo.goNext();
		yoyo.goBack();
		/*yoyo.goBack();
		yoyo.goBack();*/
		yoyo.goTr(5);
		yoyo.goTr(2);
		yoyo.goTr(11);
		yoyo.goTr(-1);
		yoyo.goTr(5);
		
		yoyo.sch(true, "군대");
	}

}
