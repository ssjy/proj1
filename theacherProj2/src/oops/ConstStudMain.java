package oops;

class ConstStud
{
	String name, gender, grade;
	int  sum, avg;
	int [] jum;
	ConstStud(String name, int kor, int eng, int mat, int mil) {
		gender="³²";
		init(name, new int[]{kor, eng,  mat,  mil});
	}
	
	ConstStud(String name, int kor, int eng, int mat) {
		gender="¿©";
		init(name, new int[]{kor, eng,  mat});	
	}

	void init(String name, int [] jum) {
	
		this.name = name;
		this.jum = jum;
		cal();
	}
	
	void cal()
	{
		sum=0;
		for(int jj : jum)
		{
			sum+=jj;
		}
		
		avg = sum/jum.length;
		
		String [] index = {"°¡","°¡","°¡","°¡","°¡","°¡",
				"¾ç","¹Ì","¿ì","¼ö","¼ö"};
		grade=index[avg/10];
	}


	void print()
	{
		String str = name+"\t"+gender+"\t";
		for(int jj : jum)
		{
			str+=jj+"\t";
		}
		if(gender=="¿©") str+="\t";
		
		str+=sum+"\t"+
		avg+"\t"+
		grade;
		
		System.out.println(str);
	}
	
	
}

public class ConstStudMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstStud [] arr = {
				new ConstStud("¿øºó", 88,87 ,87,84 ),
				new ConstStud("Åõºó", 78,76 ,79 ),
				new ConstStud("Çöºó", 91, 87, 66,55),
				new ConstStud("ÀåÈñºó", 91, 84, 74),
				new ConstStud("Ä¿ÇÇºó", 64, 75, 88),
				new ConstStud("¹Ì½ºÅÍºó", 55, 64, 72,81),
				new ConstStud("°ñºó", 84, 86, 23,35),
				new ConstStud("Á©¸®ºó", 45, 76, 41),
				
		};
		
		for(ConstStud  cs: arr )
		{
			cs.print();
		}
	}

}
