package io_p;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

class Stud implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String name, grade;
	ArrayList<Integer>jum = new ArrayList<>();
	int sum, avg, rank;
	/**
	 * @param name
	 * @param jum
	 */
	public Stud(String name, int kor, int eng, int mat) {
		this.name = name;
		jum.add(kor);
		jum.add(eng);
		jum.add(mat);
		
		cal();
	}
	
	void cal()
	{
		sum = 0;
		for(int jj : jum)
		{
			sum+= jj;
		}
		
		avg = sum/jum.size();
		
		grade = "°¡°¡°¡°¡°¡°¡¾ç¹Ì¿ì¼ö¼ö".charAt(avg/10)+""; 
	}

	@Override
	public String toString() {
		return "Stud [name=" + name + ", grade=" + grade + ", jum=" + jum + ", sum=" + sum + ", avg=" + avg + ", rank="
				+ rank + "]";
	}
	
	
	
}

class StudCom implements Comparator<Stud>, Serializable{
	
	private static final long serialVersionUID = 3L;

	@Override
	public int compare(Stud o1, Stud o2) {
		// TODO Auto-generated method stub
		
		int res = o1.rank - o2.rank; 
		
		if(res==0) res = o1.name.compareTo(o2.name);
		
		return res;
	}
	
}
class StudReg implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	TreeSet<Stud>set = new TreeSet<>(new StudCom());
	
	public StudReg(Stud [] arr) {
		// TODO Auto-generated constructor stub
		for(Stud st: arr)
		{
			st.rank=1;
			for(Stud com: arr)
			{
				if(st.avg<com.avg)
					st.rank++;
			}
			set.add(st);
		}
		
	}
	
	void print()
	{
		for(Stud st: set)
		{
			System.out.println(st);
		}
	}
}
public class SerExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudReg reg = new StudReg(new Stud[]{
				new Stud("¼±ÇÑºñ",88 ,87 , 86),
				new Stud("ÁÖ¹ÎÁ¦", 67, 78, 98),
				new Stud("±è°æÈ£", 56, 67, 78),
				new Stud("À±Áö¼·",88 ,87 , 86 ),
				new Stud("Áö½Â¿ì", 67, 78, 98 )
		});
		
		try {
			FileOutputStream fos = 
					new FileOutputStream("fff/eee.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(reg);
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

