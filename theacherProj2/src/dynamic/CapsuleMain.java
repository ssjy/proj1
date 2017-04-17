package dynamic;

class Capsule
{
	private int abc;
	private boolean ref;
	public int getAbc() {
		return abc;
	}
	public void setAbc(int abc) {
		this.abc = abc;
	}
	public boolean isRef() {
		return ref;
	}
	public void setRef(boolean ref) {
		this.ref = ref;
	}
	
	
	
/*	public void setAbc(int abc)
	{
		this.abc = abc;
	}
	
	public int getAbc()
	{
		return abc;
	}
	
	public void setRef(boolean ref)
	{
		this.ref = ref;
	}
	
	public boolean isRef()
	{
		return ref;
	}*/
}


class Exam
{
	private double [] rate = {0.5,0.3,0.2};
	
	private int [] jum;
	
	private String name;
	
	private int res;
	
	private String grade;

	public Exam(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.jum = new int[]{kor, eng,  mat};
		
	}
	
	private void cal()
	{
		res = 0;
		
		for (int i = 0; i < jum.length; i++) {
			res += jum[i]* rate[i];
		}
		
		grade = new String []{
				"가","가","가","가","가","가",
				"양","미","우","수","수"
		}[res/10];
	}
	
	void print()
	{
		cal();
		String str = name +"\t";
		for(int jj : jum)
		{str+=jj+"\t";}
		
		str += res+"\t"+grade;
		
		System.out.println(str);
	}

	public int getJum(int no) {
		return jum[no];
	}
	
	
	
	
}


public class CapsuleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Capsule cap = new Capsule();
		//cap.abc = 100;
		//System.out.println(cap.abc);
		cap.setAbc(100);
		System.out.println(cap.getAbc());
		
		Exam ex = new Exam("추주헌", 91,100,93);
		
		ex.print();
		
		System.out.println(ex.getJum(0));
		
		//ex.getJum(0) = 67;
		//ex.getJum()[0] = 67;
		ex.print();
	}

}








