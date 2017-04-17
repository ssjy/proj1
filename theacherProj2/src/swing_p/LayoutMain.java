package swing_p;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f1 = new JFrame("Border");
		f1.setBounds(1600, 0, 300, 200);
		f1.setLayout(new BorderLayout());
		f1.add("North",new JButton("북쪽"));
		//f1.add("South",new JButton("남쪽"));
		f1.add("East",new JButton("동쪽"));
		//f1.add("West",new JButton("서쪽"));
		//f1.add("Center",new JButton("중앙"));
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		
		
		JFrame f2 = new JFrame("Flow");
		f2.setBounds(1900, 0, 300, 200);
		f2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));
		                              //정렬,       h, v 간격
		for (int i = 0; i <20; i++) {
			f2.add(new JButton("ff"+i));
		}
		
		
		f2.setVisible(true);
		
		JFrame f3 = new JFrame("Grid");
		f3.setBounds(1600, 300, 300, 200);
		f3.setLayout(new GridLayout(3, 4,  5,2));
		                    //가로줄수, 세로줄수,  h, v 간격
		for (int i = 0; i <12; i++) {
			f3.add(new JButton("ff"+i));
		}
		
		
		f3.setVisible(true);
		
		JFrame f4 = new JFrame("Box");
		f4.setBounds(1900, 300, 300, 200);
		f4.setLayout(new BoxLayout(f4.getContentPane(), BoxLayout.Y_AXIS));
		                    
		for (int i = 0; i <10; i++) {
			f4.add(new JButton("ff"+i));
		}

		f4.setVisible(true);
		
		JFrame f5 = new JFrame("Box");
		f5.setBounds(2200, 0, 300, 200);
		
		CardLayout card = new CardLayout();
		f5.setLayout(card);
		
		Color [] cc ={
				Color.pink, 
				Color.blue, 
				Color.cyan, 
				Color.GREEN,
				Color.YELLOW
		};
		
		String [] pp ={
			"pinkPP","bluePP","cyanPP","greenPP","yellowPP"	
		};
		                    
		for (int i = 0; i <cc.length; i++) {
			JPanel jp = new JPanel();
			jp.setBackground(cc[i]);
			f5.add(jp,pp[i]);
		}
		
		

		f5.setVisible(true);
		
		int i =0;
		
		while(true)
		{
			card.show(f5.getContentPane(), pp[i]);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==pp.length) i=0;
		}
		
	}

}
