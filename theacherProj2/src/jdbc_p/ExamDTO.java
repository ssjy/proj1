package jdbc_p;

import java.util.Date;

public class ExamDTO {

	Integer no, kor, eng, mat;
	String title, sid, strDate;
	Date regDate;
	
	
	public ExamDTO()
	{
		
	}
	
	public ExamDTO(Integer no, String title, String sid, Integer kor, Integer eng, Integer mat, Date regDate) {
		this.no = no;
		this.title = title;
		this.sid = sid;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.regDate = regDate;
	}
	
	
	
	public ExamDTO(Integer no, String title, String sid, Integer kor, Integer eng, Integer mat, String strDate) {
		this.no = no;
		this.title = title;
		this.sid = sid;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.strDate = strDate;
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
	
	
	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	@Override
	public String toString() {
		return "ExamDTO [no=" + no + ", title=" + title + ", sid=" + sid + ", kor=" + kor + ", eng=" + eng + ", mat="
				+ mat + ", regDate=" + regDate + "]";
	}
	
	
}
