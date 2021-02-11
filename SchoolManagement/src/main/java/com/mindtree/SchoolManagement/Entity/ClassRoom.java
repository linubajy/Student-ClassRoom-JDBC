package com.mindtree.SchoolManagement.Entity;

public class ClassRoom
{

	private int id;
	private String name;
	private int str;

	
	public ClassRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClassRoom(int id, String name, int str) {
		super();
		this.id = id;
		this.name = name;
		this.str = str;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	
	
	
}
