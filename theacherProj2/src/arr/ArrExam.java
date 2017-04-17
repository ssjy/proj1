package arr;

public class ArrExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] jum = {88,72,64,91,52};
		
		int [] rank = new int[jum.length];
		for (int me = 0; me < jum.length; me++) {
			rank[me]=1;
			for (int com = 0; com < jum.length; com++) {
				System.out.println(jum[me]+":"+jum[com]);
				if(jum[me]<jum[com])
					rank[me]++;
			}
			System.out.println();
		}
		
		
		for (int i = 0; i < rank.length; i++) {
			System.out.println(jum[i]+":"+rank[i]);
		}
	}

}
