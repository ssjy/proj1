package net;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatForm extends JFrame
{
    
    public JTextArea ta;
    public JTextField tf;
    
    public ChatForm(String name)
    {
        super(name);
        setBounds(100, 0, 300, 500);
        ta= new JTextArea();
        tf= new JTextField();
        
        ta.setEditable(false);	///대화창 수정불가
        tf.setEnabled(false);	
        //클라이언트 접속 해야 사용 가능토록 처음에는 대화 입력창 막음
        
        ta.setFocusable(false); //초기화면구성시 포커스를 가지고 있지 않음
        tf.setFocusable(true);  //초기화면구성시 포커스를 가지고 있음

        JScrollPane jsp = new JScrollPane(ta);
        
        //JTextArea(크기, 위치 지정 안함) -> JScrollPane(크기, 위치정보 있음) -> JFrame
        //                   new JScrollPane(ta)            add(jsp,"Center");
        
        
        
        add(tf,"South"); 
        add(jsp,"Center");
       
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
