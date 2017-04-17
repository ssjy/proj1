package inter;
////추주헌을 구현하세요
/// 엄마를 만날때 - 밥 줘요, 잔소리좀 
/// 선생님 만날때 - 가르쳐주세요, 잔소리좀
/// 윤성문 만날때 - 사랑합니다, 잔소리좀
interface Mom
{
	String name ="엄마";
	void bab(String name);
	void nagging(String name);
}

interface Instructor
{
	String name ="샘";
	void teaching(String name);
	void nagging(String name);
}

interface Monster
{
	String name ="성문형";
	void love(String name);
	void nagging(String name);
}

class ChuJuHeon implements Mom, Instructor, Monster
{

	@Override
	public void love(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"사랑해요 성문형");
	}

	@Override
	public void teaching(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"가르쳐주세요");
	}

	@Override
	public void bab(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+" 밥줘요");
	}

	@Override
	public void nagging(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"잔소리중");
	}
	
}
public class ChuJuHeonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mom mm;
		Instructor inst;
		Monster mo;
		
		ChuJuHeon cjh = new ChuJuHeon();
		
		mm=cjh;
		mm.bab("맛있는");
		mm.nagging("엄마는 ");
		
		inst =cjh;
		inst.nagging("쌤은 ");
		inst.teaching("인터페이스를 ");
		
		mo = cjh;
		//System.out.println(mo.name);
		mo.love("죽을만큼 ");
		mo.nagging("죽일만큼 ");
	}

}
