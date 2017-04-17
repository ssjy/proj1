package swing_p;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FontsMain {

	public static void main(String[] args) {

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		Font [] fs = ge.getAllFonts();
		
		for(Font ff : fs) {
			System.out.println(ff.getFontName());//font name 확인
			
		}
		
		String str = "선생님은 귀여워요 Love 1234567890";
		
		JFrame jf = new JFrame();
		jf.setBounds(300, 200, 400, 600);
		
		Font [] arr = {
				new Font("Arial", Font.ITALIC, 20),
				new Font("Serif", Font.ITALIC, 20),
				new Font("Serif", Font.BOLD, 20),
				new Font("Serif", Font.BOLD+Font.ITALIC, 20),
				new Font("Serif", Font.PLAIN, 20),
				new Font("Serif", Font.PLAIN, 30),
				new Font("Serif", Font.PLAIN, 40)
				
				};
//						name, 		style, 	  size
		
		jf.setLayout(new GridLayout(arr.length, 1));
		
		for(Font ff : arr) {
			JLabel lb = new JLabel(str);
			lb.setFont(ff);		//		폰트 지정
			jf.add(lb);
		}
		
		jf.setVisible(true);
		//jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
