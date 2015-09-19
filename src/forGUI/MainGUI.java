package forGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import method.CheckIDAndPassword;

public class MainGUI extends JFrame implements ActionListener{
	
	JLabel lLogin,lKey; 
    JTextField textLogin;
    JPasswordField textKey;//�����ı���
    JButton button1,button2;
    public static String ID;
   
   public   MainGUI(){
	   setTitle("学生信息管理系统");
	   lLogin=new JLabel("学号",Label.LEFT);
	   add(lLogin);
	   textLogin=new JTextField("",12);
	   add(textLogin);//ʵ�����ı���
	   lKey=new JLabel("密码",Label.LEFT);
	   add(lKey);
	   textKey=new JPasswordField("",12); 
	   textKey.setEchoChar('*');				//ʵ�ֵ�½���벻�ɼ�
	   add(textKey);
	   button1=new JButton("注册");
	   button1.addActionListener(this);
	   add(button1);
	   button2=new JButton("登陆");
	   button2.addActionListener(this);
	   add(button2);
	   setLayout(new GridLayout(3, 2));
	   setSize(320,130);
	   setVisible(true);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //����رտɽ�������
	   setLocation(550,200);
	   setResizable(false);       //���ñ߿򲻱�����
   }
 /*
  * ������Ӧ��ť���¼�
  */
   @SuppressWarnings("deprecation")
   	public  void actionPerformed(ActionEvent e){
	   	if(e.getSource()==button1)  
	   	{
		   new Studentlogin();									//��תע�����
		   new Studentfinal("����ذ���ʾ��д,ѧ���Ѹ�");		//��ע������ʾ��Ϣ��������ɹ�ע��
		   // this.dispose();
	   	}
	   	else if(e.getSource()==button2) 
	   	{
		    ID=textLogin.getText();				  //��ȡ��½�˺ţ�����ѧ�ŵļ��ʹ���ѧ��������Ҫ�õ��ķ���
		    String Password=textKey.getText();
		    /*
		     * ���ڼ���½ѧ�ź��������ȷ��   ��ȷ��ת���ܽ���
		     */
		    new CheckIDAndPassword(ID,Password);				
		    this.dispose(); 
	   	}
   }
   public static void main(String[] args){
	new MainGUI();   
   }
}














