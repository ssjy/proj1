package arr;

public class ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		
		int [] arr =new int[] {100,3,20,50};	//선언 및 초기화(공간할당)
		
		int [] arr2;				//선언만
		
		int [] arr3 = new int[5];	//선언 및 공간할당
						//new의 리턴값은 메모리 주소
		int [] arr4;
		
		int [] arr5;
		
		//arr4 = {34,45,56};   초기화 방식은 선언 시에만 가능하다.
		
		arr4 = new int[3];	
		//공간할당은 new 를 통해 메모리에 새로이 얻은 주소를 리턴 받기에 가능하다.
		
		arr5 = new int[]{33,44,55,66,44,32,1234};
		//1. 공간할당 2. 원소배당   3. 메모리 주소 리턴
		
		System.out.println(arr);//배열이름은 주소를 가지고 있다.
		//System.out.println(arr2);
		
		arr[1] = 3333;	//배열 원소의 대입
		
		System.out.println(arr[0]);//배열 원소 호출
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		//System.out.println(arr[4]);
		
		System.out.println(arr3[0]);
		System.out.println(arr3[1]);
		System.out.println(arr3[2]);
		System.out.println(arr3[3]);
		System.out.println(arr3[4]);
		
		System.out.println(arr5[2]);
		
		System.out.println(arr.length);
		System.out.println(arr3.length);
		System.out.println(arr4.length);
		System.out.println(arr5.length);
		
		System.out.println("arr:"+arr);
		System.out.println("arr3:"+arr3);
		System.out.println("arr4:"+arr4);
		System.out.println("arr5:"+arr5);
		System.out.println(arr5[2]);
		arr5 = arr;
		System.out.println(arr5[2]);
		System.out.println("arr:"+arr);
		System.out.println("arr3:"+arr3);
		System.out.println("arr4:"+arr4);
		System.out.println("arr5:"+arr5);
		
		
	}

}
