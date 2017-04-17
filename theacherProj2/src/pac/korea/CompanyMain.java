package pac.korea;

import pac.taiwan.Battery;
import pac.taiwan.Camera;
import pac.taiwan.Mic;


class NewBattery extends Battery
{
	public NewBattery() {
		// TODO Auto-generated constructor stub
		super("¸ô¶ó", 200);
	}
	
	
	public String gogo() {
		
		return name+"ÅÍÁö°í ¹æ¼öµÅ¿ä";
	}
	
}

class HandPhone
{
	
	public HandPhone(String name, NewBattery bat, Camera cam, Mic mic) {
		super();
		this.name = name;
		this.bat = bat;
		this.cam = cam;
		this.mic = mic;
	}
	String name;
	NewBattery bat;
	Camera cam;
	Mic mic;
	
	void tel()
	{
		System.out.println(name+mic.name+"ÀüÈ­ ÇØ¿ä");
	}
	
	void photo()
	{
		System.out.println(name+cam.takePicture());
	}
	void bomb()
	{
		System.out.println(name+bat.gogo());
	}
	
	
}
class Company
{
	String name;
	
	
	
	public Company(String name) {
		super();
		this.name = name;
	}



	HandPhone makePhone(String name, NewBattery bat, Camera cam, Mic mic)
	{
		HandPhone ret = new HandPhone(name, bat, cam, mic);
		
		return ret;
	}
}

public class CompanyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company com = new Company("½Ó½ö");
		
		HandPhone gall = com.makePhone(
				"°¶·°½Ã",
				new NewBattery(),
				new Camera("±¤ÇÐ", 600000),
				new Mic("¹«¼±")
				);
		
		gall.tel();
		gall.photo();
		gall.bomb();
	}

}
