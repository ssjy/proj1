package oops;

import java.util.Scanner;

class Stud{
	int no, ban, sum, avg, gender;
	String name, tel;
	int [] jum, rank, sort;
	
}
////학생클래스를 정의, 선언, 생성, 호출 하여 학생정보를 출력하세요

//--- 학번, 이름, 반, 전화번호,  점수 [국어, 영어, 수학], 총점, 평균
public class StudMain {

	public static void main(String[] args) {
		/*Stud st = new Stud();
		st.no = 1;
		st.ban = 1;
		st.name = "장동건";
		st.tel = "010-1234-5678";
		st.jum = new int []{88,89,86};
		for (int i = 0; i < st.jum.length; i++) {
			st.sum+= st.jum[i];
		}
		for(int jj : st.jum)
		{
			st.sum += jj;
		}
		st.avg = st.sum/st.jum.length;
		
		
		System.out.println(st.ban);
		System.out.println(st.no);
		System.out.println(st.name);
		System.out.println(st.tel);
		for(int jj : st.jum)
		{
			System.out.println(jj);
		}
		System.out.println(st.sum);
		System.out.println(st.avg);*/
		
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
		
		String [][] index = {
				{"입력 순서", "전체 등수", "반별 등수", "성별 등수", "반, 성별, 등수"}, 
				{"반","이름","성별","국어","영어","수학","교련","총점","평균","등급","등수"},
				{"남자","여자"},
				{"가","가","가","가","가","가"
				,"양","미","우","수","수"}
				
			};
		
		Stud [] arr = new Stud[name.length];
		int maxBan = -1;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Stud();
			arr[i].rank = new int [index[0].length];
			arr[i].sort = new int [index[0].length];
			
			arr[i].name = name[i];
			arr[i].ban = stu[i][0];
			
			arr[i].jum = new int [stu[i].length-1]; 
			
			for (int j = 0; j < arr[i].jum.length; j++) {
				arr[i].jum[j]=stu[i][j+1];
			}
			arr[i].sum =0;
			for(int jj : arr[i].jum)
			{
				arr[i].sum += jj;
			}
			arr[i].avg = arr[i].sum/arr[i].jum.length;
			
			if(stu[i][0]> maxBan) maxBan = stu[i][0];
			
			arr[i].gender= index[1].length-6-stu[i].length;
			
		}
		/////////////////////////////
		
		
		
		int [][] banCnt = new int [maxBan+1][2];
		///반 인원수 처리
		for (int i = 0; i < arr.length; i++) {
			banCnt[stu[i][0]][arr[i].gender]++;
		}
		
		
		
		//등수
		for (int i = 0; i < arr.length; i++) {
			
			///등수초기화
			for (int j = 0; j < arr[i].rank.length; j++) {
				arr[i].rank[j]=1;
			}
			
			
			/// 현재 반 초기화
			for (int j = 1; j < arr[i].ban; j++) {
				for (int k = 0; k < banCnt[j].length; k++) {
					arr[i].sort[2]+= banCnt[j][k];
					//arr[i].sort[4]+= banCnt[j][k];
				}
				arr[i].sort[4] =arr[i].sort[2]; 
			}
			
			/// 성별(여자)초기화
			if(arr[i].gender==1) {
				for (int j = 1; j < banCnt.length; j++) {
					arr[i].sort[3]+=banCnt[j][0];
					
				}
				arr[i].sort[4]+= banCnt[arr[i].ban][0];
				
			} //여자라면 초기값 남자인원수
			
			for (int j = 0; j < arr.length; j++) {
				
				if(arr[i].avg<arr[j].avg)
				{
					
					arr[i].rank[0]++;
					
					arr[i].sort[1]++;
					arr[i].rank[1]++;
					
					if(arr[i].gender==arr[j].gender)//성별이 같다면
					{
						arr[i].rank[3]++;
						arr[i].sort[3]++;
					}
					
					if(arr[i].ban==arr[j].ban)//반이 같다면
					{
						arr[i].rank[2]++;
						arr[i].sort[2]++;
						if(arr[i].gender==arr[j].gender)//성별이 같다면
						{
							arr[i].rank[4]++;
							arr[i].sort[4]++;
						}
					}
				}
				
			}
			
		}
		
		
		///////////////////////////
		
///////////////출력부
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
		
		for (int i = 0; i < arr.length; i++) {//i-> 학생
			
			if(r == arr[i].sort[kind])//현재출력번호 === 나의 각 출력방식의 출력번호가 같은지
			{
				String str = 
						
						arr[i].ban+"\t"+	//반
						arr[i].name+"\t"+	//이름
						index[2][arr[i].gender]+"\t";	
				//성별{"남자","여자"}[] 
				
				for (int j = 0; j < arr[i].jum.length; j++) {//j-> 과목
					str+=arr[i].jum[j]+"\t";
				}
				if(arr[i].gender==1)	//성별{"남자","여자"}[]  여자인가?
					str+="\t";
				
				
				str+=arr[i].sum+"\t"+arr[i].avg+"\t";
				
				str+=index[3][arr[i].avg/10]+"\t";	
				//{"가"...,"양","미","우","수","수"}res[i][2]:평균/10
				str+=arr[i].rank[kind];//0,1,2,3,4 등수 종류
				
				System.out.println(str);
			}
		}
	}
		
		
		
	}
}
