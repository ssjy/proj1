package pac.taiwan;

public class Camera {

	private String name;
	private int pixel;
	
	
	
	public Camera(String name, int pixel) {
		super();
		this.name = name;
		this.pixel = pixel;
	}



	public String takePicture()
	{
		return name+" 사진을 찍어요";
	}
}
