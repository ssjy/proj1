package arr;

public class Array2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] jum = {88,87,76,56,90,78};
		String [] grade = {"가","가","가","가","가","가",
				"양","미","우","수","수"};
		int sum =0;
		
		for (int i = 0; i < jum.length; i++) {
			sum+=jum[i];
		}
		
		int avg = sum/jum.length;
		/*sum = jum[0]+jum[1]+jum[2];
		
		int avg = sum/3;*/
		
		System.out.println(sum);
		System.out.println(avg);
		System.out.println(grade[avg/10]);
	}

}
