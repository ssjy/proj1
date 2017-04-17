package swing_p;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintMain extends JFrame{

	public PaintMain() {
		// TODO Auto-generated constructor stub
		System.out.println("»ý¼ºÀÚ");
		setBounds(1600, 0, 600, 600);
		setVisible(true);
		setResizable(false);
		addWindowListener(new FrameClose2());
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		g.drawLine(60, 40, 500,500);
		
		System.out.println("±×¸²À» ±×·Á¿ä");
		g.drawString("À±¼º¹® ¾È³ç?", 50,50);
		g.setColor(Color.green);
		g.drawString("ÃßÁÖÇå ¾È³ç?", 50,50);
		g.drawRect(50, 100, 200, 100);
		g.setColor(Color.YELLOW);
		g.fillRect(60, 110, 180, 80);
		
		g.setColor(Color.red);
		g.drawOval(50, 210, 200, 100);
		g.setColor(Color.YELLOW);
		g.fillOval(60, 220, 180, 80);
		
		g.fillRoundRect(60, 320, 200,100, 100,50);
		
		g.fillArc(310,50,200,200,45,90);
		
		g.fillPolygon(
				new int[]{320,370,500,350}, 
				new int[]{260,210,330,310}, 
				4);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PaintMain();
	}

}
