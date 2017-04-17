package swing_p;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

public class ImagePaint extends JFrame {
	
	Image img = null;
	Graphics gimg = null;
	
	public ImagePaint() {
		// TODO Auto-generated constructor stub
		setBounds(100, 0, 600, 600);
		
		/*
		 * 에러 발생 ---> setVisible(true); 이후 실행
		 * 화면 생성 이후 Graphics를 얻을 수 있음
		img = createImage(600, 400);
		gimg = img.getGraphics();
			
		*/
		
		setVisible(true);	///------1
		setResizable(false);
		
		addWindowListener(new FrameClose2());
	
		img = createImage(600, 400);///---2
		gimg = img.getGraphics();   ///---3
		
		//gimg를 이용하여 img에 그리기 (도화지에 그림)
		gimg.fillOval(100, 100, 200,200);	///---4
		gimg.fillOval(100,350, 200,200);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//jframe에 img 그리기
		//벽에 도화지 붙히기
		g.drawImage(img, 100,100,this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImagePaint();
	}

}
