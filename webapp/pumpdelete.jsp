<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
    <%@page import = "com.Swaraj.data.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Pump</title>
</head>
<body>
 
            <%
			  
				String i = request.getParameter("id");
 				try
				{
 					Connection con = ConnectJDBC.connect();
					PreparedStatement ps1 = con.prepareStatement("delete from cngpumps where mobile=?");
					ps1.setString(1,i);
 					int res = ps1.executeUpdate();
					if(res>0)
					{
						response.sendRedirect("Vdelete.jsp");
					}
					else
					{
						response.sendRedirect("404.html");
					}
				
					
					 
			    }
			    catch(Exception e)
			    {
					e.printStackTrace();
				}
            %>

</body>
</html>