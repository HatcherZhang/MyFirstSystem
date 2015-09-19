package forGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import toachieve.Mysqlallrefer;
import toachieve.Mysqlnumrefer;
public class Teacherlogin extends JFrame implements ActionListener{
		private JButton b1,b2,b3,b4,b5,b6;
		private JLabel r1= new JLabel("  查询选择      ");
		private JPanel p=new JPanel();
	  
		public Teacherlogin(){
		  setLayout(new FlowLayout());
		  add(r1);
		  b1=new JButton("条件查询");
		  b2=new JButton("排序查询");
		  b3=new JButton("总情况");
		  b4=new JButton("总人数");
		  b5=new JButton("其他功能   ");
		  b6=new JButton("返回");
		  b1.addActionListener(this);
		  b2.addActionListener(this);
		  b3.addActionListener(this);
		  b4.addActionListener(this);
		  b5.addActionListener(this);
		  b6.addActionListener(this);
		  setTitle("教师查询界面");
		  p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);
		  p.setLayout(new GridLayout(6, 2));
		  add(p);
		  setLocation(350,250);
		  setVisible(true);
		  setSize(300,216);
	  }
	  public void actionPerformed(ActionEvent e){
		  	if(e.getSource()==b1) 		new StudentreferGUI();//进入按条件查询界面
		  	else if(e.getSource()==b2) 	new Studentfinal("暂无此功能，敬请期待") ;
		  	else if(e.getSource()==b3) 	new Mysqlallrefer(); //查看所有学生的信息
		  	else if(e.getSource()==b4) 	
		  		{new Mysqlnumrefer();
		  		new Studentfinal("学生总人数为:"+toachieve.Mysqlnumrefer.count);toachieve.Mysqlnumrefer.count=0;}//显示全部学生人数
		  	else if(e.getSource()==b5) 	new Studentfinal("暂无此功能，敬请期待") ;
		  	else if(e.getSource()==b6) 	{this.dispose();new TeacherGUI();} //返回教师界面
		  	}
	  	/*
		 * 用于此功能的测试
		 */
	public static void main(String[] args) {
	new Teacherlogin();

	}

}
