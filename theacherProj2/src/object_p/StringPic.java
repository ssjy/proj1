package object_p;

import java.util.Arrays;

public class StringPic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사진 파일을 확인하세요 ex) 영업_홍길동_20110823.jpg
		
		
		
		
		//호봉수를 계산할 것 (년도단위에서 절삭)
		
		
		try {
			String input = "영업_홍길동_20110823.jpg";
			
			String [] inArr = input.split("_");
			
			if(inArr.length!=3)
				throw new Exception("길이 에러");
			
			//System.out.println(inArr[4]);
			
			boolean chk = false;
			String [] chArr = {"영업", "총무", "인사", "기획", "생산"};
			for(String ch : chArr)
			{
				if(ch.equals(inArr[0]))
					chk=true;
			}
			
			if(!chk)
				throw new Exception("부서 에러");
			
			if(inArr[1].length() >4 || inArr[1].length() <2)
				throw new Exception("이름 에러");
			
			chk = false;
			chArr =new String[] {"jpg","bmp","gif"};
			
			String ext = inArr[2].toLowerCase().substring(
					inArr[2].lastIndexOf(".")+1);
			
			
			String emp = inArr[2].substring(0,
					inArr[2].lastIndexOf("."));
			
			for(String ch : chArr)
			{
				if(ch.equals(ext))
					chk=true;
			}
			if(!chk)
				throw new Exception("확장자 에러");
			
			
			if(emp.length()!=8)
				throw new Exception("입사일길이에러");
					
			for(int i =0; i<emp.length();i++)
			{
				if(emp.charAt(i)<'0' || emp.charAt(i)>'9')
					throw new Exception("입사일숫자에러");
			}
			
			int [] dd = {0,4,6,8};
			
			int [] dday = new int[dd.length-1];
			
			for(int i =0;i<dd.length-1;i++)
			{

				for(int k =dd[i];k<dd[i+1];k++)
				{
					dday[i]*=10;
					dday[i]+=emp.charAt(k)-'0';
				}
				
			}
			
			int hh = 2017 - dday[0];
			
			if(dday[1]>3)
			{
				hh--;
			}else if(dday[1]==3){
				if(dday[2]>6)
					hh--;
				
			}
			
			//System.out.println(hh);
			
		
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
