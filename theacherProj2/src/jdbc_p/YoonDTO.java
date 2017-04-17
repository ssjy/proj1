package jdbc_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YoonDTO {

   Integer no,kor,eng,mat;
   String title, sid;
   Date regDate;
   public YoonDTO(Integer no, Integer kor, Integer eng, Integer mat, String title, String sid, String regDate) {
      super();
      this.no = no;
      this.kor = kor;
      this.eng = eng;
      this.mat = mat;
      this.title = title;
      this.sid = sid;
      try {
         this.regDate = new SimpleDateFormat("yyyy-MM-dd").parse(regDate);
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public YoonDTO() {
      // TODO Auto-generated constructor stub
   }
   public Integer getNo() {
      return no;
   }
   public void setNo(Integer no) {
      this.no = no;
   }
   public Integer getKor() {
      return kor;
   }
   public void setKor(Integer kor) {
      this.kor = kor;
   }
   public Integer getEng() {
      return eng;
   }
   public void setEng(Integer eng) {
      this.eng = eng;
   }
   public Integer getMat() {
      return mat;
   }
   public void setMat(Integer mat) {
      this.mat = mat;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getSid() {
      return sid;
   }
   public void setSid(String sid) {
      this.sid = sid;
   }
   public Date getRegDate() {
      return regDate;
   }
   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }
   @Override
   public String toString() {
      return "YoonDTO [no=" + no + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", title=" + title + ", sid="
            + sid + ", regDate=" + regDate + "]";
   }
   
   
   

}