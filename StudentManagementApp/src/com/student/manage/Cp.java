package com.student.manage;
import java.sql.*;

public class Cp {
	
	static Connection con;
	public static Connection creatC()
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String user = "root";
			String password = "12345";
			//String query = "select * from students ";
			con = DriverManager.getConnection(url,user,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
