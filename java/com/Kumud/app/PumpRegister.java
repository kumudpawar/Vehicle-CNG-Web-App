package com.Kumud.app;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class PumpRegister extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     public PumpRegister() 
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
		int id = 0;
		String name = request.getParameter("pname");
		String address = request.getParameter("add");
		String ct = request.getParameter("city");
		String tal = request.getParameter("taluka");
		String dist = request.getParameter("district");
		String otime = request.getParameter("opt");
		String ctime = request.getParameter("cpt");
		String mo_num = request.getParameter("mono");
 		String pass = request.getParameter("Password");
		String lat =  request.getParameter("latti");
		String lon = request.getParameter("longi");
		String kg = "cng_kg";
		String status = "pending";
		 
			try
			{
				Connection con = ConnectJDBC.connect();
			    PreparedStatement ps1 = con.prepareStatement("insert into cngpumps values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			    ps1.setInt(1, id);
			    ps1.setString(2, name);
			    ps1.setString(3, address);
			    ps1.setString(4, ct);
			    ps1.setString(5, tal);
			    ps1.setString(6, dist);
			    ps1.setString(7, otime);
			    ps1.setString(8, ctime);
			    ps1.setString(9, mo_num);
 			    ps1.setString(10, pass);
 			    ps1.setString(11, lat);
 			    ps1.setString(12, lon);
  			    ps1.setString(13, kg);
 			    ps1.setString(14, status);
 			    int i = ps1.executeUpdate();
			    if (i == 0)	
			    {
			    	response.sendRedirect("error.html");
			    	System.out.println("Registration is Failed.......!");
	 		    }
			    else
			    {
			    	response.sendRedirect("pumpLogin.html");
			    	System.out.println("Registration is successful.......!");
			    	
			    }
			    
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}
