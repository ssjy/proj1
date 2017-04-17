package net_p;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatHome extends JFrame {

	public JTextArea ta;
	public JRadioButton rb1;
	public JRadioButton rb2;
	public JTextField tf;
	public JScrollPane sp = new JScrollPane(ta);

	public ChatHome(String name) {
		// TODO Auto-generated constructor stub
		super(name);

		setBounds(100, 0, 400, 600);
		setLayout(null);

		ta = new JTextArea();
		rb1 = new JRadioButton("single", true);
		rb2 = new JRadioButton("broad");
		tf = new JTextField();

		sp.setBounds(15, 20, 353, 400);

		rb1.setBounds(15, 420, 60, 50);
		rb2.setBounds(95, 420, 60, 50);
		ButtonGroup bg = new ButtonGroup(); // 버튼중복선택 막기
		bg.add(rb1);
		bg.add(rb2);

		tf.setBounds(15, 470, 353, 70);

		ta.setEditable(false); // 입 력된 채팅창에 수정하지 못하게함
		tf.setEditable(true); 

		ta.setFocusable(false); // 초기화면구성시 포커스를 가지고 있지 않음(커서 놓을 수 없음)
		tf.setFocusable(true); // 초기화면구성시 포커스를 가지고 있음 (커서 놓을 수 있음)

		add(rb1);
		add(rb2);
		add(tf, "South");
		add(sp, "Center");

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
