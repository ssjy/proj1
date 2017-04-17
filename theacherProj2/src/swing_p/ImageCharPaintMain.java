package swing_p;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class ImageCharPaintMain extends JFrame implements MouseMotionListener{
	public ImageCharPaintMain() {
		// TODO Auto-generated constructor stub
		//System.out.println("생성자");

		setBounds(100, 0, 600, 600);
		setVisible(true);
		setResizable(false);
		
		img = createImage(600, 400);///---2
		gimg = img.getGraphics();   ///---3
		
		addWindowListener(new FrameClose2());
		addMouseMotionListener(this);
		
	}
	
	int x =0, y=0;
	boolean	chk = false;
	String str="*";
	Image img = null;
	Graphics gimg = null;
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(g); //배경다시그리기
		System.out.println("paint");g.setColor(Color.YELLOW);
		init(g);
		
		/*g.drawString("마우스를 움직여 보세요", 50,50);
	
		if(str.equals("*"))
		{
			g.setColor(Color.BLACK);
			g.drawString(str, x,y);
		}
		
		else if(str.equals("-"))
		{
			g.setColor(Color.YELLOW);
			g.fillOval(x-50, y-50, 100,100);
		}*/
		g.drawImage(img, 100,100,this);
	}
	
	void init(Graphics g)
	{
		if(!chk)
		{
			chk = true;
			g.setColor(Color.YELLOW);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.BLACK);
		}
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//super.update(g);
		paint(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageCharPaintMain();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getModifiersEx());
		//System.out.println(MouseEvent.BUTTON3_DOWN_MASK);
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK)
		{
			str="*";
		}else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK)
		{
			str="-";
		}
		
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
