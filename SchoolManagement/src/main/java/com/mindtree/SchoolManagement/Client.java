package com.mindtree.SchoolManagement;

import java.util.List;
import java.util.Scanner;

import com.mindtree.SchoolManagement.Entity.ClassRoom;
import com.mindtree.SchoolManagement.Entity.Student;
import com.mindtree.SchoolManagement.Service.SchoolManagementService;
import com.mindtree.SchoolManagement.Service.Exception.SchoolManagementServiceException;
import com.mindtree.SchoolManagement.Service.Impl.SchoolManagementServiceImpl;

public class Client {

	private static SchoolManagementService sms = new SchoolManagementServiceImpl(); 
	static Scanner sc = new Scanner(System.in);
	
	public static void displayMessage() {
		System.out.println("SCHOOL MANAGEMENT SYSTEM \n**************************");
		System.out.println("1.CREATE CLASSROOM ");
		System.out.println("2.CREATE STUDENT");
		System.out.println("3.DISPLAY ALL DETAILS");
		System.out.println("4.UPDATE DETAILS");
		System.out.println("5.EXIT");

	}
	
	public static void main(String[] args)
	{
		int flag = 0;
		int ch = 0;
		ClassRoom classroom = null;

		do {
			displayMessage();
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				classroom = createClassRoom();
				if (classroom != null) {
					boolean isInserted = false;
					try {
						isInserted = sms.insertClassRoomIntoDB(classroom);
					} catch (SchoolManagementServiceException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					if (isInserted == true) {
						System.out.println("Inserted Successfully");
					}
				} else
					continue;
				break;

			case 2:
				Student student = createStudent(classroom);
				if (student != null) {
					boolean isInserted = false;
					try {
						isInserted = sms.insertStudentIntoDB(student);
					} catch (SchoolManagementServiceException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					if (isInserted == true) {
						System.out.println("Inserted Successfully");
					}
				} else
					continue;
				break;
				
				
			case 3:
				System.out.println("Enter the sid to display details: ");
				int sid = sc.nextInt();
				
				try {
					List<Student> students = sms.getAllDetails(sid);
					
				} catch (SchoolManagementServiceException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				

			case 4:
				System.out.println("Enter the sid to update: ");
				int sid1 = sc.nextInt();
				System.out.println("Enter the age to update:");
				int age=sc.nextInt();
				try {
					List<Student> hotels = sms.updateDetails(sid1,age);
					
				} catch (SchoolManagementServiceException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				flag = 1;
				break;

			}

		} while (ch != 5);


	}
	
	private static ClassRoom createClassRoom() 
	{
		System.out.println("Enter Class ID : ");
		int id = sc.nextInt();
		System.out.println("Enter Class Name: ");
		String name = sc.next();
		System.out.println("Enter Class Strength:");
		int str = sc.nextInt();
		ClassRoom classroom = new ClassRoom(id, name,str);

		return classroom;
	}

	private static Student createStudent(ClassRoom classroom)
	{
		System.out.println("Enter Student ID : ");
		int sid = sc.nextInt();
		System.out.println("Enter Student Name: ");
		String name = sc.next();
		System.out.println("Enter Student Age: ");
		int str = sc.nextInt();
		System.out.println("Enter the classroom ID:");
		int schoolid=sc.nextInt();
		
		
		Student student = new Student(sid, name,str,schoolid);

		return student;
		
	}


	

}
