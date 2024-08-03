package com.Kumud.data;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectJDBC 
{
	static Connection con = null;
	public static Connection connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers Loaded........!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cng_booking","root","kumud");
			System.out.println("Connection Establish :"+con);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}
