 package object_p;
class Kanu{
   String name;
   int cnt;
   
   
   public Kanu(String name, int cnt) {
      super();
      this.name = name;
      this.cnt = cnt;
   }

   @Override
   public boolean equals(Object obj) {
      // TODO Auto-generated method stub
      return name.equals(((Kanu)obj).name);
   }

   @Override
   protected Object clone() throws CloneNotSupportedException {
      // TODO Auto-generated method stub
      return new Kanu(name, cnt);
   }
   
   @Override
   public String toString() {
      return "Kanu [name=" + name + ", cnt=" + cnt + "]";
   }
   
   
}
public class KanuMain {

   public static void main(String[] args) throws CloneNotSupportedException {
      // TODO Auto-generated method stub
      Kanu [] arr = {
            new Kanu("�Ƹ޸�ī��", 1),
            new Kanu("������ī��", 2),
            new Kanu("�Ƹ޸�ī��", 1),
            new Kanu("���þƳ�", 3),
            new Kanu("������ī��", 1)
      };
      
      Kanu [] ����õ = new Kanu[0];
      
      for(Kanu kk: arr)                                /// �� �ֹ� ���� ���������� ����
      {
         boolean chk = true; //chk �ʱⰪ true�� �ʱ�ȭ
         
         for(Kanu ����: ����õ) // ����õ ���� ���� ���� -ù������ ũ�Ⱑ �����Ƿ� �ȵ��� if������ �Ѿ
         {
            if(kk.equals(����)) //�ֹ������� ������ ���ٸ�
            {
               ����.cnt+=kk.cnt; //������ ������ �ֹ������� ������ �� ���Ѱ�
               chk=false;      //chk�� false�� ������������ for�� ����
            }
         }
         if(chk)    // chk�� true���
         {
            Kanu [] �ٲ� = new Kanu[����õ.length+1]; // �ٲ��� Ŭ��������(ũ��� ����õ����+1)
            for (int i = 0; i < ����õ.length; i++) {  // ����õ�� ���̸�ŭ ���� -ù��°�� ����õ�� �ȵ� �ι������� ��
               �ٲ�[i] = ����õ[i]; //i�� ������ �°� �ٲ㿡 ����õ�� ����
            }
            �ٲ�[����õ.length]= (Kanu)kk.clone(); //�ٲ�[����õ���̹�°] = �ֹ���������
            ����õ = �ٲ�; // �ٲ��� ���� ����õ ����
         }
      }                                                  /// ������� ù��° for�� ��
      
      for(Kanu ret: ����õ) // ����õ ���� ��ü�� �ϳ��� �̾Ƴ� - ���� ��޴��� �󸶳� �Ǹ��ߴ��� �� �� ����
      {
         System.out.println(ret); 
      }
  	System.out.println("------------------------");
	
	for(Kanu ret: arr) // �ֹ����� ����
	{
		System.out.println(ret);
	}
   }

}