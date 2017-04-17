package excep;
class ReThrow
{
	void meth_1() throws Exception
	{
			
			try {
				System.out.println("meth_1 시작");
				meth_2();
				System.out.println("meth_1 끝");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("meth_1() 에러처리:"+e.getMessage());
				throw e;
			}
			
			
	}
	
	void meth_2() throws Exception
	{
		try {
			System.out.println("meth_2 시작");
			
			//int a = 10/0;
			throw new Exception("성문 니가 그렇게 싸움을 잘해?");
			//System.out.println("meth_2 끝");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("meth_2() 에러처리:"+e.getMessage());
			throw e;
		}	
	}
	
}
public class ReThrowingMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ReThrow rw = new ReThrow();
		
		
		try {
			rw.meth_1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("main() 에러처리:"+e.getMessage());
			throw e;
		}
	}

}
