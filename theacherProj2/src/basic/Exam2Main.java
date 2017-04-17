package basic;

public class Exam2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int kor=88, eng = 87, mat = 87;
		int sum = kor+eng+mat;
		//double avg = (double)sum/3;
		int jari = 10000;
		double avg = (double)(int)((double)sum/3 *jari+0.5)/jari;
		
		/*double res1 = avg*100;
		int res2 = (int)res1;
		double res3 = (double)res2/100;*/
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
		System.out.println(sum);
		System.out.println(avg);
		/*System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);*/
		
		System.out.println();
		/*System.out.println(sum/3);
		System.out.println(262/3);
		System.out.println(262.0/3);
		System.out.println(sum);
		System.out.println((double)sum);
		System.out.println((int)262.33333);*/
		
	}

}
