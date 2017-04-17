package util_p;

import java.util.Calendar;

public class DiaryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar today = Calendar.getInstance();
		int mm = today.get(Calendar.MONTH);
		int dd = today.get(Calendar.DATE);
		
		for (int m = 0; m <12; m++) {
			
			System.out.println("===========  "+(m+1)+"¿ù  ===============");
			today.set(today.get(Calendar.YEAR),m, 1);
			
			for (int i = 1; i <today.get(Calendar.DAY_OF_WEEK); i++) {
				System.out.print("     ");
			}
			
			for (int i = 1; i <=today.getActualMaximum(Calendar.DATE); i++) {
				
				today.set(Calendar.DATE, i);
				String prefix = "", surfix="";
				
				
				
				if(mm == today.get(Calendar.MONTH) && dd==i){
					prefix +="["; 
					surfix +="]";
				}else{
					prefix +=" "; 
					surfix +=" ";
				}
				
				if(i<10) prefix +=" ";
				surfix+=" ";
				
				System.out.print(prefix +i+surfix);
				
				if(today.get(Calendar.DAY_OF_WEEK)==7)
					System.out.println();
				
			}
			
			System.out.println();
		}
	
	}
}
