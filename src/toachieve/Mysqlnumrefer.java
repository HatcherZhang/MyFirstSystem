package toachieve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
public class Mysqlnumrefer {
	Statement st=null;
	Connection con=null;
	ResultSet rs=null;
	public static int count=0;     //总人数  用于小功能和注册时提供注册学号
	public  Mysqlnumrefer(){
		con = getAccessCon();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from studentsdata");
			while(rs.next()){
				count++;
			}
						
	    }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(st != null) {
					st.close();
					st = null;
				}
				if(con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
			}
		}
			public static Connection getAccessCon(){
				Connection con = null;
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
				}catch(Exception e){
					e.printStackTrace();
				}
				return con;
			}
			/*
			 * 用于此功能的测试
			 */
		
			/*public static void main(String[] args) {
			  new Mysqlnumrefer();
		      System.out.println(count);
		      toachieve.Mysqlnumrefer.count=0;
			}*/

}
