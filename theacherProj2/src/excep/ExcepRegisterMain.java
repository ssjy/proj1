package excep;

import java.util.Scanner;

//회원가입 프로그램을 작성하세요
//입력사항 - id", "pw", "pw확인", "성명", "이메일", "취미", "특기", "전화번호", "핸드폰", "생년월일", "성별
//필수 입력사항 - id", "pw", "pw확인", "성명", "전화번호", "생년월일", "성별 (값이 없으면 에러 발생)
//유효성 검사 - 생년 : 1980 이전 출생자만 가입 가능
//          비밀번호", "비밀번호 확인은 값이 같아야만 가능
public class ExcepRegisterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] qq ={"id", "pw", "pw확인", "성명", "이메일", 
				"취미", "특기", "전화번호", "핸드폰", "생년월일", "성별"};
		boolean [] cjh = {true,true,true, true,false,false,false,true,false,true,true};
		int excepNum = 9;
		String pwChk="";
		Scanner sc = new Scanner(System.in);
		tot:while(true)
		{
			try {
				for (int i = 0; i < qq.length; i++) {
					System.out.print(qq[i]+":");
					
					if(i!=excepNum)
					{
						String input = sc.nextLine();
						if(cjh[i] && input.equals(""))
							throw new Exception(qq[i]+" 입력에러");
						
						if(i==1) pwChk = input;
						
						if(i==2 && !pwChk.equals(input))
							throw new Exception("pw 불일치");
						
						System.out.println(input);
					}else{
						int input = sc.nextInt();
						if(input<19800000)
							throw new Exception(qq[i]+" 1980이상");
							System.out.println(input);
						sc.nextLine();
					}
				}
				break tot;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("회원가입 완료");
	}

}
