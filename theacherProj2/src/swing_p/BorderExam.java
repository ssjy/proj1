package swing_p;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class BorderExam extends JPanel
{
 public BorderExam()//생성자 패널을 먼저 생성...
 {
  BevelBorder border;
  EtchedBorder eborder;
  TitledBorder tborder;
  
  JLabel label;
  
  setLayout(new GridLayout(1,4,20,20));//패널을 그리드아웃으로 레이아웃을 잡는다.
  
  label=new JLabel("보더없음",JLabel.CENTER);//
  add(label);
  
  /*-----BevelBorder-----*/
  label=new JLabel("beveled border",JLabel.CENTER);
  border=new BevelBorder(BevelBorder.RAISED);//3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
  label.setBorder(border);//라벨에 적용시킨다.
  add(label);
  /*---------------------*/
  
  /*-----EtchedBorder-----*/
  label=new JLabel("돌출한 etched border",JLabel.CENTER);
  eborder=new EtchedBorder(EtchedBorder.RAISED);//평면에 끌로 판듯이 외곽선 효과를 내는 것이고 양각의 효과를 준다.
  label.setBorder(eborder);
  add(label);
  /*----------------------*/
  
  /*-----TitledBorder-----*/
  label=new JLabel("titled border",JLabel.CENTER);
  tborder=new TitledBorder("제목");
  tborder.setTitlePosition(TitledBorder.ABOVE_TOP);//지정한 위치에 타이틀을 나타내주는 보더...
  tborder.setTitleJustification(TitledBorder.CENTER);//자리맞춤을 가운데로 지정...
  label.setBorder(tborder);
  add(label);
  /*----------------------*/
 }
  
 public static void main(String args[])
 {
  JFrame f=new JFrame("보더를 테스트 합니다.");
  BorderExam b=new BorderExam();//생성자 실행...패널을 설정...한다...
  
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼을 통해 프레임을 닫는다.
  f.getContentPane().add("Center",b);//패널을 프레임에 붙힌다.
  
  f.setSize(500,100);
  f.show();
 }
}


