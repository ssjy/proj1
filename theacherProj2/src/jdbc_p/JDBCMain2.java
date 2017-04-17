package jdbc_p;

public class JDBCMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudDAO dao = new StudDAO();
		
		for(StudDTO dto :dao.getList())
		{
			System.out.println(dto);
		}
		
		System.out.println(new StudDAO().getOne("bbb"));
		
		System.out.println(new StudDAO().insert(
	new StudDTO("ert","Ω√πŒ¡¶","010-1234-4567","aaa@aa.com",1,"1979-08-09","2017-04-07 15:20:30")));
	}

}
