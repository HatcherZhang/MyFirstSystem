package forGUI;//ѧ��ע�����
import java.awt.*;
import java.awt.event.*;

import toachieve.*;

import javax.swing.*;
@SuppressWarnings("serial")
public class StudentGUI extends JFrame implements ActionListener{
	
	JButton button1,button2,button3;
	JLabel j;
	JPanel p;
	
	
	public StudentGUI(){
				setTitle("学生信息");
			    setLayout(new FlowLayout(FlowLayout.CENTER));
			    p=new JPanel(new FlowLayout());
			    j=new JLabel("功能选择");
				button1=new JButton("个人查询");
				button2=new JButton("信息修改");
				button3=new JButton("退出");
				button1.addActionListener(this);
				button2.addActionListener(this);
				button3.addActionListener(this);
				add(j);
				p.add(button1);
				p.add(button2);
				p.add(button3);
				add(p);
			    setLocation(350,200);
				setSize(300,120);
				setVisible(true);
				setResizable(false);
				}
	
	
	public void actionPerformed(ActionEvent e){
    	if(e.getSource()==button1) 
    	{
    		String s=MainGUI.ID;
    		new Mysqlpersonrefer(s);}			//��ʾ��¼ѧ������Ϣ
    			//new StudentreferGUI();this.dispose();}
    	
    	 if(e.getSource()==button2)  {
    		 
    		 new Studentrevise();				//��ѧ���޸��Լ�����Ϣ
    		 }
    	
    	 if(e.getSource()==button3)   System.exit(-1);		//�˳�����
   }

	public static void main(String[] args) {
       new StudentGUI();
	}

}
