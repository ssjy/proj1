package object_p;

class ObjAAA{
	
	public ObjAAA() {
		// TODO Auto-generated constructor stub
		super();
	}
}

class ObjBBB{
	int a;
	String b ="�������� ������";
	
	/*@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return a;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		ObjBBB com = (ObjBBB)obj;
		
		return com.hashCode() == hashCode();
	}*/
	
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ObjBBB ret = new ObjBBB();
		ret.a = a;
		ret.b = b;
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31; //final-����Ұ�, �������̵����� ��������� �����ڿ����� ���氡��
		int result = 1;
		result = prime * result + a;
		result = prime * result + ((b == null) ? 0 : b.hashCode()); // ���׿����� (����?��:����)
		// b������ ���� ���̸� 0 �ƴϸ� b���� �޸��� �ּҰ�
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjBBB other = (ObjBBB) obj;
		if (a != other.a)
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjBBB [a=" + a + ", b=" + b + "]";
	}
	
	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a+","+b;
	}*/
	
}

public class ObjectMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjAAA oa = new ObjAAA();
		ObjAAA oa2 = new ObjAAA();
		
		Object oo = oa; //oa������Ʈ�� oo�� ����
		
		System.out.println("oa:"+oa); //oa�� �ּҰ�
		System.out.println("oo:"+oo); //oo�� oa�� �ּҰ��� ����
		System.out.println("oa2:"+oa2); //oa2�� �ּҰ��� �ٸ�
		
		System.out.println(oa.getClass()); //��� Ŭ�������� �۵��Ǵ����� �˷��� ObjAAA���� ��
		System.out.println(oo.getClass()); // ObjAAA���� ��
		System.out.println(oa.hashCode()); // oa�� �޸��� �ּҰ�
		System.out.println(oo.hashCode()); // oo�� oa�� �޸��� �ּҰ��� ����
		System.out.println(oa2.hashCode()); // oa2�� �ּҰ� �ٸ�
		
		System.out.println(oa instanceof Object); //oa�� Object�� �������� �����Ѱ�? true
		
		System.out.println(oa==oa2); // false 
		
		System.out.println("===========================");
		
		ObjBBB ob1 = new ObjBBB();
		ObjBBB ob2 = new ObjBBB();
		ObjBBB ob3 = new ObjBBB();
		ObjBBB ob11 = ob1; // ob1�� ��ü ����
		
		
		ob1.a =10;
		ob2.a =1000;
		ob3.a =10;
		ObjBBB ob12 = (ObjBBB)ob1.clone(); // ob1�� ������ü�� ob12�� ����
		
		System.out.println(ob1.hashCode()); //ob1�� �޸��ּҰ�
		System.out.println(ob2.hashCode()); //ob2�� �޸��ּҰ�
		System.out.println(ob3.hashCode()); // ob3�� ob1�� �޸��ּҰ��� ����
		System.out.println(ob11.hashCode()); // ob11(����)�� ob1�� �޸��ּҰ��� ����
		System.out.println(ob12.hashCode()); // ob12(����)�� ob1�� �޸��ּҰ��� ����
		
		System.out.println(ob1==ob2); // false - �޸��ּҰ����� �ٸ� 
		System.out.println(ob1==ob3); // false - �޸� �ּҰ��� ������ �����ʴ�????
		System.out.println(ob1==ob11); // (����)true  
		System.out.println(ob1==ob12); // (����)false
		
		System.out.println("------------------------");
		
		System.out.println(ob1.equals(ob2)); // 
		System.out.println(ob1.equals(ob3));
		System.out.println(ob1.equals(ob11));
		System.out.println(ob1.equals(ob12));
		
		System.out.println("------------------------");
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.println(ob3);
		System.out.println(ob11);
		System.out.println(ob12);
		System.out.println("------------------------");
		System.out.println(ob1.toString());
		System.out.println(ob2.toString());
		System.out.println(ob3.toString());
		System.out.println(ob11.toString());
		System.out.println(ob12.toString());
		
	}
	
	
	////// ���� �Ǹ��� Ŀ�Ǹ� ������ ������ ����ϼ���
	/// Ŀ�� ���� : �Ƹ޸�ī��, ������ī��, �ƽþƳ�, ���þƳ�, �����ƴϾƳ�
	
	// �ֹ��� Ŭ���� : �Ƹ޸�ī�� 1, ������ī�� 2, �Ƹ޸�ī�� 1, ���þƳ� 3, ������ī�� 1
	
	/// ���� �Ǹ� : �Ƹ޸�ī�� 2, ������ī�� 3, ���þƳ� 3

}
