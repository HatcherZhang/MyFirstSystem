package forGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import toachieve.Mysqlallrefer;
import toachieve.Mysqldelete;
public class Teacherdelete extends JFrame implements ActionListener{
	JPanel  p1=new JPanel();
	JPanel  p2=new JPanel();
	JTextField c1,c2,c3,c4,c5,c6,c7,c8,c9,c0;
	JTextArea a=new JTextArea("欢迎使用学生信息管理系统");
	JButton b1=new JButton("确认");
	JButton b2=new JButton("取消");
	
	JLabel j=new JLabel("请输入要删除的学号");
	static String[] Id=new String[10];
    public Teacherdelete(){
	c1=new JTextField("",8);c2=new JTextField("");
	c3=new JTextField("");c4=new JTextField("");
	c5=new JTextField("");c6=new JTextField("");
	c7=new JTextField("");c8=new JTextField("");
	c9=new JTextField("");c0=new JTextField("");
	setLayout(new FlowLayout());
	b1.addActionListener(this);
	b2.addActionListener(this);
	p1.setLayout(new GridLayout(5,2));
	p1.setSize(240, 240);
	p2.setSize(500,250);
	p2.add(a);
	//p1.add(b1);p1.add(b2);
	p1.add(c0);p1.add(c1);p1.add(c2);p1.add(c3);p1.add(c4);
	p1.add(c5);p1.add(c6);p1.add(c7);p1.add(c8);p1.add(c9);
	add(b1,FlowLayout.LEFT);
	add(b2,FlowLayout.LEFT);	
	add(j,FlowLayout.LEFT);
	add(p1);
	add(p2);
	setSize(300,250);
	setVisible(true);
	setLocation(30, 150);
}

public void actionPerformed(ActionEvent e) {
	/*
	 * 实现确认删除的功能
	 */
	if(e.getSource()==b1)      {
		 Id[0]=c0.getText();Id[1]=c1.getText();
		 Id[2]=c2.getText();Id[3]=c3.getText();
		 Id[4]=c4.getText();Id[5]=c5.getText();
		 Id[6]=c6.getText();Id[7]=c7.getText();
		 Id[8]=c8.getText();Id[9]=c9.getText();
		 for(int i=0;i<10;i++)
			 new Mysqldelete(Id[i]);
		// TeacherGUI.Mysqlallrefer.close();
		 new Mysqlallrefer();
		 new Studentfinal("删除成功,请重新查看");
		}
	/*
	 * 
	 */
  	else if(e.getSource()==b2) {this.dispose(); }
}

	public static void main(String[] args) {
		new Teacherdelete();
	}


}
