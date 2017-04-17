package swing_p;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventMain extends JFrame implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		String rr = "->";
		
		if(e.getX()<xx) rr="<-";
		
		res.setText("마우스 방향:"+rr);
		System.out.println("마우스 드래그:"+e.getX()+","+e.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스가 움직임"+e.getX()+","+e.getY());
		
		xx = e.getX();
		ysm.setLocation(e.getX()-25,400);
	}
	
	JLabel ysm, res;
	
	int xx;
	
	public MouseEventMain() {
		// TODO Auto-generated constructor stub
		setBounds(100, 0, 600, 600);
		setLayout(null);
		res = new JLabel("마우스 방향:");
		ImageIcon icon = new ImageIcon("fff/mon.png");
		 ysm= new JLabel(icon);
		 //ysm.setBackground(Color.yellow);
		 ysm.setBounds(0,400,50,50);
		 res.setBounds(0, 30, 200, 50);
		 add(ysm);
		 add(res);
		
		setVisible(true);
		setResizable(false);
		addWindowListener(new FrameClose2());
		addMouseMotionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseEventMain();
	}
	

}
