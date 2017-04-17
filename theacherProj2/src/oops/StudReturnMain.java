package oops;

import java.util.Arrays;
import java.util.Scanner;

class StudRetData{
	int no, ban, sum, avg, gender;
	String name, tel;
	int [] jum, rank, sort;
	boolean mid;
	
	void init(String name, int [] stu, int cnt, boolean mid)
	{
		this.mid = mid;
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
	
	void max()
	{
		 
		
		for (int j = 0; j < jum.length; j++) {
			jum[j]=999;
		}
		sum = 999999;
		avg = 999;
		
	}
	
	void acc(StudRetLogic logic)
	{
		
		
		logic.sta[0][0].cal(this);
		logic.sta[1][0].cal(this);
		logic.sta[2][ban].cal(this);
		logic.sta[3][gender].cal(this);
		logic.sta[4][ban*2+gender].cal(this);
		
		for(StudRetData bb: logic.sta[2][ban].arr)
		{
			bb.ban = ban;
		}
		
		
		for(StudRetData bb: logic.sta[3][gender].arr)
		{
			bb.gender = gender;
		}
		
		for(StudRetData bb: logic.sta[4][ban*2+gender].arr)
		{
			bb.gender = gender;
			bb.ban = ban;
		}
		
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
	
	void rankCal(StudRetData [] arr, int [][] banCnt)
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
	
	
	
	void rankCal2(StudRetLogic sl)
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
		
		if(!mid)
		str+=index[1][avg/10];
				
		str+="\t";	
		//{"가"...,"양","미","우","수","수"}res[i][2]:평균/10
		str+=rank[kind]+"\t";
				
				str+=sort[kind];//0,1,2,3,4 등수 종류
		
		System.out.println(str);
	}
	
}

class StudRetArr
{
	StudRetData [] arr;
	String [] name={"총점","평균","최대","최소"};
	int totCnt, manCnt, sort;
	
	StudRetArr init()
	{
		arr = new StudRetData[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new StudRetData();
			arr[i].init(name[i], new int[5], 5, true);
			
		}
		
		arr[3].max();
		return this;
	}
	
	
	void cal(StudRetData data)
	{
		totCnt++;
		
		for (int i = 0; i < data.jum.length; i++) {
			
			arr[0].jum[i]+=data.jum[i];
			
			if(arr[2].jum[i]<data.jum[i])
				arr[2].jum[i]=data.jum[i];
			
			if(arr[3].jum[i]>data.jum[i])
				arr[3].jum[i]=data.jum[i];

		}
		arr[0].sum+=data.sum;
		arr[0].avg+=data.avg;
		
		if(arr[2].sum<data.sum)
			arr[2].sum=data.sum;
		if(arr[2].avg<data.avg)
			arr[2].avg=data.avg;
		
		if(arr[3].sum>data.sum)
			arr[3].sum=data.sum;
		if(arr[3].avg>data.avg)
			arr[3].avg=data.avg;
		
		for (int i = 0; i < arr[1].jum.length-1; i++) {
			
			arr[1].jum[i]=arr[0].jum[i]/totCnt;

		}
		
		if(data.gender==0)
		{
			manCnt++;
			arr[1].jum[3]=arr[0].jum[3]/manCnt;
		}
		arr[1].sum=arr[0].sum/totCnt;
		arr[1].avg=arr[0].avg/totCnt;
		
	}
	
	
}


class StudRetLogic
{
	StudRetArr [][] sta = new StudRetArr[5][];
	StudRetData [] arr;
	int [][] banCnt;
	String [][] index = {
			{"입력 순서", "전체 등수", "반별 등수", "성별 등수", "반, 성별, 등수"}, 
			{"반","이름","성별","국어","영어","수학","교련","총점","평균","등급","등수"}
	
		};
	void cal(StudRetData [] arr)
	{
		this.arr = arr;
		init();
		acc();
		rank();
		print();
	}
	
	void acc()
	{
		sta[0] = new StudRetArr[1];
		sta[1] = new StudRetArr[1];
		sta[2] = new StudRetArr[banCnt.length];
		sta[3] = new StudRetArr[2];
		sta[4] = new StudRetArr[banCnt.length*2];
		
		int [] rrr = new int [sta.length];
		for (int i = 0; i < sta.length; i++) {
			for (int j = 0; j < sta[i].length; j++) {
				sta[i][j] = new StudRetArr().init();
				if(i==1)
				{
					rrr[i] = arr.length;
				}else if(i==2)
				{
					rrr[i] += banCnt[j][0]+banCnt[j][1];	
				}
				else if(i==3)
				{
					for (int k = 0; k < banCnt.length; k++) {
						rrr[i]+=banCnt[k][j];
					}
				}
				else if(i==4)
				{
					rrr[i] += banCnt[j/2][j%2];	
				}
				sta[i][j].sort +=rrr[i];
			}
		}
		
		
		for (int i = 1; i < sta.length; i++) {
			for (int j = 0; j < sta[i].length; j++) {
				sta[i][j].sort--;
			}
		}
		
		
		
		for (StudRetData data : arr) {
			data.acc(this);
		}
	}
	
	void init()
	{
		int maxBan = -1;
		
		for(StudRetData sd : arr)
		{
			if(sd.ban> maxBan) maxBan = sd.ban;
			
			sd.gender= index[1].length-7-sd.jum.length;
		}
		banCnt = new int [maxBan+1][2];
		
		///반 인원수 처리
		for(StudRetData sd : arr){
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
			
			for (StudRetData sd :arr) {//i-> 학생
				
				if(r == sd.sort[kind])//현재출력번호 === 나의 각 출력방식의 출력번호가 같은지
				{
					sd.print(kind);
				}
			}
			
			for(StudRetArr acc : sta[kind])
			{
				if(acc.sort==r)
				{
					System.out.println(acc.sort+"--------------------------------------------------------------------------------------");
					
					for(StudRetData dd : acc.arr)
					{
						dd.print(kind);
					}
					System.out.println("--------------------------------------------------------------------------------------");
				}
			}
		}
		
		
	}
}


////학생클래스를 정의, 선언, 생성, 호출 하여 학생정보를 출력하세요

//--- 학번, 이름, 반, 전화번호,  점수 [국어, 영어, 수학], 총점, 평균
public class StudReturnMain {

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
		
		
		
		StudRetData [] arr = new StudRetData[name.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new StudRetData();
			arr[i].init( name[i], stu[i], 5, false);
			
		}
		
		new StudRetLogic().cal(arr);
		
		
		
	}
}
