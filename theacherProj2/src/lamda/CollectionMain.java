package lamda;

import java.util.Arrays;
import java.util.Comparator;


public class CollectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] arr = {"w","A","0","3","9","4","t","b"};
		
		System.out.println("정렬전-------");
		
		System.out.println(Arrays.toString(arr));
		
		/*Arrays.sort(arr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});*/
		Arrays.sort(arr,(o1, o2)->o2.compareTo(o1));
		
		System.out.println("정렬후-------");
		System.out.println(Arrays.toString(arr));
	}

}
