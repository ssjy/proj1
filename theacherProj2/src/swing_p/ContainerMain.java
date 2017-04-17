package swing_p;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ContainerMain {

	public static void main(String[] args) {

		JFrame f1 = new JFrame("jPanel");
		f1.setBounds(50, 100, 300, 300);
		f1.setLayout(null);	
		
		
		
		
		JPanel p1 = new JPanel();
		p1.setBounds(20, 20, 100, 200);
		p1.setBackground(Color.PINK);		//	색갈 집어 넣기.
		
		JPanel p2 = new JPanel();
		p2.setBounds(130, 20, 100, 200);
		p2.setBackground(Color.YELLOW);
		
		for (int i = 0; i < 10; i++) {
			p1.add(new JButton("버튼"+i));		//	add 안에도 버튼을 만들어 넣을수 있다.
			p2.add(new JButton("버튼"+i));
		}
		
		f1.add(p1);
		f1.add(p2);
		
		
		
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
//		set -- 하나만 들어가는것   add -- 여러개가 들어가는것
//		---------------------- JScrollPane 을 만들어보자 -----------------------

		JFrame f2 = new JFrame("JScrollPane");
		f2.setBounds(350, 100, 300, 300);
		f2.setLayout(null);
		
//		------------ 가로로 스크롤 팬 만들기  >>>>>>>>>>>>>   ------------
		
		JPanel p3 = new JPanel();
		JScrollPane hs = new JScrollPane(p3);
		hs.setBounds(20, 20, 100, 200);			//패널에다 잡을필요 없이 그냥 스크롤 팬에다가만 bounds 로 위치만 잡아주면 된다.
		f2.add(hs);
		p3.setBackground(Color.YELLOW);
		
		for (int i = 0; i < 10; i++) {
			p3.add(new JButton("버튼"+i));
		}
		
		f2.add(hs);
		
//		------------ 세로로 스크롤 팬 만들기   >>>>>>>>>>>>>   ------------
		// setLayout 은 여기서 꼭 해줘야 한다.
		
		
		JPanel p4 = new JPanel();
		JScrollPane vs = new JScrollPane(p4);
		vs.setBounds(140, 20, 100, 200);			//패널에다 잡을필요 없이 그냥 스크롤 팬에다가만 bounds 로 위치만 잡아주면 된다.
		f2.add(vs);
		p4.setBackground(Color.PINK);
		p4.setLayout(new GridLayout(10, 1));
		
		for (int i = 0; i < 10; i++) {
			p4.add(new JButton("버튼"+i));
		}
		
		f2.add(vs);
		
		
		f2.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		---------------------- 다이얼 로그 을 만들어보자 -----------------------		
		
		
		
		JFrame f3 = new JFrame("JDialog");
		f3.setBounds(50, 400, 300, 300);
		f3.setLayout(null);
		
		JDialog dd = new JDialog(f3, "메시지창", true);	// 이놈은 프레임이랑 따로 노는 놈이다. 
		// 그리하여 dd.setvisible 이 가능하다
		// true 는 dd 가 먼저 뜨고 저것을 꺼야지 dialog 프래임이 실행이된다. 
		// false 를 넣으면 그냥 바로 다 출력이 된다.
		//dd.setVisible(true);		여기다 놓으면 메시지 창은 bounds 해놓은 크기 설정이 먹지 않는다.
		dd.setBounds(150, 400, 300, 200);
		dd.setLayout(new FlowLayout());
		dd.add(new JLabel("경고창입니다."));
		dd.add(new JButton("확인"));
		dd.setVisible(true);
		
		
		f3.setVisible(true);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		---------------------- 파일 다이얼 로그 을 만들어보자 -----------------------		
		
		JFrame f4 = new JFrame("FileDialog");
		f4.setBounds(350, 400, 300, 300);
		f4.setLayout(null);
		f4.setVisible(true);
		
		FileDialog fd = new FileDialog(f4, "파일열기", FileDialog.LOAD);
		fd.setLocation(2000, 100);
		fd.setDirectory("C:\\Users\\임종천\\Desktop");	//	폴더의 주소를 복사해서 붙여넣기 하면 된다.
		fd.setVisible(true);
		
		
		System.out.println(fd.getDirectory());	//	파일 경로를 알아보는것.
		System.out.println(fd.getFile());		//	파일 이름을 알아보는것.
		
		
		f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		

	}

}
