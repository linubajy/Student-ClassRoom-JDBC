package com.mindtree.SchoolManagement.Service.Impl;

import java.util.List;

import com.mindtree.SchoolManagement.DAO.SchoolManagementDAO;
import com.mindtree.SchoolManagement.DAO.Exception.IDAbsentException;
import com.mindtree.SchoolManagement.DAO.Exception.SchoolManagementDAOException;
import com.mindtree.SchoolManagement.DAO.Impl.SchoolManagementDAOImpl;
import com.mindtree.SchoolManagement.Entity.ClassRoom;
import com.mindtree.SchoolManagement.Entity.Student;
import com.mindtree.SchoolManagement.Service.SchoolManagementService;
import com.mindtree.SchoolManagement.Service.Exception.SchoolManagementServiceException;

public class SchoolManagementServiceImpl implements SchoolManagementService{

	SchoolManagementDAO dao=new SchoolManagementDAOImpl();
	
	public boolean insertStudentIntoDB(Student student) throws SchoolManagementServiceException
	{
		try 
		{
			return dao.insertStudentIntoDB(student);
		}
		catch(SchoolManagementDAOException e)
		{
			throw new SchoolManagementServiceException(e.getMessage());
		}
		
		
		
	}

	public boolean insertClassRoomIntoDB(ClassRoom classroom) throws SchoolManagementServiceException
	{
		try 
		{
			return dao.insertClassRoomIntoDB(classroom);
		}
		catch(SchoolManagementDAOException e)
		{
			throw new SchoolManagementServiceException(e.getMessage());
		}
	
		
	}

	public List<Student> getAllDetails(int sid) throws SchoolManagementServiceException
	{
		try 
		{
			return dao.getAllDetails(sid);
		}
		catch(SchoolManagementDAOException e)
		{
			throw new SchoolManagementServiceException(e.getMessage());
		}
		
	}

	public List<Student> updateDetails(int sid, int newage) throws SchoolManagementServiceException 
	{

		try 
		{
			return dao.updateDetails(sid, newage);
		}
		catch(SchoolManagementDAOException e)
		{
			throw new SchoolManagementServiceException(e.getMessage());
		}
		
		
	}

	public boolean checkStudentID(int sid) throws IDAbsentException
	{
		try 
		{
			return dao.checkStudentID(sid);
		}
		catch(IDAbsentException e)
		{
			throw new IDAbsentException(e.getMessage());
		}
		
	}

	

}
