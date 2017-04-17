package oops;

import java.util.Scanner;
 
class StudHH{
  int no, ban, sum,  gender;
  
  double avg;
  
  String name, tel;
  int [] jum, sort, rank;
  
 }
 ////학생클래스를 정의, 선언, 생성, 호출 하여 학생정보를 출력하세요
 
 //--- 학번, 이름, 반, 전화번호,  점수 [국어, 영어, 수학], 총점, 평균
 public class Report_9_1 {
 
  public static void main(String[] args) {
   
   Scanner sc = new Scanner(System.in);
   
  
   
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
   
   
   int[] stuNo = 
              {1, 2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
 
   String [][] index = {
    {"입력 순서", "전체 등수", "반별 등수", "성별 등수", "반, 성별, 등수", "반,성별,번호"}, 
    {"반","이름","성별","국어","영어","수학","교련","총점","평균","등급","등수"},
    {"남자","여자"}
   };
   
   StudHH [] arr = new StudHH[name.length];
   
   for (int i = 0; i < arr.length; i++) {  // i는 생성한 배열의 수만큼의 범위를 갖는다.
    arr[i] = new StudHH();    // 각각의 arr[i]에 대해 객체를 생산한다.
    arr[i].name = name[i];     // arr[i]의 이름에  학생이름 name[i]를 넣는다.
    arr[i].no = stuNo[i];
    arr[i].ban = stu[i][0];    // arr[i]의 반에 학생의 반 stu[i][0]을 넣는다.
    
    arr[i].jum = new int [stu[i].length-1];   //arr[i]마다 응시한 과목 수 (반은 빼고 점수만 )만큼 배열 생성 
    arr[i].rank = new int [index[0].length];
    arr[i].sort = new int [index[0].length];
    
    for (int j = 0; j < arr[i].jum.length; j++)  //  j는 각 학생이 본 과목의 길이만큼 arr[i]마다 다르게 할당
    {
     arr[i].jum[j]=stu[i][j+1];  // 각각의 arr[i]에 실질적인 점수를 넣는다.   1은 stu맨 앞에 반 때문
    }
    
    arr[i].sum =0;     //앞의 값이 있기 때문에 0으로 초기화한다.
    for(int jj : arr[i].jum)    
    {
     arr[i].sum += jj;  //arr[i]에 있는 점수 값들을 모두 더해서 arr[i].sum에 집어 넣는다.
    }
    
  
    arr[i].avg =(double)((int)(100*((double) arr[i].sum/arr[i].jum.length)))/100;  // arr[i].avg는 arr[i]의 sum값들에 
                //각각의 사람들이 응시한 과목수만큼 나눈다.
    arr[i].gender = index[1].length - 6 -stu[i].length;  // gender값을 넣는다. 1이면 여자, 0이면 남자
//    System.out.println("arr["+i+"].gender="+arr[i].gender+"\t");
   }
   
   System.out.println("0.자료입력순서 1.전체  2.반별  3.성별별  4.반,성별,등수  5.반,성별,번호 ");
   System.out.print("출력방식(1~5)을 선택하세요> ");
   int choice = sc.nextInt();
   
   // arr[i]의 rank=1, sort=0으로 초기화
   for(int i=0; i<arr.length; i++)
   {
    for(int j=0; j<arr[i].rank.length; j++)
    {
     arr[i].rank[j]=1;
     arr[i].sort[j]=0;
    }
    
   }
   
   
   //반수 구하기, 과목수 구하기
   int banMax=0, subMax=0;
   for(int i=0; i<arr.length; i++)    
   {
    if(arr[i].ban>banMax)
    {
     banMax = arr[i].ban;
    }
    
    if(arr[i].jum.length > subMax)
    {
     subMax = arr[i].jum.length;
    }
    
   }
      
   //sort 가중치 구하기
 
   int [] banStu = new int [banMax+1]; //각 반의 학생들 수 구하기
   int [] banMale = new int [banMax+1]; //각 반별 남학생들의 수 구하기
   
   for(int i=0; i<banMax+1; i++)        //추가
   {
       banStu[i]=0;    banMale[i]=0; //전부 0으로 초기화
   }
   
   
   // 성별별 출력시 사용할 전체 남학생 수
   for(int i=0; i<arr.length; i++) 
   {
    if(arr[i].gender == 0) //학생의 성별이 남자일 경우
    {
     banMale[0]++;  //bamMale[0] = 전체 남학생의 수
    }
   }   
 
   //각 반의 학생수와 각 반의 남학생 수
   for(int j =1; j<= banMax; j++)
   {
    for(int i=0; i<arr.length; i++)
    {
     if(arr[i].ban == j)
     {
      banStu[j]++; //반 별 학생수 구하기
      if(arr[i].gender == 0) //특정 반 학생의 성별이 남자일 경우
      {
       banMale[j]++;  //반 별 남학생  수 구하기
      }
     }
    }
   }
  
   
  
   
   
   for(int i=0; i<arr.length; i++)
   {
    for(int j=1; j<index[0].length; j++)
    {
     if(j==2)       //choice ==2 의 값2.반별 
     {
     for(int k=1; k<arr[i].ban; k++)
     {
      arr[i].sort[j] += banStu[k];
     }
     }
     else if(j==3)      //choice ==3 의 값3.성별별  
     {
      if(arr[i].gender == 1)
      {
       arr[i].sort[j] = banMale[0];   // 전체 남학생 수
      }
     }
     else if(j==4 || j==5)     //choice ==4,5 의 값 4.반,성별,등수  5.반,성별,번호
     {
  /*arr[i].sort[j] += banStu[j-1]+banMale[j];  //전 반의 학생수들의 합 + 해당 반의 남학생 수   [banMax+1]; (1~3)*/ 
      if(arr[i].gender==1)
      {
       for(int k=1; k<arr[i].ban; k++)
       {
        arr[i].sort[j] += banStu[k];
       }
       arr[i].sort[j] += banMale[arr[i].ban];
      }else if(arr[i].gender == 0)
      {
       for(int k=1; k<arr[i].ban; k++)
       {
        arr[i].sort[j] += banStu[k];
       }
      }
     }
    
 
    }
   }
   
   
   
  
   //arr[i].rank와 arr[i].sort 채우기
   for(int i=0; i< arr.length; i++)
   {
    for(int j=0; j<arr.length; j++)
    {
     if(arr[i].avg < arr[j].avg) 
     {
     
      arr[i].rank[0]++;    // 0번. 자료 입력 순서
      
      arr[i].rank[1]++;    // 1번. 전체 등수
      arr[i].sort[1]++;
      
      if(arr[i].ban == arr[j].ban)  
      {
       arr[i].rank[2]++;   //2번. 반 별 등수
       arr[i].sort[2]++;
      }
      
      if(arr[i].gender == arr[j].gender) 
      {
       arr[i].rank[3]++;   //3번. 성별 별 등수
       arr[i].sort[3]++;
       
       if(arr[i].ban == arr[j].ban)
       {
        arr[i].rank[4]++;  //4번. 반, 성별, 등수
        arr[i].sort[4]++;
       }
      }
     }
     
     if(arr[i].no > arr[j].no)
     {
      if(arr[i].ban == arr[j].ban )
      {
       if(arr[i].gender == arr[j].gender)
       {
        arr[i].rank[5]++;  //5. 반, 성별, 번호
        arr[i].sort[5]++;
       }
      }
     }
    }
   }
   
   
   //출력
   
   int z = 0;
   System.out.println("학번\t반\t이름\t성별\t국어\t영어\t수학\t교련\t총점\t평균\t순위");
   for(int i=0; i<arr.length;i++)
   {
    for(int j=0; j<arr.length;j++)
    {
     if(arr[j].sort[choice] == i)
     {
      System.out.print(
    		arr[j].no+"\t"
           +arr[j].ban+"\t"
           +arr[j].name+"\t"
           +arr[j].gender+"\t");
      for(int k=0; k< arr[j].jum.length; k++)
      { 
       
       if( arr[j].gender == 1 && k== arr[j].jum.length-1 )
       {
        System.out.print(arr[j].jum[k]+"\t\t");
       }else{
        System.out.print(arr[j].jum[k]+"\t");
       }
       
       
      }
      System.out.println(arr[j].sum+"\t"+arr[j].avg+"\t"+arr[j].rank[choice]);
     }
    }
   }
    
   
   
 
   
  ///////  반을 넣고 반별, 번호별, 성별로 출력하세요
  //// 출력 방식
  ////1. 반별 입력 순서  2. 반별 등수  3. 성별 등수  4, 반, 성별, 등수   5, 반, 성별, 번호
 
  //// 각 분류의 마지막에는 과목별 총점, 평균을 출력할 것
   
   
   
   
 
   
  }
 }
 
 