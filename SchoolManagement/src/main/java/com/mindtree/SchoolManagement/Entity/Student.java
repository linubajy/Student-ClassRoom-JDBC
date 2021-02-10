package com.mindtree.SchoolManagement.Entity;

public class Student {

	private int sid;
	private String name;
	private int age;

	private ClassRoom classroom;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String name, int age, ClassRoom classroom) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.classroom = classroom;
	}

	public int getsid() {
		return sid;
	}

	public void setsid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
