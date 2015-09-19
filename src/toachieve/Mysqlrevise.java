package toachieve;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysqlrevise {
	
	//Á¬½ÓMysql
	public Mysqlrevise(String[] Id,Date Id3,Double Id5){
		Connection con = null;
	    try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=admin");
		}catch(Exception e){
			e.printStackTrace();
		}
	    
	    
	    try{
	    	Statement s=con.createStatement();
	    	PreparedStatement ps=con.prepareStatement("update studentsdata set "
	    			+ "sname=?,ssex=?,sbirthday=?,tel=?,grade=?,sdept=?,livePlace=?,status=?,password=? where studentId=?");
	    	
	       do{
	    	ps.setString(1,Id[1]);
	    	ps.setString(2,Id[2]);
	    	ps.setDate(3,Id3);
	    	ps.setString(4,Id[4]);
	    	ps.setDouble(5,Id5);
	    	ps.setString(6,Id[6]);
	    	ps.setString(7,Id[7]);
	    	ps.setString(8,Id[8]);
	    	ps.setString(9,Id[9]);
	    	ps.setString(10,Id[0]);
	    	ps.executeUpdate();
	    	}while(false);
	    ps.close();
		s.close();
		con.close();
	    }catch(SQLException e){
	    	System.out.println("SQLException:"+e.getMessage());
	    }
	}

	public static void main(String[] args) {
		String[] Id=new String[10];
		Id[0]="1";Id[3]="1994-02-17";
		Id[1]="ÕÅº£Ç¿";Id[2]="ÄÐ";Id[4]="ºÇ";Id[6]="ºÇºÇ";Id[7]="ºÇºÇ";Id[8]="ºÇºÇ";Id[9]="ºÇºÇ";
		Date Id33=Date.valueOf(Id[3]);
		Double Id5=(double) 601;
	new Mysqlrevise(Id,Id33,Id5);

	}

}
