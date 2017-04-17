package jdbc_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudDTO {

	String id, name, tel,email;
	Integer grade;
	Date birth, regdate;
	
	
	
	
	public StudDTO(String id, String name, String tel, String email, Integer grade, String birth, String regdate) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.grade = grade;
		try {
			this.birth = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
			this.regdate =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(regdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public StudDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "StudDTO [id=" + id + ", name=" + name + ", tel=" + tel + ", email=" + email + ", grade=" + grade
				+ ", birth=" + birth + ", regdate=" + regdate + "]";
	}
	
	
}
