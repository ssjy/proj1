package oops;

import java.util.Scanner;

class CarTrackCar2
{
	String  name, grade;
	int [] jum;
	double per;
	int kind, rank, sort;
	String [] kindStr = {"스포츠카","트럭","승합차","택시"};
	

	double [][] rate = {
			{0.6,0.15,0.25},
			{0.4,0.6},
			{0.3,0.5,0.2},
			{0.6,0.3,0.1}
	};
	
	void init(String name,int [] jum)
	{
		this.kind = jum[0];
		this.name = name;
		this.jum = new int[jum.length-1];
		
		for (int i = 0; i < this.jum.length; i++) {
			this.jum[i]= jum[i+1];
		}
		cal();
	}
	void cal()
	{
		per = 0;
		for (int i = 0; i < rate[kind].length; i++) {
			per += rate[kind][i]* jum[i];
		}
	}
	
	void print()
	{
		String str = 
				kindStr[kind]+"\t"+
				name+"\t";
		for(int jj : jum)
		{
			str+=jj+"\t";
		}
		str+=per+"\t"+rank;
		
		System.out.println(str);
	}
}
class CarTrackTrack2
{
	String name;
	String [] ppStr = {"입력순서","전체등수","차종별 등수"};
	int [] kindArr;
	int [][] kindCnt = new int[2][4];
	int ppNum;
	
	CarTrackCar2 [] okCar;
	CarTrackCar2 [] noCar;
	
	void init(String name,	int [] kindArr)
	{
		this.name = name;
		this.kindArr = kindArr;
		
		
	}
	
	void cal(CarTrackCar2 [] carArr)
	{
	
		okCar = new CarTrackCar2[0];
		noCar = new CarTrackCar2[0];
		for(CarTrackCar2 car: carArr)
		{
			boolean chk = false;
			for(int kk : kindArr)
			{
				if(car.kind==kk)
				{
					chk = true;
					arrCarAdd(chk, car);
					kindCnt[0][car.kind]++;
				}
			}
			if(!chk)
			{
				arrCarAdd(chk, car);
				kindCnt[1][car.kind]++;
			}
		}

		rank();
		print();
	}
	
	
	void arrCarAdd(boolean chk,CarTrackCar2 car)
	{
		CarTrackCar2 [] buf;
		CarTrackCar2 [] ori;
		if(chk)
			ori=okCar;
		else
			ori=noCar;
		
		buf = new CarTrackCar2[ori.length+1];
		for (int i = 0; i < ori.length; i++) {
			buf[i] = ori[i];
		}
		buf[ori.length] = car;
		
		if(chk)
			okCar = buf;
		else
			noCar = buf;
		
		
	}
	
	void rank()
	{
		System.out.println("출력 선택");
		for (int i = 0; i < ppStr.length; i++) {
			
			System.out.print(i+"."+ppStr[i]);
			
			if(i<ppStr.length-1)
				System.out.print(", ");
		}
		System.out.print("\n 출력번호:");
		Scanner sc = new Scanner(System.in);
		ppNum = sc.nextInt();
		subRank(okCar,kindCnt[0]);	
		subRank(noCar,kindCnt[1]);
	}
	
	void subRank(CarTrackCar2[] car, int [] kindCnt)
	{
		for(CarTrackCar2 me: car)
		{
			if(ppNum==2)
			{
				for (int i = 0; i < me.kind; i++) {
					me.sort+=kindCnt[i];
				}
			}
			me.rank=1;
			for(CarTrackCar2 com: car)
			{
				if(me.per < com.per)
				{
					if(ppNum==2)
					{
						if(me.kind==com.kind)
						{
							me.rank++;
							me.sort++;
						}
					}else{
						if(ppNum==1)
						{
							me.sort++;
						}
						me.rank++;
					}
				}	
			}
			
		}
	}
	void print()
	{
		
		System.out.println("가능");
		
		subPrint(okCar);
		
		System.out.println("불가능");
		subPrint(noCar);
	}
	
	void subPrint(CarTrackCar2[] car)
	{
		for (int i = 0; i < car.length; i++) {
		
			for(CarTrackCar2 cc: car)
			{
				if(i==cc.sort)
					cc.print();
			}
		}
		
	}
	
}

class CarTrackLogic2
{
	CarTrackCar2 [] carArr;
	CarTrackTrack2 [] trackArr;
	int ttNum;
	
	void init(CarTrackCar2[] carArr, CarTrackTrack2[] trackArr) {
		
		this.carArr = carArr;
		this.trackArr = trackArr;
		input();
		cal();
	}
	
	void input()
	{
		System.out.println("트랙 선택");
		for (int i = 0; i < trackArr.length; i++) {
			
			System.out.print(i+"."+trackArr[i].name);
			
			if(i<trackArr.length-1)
				System.out.print(", ");
		}
		System.out.print("\n 트랙번호:");
		Scanner sc = new Scanner(System.in);
		ttNum = sc.nextInt();
	}
	void cal()
	{
		trackArr[ttNum].cal(carArr);
		
	}
	
	
	
}


public class CarTrackMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [][] carName={{"장동건차","장남건차","장서건차","장중건차","북두신건차",
                "현빈차","원빈차","김우빈차","투빈차","골빈차","미스터빈차",
                "젤리빈차","장희빈차","커피빈차","한가인차","한나인차","한다인차","한라인차"},
				{"서울","인천","분당"}
		};

		int [][][] jum={{
		        {1, 37,70}, 
		        {2, 96,95,99}, 
		        {3, 78,69,57}, 
		        {2, 67,65,86}, 
		        {1, 76,80},
		        {3, 67,62,70}, 
		        {2, 57,45,60}, 
		        {0, 55,50,80}, 
		        {2, 86,96,40}, 
		        {1, 95,85},
		        {3, 65,49,20},
		        {1, 49,45}, 
		        {3, 63,78,78}, 
		        {0, 76,86,75}, 
		        {3, 45,63,57}, 
		        {3, 78,67,79}, 
		        {2, 99,89,68}, 
		        {0, 64,97,85}
			},
				{
					{0,2,3},
					{1,3},
					{0,1,2}
					
				}
		};
		
	      
		CarTrackCar2 [] carArr = new CarTrackCar2[carName[0].length];
		
		for (int i = 0; i < carArr.length; i++) {
			carArr[i] = new CarTrackCar2();
			carArr[i].init(carName[0][i], jum[0][i]);
		}
		
		CarTrackTrack2 [] trackArr = new CarTrackTrack2[carName[1].length];
		for (int i = 0; i < trackArr.length; i++) {
			trackArr[i] = new CarTrackTrack2();
			trackArr[i].init(carName[1][i], jum[1][i]);
		}
		
		CarTrackLogic2 logic = new CarTrackLogic2();
		logic.init(carArr, trackArr);
	}

}
