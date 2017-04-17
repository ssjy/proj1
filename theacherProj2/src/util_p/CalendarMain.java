package util_p;

import java.util.Calendar;

public class CalendarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar today = Calendar.getInstance();
		
		System.out.println(today);
		
		System.out.println(today.get(0));
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.MONTH));
		System.out.println(today.get(Calendar.WEEK_OF_YEAR));
		System.out.println(today.get(Calendar.DAY_OF_YEAR));
		System.out.println(today.get(Calendar.WEEK_OF_MONTH));
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.DAY_OF_WEEK));
		
		System.out.println(today.get(Calendar.AM_PM));
		System.out.println(today.get(Calendar.HOUR));
		System.out.println(today.get(Calendar.HOUR_OF_DAY));
		System.out.println(today.get(Calendar.MINUTE));
		System.out.println(today.get(Calendar.SECOND));
		System.out.println(today.get(Calendar.MILLISECOND));
		
		//2017년 3월 7일 화요일  오후 5:17:32.123
		
		print(today);
		
		today.set(Calendar.YEAR, 1989);
		today.set(1989,2,20);
		today.set(2015,2,20,14,30,12);
		//today.set(Calendar.YEAR,today.get(Calendar.YEAR)+1 );
		today.add(Calendar.MONTH,3);
		print(today);
		today.add(Calendar.DATE,-15);
		today.set(Calendar.MONTH,1);
		today.set(1989,3,0);
		print(today);
		
		Calendar now = Calendar.getInstance();
		
		System.out.println(today.before(now));
		System.out.println(today.after(now));
		System.out.println(today.getActualMaximum(Calendar.YEAR));
		System.out.println(today.getActualMaximum(Calendar.MONTH));
		System.out.println(today.getActualMaximum(Calendar.DATE));
		System.out.println(today.getTimeInMillis());
		today.setTimeInMillis(0);
		today.set(2017,2,20);
		print(today);
		
		long dday = (today.getTimeInMillis()-now.getTimeInMillis())/1000/60/60/24;
		
		System.out.println(dday);
	}
	
	
	public static void  print(Calendar cc)
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
				
		
		System.out.println(str);
	}

}
