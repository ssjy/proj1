package collection_p;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

class Studcomm
{
   String name,gender;
   int sum,avg,ban,rank=1;
   ArrayList jum = new ArrayList<>();
   
   
   Studcomm(String name, int kor,int eng,int mat,int ban)
   {
      this.name=name;
      this.ban=ban;
      jum.add(kor);
      jum.add(eng);
      jum.add(mat);
      this.gender="여자";
      cal();
   }
   Studcomm(String name, int kor,int eng,int mat,int lol,int ban)
   {
      this(name, kor, eng, mat, ban);
      jum.add(lol);
      this.gender="남자";
      cal();
   }
   
   void cal()
   {
      sum=0;
      
      
      for(Object jj : jum)
      {
         sum += (int)jj;
      }
      
      avg = sum/jum.size();
         
   }
    @Override
    public String toString() {
        String str=  ban + "\t" + name + "\t" + gender + "\t" +jum + "\t";
        
        if(jum.size()==3) str+="\t";
        
        str+= sum + "\t" + avg + "\t" + rank ;
               
        return str;
    }
  
}
class Treecom implements Comparator{
	
	int kind;

	public Treecom(int kind) {
		super();
		this.kind = kind;
	}



	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Studcomm me = (Studcomm)o1;
		Studcomm you = (Studcomm)o2;
		int res =1;
		switch(kind)
		{
			case 3:
			case 1:
					res = me.ban -you.ban;
					if(res!=0) break;
			case 2:
				if(kind!=1)
				{
					res = me.gender.compareTo(you.gender);
					if(res!=0) break;
				}
			case 0:
				res = you.avg - me.avg;
				if(res==0) res =me.name.compareTo(you.name);
				if(res==0) res =1;
			break;
		}
		
		return res;
	}
}

public class TreeSetExamMain {

	static void rank(HashSet set, int kind)
	{
		for(Object o1 : set)
		{
			Studcomm me = (Studcomm)o1;
			me.rank=1;
			for(Object o2 : set)
			{
				Studcomm you = (Studcomm)o2;
						 
				if(you.avg>me.avg)
				{
					if(kind==0)	me.rank++;
					if(kind==1 && me.ban==you.ban)me.rank++;
					if(kind==2 && me.gender.equals(you.gender))me.rank++;
					if(kind==3 && me.gender.equals(you.gender) && me.ban==you.ban)me.rank++;
					
				}

			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int kind =3;
		HashSet set = new HashSet<>();
		TreeSet ttt = new TreeSet(new Treecom(kind));
	      
	      set.add(new Studcomm("aaa",78,98,56,90,1));
	      set.add(new Studcomm("bbb",90,78,86,2));
	      set.add(new Studcomm("fff",58,48,67,2));
	      set.add(new Studcomm("ccc",68,78,96,1));
	      set.add(new Studcomm("ddd",88,48,96,80,2));
	      set.add(new Studcomm("ccc",68,78,95,1));
	      set.add(new Studcomm("ggg",88,48,96,2));
	      set.add(new Studcomm("hhh",78,48,96,76,1));
	      set.add(new Studcomm("lll",48,78,67,2));
	      
	      rank(set, kind);
	      
	      ttt.addAll(set);
	      Iterator it = ttt.iterator();
	      
	      while(it.hasNext())
	      {
	         System.out.println(it.next());  
	      }

	}

}
