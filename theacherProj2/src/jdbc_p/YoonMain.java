package jdbc_p;

public class YoonMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      ExamDAO dao = new ExamDAO();
      
      for(ExamDTO dto :dao.getList())
      {
         System.out.println(dto);
      }
      
     // System.out.println(new ExamDAO().getOne(1));
      
    /*  System.out.println(new ExamDAO().insert(
   new YoonDTO(2,80,90,80,"semi","aaa","2017-04-07")));*/
   }

}