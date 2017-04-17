package object_p;

import java.util.Arrays;

////생년월일
/// 성별
/// 국적
/// 나이(한국 나이)
/// 다가올생일
/// D-Day (생일까지)


public class JuminMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jumin = "890306-1234567";
		             // 0123456
		             // 0 2 4 6
		int kk = jumin.charAt(7)-'0';
		
		int [] birth = new int[3];
		
		for (int i = 0; i < birth.length; i++) {
			/*String sub = jumin.substring(i*2, (i+1)*2);
			for(int k =0;k<sub.length();k++)
			{
				birth[i]*=10;
				birth[i]+=sub.charAt(k)-'0';
			}*/
			
			for(int k =i*2;k<(i+1)*2;k++)
			{
				birth[i]*=10;
				birth[i]+=jumin.charAt(k)-'0';
			}
		}
		
		
		String gender = new String[]{"여자","남자"}[kk%2];
		String local = new String[]{"내국인","외국인"}[kk%9/5];
		birth[0]+= (19+(kk%9==0 ? -1 : (kk-1)%4/2))*100; // 몇년도인지(1900,1800,2000)
		System.out.println(Arrays.toString(birth));
		System.out.println(gender);
		System.out.println(local);
		
		int [] now = {2017, 3,7}; // today
		
		System.out.println(now[0]-birth[0]+1); // 나이
		
		boolean chk = false;
		for (int i = 1; i < now.length; i++) {  //생일이 지났는지의 여부 확인
			
			if(birth[i]<now[i])
			{
				chk = true;
				break;
			}else if(birth[i]>now[i])
			{
				chk = false;
				break;
			}
		}
		
		int [] mm ={0, 31,28,31,30,31,30,31,31,30,31,30,31};
		System.out.println(chk);
		
		int birthCnt = birth[2];
		int toDayCnt = now[2];
		int totCnt=0;
		
		for (int i = 0; i < mm.length; i++) {
			totCnt+=mm[i];
			if(i<birth[1]) birthCnt+=mm[i];
			
			if(i<now[1]) toDayCnt+=mm[i];
		}
		
		int dday = birthCnt - toDayCnt;
		
		if(chk)
		{
			dday = totCnt-toDayCnt+birthCnt;
		}
		
		System.out.println(dday);

	}

}
