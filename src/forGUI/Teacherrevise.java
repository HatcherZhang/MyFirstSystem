package forGUI;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import toachieve.Mysqlrevise;
import toachieve.Mysqlset;


public class Teacherrevise extends JFrame implements ActionListener{
		private JLabel studentId = new JLabel("ѧ��", Label.LEFT);
		private JLabel sname = new JLabel("����", Label.LEFT);
		private JLabel ssex = new JLabel("�Ա�", Label.LEFT);
		private JLabel sbirthday = new JLabel("��������", Label.LEFT);
		private JLabel tel = new JLabel("�绰", Label.LEFT);
		private JLabel grade = new JLabel("��ѧ�ɼ�", Label.LEFT);
		private JLabel sdept = new JLabel("ѧԺ", Label.LEFT);
		private JLabel liveplace = new JLabel("��ͥ��ַ", Label.LEFT);
		private JLabel status = new JLabel("��У״̬", Label.LEFT);
		private JLabel password = new JLabel("����", Label.LEFT);


		JTextField TstudentId = new JTextField("");
		JTextField Tsname = new JTextField("");
		JTextField Tssex = new JTextField(" ");
		JTextField Tsbirthday = new JTextField("");
		JTextField Ttel = new JTextField("");
		JTextField Tgrade = new JTextField("");
		JTextField Tsdept = new JTextField("");
		JTextField Tliveplace = new JTextField("");
		JTextField Tstatus = new JTextField("");
		JTextField Tpassword = new JTextField("");

		private JButton bffinish = new JButton("ȷ���޸�");
		private JButton bfcancel = new JButton("��ʾ");

		private JPanel p = new JPanel();
		
		 static  java.sql.Date Id33;//static Date Id33;
		 static Double Id55;
	    static String Id0;
		public Teacherrevise(){
		
			setTitle("����ѧ����ʾ*�޸�");
			add(studentId);  	add(TstudentId);
			add(sname);    		add(Tsname);
			add(ssex);			add(Tssex);
			add(sbirthday);		add(Tsbirthday);
			add(tel);			add(Ttel);
			add(grade);			add(Tgrade);
			add(sdept);			add(Tsdept);
			add(liveplace);		add(Tliveplace);
			add(status);		add(Tstatus);
			add(password);		add(Tpassword);
			add(bfcancel);		add(bffinish);
			bffinish.addActionListener(this);
			bfcancel.addActionListener(this);
			setLayout(new GridLayout(11, 2));
			setSize(400,400);
			setLocation(500, 200);
			setVisible(true);
		
		   
			
			      }
		
		
		

		 
		
		public void actionPerformed(ActionEvent e){
			//��ʾ��ť����ʵ��
		    	if(e.getSource()==bfcancel) {
		    		
		    		  Id0=TstudentId.getText();
						Connection con = null;
					    try{
							Class.forName("com.mysql.jdbc.Driver").newInstance();
							con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
						}catch(Exception e1){
							e1.printStackTrace();
						}
					    try{
					    	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
					        Statement sm=con1.createStatement();
					        ResultSet rs=sm.executeQuery("select * from studentsdata where studentId='"+Id0+"'");
					        if(rs.next()) {
					        	Tsname.setText(rs.getString("sname"));
					        	Tssex.setText(rs.getString("ssex"));
					        	Tsbirthday.setText(rs.getString("sbirthday"));
					        	Ttel.setText(rs.getString("tel"));
					        	Tgrade.setText(rs.getString("grade"));
					        	Tsdept.setText(rs.getString("sdept"));
					        	Tliveplace.setText(rs.getString("liveplace"));
					        	Tstatus.setText(rs.getString("status"));
					        	Tpassword.setText(rs.getString("password"));
					        }
					        else {new Studentfinal("��ʾʧ�ܣ�����ѧ��");
					        	
					        	}
					    	}catch(SQLException e1){
					    		System.out.println("SQLException:"+e1.getMessage());
					    	}	
		    		
		    		
		    		
		    	}
		    		
		    	
		    	//�޸İ�ť����ʵ��
		    	if(e.getSource()==bffinish)  
		    		
		    	{	
		    		
		    		String[] Id=new String[10];
		    		Id[0]=TstudentId.getText();
		    		Id[1]=Tsname.getText();
					Id[2]=Tssex.getText();
  	
  /*	try
  	{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
					Date Id3 = sdf.parse(Tsbirthday.getText());
					 Id33 = new java.sql.Date(Id3.getTime());
  	}
  	catch (ParseException e1)
  	{
					System.out.println(e1.getMessage());
  	}*/

  	
  	
  	
					Id33=Date.valueOf(Tsbirthday.getText());
					Id[4]=Ttel.getText();
					Id[5]=Tgrade.getText();
					Id55=Double.parseDouble(Id[5]);
					Id[6]=Tsdept.getText();
					Id[7]=Tliveplace.getText();
					Id[8]=Tstatus.getText();
					Id[9]=Tpassword.getText();
					/*
					 * �޸������ж�
					 */
					
					
				 if(Id[1] == null || Id[1].length() >= 31)      {new Studentfinal("����̫����Ϊ��");}
					else if(Id[2].length() > 0)
							{
								       if((!("��".equals(Id[2]))&&!("Ů".equals(Id[2])))||Id[2].length() >= 2) 
							                   {
									             new Studentfinal("�Ա���Ϣ���󣬱���*�л�Ů");
									            }
								      
					//else if(Tsbirthday.getText() .length() <= 0)		new Studentfinal("ע��������ڸ�ʽ");
					else if(Id[4].length() >= 21)  {new Studentfinal("�绰��Ϣ������Χ");}
					else if(Id55>760)  {new Studentfinal("�ɼ���������");}
					else if(Id[6].length() >= 21)  {new Studentfinal("ѧԺ��Ϣ̫��");}
					else if(Id[7].length() >= 101)  {new Studentfinal("סַ��Ϣ̫��");}
					else if(Id[8].length() > 0)
					   	{
						  	   if(!("ס��".equals(Id[8]))&& !("�߶�".equals(Id[8]))||Id[8].length()>=11) {new Studentfinal("ס����Ϣ����");}
						       else if(Id[9].length() == 0 || Id[9].length() >= 21)  {new Studentfinal("����Ϊ�ջ򳬳�����");}
						  //else if(Id33==null)  {new Studentfinal("�������ڲ���Ϊ��");}
						  else {	
	
					if(Id[0].equals(Id0))
					{new Mysqlrevise(Id,Id33,Id55);//System.out.println(Id33);
					//new MainGUI();
					new Studentfinal("�޸ĳɹ��������²�ѯ");
					this.dispose();}
					else  new Studentfinal("ѧ�Ų����޸�");
			  
		    	}
		    	
					   		}
						 }
					}
		    	
		 }
		public static void main(String[] args) {
		
	      new Teacherrevise();
	      
		}

	}