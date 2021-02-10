package com.mindtree.SchoolManagement.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.SchoolManagement.DAO.SchoolManagementDAO;
import com.mindtree.SchoolManagement.DAO.Exception.IDAbsentException;
import com.mindtree.SchoolManagement.DAO.Exception.IDPresentException;
import com.mindtree.SchoolManagement.DAO.Exception.SchoolManagementDAOException;
import com.mindtree.SchoolManagement.Entity.ClassRoom;
import com.mindtree.SchoolManagement.Entity.Student;
import com.mindtree.SchoolManagement.Exception.SchoolManagementException;
import com.mindtree.SchoolManagement.Utility.JDBCConnection;

public class SchoolManagementDAOImpl implements SchoolManagementDAO{

	
	private static JDBCConnection connection = new JDBCConnection();
	
	public boolean insertStudentIntoDB(Student student) throws SchoolManagementDAOException 
	{
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			
			con = connection.getConnection();
			
			String insertQuery = "Insert into Student values(?,?,?)";
			ps = con.prepareStatement(insertQuery);

			ps.setInt(1, student.getsid());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
		

			ps.executeUpdate();
			isInserted = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (SchoolManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
		}
		
		return isInserted;
		
	}

	public boolean insertClassRoomIntoDB(ClassRoom classroom) throws SchoolManagementDAOException
	{
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connection.getConnection();
			
			String insertQuery = "Insert into ClassRoom values(?,?,?)";
			ps = con.prepareStatement(insertQuery);

			ps.setInt(1, classroom.getId());
			ps.setString(2, classroom.getName());
			ps.setInt(3, classroom.getStr());
		

			ps.executeUpdate();
			isInserted = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (SchoolManagementException e) {
			
			e.printStackTrace();
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
		}
		
		return isInserted;
	}

	public List<Student> getAllDetails(int sid) throws SchoolManagementDAOException 
	{
		List<Student> student= new ArrayList<Student>();
		
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		String query = "select sid,Student.name,age,id,Classroom.name,str from Student inner join ClassRoom on Student.sid=Classroom.id where sid="+sid+"";

		try 
		{
			checkStudentID(sid);
			try {
			con = connection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next())
			{
				
				int ssid=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				int id=rs.getInt(4);
				String cname=rs.getString(5);
				int str=rs.getInt(6);
				
				System.out.println("ID:"+ssid);
				System.out.println("Name"+name);
				System.out.println("Age"+age);

				System.out.println("ID:"+id);
				System.out.println("Name"+cname);
				System.out.println("Strength"+str);
				

			
				} 
			}
			catch (SQLException e) 
			{
			System.out.println(e.getMessage());
			} 
		}	
		catch (SchoolManagementException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			connection.closeResources(con);
			connection.closeResources(st);
			connection.closeResources(rs);
		}
			
		return student;
	}

	public List<Student> updateDetails(int sid, int newage) throws SchoolManagementDAOException
	{

		List<Student> student= new ArrayList<Student>();
		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String query = "update student set age="+newage+ " where sid= " + sid + " ";

		try 
		{
			checkStudentID(sid);
			
			try 
			{
				con = connection.getConnection();
				ps = con.prepareStatement(query);
				int c =ps.executeUpdate();								
				System.out.println(c+" row(s) affected");
			
			
			}
			catch (SQLException e) 
			{
			System.out.println(e.getMessage());
			}
		}
		catch (SchoolManagementException e) 
		{
			System.out.println(e.getMessage());
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
			connection.closeResources(rs);
		}
		
		return student;
	}

	public boolean checkStudentID(int sid) throws IDAbsentException 
	{
		int count = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		boolean valid = true;
		try {

			con = connection.getConnection();
			String query = "Select count(*) from Student where sid=" + sid;
			ps = con.prepareStatement(query);

			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
				if (count == 0) 
				{
					valid = false;
					break;
				}
			}

			if (valid == false) {
				throw new IDAbsentException(" Student ID is not  Present");
			}

			if (ps != null) {
				ps.close();
			}

		} catch (Exception e)
		{
			throw new IDAbsentException(" Student ID is not Present");
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
		}
		return valid;
	}

}
