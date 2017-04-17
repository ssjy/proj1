package dynamic;
class Hambuger
{
	private final String beef = "한우";

	final String getBeef() {
		return beef;
	}
	
	
}

class ShSh extends Hambuger
{
	String kkh;
	
	/*String getBeef() {
		return kkh;
	}*/
	
	void makeBuger()
	{
		System.out.println(getBeef()+" 슈슈 버거 만들어요");
	}
}
public class HambugerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShSh hb = new ShSh();
		hb.kkh="중국산";
		hb.makeBuger();
		
	}

}
