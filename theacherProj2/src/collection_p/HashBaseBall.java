package collection_p;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class PlayerCom implements Comparator{ // ���ڸ� �޴� Ŭ���� ����
	
	@Override
	public int compare(Object o1, Object o2) {  // �񱳸޼ҵ� �������̵� (��ü o1,��ü o2)
		// TODO Auto-generated method stub       
		String str ="out,1,2,3,h";         //     str ���� (����)

		return str.indexOf(((String)o1))-     
				str.indexOf(((String)o2));    
		// ������ indexof((��Ʈ��)����ȯ�� ��ü o1)=>���ڰ� ����(0,1,2,3,4) - (��Ʈ��)����ȯ�� o2  
		//==>�ᱹ ���� ������ ��� �� ���ΰ��� �����ִ� �� (������ ����, ������ ������)
	}
}

public class HashBaseBall {

	//out, 1,2,3,h
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr={"23-1","5-1","7-2","23-out","11-1",
				"23-h","6-1","2-2","23-1","7-3","2-2",
				"23-out"};  // ���ȣ ����-�ƿ�,1��Ÿ,2��Ÿ,Ȩ��
		
		//LinkedHashMap player = new LinkedHashMap();
		TreeMap player = new TreeMap(); // Ʈ���� ����� ���� (Ʈ������ ����)
		
		for(String str: arr)
		{
			//String pp = str.substring(0,str.indexOf("-"));
			
			int pp = 
			Integer.parseInt(str.substring(0,str.indexOf("-"))); //pp= ���ȣ ����
			String hit = str.substring(str.indexOf("-")+1); // hit = ��Ʈ����
			
			//HashMap nowPP;
			TreeMap nowPP; // Ʈ���� ����
			
			if(player.containsKey(pp))   // �÷��̾� Ʈ���� �ȿ� pp��� Ű���� �ִٸ�
				nowPP = (TreeMap)player.get(pp);  // nowPP�� �÷��̾ pp��(���ȣ)�� ����
			else                                   // ���ٸ�
				nowPP = new TreeMap(new PlayerCom()); // nowPP�� ���ο� Ʈ����(�� Ŭ���� ������)����
			
			player.put(pp, nowPP); //�÷��̾ key�� pp(���ȣ), value�� nowPP=>Ʈ����(Ű-Ȩ,�ƿ�/ ���- � �ƴ���) 
			
			int a = 1;	// ��ŸȽ�� 
			if (nowPP.containsKey(hit))	// key ���� �����. key���� �ִٸ�, ��!Ȩ,1,2,3 �ƿ��� ���� �ִٸ�
				a += (int) nowPP.get(hit);	//Object value = map.get(key); key �� ���� value ���� ������ �´�.
			   // ��Ÿ�� nowPP���� ������ ��Ʈ ���� ���Ѱ��� ���� 

			nowPP.put(hit, a); // nowPP��  key ���� ����,a�� Ƚ��
			
		}
		Iterator it = player.keySet().iterator(); // ���ͷ����� it =  �÷��̾ Ű������ ���ͷ�����
		
		while(it.hasNext()) // ���� ���� �ִٸ� �ݺ�
		{
			Object key = it.next();  //Ű = ���� �� ����
			System.out.println(key+">>>"); // ���ȣ >>>
			
			TreeMap ppp = (TreeMap)player.get(key); // (����ȯ)��Ʈ�� Ű��
			
			Iterator pit = ppp.keySet().iterator();  // 
			
			while(pit.hasNext())
			{
				Object kkey = pit.next(); // nowPP�� Ű���� ���Ÿ���� ����
				System.out.println("\t"+kkey+":"+ppp.get(kkey));
			}	//                       ���� : ������ ��� �ƴ���
			
		}	
		
		
	}

}
