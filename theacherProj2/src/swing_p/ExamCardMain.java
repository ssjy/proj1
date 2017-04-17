package swing_p;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ExamCardMain extends JFrame{

	ArrayList<JPanel> cardMap = new ArrayList<>();
	JPanel cardPP = new JPanel();
	CardLayout card = new CardLayout();
	ArrayList<SingleQQ> arr = new ArrayList<>();
	JLabel resLB = new JLabel("결과:");
	
	class BtnAction implements ActionListener
	{
		int num;
		
		public BtnAction(int num) {
			this.num = num;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			card.show(cardPP, num+"");
		}
	}
	
	
	
	public ExamCardMain() {
		// TODO Auto-generated constructor stub
		setBounds(100, 0, 800, 600);
		JPanel nn = new JPanel();
		
		JPanel qqPP = new JPanel();
		JPanel resPP = new JPanel();
		qqInit();
		
		Color [] cc = {
				Color.pink, Color.YELLOW, Color.cyan,
				Color.ORANGE, Color.LIGHT_GRAY
		};
		
		
		nn.setLayout(new GridLayout(1, 2));
		nn.add(resPP);
		nn.add(qqPP);
		add(nn,"North");
		
		
		cardPP.setLayout(card);
		
		
		add(cardPP,"Center");
		
		
		
		qqPP.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		for (int i = 0; i < cardMap.size(); i++) {
			btns.add(new JButton(i+1+""));
			qqPP.add(btns.get(i));
			cardMap.get(i).setBackground(cc[i]);
			
			cardPP.add(cardMap.get(i),i+"");
			btns.get(i).addActionListener(new BtnAction(i));
		}
		
		
		JButton resBtn = new JButton("확인");
		resBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int jum=0;
				
				for(SingleQQ sq: arr)
				{
					if(sq.chk())
					{
						jum+=20;
					}
				}
				
				resLB.setText("결과:"+jum);	
			}
		});
		resPP.add(resBtn);
		resPP.add(resLB);
		
		card.show(cardPP, "0");

		setVisible(true);
		setResizable(false);
		addWindowListener(new FrameClose2());
	}
	
	void qqInit()
	{
		arr.add(new SingleQQ("2+3", "5"));
		arr.add(new SingleQQ("4*5", 2,"10","20","30","40"));
		arr.add(new SingleQQ("8-5", "3"));
		arr.add(new SingleQQ("15/3",3,"3","4", "5","6"));
		arr.add(new SingleQQ("9%4", "1"));
	}
	
	class SingleQQ
	{
		JPanel nowPP;
		String qq;
		String ans;
		JTextField ju = new JTextField();
		
		ArrayList<JRadioButton> arr = new ArrayList<>();
		int type;
		public SingleQQ(String qq, String ans) {
			// TODO Auto-generated constructor stub
			
			nowPP =new JPanel();
			cardMap.add(nowPP);
			this.qq = qq;
			this.ans = ans;
			type = 2;
			
			paint();
		}
		
		public SingleQQ(String qq, int ans, String an1, String an2, String an3, String an4) {
			// TODO Auto-generated constructor stub
			nowPP =new JPanel();
			cardMap.add(nowPP);
			
			this.qq = qq;
			this.ans = ans+"";
			type = 5;
			arr.add(new JRadioButton(an1));
			arr.add(new JRadioButton(an2));
			arr.add(new JRadioButton(an3));
			arr.add(new JRadioButton(an4));
			
			paint();
		}
		
		void paint()
		{
			nowPP.setLayout(new GridLayout(type,1));
			nowPP.add(new JLabel(qq));
			
			if(type==2)
			{
				nowPP.add(ju);
			}else{
				ButtonGroup bg = new ButtonGroup();
				for(JRadioButton jrb: arr)
				{
					bg.add(jrb);
					nowPP.add(jrb);
				}
			}
		}
		
		
		boolean chk(){
			boolean res = false;
			
			if(type==2)
			{
				res = ju.getText().trim().equals(ans);
			}else{
				
				res = arr.get(Integer.parseInt(ans)).isSelected();
			}
			
			return res;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExamCardMain();
	}

}
