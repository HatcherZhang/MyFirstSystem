package toachieve;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Mysqlpersonrefer extends JFrame {
	private JTextArea t;
	Statement sm=null;
	Connection con1=null;
	ResultSet rs=null;
	
	/*
	 * ����ѧ�ţ�������ѧԺ�ɲ�ѯ�����Ϣ
	 */
	public Mysqlpersonrefer(String IdOrName) {
		super("个人信息");
		t=new JTextArea("",20,30);
		add(t);
		/*
		 * 连接mysql
		 */
		Connection con = null;
	        try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=root");
			}catch(Exception e){
				e.printStackTrace();

		}
		try{
		 con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
         sm=con1.createStatement();
         rs=sm.executeQuery("select * from studentsdata where (studentId='"+IdOrName+"')||(sname='"+IdOrName+"')||(sdept='"+IdOrName+"')");
      
         // ��ȡ��Ӧѧ�ţ�������ѧԺ����Ϣ   ���ı����������������Ҫ��ȡ��ע�Ϳ�ʹ����ʾѧ�����룩
         
        t.append("studentId"+"\t"+"sname"+"\t"+"ssex"+"\t"+"sbirthday"+"\t"+"tel"+"\t"+"grade"+"\t"+"sdept"
       +"\t"+"livePlace"+"\t"+"status"+"\n");
        
        while(rs.next()){
        	t.append(rs.getString("studentId")+"\t"+rs.getString("sname")+"\t"+
        rs.getString("ssex")+"\t"+rs.getString("sbirthday")+"\t"+rs.getString("tel")+
        "\t"+rs.getString("grade")+"\t"+rs.getString("sdept")+"\t"+rs.getString("livePlace")+
        "\t"+rs.getString("status")+"\n");
        }
        //sm.close();
        //con1.close();
		}catch(SQLException e){
			System.out.println("SQLException:"+e.getMessage());
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		setSize(800,200);
		setVisible(true);
		setLocation(150,130);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
     * ���ڼ���½ѧ�ź��������ȷ��   ��ȷ��ת���ܽ���
     */
	public static void main(String[] args) {
		new Mysqlpersonrefer("1");

	}

}
