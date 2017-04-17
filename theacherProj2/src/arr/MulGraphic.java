package arr;

import java.util.Arrays;

public class MulGraphic {

	public static void main(String[] args) {
		String [][] arr = {
				{"0-0","0-1","0-2","0-3","0-4","0-5","0-6","0-7"},
				{"1-0","1-1","1-2","1-3","1-4","1-5","1-6","1-7"},
				{"2-0","2-1","2-2","2-3","2-4","2-5","2-6","2-7"},
				{"3-0","3-1","3-2","3-3","3-4","3-5","3-6","3-7"},
				{"4-0","4-1","4-2","4-3","4-4","4-5","4-6","4-7"},
				{"5-0","5-1","5-2","5-3","5-4","5-5","5-6","5-7"},
				{"6-0","6-1","6-2","6-3","6-4","6-5","6-6","6-7"},
				{"7-0","7-1","7-2","7-3","7-4","7-5","7-6","7-7"}
		};
		
		
		String [] answer = new String[64];
		
		int curr =0, max = 1;
		
		for (int k = 0; k < 8; k+=2) {
			answer[curr]=arr[0][k];
			curr++;
			
			int i =k+1;
			int r =0;
			for(;r<=k+1;r++)
			{
				if(r!=7)
				{
					answer[curr]=arr[r][i--];
				curr++;
				}
			}
			if(r<8){
				
				
				for(;r>0;r--)
				{
					answer[curr]=arr[r][++i];
					curr++;
				}
			}	
		}
		
		for(int k=0;k<8;k+=2)
		{
			answer[curr]=arr[7][k];
			curr++;
			int i =k+1;
			int r =7;
			for(;i<8;i++)
			{
				
				answer[curr]=arr[r--][i];
				curr++;
			}
			i--;
			r+=2;
			//System.out.println(arr[r][i]);
			for(;r<7;r++)
			{
				
				answer[curr]=arr[r][i--];
				curr++;
			}
		}
		
		
		
		System.out.println(Arrays.toString(answer));
	}
}
