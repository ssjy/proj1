package thread_p;

import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

class MulTimer extends Thread // Ÿ�̸� Ŭ����
{
	MulExamData md;   // �����Ͱ� �� �ִ� Ŭ���� md���� 
	@Override
	public void run() {  //�۵���Ű�� �޼ҵ�
		// TODO Auto-generated method stub
		for (int i = 10; i >0; i--) {  // 10���� 1���� ���� ��
			try {
				
				sleep(1000);            //  1�ʸ��� ��
				
				if(md.chk) break;       // �ʱⰪfalse�� true��� for�� ������  
				System.out.println(i);  // i���
			} catch (InterruptedException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		md.chk=true; //md�� chk���� true ����
		System.out.println("���� ����"); // ���� ���� ���
		md.print(); //md�� ����Ʈ �޼ҵ�� ����
	}
}

class MulExam extends Thread  // ���� Ŭ����
{
	MulExamData md;
	
	@Override
	public void run() {
		
		Iterator<String> it = md.map.keySet().iterator();
		// TODO Auto-generated method stub
		md.cnt=0;
		while(it.hasNext())
		{
			
			String key = it.next();
			if(md.chk) break;
			String input = JOptionPane.showInputDialog(key);
			if(md.chk) break;
			md.solve(key,input);
			
				
			System.out.println("�Է°�:"+input);
		}
		md.chk=true;
	}
}
class MulExamData  //���̱��� ������ Ŭ�� ����
{
	LinkedHashMap<String, String> map = new LinkedHashMap<>(); //������� ���ĵǴ� map�� ���� 
	LinkedHashMap< String,String> ok = new LinkedHashMap<>(); // ������� ���ĵǴ� ok�� ���� 
	LinkedHashMap< String,String> nono = new LinkedHashMap<>();// ������� ���ĵǴ� nono�� ����
	boolean chk = false; //chk �ʱ�ȭ �� false
	int cnt; // cnt ���� ����
	void solve(String key,String input) //�ֺ� �޼ҵ� (���ڰ����� key�� input�� �޴´�)
	{
		if(map.get(key).equals(input)) //map���� Ű�� ���� input�� ���ٸ�
		{
			ok.put(cnt+". "+key, map.get(key)); //ok�ʿ� �߰�(key = cnt+���ڰ�key,value = map�� Ű��)
		}else{                         //map���� Ű ���� input�� �ٸ��ٸ� 
			nono.put(cnt+". "+key, input+"("+map.get(key)+")"); //nono�ʿ� �߰�(key = cnt+���ڰ�key,value = map�� Ű��) 
	  	}
		cnt++; //ī��Ʈ 1�� ���� 
	}
	
	void print() // ����Ʈ �޼ҵ� 
	{
		timeover(); //Ÿ�ӿ��� �޼ҵ�� ���� 
		
		
		System.out.println("����>>>>"); // ���
		printModule(ok);               //����Ʈ��⿡ ok�� ���ڰ����� ����
		System.out.println("����>>>>"); // ���
		printModule(nono);            //����Ʈ����� nono�� ���ڰ����� ����
	}
	void timeover() //Ÿ�ӿ��� �޼ҵ� 
	{
		Iterator<String> it = map.keySet().iterator(); // ��Ʈ���޴�it
		
		for (int i = 0; i <cnt; i++) { //cnt ī��Ʈ�� ������ŭ for�� ����
			it.next(); // it�� ��ü���� ����
		}
		
		while(it.hasNext()) //�������� �ִٸ�
		{
			String key = it.next(); // key�� it�� ��ü ����
			nono.put(cnt+". "+key, "�ð��ʰ�("+map.get(key)+")"); // nono�ʿ� �߰�(key = cnt+key,value = �ð��ʰ�map�� Ű��) 
			cnt++; //ī��Ʈ�� �ø�
		}
		
		
	}
	void printModule(LinkedHashMap< String,String> map) //����Ʈ��� �޼ҵ�(���� ���ڰ����� �޴´�)
	{
		Iterator it = map.entrySet().iterator(); // ���ͷ����ͷ� ��ü�� ���ϰ� �̱� ���� map���� set�������ͷ����ͷ� it�� ���� 
		
		while(it.hasNext()) // �ݺ�(it�� �������� �����Ѵٸ�)
		{
			System.out.println(it.next()); // ���(it�� ���� ��ü�� ���ʴ�� ��µ�)
		}
	}
}

public class ExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MulTimer mm = new MulTimer();
		MulExam me = new MulExam();
		
		MulExamData md = new MulExamData();
		md.map.put("2+3", "5");
		md.map.put("4*5", "20");
		md.map.put("8-5", "3");
		md.map.put("15/3", "5");
		md.map.put("9%4", "1");
		
		mm.md = md;
		me.md = md;
		
		mm.start();
		me.start();
	}

}
