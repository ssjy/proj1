package text_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import util_p.CalendarMain;

public class DateMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Date today = new Date();
		Calendar cday = Calendar.getInstance();
		today = new Date(1989-1900,2,20,15,35,48);
		System.out.println(today);
		System.out.println(today.getYear()+1900);
		System.out.println(today.getMonth());
		System.out.println(today.getDate());
		System.out.println(today.getDay());
		System.out.println(today.getHours());
		System.out.println(today.getMinutes());
		System.out.println(today.getSeconds());
		System.out.println(today.getTime());
		System.out.println(cday.getTimeInMillis());
		
		//cday.setTimeInMillis(today.getTime());
		cday.setTime(today);
		CalendarMain.print(cday);
		
		cday.add(Calendar.YEAR, 10);
		CalendarMain.print(cday);
		
		today = cday.getTime();
		System.out.println(today);
		
		today = new Date();
		
		String [] ppStr = {
			"y"	,"yy","yyyy",
			"M","MM","MMM","MMMM",
			"d","dd","D",
			"E","EEEE","F",
			"a",
			"H","HH","h","hh",
			"m","mm",
			"s","ss","S"
			
				
		};
		
		for(String pp: ppStr)
		{
			SimpleDateFormat sdf = new SimpleDateFormat(pp, new Locale("en"));
			System.out.println(pp+":"+sdf.format(today));
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		Date birth = sdf.parse("19980406");
		
		System.out.println(birth);
	}

}
