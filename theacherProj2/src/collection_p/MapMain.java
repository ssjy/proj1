package collection_p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new HashMap<>();
		
		ArrayList ar =new ArrayList();
		
		map.put(1, "ÃßÁÖÇå");
		map.put("aaa", "¹¹°¡¿ä?");
		map.put(new int[]{123,456},345);
		map.put(ar,"±èÁøÇâ");
		map.put(456.789,new String[]{"À±¼º¹®","¹ÎÁ¤ÈÆ"});
		map.put("aaa", "ÃßÁÖÇå ´©³ª");
		map.put(345, "ÃßÁÖÇå");
		
		System.out.println(map);
		System.out.println(map.get("aaa"));
		System.out.println(map.get(0));
		System.out.println(map.containsKey("dbfef"));
		System.out.println(map.containsKey(1));
		System.out.println(map.containsValue("ÃßÁÖÇå¿©Ä£"));
		System.out.println(map.containsValue("ÃßÁÖÇå"));
		System.out.println(map.size());
		System.out.println(map.hashCode());
		System.out.println(map.isEmpty());
		map.remove(1);
		System.out.println(map);
		
		System.out.println("------------------");
		/*Set ss = map.keySet();
		Iterator it = ss.iterator();*/
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext())
		{
			Object key =it.next();
			System.out.println(key+":"+map.get(key));
		}
		System.out.println("------------------");
		it = map.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry me= (Map.Entry)it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}
		System.out.println("------------------");
		/*Collection vv = map.values();
		it = vv.iterator();*/
		it = map.values().iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		System.out.println(map.get(ar));
		
		System.out.println("--------------------");
		// Å¸ÀÚ¼ø¼­´ë·Î ¾ÈÅ¸ È½¼ö¸¦ ±â·ÏÇÏ¼¼¿ä
		// {23-1,5-1,7-2,11-1,23-h,6-1,2-2,23-1,7-3};
		int [] hh = {23,5,7,11,23,6,2,23,7};
		
		Map pp = new HashMap<>();
		
		for(int h: hh)
		{
			int a=1;
			if(pp.containsKey(h)) 
				a += (int)pp.get(h);
			
			pp.put(h, a);
		}
		
		it = pp.keySet().iterator();
		
		while(it.hasNext())
		{
			Object key = it.next();
			System.out.println(key+":"+grapic(pp.get(key)));
		}	
	}
	static String grapic(Object num)
	{
		String str="¡ß";
		String res="";
		for (int i = 0; i < (int)num; i++) {
			res+=str;
		}
		return res;
	}

}
