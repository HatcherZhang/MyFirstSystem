package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import forGUI.MainGUI;
import forGUI.StudentGUI;
import forGUI.Studentfinal;
import forGUI.StudentreferGUI;
import forGUI.TeacherGUI;

public class CheckIDAndPassword {
	static String ID,Password;
	Statement sm=null;
	Connection con1=null;
	ResultSet rs=null;
	/*
	 * ����ѧ�ź����뼴�������ݿ�ƥ������ȷ��
	 */
	public CheckIDAndPassword(String ID,String Password) {
		/*
		 * �������ݿ�
		 */
		Connection con = null;
        try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
		}catch(Exception e){
			e.printStackTrace();

	}
	try{
	 con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=root");
     sm=con1.createStatement();
     rs=sm.executeQuery("select * from studentsdata where (studentId='"+ID+"')&&(password='"+Password+"')");
     /*
      * ��������Ϣ���ж�   ��ת��ͬ����
      */
    if("admin".equals(ID)&&"admin".equals(Password))  
    { new TeacherGUI();			//��ʦ����
    }
    else if(rs.next())
    new StudentGUI();			//ѧ������
 
    else {
    	new MainGUI();
    	new Studentfinal("��½ʧ�ܣ������˺�����");}		//���ڴ��������Ϣ
    	//sm.close();
    	//con1.close();
    
	}catch(SQLException e){
		
		System.out.println("SQLException:"+e.getMessage());
	}
	/*
	 * �ֶ��ͷ��������ݿ���ռ�õ��ڴ�
	 */
	finally {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
	/*
	 * ���ڴ˹��ܵĲ���
	 */
	public static void main(String[] args) {
		new CheckIDAndPassword("1","2285663");
	}

}
