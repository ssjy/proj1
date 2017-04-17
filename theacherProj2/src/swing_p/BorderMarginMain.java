package swing_p;

import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class BorderMarginMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 JFrame frm = new JFrame("타이틀보더"); 
	      frm.setBounds(0,0,300,200); 
	      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	      TitledBorder border = new TitledBorder("타이틀이름"); 
	      JPanel p = new JPanel(); 
	      p.setBorder(border); 
	      frm.add(p); 
	      frm.setVisible(true); 
	}

}
