package swing_p;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ExamMain extends JFrame{

	ArrayList<JCheckBox> q1 = new ArrayList<>();
	ArrayList<JRadioButton> q2 = new ArrayList<>();
	ArrayList<JTextField> q3 = new ArrayList<>();
	JLabel res = new JLabel("°á°ú:");
	
	class BtnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int jum =0;
			
			for(JCheckBox box: q1 )
			{
				if(box.isSelected()) jum+=20;
			}
			
			if(q2.get(1).isSelected()) jum+=20;
			
			
			
			res.setText("°á°ú:"+jum);
		}
		
		
		
	}
	
	public ExamMain() {
		// TODO Auto-generated constructor stub
		setBounds(1600, 100, 600, 600);
		
		q1.add(new JCheckBox("Àåµ¿°Ç"));
		q1.add(new JCheckBox("Á¤¿ì¼º"));
		q1.add(new JCheckBox("Çöºó"));
		q1.add(new JCheckBox("¿øºó"));
		
		q2.add(new JRadioButton("±ôÂïÇØ¿ä"));
		q2.add(new JRadioButton("±Í¿©¿ö¿ä"));
		q2.add(new JRadioButton("¸ÚÁ®¿ä"));
		q2.add(new JRadioButton("²ûÂïÇØ¿ä"));
		
		setLayout(new GridLayout(q1.size()+q2.size()+4, 1));
		
		add(new JLabel("1. ¼±»ý´Ô º°¸íÀº?"));
		
		for(JCheckBox box: q1 )
		{
			add(box);
		}
		
		add(new JLabel("2. ¼±»ý´Ô Æ¯±â´Â?"));
		ButtonGroup bg = new ButtonGroup();
		for(JRadioButton box: q2 )
		{
			bg.add(box);
			add(box);
		}
		
		JButton btn = new JButton("È®ÀÎ");
		
		add(btn);
		add(res);
		setVisible(true);
		setResizable(false);
		addWindowListener(new FrameClose2());
		
		btn.addActionListener(new BtnActionListener());
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExamMain();
	}

}
