package com.javatpoint;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CreateServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		String ph=request.getParameter("phone");
		double phone=Double.parseDouble(ph);
	
		String adderess=request.getParameter("adderess");
		
		String syd=request.getParameter("syd");
			
	    int status=RegisterUser.register(username, password, repassword,phone, adderess,syd);
	   
	    
		if(status>0){
				
			request.setAttribute("welcome","WELCOME! YOU HAVE BEEN REGISTERD");
			RequestDispatcher rd=request.getRequestDispatcher("member.jsp");
			rd.include(request, response);
		}
		else{
			out.print("Sorry,Registration failed. please try later");
			RequestDispatcher rd=request.getRequestDispatcher("member.jsp");
			rd.include(request, response);
		}
		
	out.close();	
	}

}
