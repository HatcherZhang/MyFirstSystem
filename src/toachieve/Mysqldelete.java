package toachieve;

import java.sql.*;
public class Mysqldelete {
	Statement s=null;
	Connection con=null;
	public Mysqldelete(String Id){
	Connection con = null;
    try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
	}catch(Exception e){
		e.printStackTrace();
	}
    try{
    	 s=con.createStatement();
    	PreparedStatement ps=con.prepareStatement("delete from studentsdata where studentId=?");
    	ps.setString(1, Id);
    	ps.executeUpdate();
    
	s.close();
	con.close();
    }catch(SQLException e){
    	System.out.println("SQLException:"+e.getMessage());
    }finally {
		try {
			if(s != null) {
				s.close();
				s = null;
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
	/* 
	 * 用于此功能的测试
	 */
	 
	/*public static void main(String[] args) {
	new Mysqldelete("13");
	System.out.print("删除成功");
	}*/
}
