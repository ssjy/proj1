package arr;

import java.util.Scanner;

///////  반을 넣고 반별, 번호별, 성별로 출력하세요
////출력 방식
////1. 입력 순서  2.전체 등수 3. 반별 등수  4. 성별 등수  5, 반, 성별, 등수 

////각 분류의 마지막에는 과목별 총점, 평균을 출력할 것



/// 단 여학생인 경우 수학비율과 롤비율을 합쳐서 계산한다.
public class MulExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		int [][] res = new int [stu.length][3];
		int [][] rank = new int [stu.length][index[0].length];
		/*{
			{전체등수, 전체등수,반별등수,성별등수, 반성별등수},
			{전체등수, 전체등수,반별등수,성별등수, 반성별등수},
			{전체등수, 전체등수,반별등수,성별등수, 반성별등수},
			{전체등수, 전체등수,반별등수,성별등수, 반성별등수},
			...
			
		}*/
		int maxBan = -1;
		
		
		
		int [][] sort = new int [stu.length][index[0].length];
		/*{
		{전체등수출력, 전체등수,반별등수,성별등수, 반성별등수},
		{전체등수, 전체등수,반별등수,성별등수, 반성별등수},
		{전체등수, 전체등수,반별등수,성별등수, 반성별등수},
		{전체등수, 전체등수,반별등수,성별등수, 반성별등수},
		...
		
	}*/
		
		
		//연산부
		//기본 정보
		for (int i = 0; i < stu.length; i++) {
			
			if(stu[i][0]> maxBan) maxBan = stu[i][0];
			
			res[i][0]= index[1].length-6-stu[i].length;
			
			
			for (int j = 1; j < stu[i].length; j++) {
				res[i][1]+=stu[i][j];
			}
			res[i][2]=res[i][1]/(stu[i].length-1);
		}
		
		
		int [][] banCnt = new int [maxBan+1][2];
		///반 인원수 처리
		for (int i = 0; i < stu.length; i++) {
			banCnt[stu[i][0]][res[i][0]]++;
		}
		
		
		
		//등수
		for (int i = 0; i < res.length; i++) {
			
			///등수초기화
			for (int j = 0; j < rank[i].length; j++) {
				rank[i][j]=1;
			}
			
			
			/// 현재 반 초기화
			for (int j = 1; j < stu[i][0]; j++) {
				for (int k = 0; k < banCnt[j].length; k++) {
					sort[i][2]+= banCnt[j][k];
					sort[i][4]+= banCnt[j][k];
				}
			}
			
			/// 성별(여자)초기화
			if(res[i][0]==1) {
				for (int j = 1; j < banCnt.length; j++) {
					sort[i][3]+=banCnt[j][0];
					
				}
				sort[i][4]+= banCnt[stu[i][0]][0];
				
			} //여자라면 초기값 남자인원수 
			for (int j = 1; j < res.length; j++) {
				
				if(res[i][2]<res[j][2])
				{
					//sort[i][0]++;
					rank[i][0]++;
					
					sort[i][1]++;
					rank[i][1]++;
					
					if(res[i][0]==res[j][0])//성별이 같다면
					{
						sort[i][3]++;
						rank[i][3]++;
					}
					
					if(stu[i][0]==stu[j][0])//반이 같다면
					{
						sort[i][2]++;
						rank[i][2]++;
						if(res[i][0]==res[j][0])//성별이 같다면
						{
							sort[i][4]++;
							rank[i][4]++;
						}
					}
				}
				
			}
			
		}
		
		
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
		/*for (int i = 0; i < index[1].length; i++) {
			System.out.print(index[1][i]+"\t");
			line+="========";
		}*/
		
		for(String buf : index[1])
		{
			System.out.print(buf+"\t");
			line+="========";
		}
		System.out.println("\n"+line);
		
		
		///2. 출력출력
		for(int r =0;r<name.length;r++)//r 0 -> 17
		{
			
			for (int i = 0; i < name.length; i++) {//i-> 학생
				
				if(r == sort[i][kind])//현재출력번호 === 나의 각 출력방식의 출력번호가 같은지
				{
					String str = 
							
							stu[i][0]+"\t"+	//반
							name[i]+"\t"+	//이름
							index[2][res[i][0]]+"\t";	
					//성별{"남자","여자"}[]  res[i][0]=> 0,1
					
					for (int j = 1; j < stu[i].length; j++) {//j-> 과목
						str+=stu[i][j]+"\t";
					}
					if(res[i][0]==1)	//성별{"남자","여자"}[]  여자인가?
						str+="\t";
					
					for (int j = 1; j < res[i].length; j++) {//j-> 총점, 평균
						str+=res[i][j]+"\t";
					}
					str+=index[3][res[i][2]/10]+"\t";	
					//{"가"...,"양","미","우","수","수"}res[i][2]:평균/10
					str+=rank[i][kind];//0,1,2,3,4 등수 종류
					
					System.out.println(str);
				}
			}
		}
	}
}
