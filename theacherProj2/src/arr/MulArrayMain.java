package arr;

public class MulArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String [][] arr11 = {               //1차원|
				                           //    V
				{"0_0",  "0_1",  "0_2",   "0_3"},//arr11[0]
				{"1_0",  "1_1",  "1_2",   "1_3"},//arr11[1]
				{"2_0",  "2_1",  "2_2",   "2_3"} //arr11[2]
	//2차원 =>arr[?][0],arr[?][1],arr[?][2],arr[?][3]
		};
		
		System.out.println(arr11);
		System.out.println(arr11[0]);
		System.out.println(arr11[0][2]);
		System.out.println(arr11[1]);
		System.out.println(arr11[1][2]);
		
		String [][] arr22 = new String [2][];
		
		
		String [][] arr33;
		
		String [] arr4 = {"추주헌","김진향","윤지섭"};
		
		String [] arr5;
		
		arr33 = new String [][]{
			{"aa0_0",  "aa0_1"},//arr11[0]
			arr4,
			arr5 = new String[]{"aa2_0",  "aa2_1",  "aa2_2",   "aa2_3"},//arr11[2],
			arr11[1] //{"1_0",  "1_1",  "1_2",   "1_3"}의 주소
		};
		
		System.out.println("arr33:"+arr33);
		System.out.println(arr33[0]);
		System.out.println(arr33[0][1]);
		System.out.println(arr33[1]);
		System.out.println(arr33[1][2]);
		System.out.println(arr33[3]);
		System.out.println(arr33[2]);
		System.out.println(arr5);
		
		arr5[1] = "중사님";
		
		System.out.println(arr5[1]);
		System.out.println(arr33[2][1]);
		
		arr33[0] = new String[]{"케로로","기로로","타마마","구루루","도로로"};
		
		System.out.println(arr33[0][1]);
		
		arr11[1] = arr33[0];
		
		String [] arr6 = arr5;
		//arr6 = arr33;
		
		
		arr22[0] = arr33[0];
		
		
		
		System.out.println(arr33.length);
		/*System.out.println(arr33[0].length);
		System.out.println(arr33[1].length);
		System.out.println(arr33[2].length);
		System.out.println(arr33[3].length);*/
		
		for (int i = 0; i < arr33.length; i++) {
			System.out.println("arr33["+i+"]:"+arr33[i].length);
			for (int j = 0; j < arr33[i].length; j++) {
				System.out.print(arr33[i][j]+",");
			}
			System.out.println();
			
		}
		
		
	}

}

