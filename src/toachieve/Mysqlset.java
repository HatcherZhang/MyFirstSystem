package toachieve;
import java.sql.*;

import forGUI.Studentfinal;


public class Mysqlset {
	static String[]  Id=new String[10];
	static Date Id33;
	static Double Id55;
	Statement sm=null;
	Connection con1=null;
	ResultSet rs=null;
	 /*
	  * 传入学生信息  进行mysql数据的添加
	  */
	 
	 public Mysqlset(String[] Id,Date Id33,Double Id55) throws SQLException{
	  Connection con = null;
      try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
		}catch(Exception e){
			e.printStackTrace();

	}
	try{
	 con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
     sm=con1.createStatement();
     rs=sm.executeQuery("select * from studentsdata where studentId='"+Id[0]+"'");
    if(rs.next()) new Studentfinal("学号重复，请重新注册");
    else {
    	String ss="insert into studentsdata values('"+Id[0]+"','"+Id[1]+"','"+Id[2]+"','"+Id33+"',"
    			+ "'"+Id[4]+"','"+Id55+"','"+Id[6]+"','"+Id[7]+"','"+Id[8]+"','"+Id[9]+"')";
    	sm.executeUpdate(ss);
  
    	//sm.close();
    	//con1.close();
    	//new Studentfinal("注册成功，请重新登陆");
    	}
	}catch(SQLException e){
		System.out.println("SQLException:"+e.getMessage());
	}
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
		 * 用于此功能的测试
		 */
	/*public static void main(String[] args) throws SQLException {
		String[] Id=new String[10];
		Id[0]="13";
		Id[1]="10";
		Id[2]="男";
		Id[3]="1994-02-29";
		Id[4]="48F";
		Id[6]="45";
		Id[7]="45";
		Id[8]="456";
		Id[5]="500";
		Id33=Date.valueOf(Id[3]);
       Id[9]="123";
       Id55=Double.parseDouble(Id[5]);
       new Mysqlset(Id,Id33,Id55);
	}*/

}
