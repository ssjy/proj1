package arr;

import java.util.Scanner;

public class MulCar {

	public static void main(String[] args) {
	
		String [] name = {"렉스턴","sm5","k9","bmw"};
		String [][] index = {
				{"차종", "속도", "연비","안정성","점수","등수","등급"},
				{"불량","보통","우수"}
			};
			//          70     80
		
		
		int [][] jum = {
				{99,76,54},
				{99,98,99},
				{88,64,77},
				{75,74,99}
			};
		
		double [][] rate ={
				{0.5,0.3,0.2},
				{0.15,0.25,0.6},
				{0.2,0.7,0.1}
			};
		
		int [][] res = new int [name.length][3];
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("트랙번호:");
		int track = sc.nextInt();
		
		for (int i = 0; i < jum.length; i++) {
			for (int j = 0; j < jum[i].length; j++) {
				res[i][0]+=(int)(jum[i][j]* rate[track][j]);
			}
			
			res[i][2]= res[i][0]/10/7+res[i][0]/10/8;
				
		}
		///
		/*for (int i = 0; i < res.length; i++) {
			res[i][1]=1;
			for (int j = 0; j < res.length; j++) {
				if(res[i][0]<res[j][0])
					res[i][1]++;
			}
		}*/
		
		for(int [] me : res)
		{
			me[1]=1;
			for(int [] com : res)
			{
				if(me[0]<com[0])
					me[1]++;
			}
		}
		
		/////
		
		String line="";
		for(String str : index[0])
		{
			System.out.print(str+"\t");
			line+="========";
		}
		System.out.println("\n"+line);
		
		for (int i = 0; i < name.length; i++) {
			String str = name[i]+"\t";
			
			for (int j = 0; j < jum[i].length; j++) {
				str+=jum[i][j]+"\t";
			}
			for (int j = 0; j < res[i].length-1; j++) {
				str+=res[i][j]+"\t";
			}
			str+=index[1][res[i][2]];
			System.out.println(str);
		}
		
		/*for(int [] aa : jum)
		{   // int []   <---- int[][]
			//   aa
			System.out.print(aa+":");
			for(int bb : aa)
			{// int <----- int []
				System.out.print(bb+",");
			}
			System.out.println();
		}*/
		
	}
}
