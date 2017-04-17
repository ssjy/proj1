package util_p;

import java.util.Calendar;

//주민번호를 이용하여 
//생년월일
//나이
//올해생일
//다가올 생일
//다가올 생일파티(토, 일 인경우 전 금요일)
//생일파티 D-day 를 출력하세요
public class BirthDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jumin = "890320-1234567";
		
		//String [] hdArr = {"3_20","2_3","5_5","7_17","3_1","3_17","4_10"};
		
		int kk = jumin.charAt(7)-'0';
		
		int [] birth = new int[3];
		
		for (int i = 0; i < birth.length*2; i+=2) {
			
			birth[i/2]=Integer.parseInt(jumin.substring(i, i+2));	
		}
		
		birth[0]+= (19+(kk%9==0 ? -1 : (kk-1)%4/2))*100;
		
		Calendar birthDay = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		birthDay.set(birth[0], birth[1]-1,birth[2]);
		System.out.println("생년월일:"+print(birthDay));
		
		int age = now.get(Calendar.YEAR)-birthDay.get(Calendar.YEAR);
		
		birthDay.set(Calendar.YEAR, now.get(Calendar.YEAR));
		System.out.println("올해생일:"+print(birthDay));
		if(birthDay.after(now)){ 
			age--;
			
		}else{
			birthDay.add(Calendar.YEAR,1);
		}
		System.out.println("나이:"+age);
		System.out.println("다가올생일:"+print(birthDay));
		
		
		while(true)
		{
			boolean chk = true;
			if(birthDay.get(Calendar.DAY_OF_WEEK)==7) birthDay.add(Calendar.DATE,-1);
			if(birthDay.get(Calendar.DAY_OF_WEEK)==1) birthDay.add(Calendar.DATE,-2);
			
			/*for(String hd: hdArr)
			{
				int mm = Integer.parseInt(hd.substring(0,hd.indexOf("_")))-1;
				int dd = Integer.parseInt(hd.substring(hd.indexOf("_")+1));
				
				
				if(mm == birthDay.get(Calendar.MONTH) && 
						dd == birthDay.get(Calendar.DATE) )
				{
					birthDay.add(Calendar.DATE, -1);
					chk = false;
				}
				
			}*/
			
			
			if(chk) break;
		}
		
		
		
		System.out.println("생일파티:"+print(birthDay));
		
		long dday = (birthDay.getTimeInMillis()-now.getTimeInMillis())/1000/60/60/24;
		
		System.out.println("DDay:"+dday);
	}
	
	static String  print(Calendar cc)
	{
		
		String str = cc.get(Calendar.YEAR)+"년 "+
				(cc.get(Calendar.MONTH)+1)+"월 "+
				cc.get(Calendar.DATE)+"일 "+
				"일월화수목금토".charAt(
						cc.get(Calendar.DAY_OF_WEEK)-1)+"요일 오"+
				"전후".charAt(
						cc.get(Calendar.AM_PM))+" "+
				cc.get(Calendar.HOUR)+":"+
				cc.get(Calendar.MINUTE)+":"+
				cc.get(Calendar.SECOND)+"."+
				cc.get(Calendar.MILLISECOND);
				
		
		return str;
	}

}
