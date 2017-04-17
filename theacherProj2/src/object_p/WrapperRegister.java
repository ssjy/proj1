package object_p;

import java.util.Scanner;

///회원 가입을 구현하세요

/// 증명사진 : jpg,bmp,png,gif 만 올리세요
/// 이메일 유효성 검사하세요

////  아이디@도메인   형태일 것 : @ 한개
///  아이디 영문만
//// 도메인 영문으로 구성 도메인 종류는 2,3개로
         //// naver.com,   yahoo.co.kr 
/// 전화번호는 숫자만
/// 예외처리 사용할 것
public class WrapperRegister {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
			try {
				System.out.print("증명사진:");
				String pic = sc.nextLine();
				
				String [] chArr =new String[] {"jpg","bmp","gif"};
				
				String ext = pic.toLowerCase().substring(
						pic.lastIndexOf(".")+1);
				
				boolean chk = true;
				for(String ch: chArr)
				{
					if(ch.equals(ext)) chk = false;
				}
				
				if(chk)	throw new Exception("증명사진 에러");
				
				
				System.out.print("이메일:");
				String email = sc.nextLine();
				
				
				
				String [] emArr = email.split("@");
				
				if(emArr.length!=2)	throw new Exception("이메일 @에러");
				
				chk = false;
				for(int i =0; i<emArr[0].length();i++)
				{
					if(emArr[0].toLowerCase().charAt(i)<'a'
					||emArr[0].toLowerCase().charAt(i)>'z')
						chk=true;
				}
				if(!chk)	throw new Exception("이메일 @에러");
				
				
				chArr =new String[] {"naver.com","google.com","yahoo.com"};
				chk = true;
				for(String ch: chArr)
				{
					if(ch.equals(emArr[1])) chk = false;
				}
				
				if(chk)	throw new Exception("도메인 에러");
				
			
				System.out.print("전화번호:");
				String tel = sc.nextLine();
				
				Long.parseLong(tel);
				
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
		}
		
		System.out.println("회원가입 완료");
	}

}
