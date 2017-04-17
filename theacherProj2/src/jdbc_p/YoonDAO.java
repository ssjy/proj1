/*package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class YoonDAO {

   Connection con = null;
   Statement stmt =null;
   ResultSet rs = null;
   
   String url ="localhost:1521:orcl";
   String id = "hr";
   String pw = "hr";
   String sql = null;
   
   public YoonDAO() {
      // TODO Auto-generated constructor stub
      
      try {
         con = DriverManager.getConnection("jdbc:oracle:thin:@"+url,id,pw );
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
            
            dto.setNo(rs.getInt("no"));
            dto.setSid(rs.getString("sid"));
            dto.setKor(rs.getInt("kor"));
            dto.setEng(rs.getInt("eng"));
            dto.setMat(rs.getInt("mat"));
            dto.setTitle(rs.getString("title"));
           // dto.setRegDate(rs.getDate("regDate"));
            
            
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
   
   
   
   ExamDTO getOne(Integer no)
   {
      ExamDTO res = null;
      try {
         sql = "select * from exam where no='"+no+"'";
         rs = stmt.executeQuery(sql);
         if(rs.next())
         {
            res = new ExamDTO();
            
            res.setNo(rs.getInt("no"));
            res.setSid(rs.getString("sid"));
            res.setKor(rs.getInt("kor"));
            res.setEng(rs.getInt("eng"));
            res.setMat(rs.getInt("mat"));
            res.setTitle(rs.getString("title"));
            res.setRegDate(rs.getDate("regDate"));
            
         }
         
         
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         close();
      }
      
      return res;
   }
   
   
   int insert(ExamDTO dto)
   {
      int res =0;
      
      sql = "insert into exam "
   + "(no, title, sid, kor, eng, mat, regdate)"+
      "values ("+
      dto.getNo()+",'"+
      dto.getTitle()+"','"+
      dto.getSid()+"',"+
      dto.getKor()+","+
      dto.getEng()+","+
      dto.getMat()+",'"+
      new SimpleDateFormat("yyyy-MM-dd").format(dto.getRegDate())+"')";
      
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

}*/