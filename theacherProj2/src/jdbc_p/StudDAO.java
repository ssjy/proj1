package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudDAO {

	Connection con = null;
	Statement stmt =null;
	ResultSet rs = null;
	
	String url ="localhost:1521:orcl";
	String id = "hr";
	String pw = "hr";
	String sql = null;
	
	public StudDAO() {
		// TODO Auto-generated constructor stub
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+url,id,pw );
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	List<StudDTO> getList()
	{
		List<StudDTO> res = new ArrayList<>();
		try {
			sql = "select * from stud";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				StudDTO dto = new StudDTO();
				
				dto.setId(rs.getString("id"));
				
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getDate("birth"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setGrade(rs.getInt("grade"));
				
				
				res.add(dto);
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return res;
	}
	
	
	
	StudDTO getOne(String id)
	{
		StudDTO res = null;
		try {
			sql = "select * from stud where id='"+id+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				res = new StudDTO();
				
				res.setId(rs.getString("id"));
				
				res.setName(rs.getString("name"));
				res.setBirth(rs.getDate("birth"));
				res.setTel(rs.getString("tel"));
				res.setEmail(rs.getString("email"));
				res.setRegdate(rs.getTimestamp("regdate"));
				res.setGrade(rs.getInt("grade"));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return res;
	}
	
	
	int insert(StudDTO dto)
	{
		int res =0;
		
		sql = "insert into stud "
	+ "(id, name, birth, tel, email, regdate, grade) "+
"values ('"+
dto.getId()+"','"+
dto.getName()+"','"+
new SimpleDateFormat("yyyy-MM-dd").format(dto.getBirth())+"','"+
dto.getTel()+"','"+
dto.getEmail()+"','"+
new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dto.getRegdate())+"',"+
dto.getGrade()+")";
		
		System.out.println(sql);
		try {
			res = stmt.executeUpdate(sql);
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
