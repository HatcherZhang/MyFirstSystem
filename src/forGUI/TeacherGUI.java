package forGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import toachieve.Mysqlallrefer;
import toachieve.Mysqldelete;
import toachieve.Mysqlrevise;
public class TeacherGUI extends JFrame implements ActionListener{
  private JButton b1,b2,b3,b4,b5,b6;
  private JLabel r1= new JLabel("      ����ѡ��      ");
  private JPanel p=new JPanel();
  public TeacherGUI(){
	  setLayout(new FlowLayout());
	  add(r1);
	  b1=new JButton("��ѯ");
	  b2=new JButton("���");
	  b3=new JButton("�޸�ѧ����Ϣ");
	  b4=new JButton("ɾ��ѧ����Ϣ ");
	  b5=new JButton("��������   ");
	  b6=new JButton("�˳�");
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
	  b4.addActionListener(this);
	  b5.addActionListener(this);
	  b6.addActionListener(this);
	  setTitle("��ʦ��ѯ����");
	  p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);
	  p.setLayout(new GridLayout(4, 2));
	  add(p);
	  setLocation(350,250);
	  setVisible(true);
	  setSize(620,130);
	  setResizable(false);       //���ñ߿򲻱�����
  }
  public void actionPerformed(ActionEvent e){
  	if(e.getSource()==b1)      {new Teacherlogin();this.dispose();}//������Ҳ�ѯ����
  	else if(e.getSource()==b2) {new Studentlogin();new Studentfinal("����ذ���ʾ���") ; }//�����ѧ����Ϣ
  	else if(e.getSource()==b3) {new Teacherrevise(); new Studentfinal("������ѧ����ʾ��,�����޸�") ;}//�޸�ԭ��ѧ����Ϣ
  	else if(e.getSource()==b4) {new Mysqlallrefer();new Teacherdelete();new Studentfinal("��ע�������Ӧ��ѧ��") ;}
  	else if(e.getSource()==b5)  new Studentfinal("���޴˹���") ;
  	else if(e.getSource()==b6) System.exit(-1);
	}
  	
  	/*
	 * ���ڴ˹��ܵĲ���
	 */
	public static void main(String[] args) {
		new TeacherGUI();
	}
}