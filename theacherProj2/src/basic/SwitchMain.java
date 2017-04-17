package basic;

public class SwitchMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str;//="뭐라도 써야돼";
		switch(300)
		{
			case 8:
				System.out.println("내가 8이여");
				str = "8888";
				break;
			case 20:
				System.out.println("내가 20이여");
				str="2020";
				break;
			
			case 10:
			case 14:
			case 17:
			case 27:
				System.out.println("내가 10이여");
				System.out.println("내가 10이랑께");
				System.out.println("내가 10이여라");
				str = "1010";
				break;
			case 100:
				System.out.println("내가 100이여");
				str="10000000";
				break;
			default:
				System.out.println("내가 기본이여");
				str="기본기본";
				break;
				
		}
		System.out.println(str);
		System.out.println("SwitchMain 종료");
	}

}
