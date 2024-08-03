package com.Kumud.app;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class PumpLogIn extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
        public PumpLogIn()
        {
        super();
        }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
		
		String mono = request.getParameter("mobile");
		String upass = request.getParameter("password");
		try
		{
			Connection con = ConnectJDBC.connect();
			PreparedStatement ps1 = con.prepareStatement("select * from cngpumps where mobile = ? and password = ?");
			
			ps1.setString(1, mono);
			ps1.setString(2, upass);
		    ResultSet rs = ps1.executeQuery();
		    
		    if(rs.next())
		    {
		    	response.sendRedirect("mmenu.html");
		    }
		    else
		    {
		    	response.sendRedirect("error.html");
		    }
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
