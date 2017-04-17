package text_p;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int a = 97;
		System.out.printf("정수: %d, 문자:%c, 실수:%.2f",a,a,123.4564);
		System.out.printf("%s","윤성문은?");
		System.out.println();
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
		System.out.println(df.format(789123.456789)+123);
		
		double dd = (double)df.parse("9876.5432");
		System.out.println(dd+4444);
		
		String [] ppStr = {
				"0","#","00000000","########",
				"###0000000",//"#0#0","0000####",
				".00",".##","0.00","#.##",
				"#,###.#","#,##.#",
				"#.##%","윤성문#.##","#.##죽어",
				"▲##.##;▼#,##"//,"▲;▼"
				//양수        음수
				
		};
		
		double [] ddStr = {1234.56768, -1234.5678,
						987654.43210,-987654.43210,
						.56768,-.56768,
						.43210,-.43210,0};
		
		for(String pp: ppStr)
		{
			System.out.println(pp+">>>>");
			
			df = new DecimalFormat(pp);
			
			for(double ddd: ddStr)
			{
				System.out.println("   "+ddd+":"+df.format(ddd));
			}
			
			
		}
		
//////////이름,국어, 영어, 수학 으로 평균을 계산하여
////80점 이상인 경우 :   ▲평균점수
///      이하인 경우 :   ▼평균점수
		String name = "윤성문";
		int kor = 78, eng=77, mat=76;
		int sum = kor+eng+mat;
		int avg = sum/3;
		
		String res = df.format(avg-80).substring(0,1)+avg;
		
		System.out.println(name);
		/*System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
		System.out.println(sum);
		System.out.println(avg);*/
		System.out.println(res);
		
		
	}

}
