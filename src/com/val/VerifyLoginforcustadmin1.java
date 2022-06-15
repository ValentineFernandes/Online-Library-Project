package com.javatpoint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class VerifyLoginforcustadmin1 {

public static boolean checkLogin(double id){
	boolean status=false;
	Connection con=GetCon.getCon();
	try {
		System.out.println("222222"+id);
		System.out.println("rrrrrrrr");
		//PreparedStatement ps=con.prepareStatement("Select * from MAILCASTINGUSER where EMAILADD = ? and PASSWORD =?");
		PreparedStatement ps=con.prepareStatement("Select * from NEWSTAFFMEMBER where id =?");
		//ps.setInt(1,accountno);
		ps.setDouble(1,id);
		
		
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return status;
}
}
