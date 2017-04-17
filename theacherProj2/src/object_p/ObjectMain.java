package object_p;

class ObjAAA{
	
	public ObjAAA() {
		// TODO Auto-generated constructor stub
		super();
	}
}

class ObjBBB{
	int a;
	String b ="윤성문은 연예인";
	
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
		final int prime = 31; //final-변경불가, 오버라이딩금지 멤버변수로 생성자에서만 변경가능
		int result = 1;
		result = prime * result + a;
		result = prime * result + ((b == null) ? 0 : b.hashCode()); // 삼항연산자 (조건?참:거짓)
		// b변수의 값이 널이면 0 아니면 b변수 메모리의 주소값
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
		
		Object oo = oa; //oa오브젝트를 oo에 대입
		
		System.out.println("oa:"+oa); //oa의 주소값
		System.out.println("oo:"+oo); //oo와 oa의 주소값이 동일
		System.out.println("oa2:"+oa2); //oa2의 주소값은 다름
		
		System.out.println(oa.getClass()); //어느 클래스에서 작동되는지를 알려줌 ObjAAA에서 됨
		System.out.println(oo.getClass()); // ObjAAA에서 됨
		System.out.println(oa.hashCode()); // oa의 메모리의 주소값
		System.out.println(oo.hashCode()); // oo와 oa의 메모리의 주소값이 같다
		System.out.println(oa2.hashCode()); // oa2의 주소값 다름
		
		System.out.println(oa instanceof Object); //oa를 Object로 형변한이 가능한가? true
		
		System.out.println(oa==oa2); // false 
		
		System.out.println("===========================");
		
		ObjBBB ob1 = new ObjBBB();
		ObjBBB ob2 = new ObjBBB();
		ObjBBB ob3 = new ObjBBB();
		ObjBBB ob11 = ob1; // ob1의 객체 대입
		
		
		ob1.a =10;
		ob2.a =1000;
		ob3.a =10;
		ObjBBB ob12 = (ObjBBB)ob1.clone(); // ob1의 복제객체를 ob12에 대입
		
		System.out.println(ob1.hashCode()); //ob1의 메모리주소값
		System.out.println(ob2.hashCode()); //ob2의 메모리주소값
		System.out.println(ob3.hashCode()); // ob3은 ob1의 메모리주소값과 같다
		System.out.println(ob11.hashCode()); // ob11(대입)은 ob1의 메모리주소값과 같다
		System.out.println(ob12.hashCode()); // ob12(복제)는 ob1의 메모리주소값과 같다
		
		System.out.println(ob1==ob2); // false - 메모리주소값부터 다름 
		System.out.println(ob1==ob3); // false - 메모리 주소값이 같지만 같지않다????
		System.out.println(ob1==ob11); // (대입)true  
		System.out.println(ob1==ob12); // (복제)false
		
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
	
	
	////// 오늘 판매한 커피를 종류별 갯수로 출력하세요
	/// 커피 종류 : 아메리카노, 아프리카노, 아시아노, 러시아노, 오세아니아노
	
	// 주문은 클래스 : 아메리카노 1, 아프리카노 2, 아메리카노 1, 러시아노 3, 아프리카노 1
	
	/// 오늘 판매 : 아메리카노 2, 아프리카노 3, 러시아노 3

}
