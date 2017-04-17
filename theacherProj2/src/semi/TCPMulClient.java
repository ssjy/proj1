package semi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import net.ChatForm;

class TCPMulCliSender extends Thread implements ActionListener{
	ObjectOutputStream dos;
	String name;
	ChatForm win;
	public TCPMulCliSender(Socket socket,ChatForm win) {
		// TODO Auto-generated constructor stub
		
		try {
			this.win = win;
			dos = new ObjectOutputStream(socket.getOutputStream());
			name = "["+socket.getLocalAddress()+"] ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			NetData nd = new NetData();
            nd.kind="chat";
            nd.id=null;
            
            dos.writeUTF(name);
			
			win.tf.addActionListener(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            String msg =win.tf.getText();
            
            NetData nd = new NetData();
            nd.kind="chat";
            nd.id=null;
            nd.data=msg;
            dos.writeObject(nd);
            win.tf.setText("");
            
            win.tf.setFocusable(true);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

class TCPMulCliReceiver extends Thread
{
	ObjectInputStream dis;
	ChatService chat;
	GameService game;
	public TCPMulCliReceiver(Socket socket,ChatService chat,GameService game) {
		// TODO Auto-generated constructor stub
		
		try {
			this.chat = chat;
			this.game = game;
			dis = new ObjectInputStream(socket.getInputStream());
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
				
				NetData nd = (NetData)dis.readObject();
				
				switch(nd.kind)
				{
					case "chat":
						chat.execute(nd.data);
						break;
					case "game":
						game.execute(nd.data);
						break;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ChatService {
	
	
	public ChatService(ChatForm win) {
		this.win = win;
	}

	ChatForm win;
	
	void execute(Object data)
	{
		win.ta.append("\n채팅:"+data);
        win.ta.setCaretPosition(win.ta.getDocument().getLength());
	}
}


class GameService {
	
	
	public GameService(ChatForm win) {
		this.win = win;
	}

	ChatForm win;
	
	void execute(Object data)
	{
		win.ta.append("\n게임:"+data);
        win.ta.setCaretPosition(win.ta.getDocument().getLength());
	}
}


public class TCPMulClient {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("192.168.0.29",7777);
			ChatForm win = new ChatForm("클라이언트");
            //System.out.println("서버연결 성공");
            win.ta.setText("서버연결 성공");
            if(socket!=null)
            {
                win.tf.setEnabled(true);
            }
			
            ChatService chat = new ChatService(win);
            GameService game = new GameService(win);
			new TCPMulCliSender(socket, win).start();
			new TCPMulCliReceiver(socket,chat, game).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
