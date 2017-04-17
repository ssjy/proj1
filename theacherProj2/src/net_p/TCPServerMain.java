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

public class TCPServerMain extends JFrame implements ActionListener { //������ ��� �׼Ǹ����� �߻�

	JLabel res = new JLabel(); //��������� �󺧻���

	public TCPServerMain() { //������
		setBounds(100, 100, 300, 200); // ��ġ ũ�� ����
		setLayout(new GridLayout(2, 1)); // ���̾ƿ� �����ֱ�

		add(res); // ������� �����ӿ� �߰�
		JButton btn = new JButton("����"); // ����Ŭ���Ǵ� ��ư����
		add(btn); // ��ư �����ӿ� �߰�

		setVisible(true);

		btn.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	static String getTime() { //����ƽ���� ��𼭵� ��밡���� �޼ҵ� ����
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]"); 
		//SimpleDateFormat�� ��¥�� �ð� ����� ����ִ� Ŭ����  ��:��:��
		return sdf.format(new Date()); //sdf�� ����(���ó�¥)������
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TCPServerMain();

	}

	@Override
	public void actionPerformed(ActionEvent e) { //�׼������� �޼ҵ�(�׼��̺�Ʈ�� ����) (�׼Ǹ����ʸ� �ɸ� �ʼ��޼ҵ�)
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("�ƿ��̿���");

			if (!Pattern.matches("*.(txt|doc|ppt|hwp)", res.getText())) {
				throw new Exception("Ȯ����");
			}
			if (!Pattern.matches("*.(jpg|png)", res.getText())) {
				throw new Exception("Ȯ����");
			}

			Socket socket = new Socket(res.getText(), Integer.parseInt(res.getText()));

			while (true) {
				Socket client = server.accept();

				System.out.println(getTime() + client.getInetAddress());

				OutputStream os = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);

				dos.writeUTF("���");

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
