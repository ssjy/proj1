package collection_p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class TTStud                                                 // Ŭ���� ����
{
	String name, res;                                         //������� �̸�,���
	LinkedHashMap<String, Integer> jum = new LinkedHashMap(); //�����Ѵ�� ���� ��ũ���ؽø�<key=���ڿ�,value=����>���� ���� ����
	LinkedHashMap<String,String> kind = new LinkedHashMap();  //<key=���ڿ�,value=���ڿ�>�� kind �� ����
	int sum, avg, rank, num;                                  //�հ�,���,����,��ȣ
	
	TTStud(String ban, int num,String name, int kor,int eng, int mat, int lol) // ������ 
	{
		this(ban, num, name, kor, eng, mat);    
		jum.put("��",lol);                             // ������ ����(key=��,value=lol����)
		kind.put("��", "����");                         // ������ ����(key=��,value=����)
		
		cal();                                      //���޼ҵ�� ����
	}
	
	TTStud(String ban,int num, String name, int kor,int eng, int mat) //������ �������̵�
	{
		this.num = num;                             
		this.name = name;
		jum.put("����",kor);                          //������ ���� (key=����,value=kor ����)
		jum.put("����",eng);                          //������ ���� (key=����,value=eng ����)
		jum.put("����",mat);                          //������ ���� (key=����,value=mat ����)
		kind.put("��", ban);                         // ������ ����(key=��,value=ban�̸�)
		kind.put("��", "����");                       // ������ ����(key=��,value=����)
		kind.put("��ü", "��ü");                      // ������ ����(key=��ü,value=��ü)
		
		cal();                                       //���޼ҵ�� ����
	}
	
	void cal()                                       // ��� �޼ҵ�
	{
		sum =0;                                      // �հ��� �ʱ�ȭ 0
		
		Collection<Integer> vv = jum.values();        //�ݷ���(����)<����> vv = ������ values
		
		for (Integer oo : vv) {                       //Ȯ������� vv�� �ϳ��ϳ��� ��ü�� oo�� �Ѵ�
			sum += oo;                                //�հ�+=oo�� ���Ѱ�(���ڸ� ��,��,��,�� 4���� ���Ѱ�/���ڸ� ��,��,�� 3���� ���Ѱ�)
		}
		
		avg = sum/jum.size();                          //��� = �հ�/������ ������(�迭�϶� ������ ���̿� ����)
		
		res = "���հ�";                                 //����� �ʱ�ȭ = ���հ�
		if(avg>=70) res="�հ�";                         //����� 70�� ���ų� ũ�ٸ� ���=�հ�
	}

	@Override
	public String toString() {                         // ��� �޼ҵ�
		return  kind.get("��") + "\t" + name + "\t" + num + "\t" + kind.get("��") + "\t" + jum
				+ "\t" + sum + "\t" + avg + "\t" + rank;
	}
	
	
}

class TTStCom implements Comparator{  //���ڸ� �������̽��� �޴� Ŭ���� ���� 
	Object kind;                      // ��ü kind(����)����

	public TTStCom(Object kind) {     //������ (�μ��� ���� ��ü�� �޴� ������) 
		super();                      //�θ�Ŭ���� ���
		this.kind = kind;
	}

	@Override
	public int compare(Object o1, Object o2) {   //(�μ��� ��ü o1�� o2�� �޴� �񱳸޼ҵ� )
		// TODO Auto-generated method stub
		HashMap str = new HashMap<>();            //������ �����ʴ� �ؽø� str����
		str.put("��", "������, �ҳ���, �߳���, ������");  //str�� ����(key=��,value=��,��,��,��)
		str.put("��", "����, ����");                 //str�� ����(key=��,value=����,����)
		str.put("��ü", "��ü");                    //str�� ����(key=��ü,value=��ü)
		
		int res=1;                            //��� �ʱ�ȭ 1 
		
		if(kind instanceof String)            //������ ��Ʈ������ ��ȯ���ɿ��ΰ� true��� 
		{
	
			res = ((String)str.get(kind)).indexOf(((String)o1))-  //���= ��Ʈ������ ����ȯ�� str�� ����.��ü1(��)�� ���� - 
			((String)str.get(kind)).indexOf(((String)o2));         // ��Ʈ������ ����ȯ�� str�� ����.��ü2(��)�� ���� - 
	
		}else{                                //��Ʈ�� ��ȯ�� �ȵǴ� ��� faulse��� 
			TTStud me = (TTStud)o1;           // Ŭ���� �� = Ŭ���� ����ȯ ��ü o1
			TTStud you = (TTStud)o2;          // Ŭ���� �� = Ŭ������ ����ȯ�� ��ü o2
			
			res = you.avg-me.avg;              // ����� �������-���� ��� (��������)
			if(res==0) res = me.num - you.num; // ������� 0�̶�� ����� ���� ��ȣ-���� ��ȣ(��������) 
		}
		
		return res; //������� �����Ѵ�
	}
}

public class TreeMapExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TTStud> input = new ArrayList();                 //Ŭ�����ڷ���?�� �޴� ����Ʈ ���� 
		
		input.add(new TTStud("�ҳ���",2,"������",88,89,87,74 ));   //����Ʈinput�� ���� (Ŭ���� ������(��))
		input.add(new TTStud("������",3,"���ȣ",78,87,65,54 ));
		input.add(new TTStud("�ҳ���",1,"�ֹ���", 43,32,21 ));
		input.add(new TTStud("������",2,"���Ѻ�",34,56,78 ));
		input.add(new TTStud("������",2,"������", 89,90,98));
		input.add(new TTStud("������",2,"����ȫ", 87,76,65,54));
		input.add(new TTStud("������",5,"������",89,90,98));
		input.add(new TTStud("�ҳ���",2,"������", 12,23,34,45));
		
		Scanner sc = new Scanner(System.in);  //��ĳ�� ���
		
		String [] kind = {"��ü","��","��","��,��"};  //�����迭 ����  ��ü,��,��,����
		
		for (int i = 0; i < kind.length; i++) {   //������ ���̸�ŭ ���� ����
			System.out.print(i+","+kind[i]+" ");  //��ü , ��ü�� ���� /�� ,  ���� ���� ...
		}
		System.out.print("\n�Է�:");  // �Է� ���
		
		int no = sc.nextInt();  // ��ȣ�� �Է��ϸ� �����ٷ� �Ѿ
		
		String [] arr = kind[no].split(","); //������ ��ȣ.,�� �������� ���� ��, ���϶� ��,��,��,���� ����

		TreeMap total = new TreeMap(new TTStCom(arr[0]));  // ������ ������ ������ ��Ż ���� (��Ŭ���� �������� �迭�� 0��°)
		
		for(TTStud ts : input)                                 // Ȯ������� ����Ʈ�� ����
		{
			TreeMap nowMap = total;                            // ���ĵǴ� ������ nowMap�� ��Ż(��Ŭ����)�� ����
			//TTStud ts = (TTStud)oo;

			for (int i = 0; i < arr.length-1; i++) {                 //������ ���Ұ��� �A�͵��� ����-1��ŭ ���� ����
				if(nowMap.containsKey(ts.kind.get(arr[i])))             //nowMap�� Ű������ input�� �ִ� �ϳ��� ��ü�� �������� �迭�� ���°(��������)�� �ִٸ� 
					nowMap = (TreeMap)nowMap.get(ts.kind.get(arr[i]));  //nowMap=���İ����� Ʈ�������� ����ȯ�� ������� input�� ��ü ������ �迭
				else{
					TreeMap bufMap = new TreeMap(new TTStCom(arr[i+1]));
					nowMap.put(ts.kind.get(arr[i]),bufMap);
					
					nowMap = bufMap;
				}
			}

			TreeSet<TTStud> nowSS;
			
			if(nowMap.containsKey(ts.kind.get(arr[arr.length-1])))
				nowSS = (TreeSet)nowMap.get(ts.kind.get(arr[arr.length-1]));
			else{
				nowSS = new TreeSet(new TTStCom(0));
				nowMap.put(ts.kind.get(arr[arr.length-1]),nowSS);
			}
			
			nowSS.add(ts);
		}
		
		mapPrint(total);
	
	}
	
	static void mapPrint(TreeMap map)
	{
		Iterator it = map.keySet().iterator();

		while(it.hasNext())
		{
			TTStud sum = new TTStud("",999,"�հ�", 0,0,0,0);
			Object key = it.next();
			
			System.out.println(key+">>>>>>");
			
			Object obj = map.get(key);
			if(obj instanceof TreeMap)
				mapPrint((TreeMap)obj);
			else{
				Iterator<TTStud> sit = ((TreeSet)map.get(key)).iterator();
				
				while(sit.hasNext())
				{
					TTStud now = sit.next();
					
					Iterator<String> jit = now.jum.keySet().iterator();
					while(jit.hasNext())
					{
						String jkey = jit.next();
						int jjj = sum.jum.get(jkey)+now.jum.get(jkey);
						sum.jum.put(jkey, jjj);
					}
					
					System.out.println(now);
				}
				System.out.println(sum);
			}			
		}
	}
	

}
