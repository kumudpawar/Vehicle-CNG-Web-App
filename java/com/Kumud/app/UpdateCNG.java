package com.Kumud.app;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UpdateCNG extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public UpdateCNG() 
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
		String mono = request.getParameter("mobile");
		String upass = request.getParameter("password");
		String kg = request.getParameter("CNG_kg");
		try
		{
			Connection con = ConnectJDBC.connect();
			PreparedStatement ps1 = con.prepareStatement("update cngpumps set CNG_kg = ? where mobile = ? or password = ?");
			
			ps1.setString(1, kg);
			ps1.setString(2, mono);
			ps1.setString(3, upass);
			
		    int i = ps1.executeUpdate();
		    
		    if(i>0)
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
