package threeOOPS;

class ZZigae
{
	int water;
	
	String spice;
}

class KimChiZZigae extends ZZigae 
{
	String kimchi;
}

class FishZZigae extends ZZigae 
{
	String fish;
}
public class VIPSMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KimChiZZigae kc = new KimChiZZigae();
		FishZZigae fz = new FishZZigae();
		kc.water = 80;
		kc.spice = "¹Ì¿ø";
		kc.kimchi = "½®±èÄ¡";
		
		fz.water = 80;
		fz.spice = "¹Ì¿ø";
		fz.fish = "°íµî¾î";
		
	}

}
