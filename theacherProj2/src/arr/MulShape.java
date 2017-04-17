package arr;

import java.util.Arrays;

public class MulShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] shape = {
				{5,6,15},
				{5},
				{5,6}
				
				
		};
		
		int [][] res = new int [shape.length][4];
							//넓이,둘레
		
		String [] name = {"원","직사각형","직각삼각형"};
		double pi = 3.14;
		
		int max =0;
		for (int i = 0; i < shape.length; i++) {
			int [] buf =shape[i];
			int [] rrr = res[i];
			if(max<buf.length)
				max=buf.length;
			switch(buf.length)
			{
				case 1:
					rrr[0] = (int)(buf[0]*buf[0]*pi);
					rrr[1] = (int)(buf[0]*2*pi);
					break;
				case 2:
					rrr[0] = buf[0]*buf[1];
					rrr[1] = (buf[0]+buf[1])*2;
					break;
				case 3:
					rrr[0] = buf[0]*buf[1]/2;
					rrr[1] = buf[0]+buf[1]+buf[2];
					break;
			}
	
		}
		
		
		for (int i = 0; i < res.length; i++) {
			res[i][2] = 1;
			res[i][3] = 1;
			for (int j = 0; j < res.length; j++) {
				if(res[i][0]<res[j][0])
					res[i][2]++;
				if(res[i][1]<res[j][1])
					res[i][3]++;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		for (int i = 0; i < shape.length; i++) {
			
			System.out.print(name[shape[i].length-1]+"\t");
			for (int j = 0; j < shape[i].length; j++) {
				
				System.out.print(shape[i][j]+"\t");
				
			}
			
			for(int j = shape[i].length ; j<max;j++)
			{
				System.out.print("\t");
			}
			
			for (int j = 0; j < res[i].length; j++) {
				
				System.out.print(res[i][j]+"\t");
				
			}
			System.out.println();
		}
		
		
	}

}
