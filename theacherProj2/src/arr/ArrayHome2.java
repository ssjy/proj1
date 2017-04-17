package arr;

import java.util.Scanner;

public class ArrayHome2 {

	public static void main(String[] args) {
		//1...   ArrayHome2 의 main 함수 시작
		
		////1. 입력부
		
		String [] name = {
				"장동건","장남건","장서건","장중건","북두신건"};
		//2...  이름 배열 선언 - 5명의 이름을 원소로 받음
		
		int [] ban = {2,1,2,1,2};  //3... 반 배열 선언(5명)
		int [] jum1 = {20,85,95,70,65};
        int [] jum2 = {15,80,100,55,90};
        int [] jum3 = {65,85,80,75,80};
        
        int [] sum = new int [name.length];
        //7... 합계 배열을 만듬 --학생의 인원수 만큼 배열원소 지정
        int [] avg = new int [name.length];
        
        
        int [] totalRank = new int [name.length];
        //9...  전체 등수 배열 만듬 --
           /// 전체 등수 배열은 향후 화면 출력시에 사용할 것으로
           /// printRank 에 주소값을 넘기기 위한 것이다
           /// 기록 결과는 5,2,1,4,3 으로 넣을 생각임
           /// 2.2 연산부의 등수계산에서 처리할 것이다.
        
        int [] banRank = new int [name.length];
        int [] totalSort = new int [name.length];
        int [] banSort = new int [name.length];
        
        
        
        
        String [] grade = new String [name.length];
        String [] gradeIndex = {
        		"가","가","가","가","가","가",
				"양","미","우","수","수"
        };
       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("출력방법: 1. 전체등수, 2.반별등수");
        
        System.out.print("입력:");
        
        int kind = sc.nextInt();
        
        
        ///2. 연산부
        //2.1 초기 정보 계산
      
        ///19... for문의 시작 ----> 학생의 인원수 만큼 돌린다.
        for (int i = 0; i < name.length; i++) {
        //19번의 작은 번호시작         name.length:5
        	  // 1. i =0    2. 0<5
        	                 //결과 :true
        	                           //6. i++ => i:1로 변환
        	              //7   1<5
                                 //결과 :true
        	
			sum[i]= jum1[i]+jum2[i]+jum3[i];
			//3. sum[0](장동건의 합계) = 국어[0](20)+영어[0](15)+수학[0](65)
			  //100
			
			//8. sum[1](장남건의 합계) = 국어[1](85)+영어[1](80)+수학[1](85)
			  //250
			
			avg[i] = sum[i]/3;
			//4. 
			grade[i] = gradeIndex[avg[i]/10];
			//5.
		}
        
        ///2.2 등수 계산

		for (int i = 0; i < name.length; i++) {
        	totalRank[i]=1;
        	banRank[i]=1;
        	
        	if(ban[i]==2)
        		banSort[i]=2;
        	for (int j = 0; j < name.length; j++) {
				if(avg[i]<avg[j] )
				{
					totalRank[i]++;
					totalSort[i]++;
					
					if(ban[i]==ban[j])
					{
						banRank[i]++;
						banSort[i]++;
					}
				}
			}
        }
    	   
		int [] printSort= totalSort;
        int [] printRank = totalRank;
    	switch(kind)
    	{
    		case 2:
    			printRank = banRank;
    			printSort = banSort;
    			break;
    	}
	        
	        ///3. 출력부
	        
				
			
        for (int r = 0; r <name.length; r++) {
			
	        for (int i = 0; i < name.length; i++) {
	        	String str = 
	        			ban[i]+"\t"+
	        			name[i]+"\t"+
	        			jum1[i]+"\t"+
	        			jum2[i]+"\t"+
	        			jum3[i]+"\t"+
	        			sum[i]+"\t"+
	        			avg[i]+"\t"+
	        			grade[i]+"\t"+
	        			printRank[i]+"\t"+
	        			totalRank[i]+"\t"+
	        			banRank[i]+"\t"+"\t"+
	        			printSort[i]+"\t"+
	        			totalSort[i]+"\t"+
	        			banSort[i]
	        			;
	        	
	        	if(r == printSort[i])
	        	System.out.println(str);
	        }
        }
    }
		
	

}
