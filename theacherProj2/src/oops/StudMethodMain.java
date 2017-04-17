package oops;

import java.util.Scanner;

class StudData{
	int no, ban, sum, avg, gender;
	String name, tel;
	int [] jum, rank, sort;
	
	void init(String name, int [] stu, int cnt)
	{
		ban = stu[0];
		this.name = name;
		jum = new int [stu.length-1]; 
		
		for (int j = 0; j < jum.length; j++) {
			jum[j]=stu[j+1];
		}
		rank = new int[cnt];
		sort = new int[cnt];
		cal();
	}
	
	
	void cal()
	{
		sum =0;
		for(int jj : jum)
		{
			sum += jj;
		}
		avg = sum/jum.length;
	
	}
	
	void rankCal(StudData [] arr, int [][] banCnt)
	{
		///등수초기화
		for (int j = 0; j < rank.length; j++) {
			rank[j]=1;
		}
		
		
		/// 현재 반 초기화
		for (int j = 1; j < ban; j++) {
			for (int k = 0; k < banCnt[j].length; k++) {
				sort[2]+= banCnt[j][k];
				
			}
			sort[4] =sort[2]; 
		}
		
		/// 성별(여자)초기화
		if(gender==1) {
			for (int j = 1; j < banCnt.length; j++) {
				sort[3]+=banCnt[j][0];
				
			}
			sort[4]+= banCnt[ban][0];
			
		} //여자라면 초기값 남자인원수
		
		
		
		for (int j = 0; j < arr.length; j++) {
			
			if(avg<arr[j].avg)
			{
				
				rank[0]++;
				
				sort[1]++;
				rank[1]++;
				
				if(gender==arr[j].gender)//성별이 같다면
				{
					rank[3]++;
					sort[3]++;
				}
				
				if(ban==arr[j].ban)//반이 같다면
				{
					rank[2]++;
					sort[2]++;
					if(gender==arr[j].gender)//성별이 같다면
					{
						rank[4]++;
						sort[4]++;
					}
				}
			}
			
		}
	}
	
	
	
	void rankCal2(StudLogic sl)
	{
		///등수초기화
		for (int j = 0; j < rank.length; j++) {
			rank[j]=1;
		}
		
		
		/// 현재 반 초기화
		for (int j = 1; j < ban; j++) {
			for (int k = 0; k < sl.banCnt[j].length; k++) {
				sort[2]+= sl.banCnt[j][k];
				
			}
			sort[4] =sort[2]; 
		}
		
		/// 성별(여자)초기화
		if(gender==1) {
			for (int j = 1; j < sl.banCnt.length; j++) {
				sort[3]+=sl.banCnt[j][0];
				
			}
			sort[4]+= sl.banCnt[ban][0];
			
		} //여자라면 초기값 남자인원수
		
		
		
		for (int j = 0; j < sl.arr.length; j++) {
			
			if(avg<sl.arr[j].avg)
			{
				
				rank[0]++;
				
				sort[1]++;
				rank[1]++;
				
				if(gender==sl.arr[j].gender)//성별이 같다면
				{
					rank[3]++;
					sort[3]++;
				}
				
				if(ban==sl.arr[j].ban)//반이 같다면
				{
					rank[2]++;
					sort[2]++;
					if(gender==sl.arr[j].gender)//성별이 같다면
					{
						rank[4]++;
						sort[4]++;
					}
				}
			}
			
		}
	}
	
	
	void print(int kind)
	{
		String [][] index ={
				{"남자","여자"},
				{"가","가","가","가","가","가"
					,"양","미","우","수","수"}
		};
		String str = 
				
				ban+"\t"+	//반
				name+"\t"+	//이름
				index[0][gender]+"\t";	
		//성별{"남자","여자"}[] 
		
		for (int j = 0; j < jum.length; j++) {//j-> 과목
			str+=jum[j]+"\t";
		}
		if(gender==1)	//성별{"남자","여자"}[]  여자인가?
			str+="\t";
		
		
		str+=sum+"\t"+avg+"\t";
		
		str+=index[1][avg/10]+"\t";	
		//{"가"...,"양","미","우","수","수"}res[i][2]:평균/10
		str+=rank[kind];//0,1,2,3,4 등수 종류
		
		System.out.println(str);
	}
	
}


class StudLogic
{
	StudData [] arr;
	int [][] banCnt;
	String [][] index = {
			{"입력 순서", "전체 등수", "반별 등수", "성별 등수", "반, 성별, 등수"}, 
			{"반","이름","성별","국어","영어","수학","교련","총점","평균","등급","등수"}
	
		};
	void cal(StudData [] arr)
	{
		this.arr = arr;
		init();
		rank();
		print();
	}
	
	void init()
	{
		int maxBan = -1;
		
		for(StudData sd : arr)
		{
			if(sd.ban> maxBan) maxBan = sd.ban;
			
			sd.gender= index[1].length-7-sd.jum.length;
		}
		banCnt = new int [maxBan+1][2];
		
		///반 인원수 처리
		for(StudData sd : arr){
			banCnt[sd.ban][sd.gender]++;
		}
	}
	
	void rank()
	{
		//등수
		for (int i = 0; i < arr.length; i++) {

			//arr[i].rankCal(arr,banCnt);
			arr[i].rankCal2(this);
			
		}
	}
	
	void print()
	{
	////1.출력타입 입력
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < index[0].length; i++) {
			
			System.out.print(i+"."+index[0][i]);
			if(i<index[0].length-1)
				System.out.print(", ");
		}
		System.out.print("\n입력:");
		int kind = sc.nextInt();
		String line="";
		
		for(String buf : index[1])
		{
			System.out.print(buf+"\t");
			line+="========";
		}
		System.out.println("\n"+line);
		
		
		///2. 출력출력
		for(int r =0;r<arr.length;r++)//r 0 -> 17
		{
			
			for (StudData sd :arr) {//i-> 학생
				
				if(r == sd.sort[kind])//현재출력번호 === 나의 각 출력방식의 출력번호가 같은지
				{
					sd.print(kind);
				}
			}
		}
	}
}


////학생클래스를 정의, 선언, 생성, 호출 하여 학생정보를 출력하세요

//--- 학번, 이름, 반, 전화번호,  점수 [국어, 영어, 수학], 총점, 평균
public class StudMethodMain {

	public static void main(String[] args) {
		
		
		String [] name = {
				"장동건",
				"장남건",
				"장서건",
				"장중건",
				"북두신건",
				"현빈",
				"원빈",
				"김우빈",
				"투빈",
				"골빈",
				"미스터빈",
				"젤리빈",
				"장희빈",
				"커피빈",
				"한가인",
				"한나인",
				"한다인",
				"한라인"
				
				
		};
		
		int[][] stu = {//index 0은 반, 1은 성별(0이면 남자,1이면 여자),국어, 영어 ,수학 점수)
                {1, 37,70,50}, 
                {2, 96,95,99}, 
                {3, 78,69,57,77}, 
                {2, 67,65,86}, 
                {1, 97,76,80,97},
                {3, 67,62,70}, 
                {2, 57,45,60}, 
                {3, 88,55,50,88}, 
                {2, 86,96,40}, 
                {1, 95,85,30},
                {3, 65,49,20,66},
                {1, 5,49,45}, 
                {3, 63,78,78,78}, 
                {2, 11,76,86}, 
                {3, 45,63,57,45}, 
                {3, 78,67,79}, 
                {2, 99,89,68}, 
                {1, 15,64,97,67}
        };
		
		
		
		StudData [] arr = new StudData[name.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new StudData();
			arr[i].init( name[i], stu[i], 5);
			
		}
		
		new StudLogic().cal(arr);
		
		
		
	}
}
