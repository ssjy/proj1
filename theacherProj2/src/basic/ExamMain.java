package basic;

public class ExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int kor = 88, eng = 89, mat = 86;
		int sum = kor + eng + mat;
		int avg = sum/3;
		
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
		System.out.println(sum);
		System.out.println(avg);
		
		
		//// 직사각형의 가로와 세로길이를 이용하여 넓이와 둘레를 구하세요 
		
		int width = 4, height = 5;
		int area = width * height;
		int border = (width + height)*2;
		System.out.println();
		System.out.println(width);
		System.out.println(height);
		System.out.println(area);
		System.out.println(border);
		
		
	}

}
