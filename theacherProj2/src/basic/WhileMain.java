package basic;

public class WhileMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int i = 0;	//초기값
		while(i<10)	//조건
		{
			System.out.println("선생님은 귀여워요"+i);
			i++;	//증감
		}*/
		
		
		int i = 0;
		
		while(i<20)
		{
			System.out.println("시작:"+i);
			i++;
			if(i>10)
				//break;
				continue;
				
			
			System.out.println("선생님은 깜찍해요"+i);
			
		}
		
		
		
		int a = 10;
		while(a<5)
		{
			System.out.println("while:"+a);
			a++;
		}
		
		System.out.println();
		
		a = 10;
		
		do
		{
			System.out.println("do~while:"+a);
			a++;
		}while(a<5);
		
		
		
		
		
		
	}

}
