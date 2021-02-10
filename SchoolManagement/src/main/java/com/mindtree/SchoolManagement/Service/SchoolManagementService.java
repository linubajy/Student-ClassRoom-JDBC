package com.mindtree.SchoolManagement.Service;

import java.util.List;

import com.mindtree.SchoolManagement.DAO.Exception.IDAbsentException;
import com.mindtree.SchoolManagement.Entity.ClassRoom;
import com.mindtree.SchoolManagement.Entity.Student;
import com.mindtree.SchoolManagement.Service.Exception.SchoolManagementServiceException;

public interface SchoolManagementService
{

	public boolean insertStudentIntoDB(Student student) throws SchoolManagementServiceException;
	public boolean insertClassRoomIntoDB(ClassRoom classroom) throws SchoolManagementServiceException;
	
	public List<Student> getAllDetails(int sid) throws SchoolManagementServiceException;
	public List<Student> updateDetails(int sid,int age) throws SchoolManagementServiceException;
	
	public boolean checkStudentID(int sid) throws IDAbsentException;
	
	
}
