package forGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import toachieve.Mysqlallrefer;
import toachieve.Mysqldelete;
import toachieve.Mysqlrevise;
public class TeacherGUI extends JFrame implements ActionListener{
  private JButton b1,b2,b3,b4,b5,b6;
  private JLabel r1= new JLabel("      功能选择      ");
  private JPanel p=new JPanel();
  public TeacherGUI(){
	  setLayout(new FlowLayout());
	  add(r1);
	  b1=new JButton("查询");
	  b2=new JButton("添加");
	  b3=new JButton("修改学生信息");
	  b4=new JButton("删除学生信息 ");
	  b5=new JButton("其他功能   ");
	  b6=new JButton("退出");
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
	  b4.addActionListener(this);
	  b5.addActionListener(this);
	  b6.addActionListener(this);
	  setTitle("教师查询界面");
	  p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);
	  p.setLayout(new GridLayout(4, 2));
	  add(p);
	  setLocation(350,250);
	  setVisible(true);
	  setSize(620,130);
	  setResizable(false);       //设置边框不被拉动
  }
  public void actionPerformed(ActionEvent e){
  	if(e.getSource()==b1)      {new Teacherlogin();this.dispose();}//进入教室查询界面
  	else if(e.getSource()==b2) {new Studentlogin();new Studentfinal("请务必按提示添加") ; }//添加新学生信息
  	else if(e.getSource()==b3) {new Teacherrevise(); new Studentfinal("先输入学号显示后,方可修改") ;}//修改原有学生信息
  	else if(e.getSource()==b4) {new Mysqlallrefer();new Teacherdelete();new Studentfinal("请注意输入的应是学号") ;}
  	else if(e.getSource()==b5)  new Studentfinal("暂无此功能") ;
  	else if(e.getSource()==b6) System.exit(-1);
	}
  	
  	/*
	 * 用于此功能的测试
	 */
	public static void main(String[] args) {
		new TeacherGUI();
	}
}