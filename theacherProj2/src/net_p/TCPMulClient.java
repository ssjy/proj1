package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TCPMulCliGUI extends JFrame {
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();
	
	JScrollPane sp = new JScrollPane(ta);
	public TCPMulCliGUI(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		setBounds(100, 0, 300, 500);
		ta.setFocusable(false);
		tf.setFocusable(true);
		
		add(sp, "Center");
		add(tf, "South");
		
		setVisible(true);

	}

}

class TCPMulCliSender extends Thread implements ActionListener {
	DataOutputStream dos;
	String name;
	TCPMulCliGUI ui;
	private Object sp;

	public TCPMulCliSender(Socket socket, TCPMulCliGUI ui) {
		// TODO Auto-generated constructor stub
		this.ui = ui;
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			name = "[" + socket.getLocalAddress() + "] ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		ui.tf.addActionListener(this);
		try {
			dos.writeUTF(name);

			while (dos != null) {
				dos.writeUTF(name + sc.nextLine());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			String msg = ui.tf.getText();
			dos.writeUTF(name + msg);
			ui.ta.append("\n" + msg);
			ui.tf.setText("");
	
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

class TCPMulCliReceiver extends Thread {
	DataInputStream dis;
	TCPMulCliGUI ui;

	public TCPMulCliReceiver(Socket socket, TCPMulCliGUI ui) {
		// TODO Auto-generated constructor stub
		this.ui = ui;
		
		try {
			dis = new DataInputStream(socket.getInputStream());
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (dis != null) {
			try {
				// System.out.println(dis.readUTF());
				ui.ta.append("\n" + dis.readUTF());
				ui.ta.setCaretPosition(ui.ta.getDocument().getLength());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class TCPMulClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("192.168.1.13", 7777);
			TCPMulCliGUI ui = new TCPMulCliGUI("클라이언트");
			// System.out.println("서버연결 성공");
			
			
			new TCPMulCliSender(socket, ui).start();
			new TCPMulCliReceiver(socket, ui).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
