package collection_p;

import java.util.ArrayList;
import java.util.Iterator;

class TV
{
}
class Furniture
{
}
class ACE extends Furniture
{
}
public class GenericMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList ar1 = new ArrayList<>();
		
		ar1.add("침대는 가구다");
		ar1.add(new Furniture());
		ar1.add(new ACE());
		ar1.add(new TV());
		
		ArrayList<Furniture> ar2 = new ArrayList<>();
		
		//ar2.add("침대는 가구다");
		ar2.add(new Furniture());
		ar2.add(new ACE());
		//ar2.add(new TV());
		
		ArrayList<ACE> ar3 = new ArrayList<>();
		
		//ar3.add("침대는 가구다");
		//ar3.add(new Furniture());
		ar3.add(new ACE());
		//ar3.add(new TV());
		
		meth_OO(ar1);
		meth_OO(ar2);
		meth_OO(ar3);
		
		//meth_Fur(ar1);
		meth_Fur(ar2);
		//meth_Fur(ar3);
		
		//meth_ACE(ar1);
		//meth_ACE(ar2);
		meth_ACE(ar3);
		
		//meth_EX(ar1);
		meth_EX(ar2);
		meth_EX(ar3);
		
		Iterator<Furniture> fit;
		
		//fit = ar1.iterator();
		fit = ar2.iterator();
		//fit = ar3.iterator();
		
		while(fit.hasNext())
		{
			Furniture ff = fit.next();
		}
		
		Iterator<ACE> ait;
		
		//ait = ar1.iterator();
		//ait = ar2.iterator();
		ait = ar3.iterator();
		
		while(ait.hasNext())
		{
			Furniture ff = ait.next();
		}
		
		Iterator<? extends Furniture> eit;
		
		eit = ar1.iterator();
		eit = ar2.iterator();
		eit = ar3.iterator();
		
		while(eit.hasNext())
		{
			Furniture ff = eit.next();
		}
		
	}
	
	static void meth_OO(ArrayList ar)
	{
		
	}
	
	static void meth_Fur(ArrayList<Furniture> ar)
	{
		for (Furniture fff: ar) {
			System.out.println(fff);
		}
	}
	
	static void meth_ACE(ArrayList<ACE> ar)
	{
		for (ACE fff: ar) {
			System.out.println(fff);
		}
	}
	
	static void meth_EX(ArrayList<? extends Furniture> ar)
	{
		for (Furniture fff: ar) {
			System.out.println(fff);
		}
	}

}
