package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



class UDPBroadSender extends Thread implements ActionListener{
	
	String name,ip;
	ChatForm win;
	int port, kind;
	
	public UDPBroadSender(ChatForm win,int kind, String ip, int port) {
		// TODO Auto-generated constructor stub
		
		try {
			
			this.win = win;
			this.ip = ip;
			this.kind = kind;
			this.port = port;
			
			name = "["+InetAddress.getLocalHost()+"] ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			win.tf.addActionListener(this);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
        	
        	
        	DatagramSocket ds = new DatagramSocket();
			InetAddress addr = InetAddress.getByName(win.myIp+ip);
			
			String buf = name+" "+win.tf.getText();
			
			DatagramPacket data = new DatagramPacket(
					buf.getBytes(), 
					buf.getBytes().length, 
					addr, 
					port
				);
			ds.send(data);
			
			if(kind==0)
				win.ta.append("\n[나]"+win.tf.getText());
            
			win.tf.setText("");
            
            win.ta.setCaretPosition(win.ta.getDocument().getLength());
			win.tf.setFocusable(true);
			
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

class UDPBroadReceiver extends Thread
{
	int port;
	ChatForm win;
	
	
	/**
	 * @param win
	 * @param port
	 */
	public UDPBroadReceiver(ChatForm win, int port) {
		this.win = win;
		this.port = port;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			DatagramSocket ds = new DatagramSocket(port);
		
			byte [] arr = new byte[1024];
			DatagramPacket data = new DatagramPacket(arr, arr.length);
			
			while(true)
			{
				
				ds.receive(data);
				win.ta.append("\n"+new String(arr).trim());
				for (int i = 0; i < arr.length; i++) {
					arr[i]=0;
				}
                win.ta.setCaretPosition(win.ta.getDocument().getLength());
		
			}
				
			
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class ChatForm extends JFrame
{
	String myIp;
    public JTextArea ta;
    public JTextField tf,portNum,ipNum ;
    UDPBroadSender sender;
    
    public ChatForm(String name)
    {
    	
        super(name);
        
        try {
			myIp = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myIp = myIp.substring(0,myIp.lastIndexOf(".")+1);
		
		
        setBounds(100, 0, 300, 500);
        ta= new JTextArea();
        tf= new JTextField();
        ipNum= new JTextField("029");
        portNum= new JTextField("7777");
        JPanel top = new JPanel();
        
        JRadioButton single=new JRadioButton("싱글", true);
        JRadioButton board=new JRadioButton("벙글");
        
        ButtonGroup bg = new ButtonGroup();
        
        bg.add(single);
        bg.add(board);
        
        
        top.add(single);
        top.add(new JLabel(myIp));
        top.add(ipNum);
        top.add(board);
        top.add(portNum);
        
        single.addActionListener(new RadioListen(this, 0));
        board.addActionListener(new RadioListen(this, 1));
        
        ta.setEditable(false);	///대화창 수정불가
        tf.setEnabled(false);	
        //클라이언트 접속 해야 사용 가능토록 처음에는 대화 입력창 막음
        
        ta.setFocusable(false); //초기화면구성시 포커스를 가지고 있지 않음
        tf.setFocusable(true);  //초기화면구성시 포커스를 가지고 있음

        JScrollPane jsp = new JScrollPane(ta);
        
        //JTextArea(크기, 위치 지정 안함) -> JScrollPane(크기, 위치정보 있음) -> JFrame
        //                   new JScrollPane(ta)            add(jsp,"Center");
        
        
        add(top,"North");
        add(tf,"South"); 
        add(jsp,"Center");
       
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
}

class RadioListen implements ActionListener
{
	
	ChatForm win;
	int name;
	/**
	 * @param win
	 */
	public RadioListen(ChatForm win, int name) {
		this.win = win;
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			
			win.tf.removeActionListener(win.sender);
			
			 
			
			
			String [] arr = {win.ipNum.getText(),255+""};
			
			win.sender = new UDPBroadSender(win,name,arr[name],
					Integer.parseInt(win.portNum.getText())
					);
			win.sender.start();
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
}

public class UDPBroadCastChatting {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ChatForm win = new ChatForm("UDP Single");
			win.tf.setEnabled(true);
			
			
			new UDPBroadReceiver(win,7777).start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
