package forGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import toachieve.Mysqlpersonrefer;
public class StudentreferGUI extends JFrame implements ActionListener {
	private JButton b=new JButton("��ѯ"); 
	private JButton b1=new JButton("����");
	private static  JTextField t=new JTextField("",16);
	private JLabel r1= new JLabel("��ʾ", Label.LEFT);
	private JLabel r2 = new JLabel(" ����ѧ�š�������ѧԺ", Label.LEFT);
	
	public StudentreferGUI(){
	
			b.addActionListener(this);
			b1.addActionListener(this);
			setTitle("ѧ����Ϣ����ϵͳ");
			setLayout(new FlowLayout(FlowLayout.CENTER));
			add(r1);add(r2);add(t);add(b);add(b1);
			setSize(240,135);
			//pack();
			setVisible(true);
			setLocation(350,200);
	}
	public void actionPerformed(ActionEvent e){
    	if(e.getSource()==b) 
    	{	
    	String s=t.getText();
    	new StudentreferGUI();
    	new Mysqlpersonrefer(s);
    	this.dispose(); 
    	} 
    	if(e.getSource()==b1) 
    	{//new StudentGUI();
    	this.dispose();
    	                    }
    	}
	
	/*
	 * ���ڴ˹��ܵĲ���
	 */
	public static void main(String[] args){
		new StudentreferGUI();

	}
}
