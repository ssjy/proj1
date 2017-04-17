package net_p;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TCPServerMain extends JFrame implements ActionListener { //프레임 상속 액션리스너 추상

	JLabel res = new JLabel(); //결과나오는 라벨생성

	public TCPServerMain() { //생성자
		setBounds(100, 100, 300, 200); // 위치 크기 설정
		setLayout(new GridLayout(2, 1)); // 레이아웃 나눠주기

		add(res); // 결과라벨을 프레임에 추가
		JButton btn = new JButton("전송"); // 전송클릭되는 버튼생성
		add(btn); // 버튼 프레임에 추가

		setVisible(true);

		btn.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	static String getTime() { //스테틱으로 어디서든 사용가능한 메소드 생성
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]"); 
		//SimpleDateFormat은 날짜와 시간 모양을 잡아주는 클래스  시:분:초
		return sdf.format(new Date()); //sdf의 포맷(오늘날짜)가져옴
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TCPServerMain();

	}

	@Override
	public void actionPerformed(ActionEvent e) { //액션퍼폼드 메소드(액션이벤트를 받음) (액션리스너를 걸면 필수메소드)
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("아에이오우");

			if (!Pattern.matches("*.(txt|doc|ppt|hwp)", res.getText())) {
				throw new Exception("확장자");
			}
			if (!Pattern.matches("*.(jpg|png)", res.getText())) {
				throw new Exception("확장자");
			}

			Socket socket = new Socket(res.getText(), Integer.parseInt(res.getText()));

			while (true) {
				Socket client = server.accept();

				System.out.println(getTime() + client.getInetAddress());

				OutputStream os = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);

				dos.writeUTF("어서와");

				dos.close();
				os.close();
				client.close();

			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			res.setText(e1.getMessage());
		}
	}

}
