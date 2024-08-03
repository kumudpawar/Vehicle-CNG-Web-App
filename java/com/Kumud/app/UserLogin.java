package com.Kumud.app;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
           public UserLogin() 
	   {
        	   super();
           }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
		
		String uemail = request.getParameter("email");
		String upass = request.getParameter("password");
		try
		{
			Connection con = ConnectJDBC.connect();
			PreparedStatement ps1 = con.prepareStatement("select * from user where email = ? and password = ?");
			
			ps1.setString(1, uemail);
			ps1.setString(2, upass);
		    ResultSet rs = ps1.executeQuery();
		    
		    if(rs.next())
		    {
		    	GetSet.setName(rs.getString(2));
		    	GetSet.setMobile(rs.getString(3));
		    	response.sendRedirect("umenu.html");
		    }
		    else
		    {
		    	response.sendRedirect("uerror.html");
		    }
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
