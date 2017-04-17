package swing_p;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;


//		메뉴바에서 메뉴를 걸처 메뉴 아이템으로 

//		google 에서 icon png 로 이미지 검색하면  도구로 작은 아이콘을  얻을수 있다.

public class MenuMain extends JFrame{
//	 이렇게 프래임을 만들수 있지만 하지만 생성자를 써야한다
	
	public MenuMain() {
//		내것을 돌리기 때문에 앞에 jframe 을 안붙이고 바로 매소드 호출을 할수가 있다.
		
		setBounds(30, 50, 400, 200);
		
		JMenuBar mb = new JMenuBar();
			
		setJMenuBar(mb);
//		이친구는 add 가 아니라 set 이다  다시 말하지만 set 은 한개만 들어간다.
		
		JMenu main1 = new JMenu("파일");
		JMenu main2 = new JMenu("편집");
		JMenu main3 = new JMenu("보기");
//		이때 까지는 아무 변화가 없지만 add 를 하면 바로 들어가는 것을 볼수 있다.
		
		mb.add(main1);
		mb.add(main2);
		mb.add(main3);
//		메뉴라는 이야기는 바로 아래 하위가 있다는 이야기 이다.  ---------->> 그다음 Item 
		
		JMenuItem item1_1 = new JMenuItem("새로 만들기");
		
		
		
		ImageIcon icon = new ImageIcon("fff/Exit.jpg");
		JMenuItem item1_2 = new JMenuItem("개로 만들기",icon);
		item1_2.setText("열기");	//	개로 만들기에서    열기로 바꾸는 것.
		
		
		JMenuItem item1_3 = new JMenuItem("소로 만들기");
		item1_3.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_MASK));
		
		
		
		JMenuItem item1_4 = new JMenuItem("꺼져");
		
		main1.add(item1_1);
		main1.add(item1_2);
		main1.add(item1_3);
		main1.addSeparator();	//	구분자 --->> 줄긋는것을 말한다
		main1.add(item1_4);
		
		
//		-------------------------	
		
		
		JMenu item2_1 = new JMenu("편집용지");
		JMenu item2_2 = new JMenu("머리글");
		item2_2.setEnabled(false);	//	매뉴를 못쓰는 걸로 만드는것
		
		main2.add(item2_1);
		main2.add(item2_2);		//	매뉴는 하위가 잇다
		
		
		
		JMenuItem item2_1_1 = new JMenuItem("A4");
		JMenuItem item2_1_2 = new JMenuItem("B4");
		JMenuItem item2_1_3 = new JMenuItem("C4");
		
		item2_1_2.setSelected(true);
		item2_1.add(item2_1_1);
		item2_1.add(item2_1_2);
		item2_1.add(item2_1_3);
		
		
//	   -------------------------	네모		
		JCheckBoxMenuItem item3_1 = new JCheckBoxMenuItem("안내선");
		JCheckBoxMenuItem item3_2 = new JCheckBoxMenuItem("격자",true);	// 격자에 chk 가 되어서 나온다
		
		
		main3.add(item3_1);
		main3.add(item3_2);
		
		
//		-------------------------	동그라미
		//	그룹을 하는것은 여려개가 클릭이 되니까 그것을 방지하기 위해서 그렇다.
		JRadioButtonMenuItem item3_3 = new JRadioButtonMenuItem("프레젠테이션");
		JRadioButtonMenuItem item3_4 = new JRadioButtonMenuItem("개요",true);
		JRadioButtonMenuItem item3_5 = new JRadioButtonMenuItem("출력");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(item3_3);
		bg.add(item3_4);
		bg.add(item3_5);
		
		main3.add(item3_3);
		main3.add(item3_4);
		main3.add(item3_5);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		new MenuMain();	//	생성자를 돌리고 싶으면 이렇게 먼저 잡아줘야 된다.
		//	화면 구성은 inner 클래스에서 많이 사용을 한다.
		

	}

}
