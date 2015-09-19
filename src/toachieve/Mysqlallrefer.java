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

public class Mysqlallrefer extends JFrame {
	private JTable t;
	Statement st=null;
	Connection con=null;
	ResultSet rs=null;
	public static int num;
	public Mysqlallrefer(){
		super("                                                                                                                           总情况");
		String[] columnNames={"人数","学号","姓名","性别","出生日期","电话","入学成绩","学院","家庭地址","在校状态","密码"};
		Object[][] rowData=new Object[50][11];
		int count=0;
		con = getAccessCon();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from studentsdata");
			while(rs.next()){
				rowData[count][0]=count+1;
				rowData[count][1]=rs.getString("studentId");
				rowData[count][2]=rs.getString("sname");
				rowData[count][3]=rs.getString("ssex");
				rowData[count][4]=rs.getString("sbirthday");
				rowData[count][5]=rs.getString("tel");
				rowData[count][6]=rs.getString("grade");
				rowData[count][7]=rs.getString("sdept");
				rowData[count][8]=rs.getString("livePlace");
				rowData[count][9]=rs.getString("status");
				rowData[count][10]=rs.getString("password");
				count++;
				num=count;
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
			
		Container container=getContentPane();
		t=new JTable(rowData,columnNames);
		container.add(new JScrollPane(t),BorderLayout.CENTER);
		setSize(950,500);
		setVisible(true);
		setLocation(350,150);
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

public static void main(String[] args){
	new Mysqlallrefer();
}
}