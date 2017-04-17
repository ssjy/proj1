package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TCPSingleGUI extends JFrame
{
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();

	public TCPSingleGUI(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		setBounds(100, 0, 300, 500);
		ta.setFocusable(false);
		tf.setFocusable(true);
		add(ta,"Center");
		add(tf,"South");
		
		setVisible(true);
		
		
	}
	
}

class TCPSingleSender extends Thread implements ActionListener{
	DataOutputStream dos;
	String name;
	TCPSingleGUI win;
	public TCPSingleSender(Socket socket,TCPSingleGUI win ) {
		this.win = win;
		// TODO Auto-generated constructor stub
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			name = "["+socket.getLocalAddress()+"]";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		win.tf.addActionListener(this);
		
		
		/*while(dos!=null)
		{
			try {
				dos.writeUTF(name+sc.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			String msg =win.tf.getText();
			dos.writeUTF(name+msg);
			win.ta.append("\n"+msg);
			win.tf.setText("");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

class TCPSingleReceiver extends Thread
{
	DataInputStream dis;
	TCPSingleGUI win;
	public TCPSingleReceiver(Socket socket ,TCPSingleGUI win) {
		// TODO Auto-generated constructor stub
		this.win = win;
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
		while(dis!=null)
		{
			try {
				//System.out.println(dis.readUTF());
				win.ta.append("\n"+dis.readUTF());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class TCPSingleServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server= new ServerSocket(7777);
			TCPSingleGUI win = new TCPSingleGUI("서버");
			//System.out.println("서버준비 완료");
			win.ta.setText("서버준비 완료");
			Socket client = server.accept();
			
			
			new TCPSingleSender(client, win).start();
			new TCPSingleReceiver(client, win).start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
