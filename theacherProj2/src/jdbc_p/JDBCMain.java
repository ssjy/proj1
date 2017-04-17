package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", 
					"hr", "hr"
					);
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from stud");
			
			while(rs.next())
			{
				System.out.print(rs.getString("id"));
				System.out.print(rs.getString("name"));
				System.out.print(rs.getDate("birth"));
				System.out.print(rs.getString("tel"));
				System.out.print(rs.getString("email"));
				System.out.print(rs.getTimestamp("regdate"));
				System.out.println(rs.getInt("grade"));
			}
			
			
			
			rs.close();
			stmt.close();
			con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
