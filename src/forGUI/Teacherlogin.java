package forGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import toachieve.Mysqlallrefer;
import toachieve.Mysqlnumrefer;
public class Teacherlogin extends JFrame implements ActionListener{
		private JButton b1,b2,b3,b4,b5,b6;
		private JLabel r1= new JLabel("  ��ѯѡ��      ");
		private JPanel p=new JPanel();
	  
		public Teacherlogin(){
		  setLayout(new FlowLayout());
		  add(r1);
		  b1=new JButton("������ѯ");
		  b2=new JButton("�����ѯ");
		  b3=new JButton("�����");
		  b4=new JButton("������");
		  b5=new JButton("��������   ");
		  b6=new JButton("����");
		  b1.addActionListener(this);
		  b2.addActionListener(this);
		  b3.addActionListener(this);
		  b4.addActionListener(this);
		  b5.addActionListener(this);
		  b6.addActionListener(this);
		  setTitle("��ʦ��ѯ����");
		  p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);
		  p.setLayout(new GridLayout(6, 2));
		  add(p);
		  setLocation(350,250);
		  setVisible(true);
		  setSize(300,216);
	  }
	  public void actionPerformed(ActionEvent e){
		  	if(e.getSource()==b1) 		new StudentreferGUI();//���밴������ѯ����
		  	else if(e.getSource()==b2) 	new Studentfinal("���޴˹��ܣ������ڴ�") ;
		  	else if(e.getSource()==b3) 	new Mysqlallrefer(); //�鿴����ѧ������Ϣ
		  	else if(e.getSource()==b4) 	
		  		{new Mysqlnumrefer();
		  		new Studentfinal("ѧ��������Ϊ:"+toachieve.Mysqlnumrefer.count);toachieve.Mysqlnumrefer.count=0;}//��ʾȫ��ѧ������
		  	else if(e.getSource()==b5) 	new Studentfinal("���޴˹��ܣ������ڴ�") ;
		  	else if(e.getSource()==b6) 	{this.dispose();new TeacherGUI();} //���ؽ�ʦ����
		  	}
	  	/*
		 * ���ڴ˹��ܵĲ���
		 */
	public static void main(String[] args) {
	new Teacherlogin();

	}

}
