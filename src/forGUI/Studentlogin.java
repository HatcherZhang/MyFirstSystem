package forGUI;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







import javax.swing.*;

import toachieve.Mysqlnumrefer;
import toachieve.Mysqlset;
public class Studentlogin extends JFrame implements MouseListener{
	private JLabel studentId = new JLabel("学号", Label.LEFT);
	private JLabel sname = new JLabel("姓名", Label.LEFT);
	private JLabel ssex = new JLabel("性别", Label.LEFT);
	private JLabel sbirthday = new JLabel("出生年份", Label.LEFT);
	private JLabel tel = new JLabel("电话", Label.LEFT);
	private JLabel grade = new JLabel("入学分数", Label.LEFT);
	private JLabel sdept = new JLabel("系别", Label.LEFT);
	private JLabel liveplace = new JLabel("居住地ַ", Label.LEFT);
	private JLabel status = new JLabel("在校状态״̬", Label.LEFT);
	private JLabel password = new JLabel("密码", Label.LEFT);

	/*private TextField TstudentId = new TextField("        ");
	private TextField Tsname = new TextField("          ");
	private TextField Tssex = new TextField("        ");
	private TextField Tsbirthday = new TextField("��1994-02-17              ");
	private TextField Ttel = new TextField("              ");
	private TextField Tgrade = new TextField("              ");
	private TextField Tsdept = new TextField("              ");
	private TextField Tliveplace = new TextField("              ");
	private TextField Tstatus = new TextField("ס�޻��߶�             ");
	private TextField Tpassword = new TextField("�Ǽ�����              ");*/
	JTextField TstudentId = new JTextField("");
	JTextField Tsname = new JTextField("����");
	JTextField Tssex = new JTextField("����*�л�Ů");
	JTextField Tsbirthday = new JTextField("����*��1994-02-17");
	JTextField Ttel = new JTextField("���������0");
	JTextField Tgrade = new JTextField("���������0");
	JTextField Tsdept = new JTextField("���������0");
	JTextField Tliveplace = new JTextField("���������0");
	JTextField Tstatus = new JTextField("����*ס�޻��߶�");
	JTextField Tpassword = new JTextField("����*�Ǽ�����");

	private JButton bffinish = new JButton("���ע��");
	private JButton bfcancel = new JButton("ȡ��");

	private JPanel p = new JPanel();
	
	 static  java.sql.Date Id33;//static Date Id33;
	 static Double Id55;
	 
	 static Statement sm=null;
	 static	Connection con1=null;
	 static ResultSet rs=null;
    
	public Studentlogin(){
		
		setTitle("                                             ע��");
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
		bffinish.addMouseListener(this);
		bfcancel.addMouseListener(this);
		
		TstudentId.addMouseListener( this);
		Tsname.addMouseListener(this);
		Tsbirthday.addMouseListener(this);
		Tssex.addMouseListener(this);
		Ttel.addMouseListener(this);
		Tgrade.addMouseListener(this);
		Tsdept.addMouseListener(this);
		Tliveplace.addMouseListener(this);
		Tstatus.addMouseListener(this);
		Tpassword.addMouseListener(this);
		
		setLayout(new GridLayout(11, 2));
		setSize(400,400);
		setLocation(500, 200);
		setVisible(true);
		
		new Mysqlnumrefer();
		String str=String.valueOf(toachieve.Mysqlnumrefer.count+1);
		TstudentId.setText(str);
		
	}
	
	
	/*public void mouseClicked(MouseEvent e) {

		TextField tf = (TextField) e.getSource();
		tf.setText("");
	}*/
	
	 
	
	
	public void mousePressed(MouseEvent e) {
		String[] Id=new String[10];
		
		
	    	if(e.getSource()==bfcancel)  {this.dispose();toachieve.Mysqlnumrefer.count=0;}
	    	//if(e.getSource()==TstudentId)  TstudentId.setText("");
	    	if(e.getSource()==Tsname)  Tsname.setText("");
	    	if(e.getSource()==Tssex)  Tssex.setText("��Ů");
	    	if(e.getSource()==Tsbirthday)  Tsbirthday.setText("1994-02-17");
	    	if(e.getSource()==Ttel)  Ttel.setText("");
	    	if(e.getSource()==Tgrade)  Tgrade.setText("0");
	    	if(e.getSource()==Tsdept)  Tsdept.setText("");
	    	if(e.getSource()==Tliveplace)  Tliveplace.setText("");
	    	if(e.getSource()==Tstatus)  Tstatus.setText("ס��");//Ĭ��ס��
	    	if(e.getSource()==Tpassword)  Tpassword.setText("");
	    	
	    	//ע�ᰴť����ʵ��
	    	if(e.getSource()==bffinish)  
	    	{
	    		/*
	    		 * ��ȡ�ı����������Ϣ
	    		 */
	    	
	    	Id[0]=TstudentId.getText();
  	        Id[1]=Tsname.getText();
			Id[2]=Tssex.getText();	
			Id33=Date.valueOf(Tsbirthday.getText());//��String��ת��Ϊjava.sql.Date
			Id[4]=Ttel.getText();
			Id[5]=Tgrade.getText();
			//new java.util.Date();
			Id55=Double.parseDouble(Id[5]);//��String��ת��ΪDouble
			Id[6]=Tsdept.getText();
			Id[7]=Tliveplace.getText();
			Id[8]=Tstatus.getText();
			Id[9]=Tpassword.getText();
			toachieve.Mysqlnumrefer.count=0;
  	 /*
  	  * ����mysql   ���ѧ�ŵ��ظ�
  	  */
  	 
  	Connection con = null;
    try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=root");
	}catch(Exception e1){
		e1.printStackTrace();

	}
	try{
		 con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=root");
		 sm=con1.createStatement();
		 rs=sm.executeQuery("select * from studentsdata where studentId='"+Id[0]+"'");
	
		 /*
		  * Ϊѧ��ע����Ϣ����ж�����
		  */
	    if(rs.next())  		 new Studentfinal("ѧ�����У��뻻ѧ��");
	    else if("".equals(Id[0]))  {new Studentfinal("ѧ�Ų���Ϊ��");}
	    else if(Id[1] == null || Id[1].length() >= 31)  {new Studentfinal("����̫����Ϊ��");}
	    else if(Id[2].length() > 0)
	    {
	       if((!("��".equals(Id[2]))&&!("Ů".equals(Id[2])))||Id[2].length() >= 2) 
           {
		             new Studentfinal("�Ա���Ϣ����");
		   }
	       else if(Id[4].length() >= 21)  {new Studentfinal("�绰��Ϣ������Χ");}
	       else if(Id55>760)  {new Studentfinal("�ɼ�Ӧ������760");}
	       else if(Id[6].length() >= 21)  {new Studentfinal("ѧԺ��Ϣ̫��");}
	       else if(Id[7].length() >= 101)  {new Studentfinal("סַ��Ϣ̫��");}
	       else if(Id[8].length() > 0)
	       	{
	    	   if(!("ס��".equals(Id[8]))&& !("�߶�".equals(Id[8]))||Id[8].length()>=11) {new Studentfinal("ס����Ϣ����");}
	    	   else if(Id[9].length() == 0 || Id[9].length() >= 21)  {new Studentfinal("����Ϊ�ջ򳬳�����");}
	    	   else if(Id[9].length() == 0 || Id[9].length() >= 21)  {new Studentfinal("���벻Ϊ�ջ򳬳�����");}
	    	   else if(Id33==null)  {new Studentfinal("�������ڲ���Ϊ��");}
	    	   else 
	       			{	
  	
			  	 	try {
							new Mysqlset(Id,Id33,Id55);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
			  	 	    this.dispose();
			  	       new Studentfinal("ע��ɹ��������µ�½");
			  	     toachieve.Mysqlnumrefer.count=0;
						
	       			}
			  	
			  	}
			}
		} catch(Exception e1){
						e1.printStackTrace();	
					}finally {
						try {
							if(rs != null) {
								rs.close();
								rs = null;
							}
							if(sm != null) {
								sm.close();
								sm = null;
							}
							if(con1 != null) {
								con1.close();
								con1 = null;
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
	
	
	    }
	    	
	
	  }
	//ʹע������ı���Ͱ�ťֻ��Ӧ����¼�
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {

	}


	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	/*
	 * ���ڴ˹��ܵĲ���
	 */
	public static void main(String[] args) {
	
      new Studentlogin();
      
	}


	

}
