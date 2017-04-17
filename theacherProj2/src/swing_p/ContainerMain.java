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
		p1.setBackground(Color.PINK);		//	���� ���� �ֱ�.
		
		JPanel p2 = new JPanel();
		p2.setBounds(130, 20, 100, 200);
		p2.setBackground(Color.YELLOW);
		
		for (int i = 0; i < 10; i++) {
			p1.add(new JButton("��ư"+i));		//	add �ȿ��� ��ư�� ����� ������ �ִ�.
			p2.add(new JButton("��ư"+i));
		}
		
		f1.add(p1);
		f1.add(p2);
		
		
		
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
//		set -- �ϳ��� ���°�   add -- �������� ���°�
//		---------------------- JScrollPane �� ������ -----------------------

		JFrame f2 = new JFrame("JScrollPane");
		f2.setBounds(350, 100, 300, 300);
		f2.setLayout(null);
		
//		------------ ���η� ��ũ�� �� �����  >>>>>>>>>>>>>   ------------
		
		JPanel p3 = new JPanel();
		JScrollPane hs = new JScrollPane(p3);
		hs.setBounds(20, 20, 100, 200);			//�гο��� �����ʿ� ���� �׳� ��ũ�� �ҿ��ٰ��� bounds �� ��ġ�� ����ָ� �ȴ�.
		f2.add(hs);
		p3.setBackground(Color.YELLOW);
		
		for (int i = 0; i < 10; i++) {
			p3.add(new JButton("��ư"+i));
		}
		
		f2.add(hs);
		
//		------------ ���η� ��ũ�� �� �����   >>>>>>>>>>>>>   ------------
		// setLayout �� ���⼭ �� ����� �Ѵ�.
		
		
		JPanel p4 = new JPanel();
		JScrollPane vs = new JScrollPane(p4);
		vs.setBounds(140, 20, 100, 200);			//�гο��� �����ʿ� ���� �׳� ��ũ�� �ҿ��ٰ��� bounds �� ��ġ�� ����ָ� �ȴ�.
		f2.add(vs);
		p4.setBackground(Color.PINK);
		p4.setLayout(new GridLayout(10, 1));
		
		for (int i = 0; i < 10; i++) {
			p4.add(new JButton("��ư"+i));
		}
		
		f2.add(vs);
		
		
		f2.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		---------------------- ���̾� �α� �� ������ -----------------------		
		
		
		
		JFrame f3 = new JFrame("JDialog");
		f3.setBounds(50, 400, 300, 300);
		f3.setLayout(null);
		
		JDialog dd = new JDialog(f3, "�޽���â", true);	// �̳��� �������̶� ���� ��� ���̴�. 
		// �׸��Ͽ� dd.setvisible �� �����ϴ�
		// true �� dd �� ���� �߰� ������ ������ dialog �������� �����̵ȴ�. 
		// false �� ������ �׳� �ٷ� �� ����� �ȴ�.
		//dd.setVisible(true);		����� ������ �޽��� â�� bounds �س��� ũ�� ������ ���� �ʴ´�.
		dd.setBounds(150, 400, 300, 200);
		dd.setLayout(new FlowLayout());
		dd.add(new JLabel("���â�Դϴ�."));
		dd.add(new JButton("Ȯ��"));
		dd.setVisible(true);
		
		
		f3.setVisible(true);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		---------------------- ���� ���̾� �α� �� ������ -----------------------		
		
		JFrame f4 = new JFrame("FileDialog");
		f4.setBounds(350, 400, 300, 300);
		f4.setLayout(null);
		f4.setVisible(true);
		
		FileDialog fd = new FileDialog(f4, "���Ͽ���", FileDialog.LOAD);
		fd.setLocation(2000, 100);
		fd.setDirectory("C:\\Users\\����õ\\Desktop");	//	������ �ּҸ� �����ؼ� �ٿ��ֱ� �ϸ� �ȴ�.
		fd.setVisible(true);
		
		
		System.out.println(fd.getDirectory());	//	���� ��θ� �˾ƺ��°�.
		System.out.println(fd.getFile());		//	���� �̸��� �˾ƺ��°�.
		
		
		f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		

	}

}
