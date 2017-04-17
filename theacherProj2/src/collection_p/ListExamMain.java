package collection_p;

import java.util.ArrayList;
import java.util.List;

class Stud{
	String name, gender, res;
	ArrayList jum = new ArrayList(); // 점수 리스트 생성
	int sum, avg, rank, ban;
	
	Stud(int ban,String name, int kor,int eng, int mat, int lol) //남자 생성자
	{
		this(ban, name, kor, eng, mat);
		jum.add(lol);
		cal();
	}
	
	Stud(int ban, String name, int kor,int eng, int mat) //여자 생성자
	{
		this.ban = ban;
		this.name = name;
		jum.add(kor);
		jum.add(eng);
		jum.add(mat);
		cal();
	}
	
	void cal()
	{
		gender = new String[]{"여자","남자"}[jum.size()-3]; 
		//성별클래스= 배열 생성 {여자->0 남자->1번째 자리}[점수의 사이즈-3]
		//->여자는 3과목,남자는 4과목이므로 -3하면 0번쨰 여자,1번째 남자
		
		sum =0;
		
		for (int i = 0; i < jum.size(); i++) { //점수의 사이즈만큼  포문이 돈다--여자면 3번,남자면 4번 돔 
			sum += (int)(jum.get(i)); // jum.get(i)i번 학생의 점수를 다 더한 값을 합계로 가짐 
		}
		
		avg = sum/jum.size(); 
		
		res = "불합격";
		if(avg>=70) res="합격";
	}

	@Override
	public String toString() {
		return ban  + "\t" +name + "\t" + gender +  "\t" + jum + "\t" + sum + "\t" + avg
				+ "\t" + rank + "\t" + res;
	}
	
	
}
public class ListExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List input = new ArrayList(); // 데이터를 넣을 리스트생성
		
		input.add(new Stud(2,"윤지섭",88,89,87,74 ));
		input.add(new Stud(3,"김경호",78,87,65,54 ));
		input.add(new Stud(1,"주민제", 43,32,21 ));
		input.add(new Stud(2,"선한비",34,56,78 ));
		input.add(new Stud(3,"송정윤", 89,90,98));
		input.add(new Stud(2,"정수홍", 87,76,65,54));
		input.add(new Stud(1,"박현진",99,97,96));
		input.add(new Stud(2,"정연욱", 12,23,34,45));
		
		System.out.println("연산전 >>>>>>>>>>");
		int maxBan=0; // 최대반의 초기값을 줌, 맥스반의 초기화
		
		for (Object oo : input) {//각 학생을 받아옴
			System.out.println(oo); // 각 학생 한명한명을 출력할 수 있다.
			Stud st = (Stud)oo;//Object -> 학생 형변환
			if(maxBan <st.ban) maxBan =st.ban; //최대반을 알아냄->3
			//0<2 -> 2 / 2<3 - >3 /3<1....
		}
		/*설계 개요
		
		      	0 - 1반 ArrayList 	박현진
		      						주민제
		output  1 - 2반 ArrayList	윤지섭
									정수홍
									선한비
									정연욱
				2 - 3반 ArrayList	송정윤
									김경호
				*/
		List output = new ArrayList();//출력용 리스트 생성
		//output
		
		
		for (int i = 0; i < maxBan; i++) {	//반별 리스트 생성
			output.add(new ArrayList()); //반 수 만큼 새로운 리스트추가
		}
		/*설계 개요
		
		      	0 - 1반 ArrayList 
		output  1 - 2반 ArrayList
				2 - 3반 ArrayList
		*/
		
		
		///각 학생을 자신의 반 리스트에 넣기
		for (Object oo : input) {//각학생 가져오기
			Stud st = (Stud)oo;	
			//형변환 
			//-> 학생클래스 st =(학생클래스)각 학생 
			//-> 각 학생을 학생클래스로 형변환한 값을 st에 대입
			int meBan = st.ban-1;	
			//내반-1  (0,1,2) 
			//-> 내 반 = 각학생 반-1 (반이 1반,2반,3반까지 있으므로 나중에 output의 0번째 1번째 2번째에 넣기위함)
	      	/*		0 - 1반 ArrayList 
			output  1 - 2반 ArrayList
					2 - 3반 ArrayList
					
		meBan을 이용하여
			output 에서 내반에 해당하는 ArrayList를 가져오기 위함
					*/
			Object ob = output.get(meBan);	
					//내반 리스트 가져옴 현재는 Object(객체);
			        //->ob라는 변수명은 output에서 내 반을 말함
			
			ArrayList meBanList = (ArrayList)ob;
				//반 형변환
			    //아웃풋에서 받아온 내 반을 리스트로 만듦
			
			meBanList.add(st);	//내반의 리스트에 현재 학생을 추가
                                //st->각 학생			
			//((ArrayList)output.get(st.ban-1)).add(st); 
		    //->어레이리스트로 형변환한 아웃풋의 학생반을 받아온것에 각 학생을 추가
		}
		
		for (Object arr : output) { // 아웃풋을 가져옴
			
			for(Object oo : (ArrayList)arr)
			{
				Stud me = (Stud)oo;
				me.rank=1;
				for(Object oo2 : (ArrayList)arr)
				{
					Stud com = (Stud)oo2;
					
					if(com.avg>me.avg)
						me.rank++;
				}
			}
		}
		
		
		
		
		System.out.println("출력>>>>>");
		for (int i = 0; i < output.size(); i++) {
			System.out.println(i+1+" 반>>>");
			
			for (int j = 1; j <= ((ArrayList)output.get(i)).size(); j++) {
				for(Object oo : (ArrayList)output.get(i))
				{
					if(((Stud)oo).rank==j)
						System.out.println(oo);
				}
			}
			
			
		}
		
		
		
		
	}

}
