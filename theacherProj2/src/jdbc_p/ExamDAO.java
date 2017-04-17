package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO {

	Connection con = null;
	Statement stmt =null;
	ResultSet rs = null;
	
	String url ="localhost:1521:orcl";
	String id = "hr";
	String pw = "hr";
	String sql = null;
	
	public ExamDAO() {
		// TODO Auto-generated constructor stub
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+url,id,pw );
			con.setAutoCommit(true);
			stmt = con.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	List<ExamDTO> getList()
	{
		List<ExamDTO> res = new ArrayList<>();
		try {
			sql = "select * from exam";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				ExamDTO dto = new ExamDTO();
				
				dto.setSid(rs.getString("sid"));
				
				dto.setTitle(rs.getString("title"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setNo(rs.getInt("no"));
				
				dto.setRegDate(rs.getDate("regdate"));
				
				
				
				res.add(dto);
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			close();
		}
		
		return res;
	}
	
	
	
	ExamDTO getOne(String id)
	{
		ExamDTO dto = null;
		try {
			sql = "select * from stud where id='"+id+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				dto = new ExamDTO();
				
				dto.setSid(rs.getString("sid"));
				
				dto.setTitle(rs.getString("title"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setNo(rs.getInt("no"));
				
				dto.setRegDate(rs.getDate("regdate"));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return dto;
	}
	
	
	int insert(ExamDTO dto)
	{
		int res =0;
		try {
		sql = "insert into exam "
	+ "(no, title,  sid, kor, eng,mat, regdate) "+
"values ("+
dto.getNo()+",'"+
dto.getTitle()+"','"+
dto.getSid()+"',"+
dto.getKor()+","+
dto.getEng()+","+
dto.getMat()+",'"+
new SimpleDateFormat("yyyy-MM-dd").format(dto.getRegDate())+"')";
		
		System.out.println(sql);
		res = stmt.executeUpdate(sql);
		
		//con.commit();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	
	
	void close(){
			
		if(rs!=null) try {rs.close();} catch (SQLException e) {}
		if(stmt!=null) try {stmt.close();} catch (SQLException e) {}	
		if(con!=null) try {con.close();} catch (SQLException e) {}

	}
}
