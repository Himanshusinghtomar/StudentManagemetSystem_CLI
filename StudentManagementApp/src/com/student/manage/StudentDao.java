package com.student.manage;

import java.sql.*;
import java.io.*;


public class StudentDao {

	public static boolean insertStudentToDB(Student s)
	{
		//jdbc code to insert data
		boolean f = false;
		try
		{
			Connection con = Cp.creatC();
			String query = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			//PreparedStatement
			PreparedStatement pstm = con.prepareStatement(query);
			
			//set the values
			pstm.setString(1,s.getStudentName());
			pstm.setString(2,s.getStudentPhone());
			pstm.setString(3,s.getStudentCity());
			
			//execute
			pstm.executeUpdate();
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	public static boolean deleteStudent(int userId) {
		
		boolean f = false;
		try
		{
			Connection con = Cp.creatC();
			String query = "delete from students where sid = ?";
			
			//PreparedStatement
			PreparedStatement pstm = con.prepareStatement(query);
			
			//set the values
			pstm.setInt(1,userId);

			
			//execute
			pstm.executeUpdate();
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
	public static boolean ShowAllStudents() {
	
		boolean f = false;
		try
		{
			Connection con = Cp.creatC();
			String query = "select * from students";
			
			//PreparedStatement
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			

			while(rs.next())
			{
				int id = rs.getInt("sid");
				String name = rs.getString("sname");
				String phone = rs.getString("sphone");
				String city = rs.getString("scity");
				
				System.out.println("\n-----------------Student_Data---------------");
				System.out.println("Id : "+id);
				System.out.println("Name : "+ name);
				System.out.println("Phone : "+ phone);
				System.out.println("City : "+ city);
				System.out.println("\n---------------End_Of_Row-------------------");
			}
			
			
			
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	public static boolean updateStudents(String changeData,int studentId) {
		
		boolean f = false;
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			Connection con = Cp.creatC();
			
			
			System.out.println("Enter 1 if you want to Update Name : ");
			System.out.println("Enter 2 if you want to Update Phone Number: ");
			System.out.println("Enter 3 if you want to Update City Name : ");
			int flag = Integer.parseInt(br.readLine());
			
			if(flag == 1)
			{
				String query = "update students set sname = ? where sid = ?";
				PreparedStatement pstm = con.prepareStatement(query);
				pstm.setString(1,changeData);
				pstm.setInt(2,studentId);
				pstm.executeUpdate();
				f = true;
			}
			else if(flag == 2)
			{
				String query = "update students set sphone = ? where sid = ?";
				PreparedStatement pstm = con.prepareStatement(query);
				pstm.setString(1,changeData);
				pstm.setInt(2,studentId);
				pstm.executeUpdate();
				f = true;
			}
			else if(flag == 3)
			{
				String query = "update students set scity = ? where sid = ?";
				PreparedStatement pstm = con.prepareStatement(query);
				pstm.setString(1,changeData);
				pstm.setInt(2,studentId);
				pstm.executeUpdate();
				f = true;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
}
