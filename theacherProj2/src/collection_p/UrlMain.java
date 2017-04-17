package collection_p;

import java.util.Stack;

class Url{
	String now=null;
	
	Stack back = new Stack(); //back �̶�� ���ο� ���� ����
	Stack next = new Stack(); //next �̶�� ���ο� ���� ����
	
	void goUrl(String url) //�Ű����� url����
	{
		System.out.println("--------goUrl("+url+")");
		
		next.clear(); //�պκ� null�� ������
		
		if(now!=null)  //now�� ���� null�� �ƴ϶�� 
			back.push(now); // �鿡 �ִ� vow�� ���
		
		now =url; // ����� url�� ����
		
		print();
	}
	
	void goBack()
	{
		System.out.println("--------goBack()");
		
		if(!back.isEmpty()) // back�� ���� ���̾ƴ϶��
		{
			next.push(now); // ������.now
			
			now = (String)back.pop();// ����=��.����
			print();
		}
		else{
			System.out.println("�ڰ� �����");
		}
		
		
	}
	
	void goNext()
	{
		System.out.println("--------goNext()");
		
		if(!next.isEmpty()) // ������ ��������ʴٸ�
		{
			back.push(now); //��. ���(����)
			
			now = (String)next.pop(); //����= ����.����
			print();
		}
		else{
			System.out.println("���� �����");
		}	
	}
	
	void print()
	{
		System.out.println("����:"+now);
		System.out.println("�ڷ�:"+back);
		System.out.println("������:"+next);
	}
}
public class UrlMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Url uu = new Url();
		uu.goUrl("������");
		uu.goUrl("���׷�");
		uu.goUrl("����");
		uu.goUrl("�ٿ�");
		
		uu.goBack();
		uu.goBack();
		uu.goBack();
		uu.goBack();
		uu.goBack();
		
		uu.goNext();
		uu.goUrl("����");
	}

}
