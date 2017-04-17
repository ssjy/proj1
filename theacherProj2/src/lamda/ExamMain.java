package lamda;

import java.util.Arrays;

class Stud{
	String name;
	int [] jum;
	int sum, avg;
	public Stud(String name, int kor, int eng, int mat) {
		this.name = name;
		this.jum = new int[]{kor, eng,  mat};
		this.sum = 0;
		
		for(int jj:jum)
		{
			sum+= jj;
		}
		
		this.avg = sum/jum.length;
	}
	@Override
	public String toString() {
		return "Stud [name=" + name + ", jum=" + Arrays.toString(jum) + ", sum=" + sum + ", avg=" + avg + "]";
	}
	
	
}
public class ExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stud [] arr = {
				new Stud("¼±ÇÑºñ",77,78,76),
				new Stud("ÀÓÁ¾Ãµ",67,68,69),
				new Stud("À±¼º¹®",88,89,77),
				new Stud("¼ÛÁ¤À±",98,97,99),
				new Stud("ÃßÁÖÇå",56,55,54)
		};
		
		Arrays.sort(arr,(o1, o2)->((Stud) o2).avg-((Stud) o1).avg);
		
		for(Stud st: arr)
			System.out.println(st);
	}

}
