package jdbc_p;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(ExamDTO dto: new ExamDAO().getList())
		{
			System.out.println(dto);
		}
		
		/*new ExamDAO().insert(
		new ExamDTO(300, "final","bbb", 77,77,77,new Date())
				);*/
		
		List<ExamDTO> list = new ArrayList<>();
		
		list.add(new ExamDTO(600, "final","bbb", 77,77,77,"1988-08-08"));
		list.add(new ExamDTO(601, "final","bbb", 77,77,77,"1988-09-09"));
		list.add(new ExamDTO(602, "final","bbb", 77,77,77,"1988-08-08"));
		
		// new ExamDAO().insertList(list);
	}

}
