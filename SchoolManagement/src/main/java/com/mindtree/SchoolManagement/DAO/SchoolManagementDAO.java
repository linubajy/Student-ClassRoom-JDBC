package com.mindtree.SchoolManagement.DAO;

import java.util.List;

import com.mindtree.SchoolManagement.DAO.Exception.IDAbsentException;
import com.mindtree.SchoolManagement.DAO.Exception.SchoolManagementDAOException;
import com.mindtree.SchoolManagement.Entity.ClassRoom;
import com.mindtree.SchoolManagement.Entity.Student;

public interface SchoolManagementDAO  
{

	public boolean insertStudentIntoDB(Student student) throws SchoolManagementDAOException;
	public boolean insertClassRoomIntoDB(ClassRoom classroom) throws SchoolManagementDAOException;
	
	public List<Student> getAllDetails(int sid) throws SchoolManagementDAOException;
	public List<Student> updateDetails(int sid,int newage) throws SchoolManagementDAOException;
	
	public boolean checkStudentID(int sid) throws IDAbsentException;
}
