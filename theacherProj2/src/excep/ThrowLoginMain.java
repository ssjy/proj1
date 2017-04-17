package excep;

import java.util.Scanner;

public class ThrowLoginMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id="aaa", pw="1111";
		while(true)
		{
			try {
				System.out.print("id:");
				String input = sc.nextLine();
				
				if(!id.equals(input))
					throw new Exception("id가 존재하지 않습니다.");
				
				System.out.print("pw:");
				input = sc.nextLine();
				
				if(!pw.equals(input))
					throw new Exception("pw가 일치하지 않습니다.");
				
				System.out.print("rpw:");
				input = sc.nextLine();
				
				if(!pw.equals(input))
					throw new Exception("재입력한 pw가 일치하지 않습니다.");
				
				System.out.print("rpw:");
				input = sc.nextLine();
				
				if(!pw.equals(input))
					throw new Exception("재입력한 pw가 일치하지 않습니다.");
				
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("로그인 완료");
	}

}
