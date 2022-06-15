package com.javatpoint;
import javax.servlet.*;
import java.sql.*;

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		int status=0;
		Connection con=null;
	
      try{
		con=GetCon.getCon();
		PreparedStatement ps1=con.prepareStatement("Select * from NEWMEMBER");
		

      try{
		status=ps1.executeUpdate();
		}

      catch(Exception e)
		{e.printStackTrace();
		 status=2;
		 System.out.println("my staus is1111111"+status);
		 }		
		
       if(status==0)
		{System.out.println("your table name already exist"+status);}
		
         
       else if(status==2) 
		
               {System.out.println("else if part table does not exist new table has created"+status);
		PreparedStatement ps3=con.prepareStatement("CREATE SEQUENCE javatpoint MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE");
		ps3.executeUpdate();
		
		PreparedStatement ps=con.prepareStatement("CREATE TABLE  NEWMEMBER(ID NUMBER,USERNAME VARCHAR2(4000),PASSWORD VARCHAR2(4000),REPASSWORD VARCHAR2(4000),PHONE NUMBER, ADDERESS VARCHAR2(4000),SYD VARCHAR2(4000),PRIMARY KEY (ID))");
		ps.executeUpdate();
		
		PreparedStatement ps2=con.prepareStatement("CREATE TABLE  NEWSTAFFMEMBER(ID NUMBER,USERNAME VARCHAR2(4000),PASSWORD VARCHAR2(4000),REPASSWORD VARCHAR2(4000),PHONE NUMBER, ADDERESS VARCHAR2(4000),SYD VARCHAR2(4000),PRIMARY KEY (ID))");
		ps2.executeUpdate();
		
		PreparedStatement ps4=con.prepareStatement("CREATE TABLE  LIBRARYADMIN(USERNAME VARCHAR2(4000),PASSWORD VARCHAR2(4000))");
		ps4.executeUpdate();
		ps4 = con.prepareStatement("Insert into LIBRARYADMIN values(?,?)");
	    ps4.setString(1,"admin");
		ps4.setString(2,"admin");
		
		ps4.executeUpdate();
		
		PreparedStatement ps5=con.prepareStatement("CREATE TABLE  BOOKDETAILS(ID NUMBER,BOOKNAME VARCHAR2(4000),AUTHORNAME VARCHAR2(4000),PRIMARY KEY (ID))");
		ps5.executeUpdate();
		ps5 = con.prepareStatement("Insert into BOOKDETAILS values(?,?,?)");
		ps5.setInt(1,100);
	    ps5.setString(2,"english");
		ps5.setString(3,"gabrial");
		
		ps5.executeUpdate();
	
		ps5 = con.prepareStatement("Insert into BOOKDETAILS values(?,?,?)");
		ps5.setInt(1,101);
	    ps5.setString(2,"math");
		ps5.setString(3,"desuja");
		ps5.executeUpdate();
		
	
		}
		
		
		else{System.out.println("else part "+status);
		}}
	    catch(Exception e){e.printStackTrace();}
	    }
	    public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");
		
	}
}
