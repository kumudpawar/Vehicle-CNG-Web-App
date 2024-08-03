package com.Kumud.app;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Swaraj.data.ConnectJDBC;
import com.Swaraj.data.GetSet;
public class UBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public UBooking() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		   int id = 0;
		   String pid = GetSet.getId();
		   String name = GetSet.getName();
 		   String mono = GetSet.getMobile();
		   String cng_kg = request.getParameter("CNG_kg");
			   try
				{
					Connection con = ConnectJDBC.connect();
					PreparedStatement ps11 = con.prepareStatement("select * from cngpumps where id=?");
					ps11.setString(1, pid);
					ResultSet rs11 = ps11.executeQuery();
					if(rs11.next())
					{
						int pcng = Integer.parseInt(rs11.getString("CNG_kg"));
						int ncng = pcng-Integer.parseInt(cng_kg);
						if(pcng>=ncng)
						{
							
						PreparedStatement ps22 = con.prepareStatement("update cngpumps set CNG_kg=? where id=?");
						ps22.setInt(1, ncng);
						ps22.setString(2, pid);
						ps22.executeUpdate();
						PreparedStatement ps2 = con.prepareStatement("insert into booking values(?,?,?,?,?)");
						ps2.setInt(1, id);
						ps2.setString(2, pid);
						ps2.setString(3, name);
						ps2.setString(4, mono);
						ps2.setString(5, cng_kg);
						int i = ps2.executeUpdate();
							if(i>0)
							{
								System.out.println("Booking Successful..");
								response.sendRedirect("userView.jsp");
							}
							else
							{
								System.out.println("Booking Failed..");
								response.sendRedirect("404.html");
							}
						}	
					}	  
			    }
			   catch(Exception e)
				{
				   e.printStackTrace();
				}
		 }
	}
