package swing_p;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JFrame {
	
	public Rainbow() {
		
		setBounds(300, 300, 600, 650);
		setLayout(null);
		
	
		
		Color [] bc = {
				new Color(255, 0, 0),
				new Color(254, 188, 8),
				new Color(236, 250, 89),
				new Color(8, 250, 44),
				new Color(8, 8, 250),
				new Color(20, 3, 97),
				new Color(82, 5, 120)
		};
		
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 600);
		p1.setLayout(new GridLayout(bc.length, 1));
		p1.setBackground(new Color(255,0,0,100));
		
		for (int i = 0; i < bc.length; i++) {
			JButton btn = new JButton();
			btn.setBackground(bc[i]);
	
			
			p1.add(btn);
			
		}
		
		add(p1);
		
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new Rainbow();

	}

}
