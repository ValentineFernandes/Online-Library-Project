package com.javatpoint;
import java.sql.*;
public class RegisterUser1 {
static int status=0;
//int accountno=1;
public static int register1(String username,String password,String repassword,double phone,String adderess,String syd){
	
	Connection con=GetCon.getCon();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("Insert into NEWSTAFFMEMBER values(?,?,?,?,?,?,?)");
		int	nextvalue1=GetCon.getPrimaryKey();
	 	ps.setInt(1,nextvalue1);
	    ps.setString(2,username);
		ps.setString(3,password);
		ps.setString(4,repassword);
		ps.setDouble(5,phone);
		ps.setString(6,adderess);
		ps.setString(7,syd);
			
		status=ps.executeUpdate();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return status;
	
}
}
