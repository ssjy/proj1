package inter;
interface Stud
{
	void study();
	void sleep();
}
interface Joomma
{
	void thst();
	void sleep();
	void eat();
}
interface Daughter
{
	void fight();
	void eat();
	
}

interface Age36Women extends Stud, Joomma, Daughter
{
}

class DaughterImpl implements Daughter
{
	String name;

	public DaughterImpl(String name) {
		super();
		this.name = name;
	}
	
	public void fight() {
		// TODO Auto-generated method stub
		System.out.println(name+" 드루와드루와");
	}
	
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println(name+" 먹어요");
	}
	
	
	
}


class JoommaImpl extends DaughterImpl implements Joomma
{
	

	public JoommaImpl(String name) {
		super(name);
		
	}
	
	public void thst() {
		// TODO Auto-generated method stub
		System.out.println(name+" 확!!!");
	}

	
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println(name+" 잠자요");
	}
	
	
	
}
class StudImpl extends  JoommaImpl
{

	public StudImpl(String name) {
		super(name);
		
	}

	public void study() {
		// TODO Auto-generated method stub
		System.out.println(name+" 공부해요");
	}
	
}
class Age36WoImpl  extends StudImpl  implements Age36Women
{

	public Age36WoImpl(String name) {
		super(name);
		//this.name = name;
	}
	
}

public class SunHanBiMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Age36WoImpl shb = new Age36WoImpl("한비는");
		
		Stud st;
		Joomma jm;
		Daughter dau;
		Age36Women a3w;
		
		System.out.println("구현 클래스----------------------");
		shb.study();
		shb.sleep();
		shb.eat();
		shb.sleep();
		shb.eat();
		shb.thst();
		System.out.println("모듈묶음----------------------");
		a3w =shb;
		a3w.study();
		a3w.sleep();
		a3w.eat();
		a3w.sleep();
		a3w.eat();
		a3w.thst();
		System.out.println("모듈 st----------------------");
		//st = shb;
		st = a3w;
		st.study();
		st.sleep();
		//st.eat();
		System.out.println("모듈 jm----------------------");
		jm = shb;
		jm.sleep();
		jm.eat();
		jm.thst();
		System.out.println("모듈 dau----------------------");
		dau = shb;
		dau.fight();
		dau.eat();
		
		System.out.println("모듈 dau 단독----------------------");
		DaughterImpl ddd = new DaughterImpl("주민제");
		dau = ddd;
		dau.eat();
		
		System.out.println("모듈 jm 단독----------------------");
		JoommaImpl jjj = new JoommaImpl("서주령");
		jm = jjj;
		jm.sleep();
		
	}
	
	///기능
	//// mp3 - 듣기, 멈추기
	/// 카메라 - 찍기, 보기
	/// 전화   - 듣기, 말하기
	/// 핸드폰 - mp3, 카메라, 전화
	
	/// 구현
	///  어른폰 을 만들어 주세요
	
}
