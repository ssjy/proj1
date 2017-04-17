package threeOOPS;

class ParCar {
	String name;
	int sum, rank, sort;
	int[] jum;
	int kind;
	
	void init(String name, int[] jum) {
		this.name = name;
		sum = 0;

		this.jum = jum;

	}

	

	void print() {
		String[] index = { "½ºÆ÷Ã÷Ä«", "½ÂÇÕÂ÷", "Æ®·°" };
		String str = index[kind] + "\t" + name + "\t";
		for (int jj : jum) {
			str += jj + "\t";
		}
		if (kind != 1)
			str += "\t";

		str += sum + "\t";
		/*if (kind != 1)
			str += "\t";*/
		str += rank;

		System.out.println(str);
	}

	int rSum() {
		return sum;
	}
	
	

}

class SCar extends ParCar {

	double[] rate = { 0.6, 0.4 };

	SCar(String car_name, int speed, int fuel) {
		kind = 0;
		init(car_name, new int[] { speed, fuel });
		for (int i = 0; i < rate.length; i++) {
			sum += jum[i] * rate[i];
		}
		
		//print();
	}
	
	CarData[] addArray(CarData[] arr, int cnt)
	{
		CarData[] buf = new CarData[arr.length+1];
		
		for (int j = 0; j < arr.length; j++) {
			buf[j]=arr[j];
		}
		
		
		buf[arr.length]=new CarData();
		buf[arr.length].name="s";
		buf[arr.length].sum = sum;
		buf[arr.length].index = cnt;
		
		return buf;
	}

}

class VCar extends ParCar {

	double[] rate = { 0.3, 0.7 };

	VCar(String car_name, int speed, int fuel, int safe) {
		kind = 1;
		init(car_name, new int[] { speed, fuel, safe });
		for (int i = 0; i < rate.length; i++) {
			sum += jum[i] * rate[i];
		}
		
		//print();
	}
	
	CarData[] addArray(CarData[] arr, int cnt)
	{
		CarData[] buf = new CarData[arr.length+1];
		
		for (int j = 0; j < arr.length; j++) {
			buf[j]=arr[j];
		}
		
		
		buf[arr.length]=new CarData();
		buf[arr.length].name="v";
		buf[arr.length].sum = sum;
		buf[arr.length].index = cnt;
		
		return buf;
	}

}

class TCar extends ParCar {

	double[] rate = { 0.5, 0.5 };

	TCar(String car_name, int speed, double fuel) {
		kind = 2;
		init(car_name, new int[] { speed, (int) fuel });
		for (int i = 0; i < rate.length; i++) {
			sum += jum[i] * rate[i];
		}
		
		//print();

	}
	
	CarData[] addArray(CarData[] arr, int cnt)
	{
		CarData[] buf = new CarData[arr.length+1];
		
		for (int j = 0; j < arr.length; j++) {
			buf[j]=arr[j];
		}
		
		buf[arr.length]=new CarData();
		buf[arr.length].name="t";
		buf[arr.length].sum = sum;
		buf[arr.length].index = cnt;
		
		return buf;
	}

}




class CarLogic{
	
	CarData[] arr;
	SCar[] sArr;
	VCar[] vArr;
	TCar[] tArr;
	
	
	
	
	CarLogic(SCar[] sArr,  VCar[] vArr,TCar[] tArr) {
		this.sArr=sArr;
		this.vArr=vArr;
		this.tArr=tArr;
		this.arr=new CarData[0];
	
		for(int i=0;i<sArr.length;i++){
			arr=sArr[i].addArray(arr,i);	
		}
		for(int i=0;i<vArr.length;i++){
			arr=vArr[i].addArray(arr,i);	
		}
		for(int i=0;i<tArr.length;i++){
			arr=tArr[i].addArray(arr,i);	
		}
		calRank();
		print();
		
	}
	
	void calRank(){
		for(CarData me: arr)
		{
			for(CarData you: arr)
			{
				if(me.sum < you.sum)
				{
					me.sort++;
					switch(me.name)
					{
						case "s":
							sArr[me.index].rank++;
							break;
						case "t":
							tArr[me.index].rank++;
							break;
						case "v":
							vArr[me.index].rank++;
							break;
					}
				}
			}
		}
		
	}
	
	void print(){
		
		for (int i = 0; i < arr.length; i++) {
			for(CarData me: arr)
			{
				if(me.sort==i)
				{
					
					switch(me.name)
					{
						case "s":
							sArr[me.index].print();
							break;
						case "t":
							tArr[me.index].print();
							break;
						case "v":
							vArr[me.index].print();
							break;
					}
				}
			}
		}
		
		
		/*
		for (int i = 0; i < sArr.length; i++) {
			sArr[i].print();
			
		}
		for (int i = 0; i < vArr.length; i++) {
			
			vArr[i].print();
			
		}
		for (int i = 0; i < tArr.length; i++) {
			
			tArr[i].print();
		}*/
		
		for(CarData cd: arr)
		{
			cd.print();
		}
	}
	
	
	
	
}

class CarData {
	String name;
	int index;
	int sum, sort;

	void print() {
		String str=  name + "\t" + index + "\t" +  sum  ;
		
		System.out.println(str);
	}
	
	
}

public class ConstCarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new CarLogic(
                new SCar[]{
                      new SCar("ºØºØÀÌ",97,86),
                      new SCar("³È³Ä·ò",66,57),
                      new SCar("À½³Ä·ò",65,86),
                      new SCar("¾îÀÌÄô",75,79),
                      new SCar("¿ÀÀÌ¶ò",90,88)
                },
                new VCar[]{
                      new VCar("ÄáÄÚµå",96,85,69),
                      new VCar("ºÎ½ºÅÍ",66,58,73),
                      new VCar("»þ¹Ìµå",65,86,47),
                      new VCar("ÁêÇÇ½ã´õ",75,79,85),
                      new VCar("ÇÇÄ«Ãò",90,88,96)
                      },
                new TCar[]{
                      new TCar("³È³ÈÀÌ",96,86),
                      new TCar("½ß½ßÀÌ",66,58),
                      new TCar("µµ·ç¹¬",65,86),
                      new TCar("¹Ú±ÙÇý",75,79),
                      new TCar("¿À¾ßºØ",90,88)
                });
       }
    }