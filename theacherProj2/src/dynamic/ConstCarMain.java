package dynamic;
class ConstCar
{
	String name;
    int [] jum;
    int sum, kind, rank;
    double [][] rate = {
    		 {0.6 , 0.4},
    		 { 0.3 , 0.7},
    		 { 0.5 , 0.5}
    };
    
    ConstCar(String car_name, int speed, int fuel)
    {
    	kind = 0;
    	init(car_name, new int[]{speed, fuel});
    }
    ConstCar(String car_name, int speed, int fuel, int safe)
    {
    	kind = 1;
    	init(car_name, new int[]{speed, fuel, safe});
    }
    
    ConstCar(String car_name, int speed, double fuel)
    {
    	kind = 2;
    	init(car_name, new int[]{speed, (int)fuel});
    }
    
    void init(String name, int [] jum)
    {
    	this.name = name;
    	sum=0;
    	
    	this.jum = jum;
    	for (int i = 0; i < rate[kind].length; i++) {
			sum+=jum[i]*rate[kind][i];
		}
    	//print();
    }
    void print()
    {
    	String [] index = {"스포츠카 차종","승합차 차종","트럭      차종"};
    	String str=index[kind]+"\t"+name+"\t";
    	for(int jj : jum)
    	{
    		str+=jj+"\t";
    	}
    	if(kind!=1)str+="\t";
    	
    	str+=sum+"\t"+rank;
    	
    	System.out.println(str);
    }
}

class ConstCarLogic
{
	ConstCar []cars;

	public ConstCarLogic(ConstCar[] cars) {
		super();
		this.cars = cars;
		cal();
		print();
	}
	
	void cal()
	{
		for (ConstCar me :cars) {
			me.rank=1;
			for (ConstCar com :cars) {
				if(me.sum < com.sum)
					me.rank++;
			}
		}
	}
	
	void print()
	{
		for (ConstCar me :cars) {
			me.print();
		}
	}
}
public class ConstCarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConstCarLogic(new ConstCar[]{
			new ConstCar("페라리",60,90),        //스포츠	
	        new ConstCar("포터",80,70.0),        //트럭
	        new ConstCar("아우디",70,80),        //스포츠
	        new ConstCar("카니발",50,80,6),    //승합차
	        new ConstCar("봉고",70,90,9),        //승합차
	        new ConstCar("라보",90,70.0)
		});
	}

}
