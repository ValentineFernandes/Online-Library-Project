package com.javatpoint;
import java.sql.*;
public class RegisterUser {
static int status=0;
//int accountno=1;
public static int register(String username,String password,String repassword,double phone,String adderess,String syd){
	//public static int register(String email,String password,String gender,String country,String name){

	Connection con=GetCon.getCon();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("Insert into NEWMEMBER values(?,?,?,?,?,?,?)");
		int	nextvalue1=GetCon.getPrimaryKey();
	 	ps.setInt(1,nextvalue1);
	    ps.setString(2,username);
		ps.setString(3,password);
		ps.setString(4,repassword);
		ps.setDouble(5,phone);
		ps.setString(6,adderess);
		ps.setString(7,syd);
			
		status=ps.executeUpdate();
		System.out.println(status);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return status;
	
}
}
