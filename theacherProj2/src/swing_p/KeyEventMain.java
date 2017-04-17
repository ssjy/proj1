package swing_p;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyEventMain extends JFrame{

	
	class KeyKeyListen extends KeyAdapter
	{

		

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(KeyEvent.VK_W);
			//System.out.println(e.getKeyCode());
			
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_S:
					sp*=2;
					if(sp>20) sp = 20;
					break;
				case KeyEvent.VK_D:
					sp/=2;
					if(sp==0) sp = 1;
					break;
				case KeyEvent.VK_UP:
					System.out.println("^");
					y-=sp;
					
					if(y<0) y=0;
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("V");
					y+=sp;
					if(y>530) y=530;
					break;
				case KeyEvent.VK_LEFT:
					System.out.println("<");
					x-=sp;
					if(x<0) x=0;
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println(">");
					x+=sp;
					if(x>570) x=570;
					break;
			}
			
			
			choo.setLocation(x, y);
		}

		
	}
	JLabel choo = new JLabel("¡Ú");
	int sp = 5;
	int x=0, y=0;
	int [][] pos = new int [5][4];
	ArrayList<JLabel> ysm = new ArrayList<>();
	
	
	class MonMove extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				try {
					sleep(10);
					
					for (int i = 0; i < ysm.size(); i++) {
						pos[i][0]+=pos[i][2];
						pos[i][1]+=pos[i][3];
						
						if(pos[i][0]<0 || pos[i][0]>550) pos[i][2]*=-1; 
						if(pos[i][1]<0 || pos[i][1]>530) pos[i][3]*=-1;
						
						ysm.get(i).setLocation(pos[i][0], pos[i][1]);
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public KeyEventMain() {
		// TODO Auto-generated constructor stub
		setBounds(1600, 0, 600, 600);
		setLayout(null);
		ImageIcon icon = new ImageIcon("fff/mon.png");
		
		
		for (int i = 0; i < 5; i++) {
			ysm.add(new JLabel(icon));
			pos[i][0] = (int)(Math.random()*500+10);
			pos[i][1] = (int)(Math.random()*500+10);
			pos[i][2] = (int)(Math.random()*2);
			pos[i][3] = (int)(Math.random()*2);
			
			if(pos[i][3]==0) pos[i][3]=-1;
			if(pos[i][2]==0) pos[i][2]=-1;
			
			ysm.get(i).setBounds(
					pos[i][0], pos[i][1], 50, 50);
			add(ysm.get(i));
		}
		
		choo.setBounds(0, 0, 50, 50);
		add(choo);
		
		setVisible(true);
		setResizable(false);
		addWindowListener(new FrameClose2());
		addKeyListener(new KeyKeyListen());
		
		new MonMove().start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyEventMain();
	}

}
